package cn.itheima.jdbcTest;

import cn.itheima.JdbcUtils;
import cn.itheima.JdbcUtils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoTestUtils {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = JdbcUtils2.getConnection();
        Statement statement = connection.createStatement();

        String sql = "select * from department";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getObject(2));
        }

        JdbcUtils.closeAll(connection,statement,resultSet);
    }
}
