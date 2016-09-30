package com.epam.observer;

import java.util.ArrayList;
import java.util.List;

public class Counter implements Runnable {

    private int interval;
    private int counter;
    private List<Observer> observers = new ArrayList<>();

    public Counter(int interval) {
        this.interval = interval;
    }

    public boolean add(Observer e) {
        return observers.add(e);
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
        for (Observer observer : observers) {
            observer.event(this);
        }
    }

    @Override
    public String toString() {
        return "Counter [interval=" + interval + ", counter=" + counter + ", observers=" + observers + "]";
    }

}
