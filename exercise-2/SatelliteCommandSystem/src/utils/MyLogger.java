package utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.FileHandler;


//centrailized logger 
public class MyLogger {
        final static Logger logger = Logger.getLogger("Satellitelogs");

        static {
           
                try {
                        FileHandler fileHandler = new FileHandler("Satellitelogs.log");
                        fileHandler.setFormatter(new SimpleFormatter());
                        logger.addHandler(fileHandler);
                } catch (Exception e) {
                        System.out.println("cannot create log file");
                        
                }
        }

        public static void log(Level level, String message) {
                logger.log(level, message);
        }

}
