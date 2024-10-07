package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    
    public static String getPropertyString(String fileName) {
        Properties properties = new Properties();
        String connectionString = null;

        try (FileInputStream input = new FileInputStream(fileName)) {
            properties.load(input);
            String hostname = properties.getProperty("hostname");
            String dbname = properties.getProperty("dbname");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String port = properties.getProperty("port");

            connectionString = String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s",
                    hostname, port, dbname, username, password);
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as necessary
        }

        return connectionString;
    }
}

