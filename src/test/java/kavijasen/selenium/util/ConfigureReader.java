package kavijasen.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigureReader {

    private static Properties properties = new Properties();

    static {
        try {
            InputStream input =
                    new FileInputStream("src/test/resources/config.properties");
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key){
        return properties.getProperty(key).trim();
    }

    public static String getBaseURL(){
        return get("BASE_URL");
    }

    public static String getBrowser(){
        return get("BROWSER");
    }

    public static int getTimeout(){
        String timeout = get("TIMEOUT");
        return Integer.parseInt(timeout);
    }



}