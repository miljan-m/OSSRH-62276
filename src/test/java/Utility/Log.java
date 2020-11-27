package Utility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger LOGGER = LogManager.getLogger(Log.class.getName());

    public static void info(String message) {
        LOGGER.info(message);
    }
}
