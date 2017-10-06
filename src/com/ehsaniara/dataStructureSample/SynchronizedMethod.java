package com.ehsaniara.dataStructureSample;

import java.util.Arrays;

/**
 * this example where multiple threads are working on same array of Strings and once processed, appending thread name to the array value.
 * <p>
 * <p>
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class SynchronizedMethod {
    public static void main(String[] args) throws InterruptedException {
        String[] arr = {"1", "2", "3", "4", "5", "6"};
        MyThread hmp = new MyThread(arr);
        Thread t1 = new Thread(hmp, "t1");
        Thread t2 = new Thread(hmp, "t2");
        Thread t3 = new Thread(hmp, "t3");
        long start = System.currentTimeMillis();
        //start all the threads
        t1.start();
        t2.start();
        t3.start();
        //wait for threads to finish
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Time taken= " + (System.currentTimeMillis() - start));
        //check the shared variable value now
        System.out.println(Arrays.asList(hmp.getMap()));
    }

    static class MyThread implements Runnable {

        private String[] strArr = null;

        public MyThread(String[] m) {
            this.strArr = m;
        }

        public String[] getMap() {
            return strArr;
        }

        @Override
        public void run() {
            processArr(Thread.currentThread().getName());
        }

        private void processArr(String name) {
            for (int i = 0; i < strArr.length; i++) {
                //process data and append thread name
                processSomething(i);
                addThreadName(i, name);
            }
        }


        private void addThreadName(int i, String name) {
            strArr[i] = strArr[i] + ":" + name;
        }

        //to synchronize
        /*
            private Object lock = new Object();

            private void addThreadName(int i, String name) {
                synchronized (lock) {
                    strArr[i] = strArr[i] + ":" + name;
                }
            }
        */
        private void processSomething(int index) {
            // processing some job
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

}
