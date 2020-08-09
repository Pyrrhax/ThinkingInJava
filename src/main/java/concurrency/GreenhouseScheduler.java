package concurrency;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat ="Day";
    public synchronized String getThermostat(){
        return thermostat;
    }
    public synchronized void setThermostat(String value){
        thermostat =value;
    }
    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
    public void schedule(Runnable event,long delay){
        scheduler.schedule(event,delay, TimeUnit.MILLISECONDS);
    }
    public void repeat(Runnable event,long initialDelay,long period){
        scheduler.scheduleAtFixedRate(event,initialDelay,period,TimeUnit.MILLISECONDS);
    }
    class LightOn implements Runnable{
        @Override
        public void run() {
            System.out.println("Turning on lights");
            light=true;
        }
    }
    class LightOff implements Runnable{
        @Override
        public void run() {
            System.out.println("Turning off lights");
            light=false;
        }
    }
    class  Terminate implements Runnable {
        @Override
        public void run() {
            System.out.println("terminating");
            scheduler.shutdownNow();
            new Thread() {
                public void run() {
                    for (DataPoint d : data) {
                        System.out.println("d");
                    }
                }
            }.start();
        }
    }
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return "DataPoint{" +
                    "time=" + time +
                    ", temperature=" + temperature +
                    ", humidity=" + humidity +
                    '}';
        }
    }
    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand;
    private Calendar lastTime = Calendar.getInstance();

    {
        rand = new Random(47);
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());
    class CollectData implements Runnable{
        @Override
        public void run() {
            System.out.println("Collecting data");
            synchronized (GreenhouseScheduler.this){
                lastTime.set(Calendar.MINUTE,lastTime.get(Calendar.MINUTE)+30);
            }
            data.add(new DataPoint((Calendar)lastTime.clone(),lastTemp,lastHumidity));
        }
    }

    public static void main(String[] args) {
        GreenhouseScheduler gh = new GreenhouseScheduler();
        gh.schedule(gh.new Terminate(),5000);
        gh.repeat(gh.new LightOn(),0,200);
    }
}
