package com.logger.team2;

import com.logger.Level;
import com.logger.Logger;
import com.logger.LoggerFacade;

public class SecondLogger implements Logger, LoggerFacade {

    @Override
    public void log(Level level, String message, Exception ex) {
        System.out.println("\n\nLevel: " + level + "\n Message: " + message + "\n Exception: " + ex.getMessage());
    }

}
