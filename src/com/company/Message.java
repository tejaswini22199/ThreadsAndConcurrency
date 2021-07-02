package com.company;

public class Message {
    private String message;
    boolean empty=true;
    public synchronized String read(){
        while(empty)
        {
            try{
                wait();
            }
            catch (InterruptedException exception)
            {

            }


        }
        empty=true;
        notifyAll();
        return this.message;
    }
    public synchronized void write(String message)
    {
        while(!empty)
        {
            try
            {
                wait();
            }
            catch (InterruptedException exception) {
                System.out.println("Write thread interrupted");
            }
        }
        this.message=message;
        empty=false;
        notifyAll();

    }
}
