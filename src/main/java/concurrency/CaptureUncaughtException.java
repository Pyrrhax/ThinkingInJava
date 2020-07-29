package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/*
TODO:
不知为何处理异常前会在此通过Factory创建一个新线程。详情运行后见输出，与《Java编程思想》p673对比。
 */
class ExceptionThread2 implements Runnable{

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run()by"+t);
        System.out.println("exception handler ="+t.getUncaughtExceptionHandler());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t+"caught"+e);
        System.out.println(Thread.currentThread().getName());
    }
}
class HandlerThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this+"creating new Thread"+Thread.currentThread().getName());
        Thread t = new Thread(r);
        System.out.println("created "+t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh="+t.getUncaughtExceptionHandler());
        return t;
    }
}
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool(new HandlerThreadFactory());
        executor.execute(new ExceptionThread2());
    }
}
