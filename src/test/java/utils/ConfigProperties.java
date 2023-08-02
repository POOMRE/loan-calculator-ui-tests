package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * ConfigProperties is a utility class to read properties from a configuration file.
 */
public class ConfigProperties {

    private static FileInputStream fileInputStream;
    private static Properties properties;

    static {
        try {
            // Load the configuration file from the "src/test/resources" directory
            fileInputStream = new FileInputStream("src/test/resources/testdata.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            // Handle the exception if the file is not found or there is an I/O error
            e.printStackTrace();
        } finally {
            // Close the FileInputStream to release resources
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Get the value of the property corresponding to the given key from the configuration file.
     *
     * @param key The key for the property.
     * @return The value of the property, or null if the key is not found.
     */
    public static String getTestProperty(String key) {
        return properties.getProperty(key);
    }
}



