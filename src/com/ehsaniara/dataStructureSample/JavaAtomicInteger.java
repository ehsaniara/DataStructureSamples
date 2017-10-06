package com.ehsaniara.dataStructureSample;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/30/17.
 * From http://www.ehsaniara.com
 */
public class JavaAtomicInteger {
    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());
    }

    static class ProcessingThread implements Runnable {
        private AtomicInteger count = new AtomicInteger();

        @Override
        public void run() {
            for (int i = 1; i < 5; i++) {
                processSomething(i);

                count.incrementAndGet();
            }
        }

        public int getCount() {
            return this.count.get();
        }

        private void processSomething(int i) {
            // processing some job
            try {
                Thread.sleep(i * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
