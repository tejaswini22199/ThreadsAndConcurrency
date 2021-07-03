package com.company.deadlock;

public class Main {
    private static Object lock1=new Object();
    private static Object lock2=new Object();
    public static void main(String[] args)
    {
            new Thread1().start();
            new Thread2().start();
    }
    public static class Thread1 extends Thread{
        @Override
        public void run()
        {
            synchronized (lock1)
            {
                System.out.println("Thread1 has lock1");
                try{
                        Thread.sleep(2000);
                }
                catch(InterruptedException exception){
                    System.out.println("Thread1 interrupted");
            }
                System.out.println("Thread1 waiting for lock2");
                synchronized (lock2)
                {
                    System.out.println("Thread2 has lock2 and lock1");
                    try{
                        Thread.sleep(2000);
                    }
                    catch (InterruptedException exception){
                        System.out.println("Thread2 interrupted");
                }
                }
                System.out.println("Lock2 released");
            }
            System.out.println("Lock1 released");
        }
    }
    private static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (lock2)
            {
                System.out.println("Thread2 has lock2");
                try{
                    Thread.sleep(2000);
                }
                catch(InterruptedException exception){
                    System.out.println("Thread2 interrupted");
            }
                System.out.println("th2 Waiting for lock1");
                synchronized (lock1)
                {
                    System.out.println("thread2 has lock1 and lock2");
                    try{
                            Thread.sleep(2000);
                    }
                    catch(InterruptedException exception){
                        System.out.println("Thread2 interrupted");
                }
                }
                System.out.println("thread 2 Releasing lock1");
            }
            System.out.println("Thread2 releasing lock1");
        }
    }

}
