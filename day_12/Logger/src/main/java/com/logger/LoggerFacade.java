package com.logger;

public interface LoggerFacade {

    void log(Level level, String message, Exception ex);

}
