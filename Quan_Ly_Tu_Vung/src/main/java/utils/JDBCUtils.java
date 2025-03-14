package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream("src/main/resources/database.properties");
            properties.load(fis);

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Kết nối database
            return DriverManager.getConnection(url, user, password);

    }
}
