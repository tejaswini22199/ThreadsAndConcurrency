package com.company;

import java.util.List;

public class MyProducer implements Runnable{
    private List<String> buffer;
    public MyProducer(List<String> buffer)
    {
        this.buffer=buffer;
    }
    @Override
    public void run()
    {
        String[] nums={"1","2","3","4","5"};
        for(String num:nums)
        {
            try{
                synchronized (buffer) {
                    buffer.add(num);
                    System.out.println("Added "+num);
                }
                Thread.sleep(2000);
                //break;
            }
            catch(InterruptedException exception)
            {
                System.out.println("Producer was interrupted");
            }
        }
        System.out.println("Adding EOL");
        synchronized (buffer) {
            buffer.add("EOF");
        }
    }

}
