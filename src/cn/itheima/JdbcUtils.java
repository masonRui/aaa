package cn.itheima;

import java.sql.*;

public class JdbcUtils {
     public static Connection getConnection() throws ClassNotFoundException, SQLException {
         Class.forName("com.mysql.jdbc.Driver");
         String url = "jdbc:mysql:///day01";
         String username = "root";
         String password = "root";
         return DriverManager.getConnection(url, username, password);
     }

    public static void closeAll(Connection conn, Statement statement, ResultSet resultSet) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
