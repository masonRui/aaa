package cn.itheima;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils2 {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        InputStream is = JdbcUtils2.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pro = new Properties();

        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driver = pro.getProperty("driver");
        String url = pro.getProperty("url");
        String username = pro.getProperty("username");
        String password = pro.getProperty("password");

        Class.forName(driver);

        return DriverManager.getConnection(url, username, password);

    }
}
