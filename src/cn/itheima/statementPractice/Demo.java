package cn.itheima.statementPractice;

import cn.itheima.JdbcUtils;
import cn.itheima.JdbcUtils2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/*创建员工表和员工类，包含字段：编号，姓名，性别，入职日期，工资
        1. 使用Statement向员工表中插入3条记录。
        2. 使用Statement，将3号员工的名字改成"猪八戒"，工资还在5300，入职日期改成2017-02-01
        update employee set name = '猪八戒', salary = 5300,join_date ='2017-02-01' where id = 3;
        3. 查询所有的员工类，封装成List<Employee>返回
        4. 查询所有员工的平均工资
        select avg(salary) 平均工资 from employee ;//为什么开始平均工资不加引号报错，后来就不报错了
        //不用，值而且是字符串类型才加，列名不加
        5. 查询所有姓张的员工的信息
        select * from employee where name like '张%';
        6. 编写方法：通过ID查询指定员工的信息，并且封装成一个员工对象返回

        7. 编写方法：通过ID删除指定的员工，并且返回删除的行数*/
public class Demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        //f1();
        f2(scanner);
    }

    private static void f2(Scanner scanner) throws SQLException, ClassNotFoundException {
        System.out.println("请输入要查询的员工编号");
        String next = scanner.next();

        Connection connection = JdbcUtils2.getConnection();

        Statement statement = connection.createStatement();

        String sql ="select * from employee where id= "+next;

        ResultSet resultSet = statement.executeQuery(sql);

        resultSet.next();
        Student student = new Student();

        student.setStuNo(resultSet.getString(1));
        student.setName((resultSet.getString(2)));
        student.setGender((resultSet.getString(3)));
        student.setSalary((resultSet.getInt(4)));
        student.setJoinDate((resultSet.getDate(5)));

        System.out.println(student);
    }

    private static void f1() throws ClassNotFoundException, SQLException {
        Connection connection = JdbcUtils2.getConnection();

        Statement statement = connection.createStatement();

        String sql = "select * from employee ";

        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<Student> students = new ArrayList<Student>();

        while (resultSet.next()) {
            Student student = new Student();
            student.setStuNo(resultSet.getString(1));
            student.setName((resultSet.getString(2)));
            student.setGender((resultSet.getString(3)));
            student.setSalary((resultSet.getInt(4)));
            student.setJoinDate((resultSet.getDate(5)));
            students.add(student);
        }

        System.out.println(students);

        JdbcUtils.closeAll(connection,statement,resultSet);
    }
}
