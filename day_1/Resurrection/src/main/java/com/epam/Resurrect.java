package com.epam;

import java.util.ArrayList;
import java.util.List;

public class Resurrect {

    public static final List<Resurrect> LIVE = new ArrayList<>();

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize: " + this);
        LIVE.add(this);
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Resurrect();
        while (true) {
            Thread.sleep(100);
            System.gc();
            System.out.println(LIVE);
//            LIVE.clear();
        }
    }

}
