package com.epam.observer;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Counter(2000));
        Thread t2 = new Thread(new Counter(3000));
        t1.start();
        t2.start();
        Thread.sleep(60000);
        t1.interrupt();
        t2.interrupt();
    }
    
}
