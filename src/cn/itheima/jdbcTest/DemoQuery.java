package cn.itheima.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DemoQuery {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///day01";
        String user = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url,user,password);

        Statement statement = conn.createStatement();

        String sql = "select * from department";

        ResultSet resultSet = statement.executeQuery(sql);

       /* resultSet.next();

        int anInt = resultSet.getInt(1);

        Object object = resultSet.getObject(2);

        String string2 = resultSet.getString(3);*/

        while (resultSet.next()) {
            System.out.print(resultSet.getObject(1)+"\t");
            System.out.print(resultSet.getObject(2)+"\t");
            System.out.print(resultSet.getObject(3)+"\t");

        }



        resultSet.close();

        statement.close();

        conn.close();
    }
}
