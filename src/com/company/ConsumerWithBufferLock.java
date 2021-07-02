package com.company;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerWithBufferLock implements Runnable {
    private List<String > buffer;
    private ReentrantLock bufferLock;
    public ConsumerWithBufferLock(List<String> buffer,ReentrantLock bufferLock)
    {
        this.buffer=buffer;
        this.bufferLock=bufferLock;
    }
    @Override
    public void run()
    {
        while (true)
        {
            bufferLock.lock();
            if(buffer.isEmpty())
            {
                bufferLock.unlock();
                continue;
            }
            if(buffer.get(0).equals("EOF"))
            {
                System.out.println("Nothing to read");
                bufferLock.unlock();
                break;
            }
            else{
                System.out.println("Reading"+buffer.remove(0));
            }
            bufferLock.unlock();
        }

    }
}
