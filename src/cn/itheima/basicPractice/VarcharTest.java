package cn.itheima.basicPractice;

import cn.itheima.JdbcUtils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VarcharTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcUtils2.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from test_varchar_char";

        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        boolean b = resultSet.getString(1) == resultSet.getString(2);
        boolean c = resultSet.getString(1) .equals(resultSet.getString(2)) ;
        System.out.println(b);//不同的内存地址
        System.out.println(c);//同样的数据。按道理来说char后面是有空格的
    }
}
