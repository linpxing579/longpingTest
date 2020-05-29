package test;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest {


    public static void main(String[] args) {
        /*
         *     1. 当线程数小于核心线程数时，创建线程。
         *      2. 当线程数大于等于核心线程数，且任务队列未满时，将任务放入任务队列。
         *      3. 当线程数大于等于核心线程数，且任务队列已满
         *      - 若线程数小于最大线程数，创建线程
         *      - 若线程数等于最大线程数，抛出异常，拒绝任务
         * */
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 20, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

        //0 < 1 创建新线程
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("1:" + Thread.currentThread().getName());
            }
        });
        // 1 = 1 任务队列已满0  放入任务队列中
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2:" + Thread.currentThread().getName());
            }
        });

        // 2 > 1 任务队列已满1  2 < 4 则创建新线程
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("3:" + Thread.currentThread().getName());
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("4:" + Thread.currentThread().getName());
            }
        });
    }
}
