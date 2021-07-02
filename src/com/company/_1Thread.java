package com.company;
//creating thread using thread class
public class _1Thread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread 1 started");
        try{
            sleep(5000);

        }
        catch(InterruptedException exception){
            System.out.println("Thread1 woke me up");
        }
        System.out.println("Now Im awake");
    }

}
