package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
Message message=new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
        System.out.println("read");


















//
//        System.out.println("Main Thread running");
//        Thread thread=new _1Thread();
//        thread.start();

//        new Thread(){
//            @Override
//            public void run(){
//                System.out.println("Anonymous thread running");
//            }
//        }.start();
//        Thread myRunnable=new Thread(new MyRunnable());
//        myRunnable.start();
        //running Runnable as Anonymous class
//        new Thread(new MyRunnable(){
//            @Override
//
//            public void run(){
//                System.out.println("Anonymous class running myRunnable");
//            }
//        }).start();
      //  System.out.println("Main thread end");
    }
}
