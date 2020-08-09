package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Runner1 implements Runnable{
    Lock lock1,lock2;

    public Runner1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock2.lock();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
        }
        lock1.lock();

        lock2.unlock();
        lock1.lock();
    }
}
class Runner2 implements Runnable{
    Lock lock1,lock2;

    public Runner2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        lock1.lock();
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){

        }
        lock2.lock();

        lock1.unlock();
        lock2.unlock();
    }
}
public class DeadLock {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Thread t1= new Thread(new Runner1(lock1,lock2));
        Thread t2= new Thread(new Runner2(lock1,lock2));
        t1.start();
        t2.start();
    }
}
