package org.example.Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface Loggable<T> {
    Logger LOGGER = LogManager.getLogger(Loggable.class);

    static void logInfo(String message) {
        LOGGER.info(message.toString());
    }

    static void logError(String message) {
        LOGGER.error(message.toString());
    }

    static void logDebug(String message) {
        LOGGER.debug(message.toString());
    }
}
