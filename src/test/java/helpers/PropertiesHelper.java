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

    public static void main(String args[])  //static method
    {
        //just a try
        System.out.println(String.format("version: %s", PropertiesHelper.getValue("version")));
        System.out.println(String.format("capsLock: %s", PropertiesHelper.getValue("capsLock")));
        System.out.println(String.format("date: %s", PropertiesHelper.getValue("date")));
        //System.out.println(String.format("caseSensitive: %s", PropertiesHelper.getValue("caseSensitive")));
        initialize();
        System.out.println(String.format("caseSensitive: %s", getCaseSensitive()));
    }

}
