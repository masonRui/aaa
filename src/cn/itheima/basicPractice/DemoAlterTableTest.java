package cn.itheima.basicPractice;

import cn.itheima.JdbcUtils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoAlterTableTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcUtils2.getConnection();
        Statement statement = connection.createStatement();
       // String sql = "alter table account modify password varchar(50)";
        //String sql = "update account set password = Password(456) where id=2" ;
       // int i = statement.executeUpdate(sql);
       // System.out.println(i);
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名：");
        String username = sc.next();
        System.out.println("密码：");
        String password = sc.next();
        //如果之前密码加密过，也应该用加密函数处理密码，才可以匹配
        //单引号字符串的拼接问题
        String sql = "select * from account where name = \'"+username+"\' and password=password(\'"+ password+"\')";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        if (!resultSet.next()) {
            System.out.println("错误");
        } else {
           // resultSet.next();
            System.out.println("欢迎回来"+resultSet.getObject("name"));
        }
        statement.close();
        connection.close();
    }
}
