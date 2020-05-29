package test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Thread1 {

    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 0,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    private int i;

    public Thread1(int i) {
        this.i = i;
    }

    public void tets(){
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("--------" + i);
            }
        });

//        threadPool.shutdown();

    }

    private void ss(){
        System.out.println("--------" + i + "--------" + threadPool.getActiveCount());
        System.out.println("--------" + i + "--------" + threadPool.isTerminated());
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1(1);
        thread1.tets();

        Thread1 thread2 = new Thread1(2);
        thread2.tets();

        Thread1 thread3 = new Thread1(3);
        thread3.tets();


        try {
            Thread.sleep(6 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.ss();
        thread2.ss();
        thread3.ss();
    }
}
