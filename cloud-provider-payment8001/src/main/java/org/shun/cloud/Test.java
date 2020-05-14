package org.shun.cloud;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
//    private  static volatile int a = 0;
    private static AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) {
        Test test = new Test();
        Thread[] threads = new Thread[5];
        for (int i = 0;i < 5;i++){
            threads[i] = new Thread(()->{
                try {
                    for(int j=0;j<10;j++){
                        System.out.println(a.incrementAndGet());
                        Thread.sleep(500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start();
        }
    }
}
