package cn.itheima.transaction_test;

import cn.itheima.JdbcUtils;
import cn.itheima.JdbcUtils2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection=null;
        Statement statement =null;
        try {
             connection = JdbcUtils2.getConnection();
            connection.setAutoCommit(false);
             statement = connection.createStatement();
            String sql1 = "update account set balance =balance+100 where id=1";
            String sql2 = "update account set balance = balance -100 where id =2";
            statement.executeUpdate(sql1);
            //System.out.println(1/0);
            statement.executeUpdate(sql2);
            connection.commit();
            System.out.println("正常执行");
        } catch (Exception e) {
            System.out.println("抛异常回滚");
            e.printStackTrace();
            connection.rollback();
        } finally {
            JdbcUtils.closeAll(connection,statement,null);
        }
    }
}
