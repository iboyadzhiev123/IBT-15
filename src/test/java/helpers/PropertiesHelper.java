package helpers;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelper {
    private static boolean caseSensitive = false;

    public static boolean getCaseSensitive() {
        return caseSensitive;
    }

    public static void setCaseSensitive(boolean value) {
        caseSensitive = value;
    }

    //a method which currently isn't used anywhere. Leaving it for now in case somthing like that is
    // needed in the future
    public static String getValue(String propKey) {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "config.properties";
        Properties props = new Properties();
        String propValue = "";
        try {
            props.load(new FileInputStream(appConfigPath));
            propValue = props.getProperty(propKey);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return propValue;
    }

    public static void initialize() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "config.properties";
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(appConfigPath));
            setCaseSensitive(Boolean.parseBoolean(props.getProperty("caseSensitive")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
