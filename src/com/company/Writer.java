package com.company;

public class Writer implements Runnable{
    private Message message;
    public Writer(Message message){
        this.message=message;
    }
    @Override
    public void run() {
        String messages[]={
                "Writer Thread is writing First message",
                "Writer Thread writing second Message",
                "Writer Thread writing third message",
        };
        for(int index=0;index<messages.length;index++)
        {
            message.write(messages[index]);
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException exception)
            {

            }
        }
        message.write("Finished");
    }
}
