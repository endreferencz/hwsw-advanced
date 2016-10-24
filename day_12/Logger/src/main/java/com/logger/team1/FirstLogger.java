package com.logger.team1;

import com.logger.Level;
import com.logger.Logger;

public class FirstLogger implements Logger {

    @Override
    public void log(Level level, String message, Exception ex) {
        System.out.println("" + level + ": " + message + ", ex: " + ex.getMessage());
    }

}
