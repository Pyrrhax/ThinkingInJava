package concurrency;

import com.sun.scenario.DelayedRunnable;

import java.util.concurrent.TimeUnit;

public class Daemons implements Runnable {
    private Thread[] t = new Thread[10];
    public void run(){
        for (int i = 0; i < 10; i++) {
            t[i]=new Thread((new DaemonSpawn()));
            t[i].start();
            System.out.println("DaemonSpawn"+i+"started");
        }
        while (true){
            Thread.yield();
        }
    }
    class DaemonSpawn implements Runnable{
        public void run(){
            while (true){
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Daemons());
        t.setDaemon(true);
        t.start();
        TimeUnit.SECONDS.sleep(3);
    }
}
