package com.company;

import java.util.List;

public class MyConsumer implements Runnable {
    private List<String > buffer;
    public MyConsumer(List<String> buffer)
    {
        this.buffer=buffer;
    }
    @Override
    public void run()
    {
        while (true)
        {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals("EOF")==true) {
                    System.out.println("Exiting");
                    break;
                } else {
                    System.out.println("Removed " + buffer.remove(0));
                    // buffer.remove(0);
                }
            }
        }
    }
}
