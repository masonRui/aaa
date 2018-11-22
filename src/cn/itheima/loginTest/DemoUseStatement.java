package cn.itheima.loginTest;

import cn.itheima.JdbcUtils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DemoUseStatement {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
            Connection connection = JdbcUtils2.getConnection();

            Statement statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);

            System.out.println("please enter your username");

            String username= scanner.nextLine();

            System.out.println("please enter your password");

            String password = scanner.nextLine();
            //注释还是#号比较强大呀select * from account  where name = '1 ' and password = password('1 ') or 1=1 #')
            String sql = "select * from account  where name = \'"+username+" \' and password = password(\'"+password+"\') ";
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("欢迎回来"+resultSet.getString("name"));
                return;
            }

            System.out.println("错误");

        }

    }
}
