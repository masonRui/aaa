package cn.itheima.loginTest;

import cn.itheima.JdbcUtils;
import cn.itheima.JdbcUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DemoUsePreparedStatement {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcUtils2.getConnection();

        //与 statement 不同的地方，这个在生成preparedstatement对象时就已经有语句了，
        //preparestatement 方法对sql语句进行编译，之后要做的就是传参，传参后执行/
        //一个preparedStatement可以执行多次！！！
        String sql = "select * from account where balance = ? and password =password(?)";

        PreparedStatement pst = connection.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter balance");

        String username = scanner.nextLine();

        System.out.println("enter password");

        String password = scanner.nextLine();

        pst.setString(1, username);

        pst.setString(2,password);

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            System.out.println("welcome back "+ resultSet.getString(2));
            return;
        }

        System.out.println("error");

        JdbcUtils.closeAll(connection,pst,resultSet);
    }
}
