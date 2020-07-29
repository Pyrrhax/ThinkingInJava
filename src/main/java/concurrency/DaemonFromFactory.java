package concurrency;

import util.DaemonThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable{
   public void run(){
       try{
           while (true){
               TimeUnit.MICROSECONDS.sleep(100);
           }
       }catch (InterruptedException e){
           System.out.println("Interrupted");
       }
   }

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All daemon started");
        TimeUnit.MILLISECONDS.sleep(5000);
    }
}
