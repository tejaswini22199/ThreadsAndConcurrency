package com.company;

public class Reader implements Runnable{
    private Message message;
    public Reader(Message message)
    {
        this.message=message;
    }
    @Override
    public void run()
    {
        for(String latestMsg=message.read();;)
        {
            latestMsg=message.read();
            System.out.println(latestMsg);
            try
            {
                Thread.sleep(2000);

            }
            catch(InterruptedException exception)
            {
                System.out.println("Read thread interrupted");
            }
        }
    }
}
