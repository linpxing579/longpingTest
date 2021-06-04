package demo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {


    public static void main(String[] args) {

        //循环屏障，可重复使用
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("完成了所有");
        });

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 碰到屏障");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " 翻过屏障");

                    TimeUnit.SECONDS.sleep(1);

                    System.out.println(Thread.currentThread().getName() + " 第二次碰到屏障");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " 第二次翻过屏障");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }, String.valueOf(i)).start();
        }
    }
}
