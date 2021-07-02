package com.company;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerWithBufferLock implements Runnable {
    private List<String> buffer;
    private ReentrantLock bufferLock;
    public ProducerWithBufferLock(List<String> buffer, ReentrantLock bufferLock)
    {
        this.buffer=buffer;
        this.bufferLock=bufferLock;
    }
    @Override
    public void run()
    {
        String[] messages={"1","2","3"};
        for(String message:messages){
            try{
                System.out.println("Adding"+message);
                bufferLock.lock();
                buffer.add(message);

                Thread.sleep(2000);
            }

            catch(InterruptedException exception){
                System.out.println("Producer interrupted");
            }
            finally {
                bufferLock.unlock();
            }
        }
        System.out.println("Adding EOF");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }
}
