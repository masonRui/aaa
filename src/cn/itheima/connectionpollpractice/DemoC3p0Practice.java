package cn.itheima.connectionpollpractice;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DemoC3p0Practice {
    public static void main(String[] args) throws SQLException {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        for (int i = 0; i < 11; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i+connection.toString());
            if (i==5)
            connection.close();
        }

    }
}
