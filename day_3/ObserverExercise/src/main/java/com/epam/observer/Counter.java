package com.epam.observer;

public class Counter implements Runnable {

    private int interval;
    private int counter;

    public Counter(int interval) {
        this.interval = interval;
    }

    @Override
    public void run() {
        try {
            while (true) {
                event();
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            System.out.println("Counter stopped, id = " + this);
        }
    }

    private void event() {
        counter++;
        System.out.println("counter=" + counter + ", time= " + System.currentTimeMillis() + ", id = " + this);
    }

}
