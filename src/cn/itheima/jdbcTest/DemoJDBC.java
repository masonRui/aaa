package cn.itheima.jdbcTest;

import java.sql.*;


public class DemoJDBC {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");
        //new Driver() com.mysql.jdbc.Driver

        String url = "jdbc:mysql:///day01";
        String user = "root";

        String password = "root";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        Statement statement = connection.createStatement();
        System.out.println(statement);
       //String sql = "insert into department  values (null,'售后部','西安')";
       String sql = "update department set dep_name ='研发部' where id = 1";
       String sql2 = "update department set dep_name ='销售部' where id =2";
        //String sql = "delete from department where dep_name='售后部'";
        int i = statement.executeUpdate(sql);
        int i2 = statement.executeUpdate(sql2);
        //System.out.println(i);
        statement.close();
        connection.close();

    }
}
