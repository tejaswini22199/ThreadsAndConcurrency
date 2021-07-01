package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Main Thread running");
        Thread thread=new _1Thread();
        thread.start();

        new Thread(){
            @Override
            public void run(){
                System.out.println("Anonymous thread running");
            }
        }.start();
        System.out.println("Main thread end");
    }
}
