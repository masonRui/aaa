package cn.itheima.connectionpollpractice;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DemoDruidPractice {

    public static void main(String[] args) throws Exception {
        InputStream stream = DemoDruidPractice.class.getClassLoader().getResourceAsStream("druiddb.properties");

        Properties properties = new Properties();

        properties.load(stream);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        for (int i = 0; i < 11; i++) {
            Connection connection = dataSource.getConnection();

            System.out.println(i+connection.toString());

            if (i==5) {
                connection.close();
            }
        }


    }
}
