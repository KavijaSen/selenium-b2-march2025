package kavijasen.selenium.log4j;
import org.testng.annotations.Test;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Log4JTest {

    private final Logger logger = LogManager.getLogger(Log4JTest.class);

    @Test
    public void testLog4J() {
        logger.info("Starting test execution");
        logger.debug("This is a debug message");
        logger.warn("This is a warning");
        logger.error("This is an error message");
        logger.info("Test execution completed");

    }
}
