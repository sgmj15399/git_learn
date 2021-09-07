package com.mjstudy.example.week5demo10.database.jdbc;

import java.sql.*;
import java.util.*;

/**
 * 使用 JDBC 原生接口，实现数据库的增删改查操作。
 * @author minjian
 */
public class MysqlJdbc {


    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find mysql jdbc driver");
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mall", "root", "root");
            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed!");
            }
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return null;
    }

    public static void updateSql(String sql) {
        Connection connection = createConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int count = 0;
        try {
            count = statement.executeUpdate(sql);
            System.out.println(count == 1 ? "插入成功" : "插入失败");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
            // 要按照从小到大的顺序依次关闭资源，并且分别使用try..catch语句
            if (statement != null) {
                try {
                    statement.close();  // 先关闭数据库操作对象
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();  // 再关闭连接对象
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public static void querySql(String sql) {
        Connection connection = createConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int count = 0;
        try {
            ResultSet result  = statement.executeQuery(sql);
            int deptno = result.getInt("deptno");
            String dname = result.getString("dname");
            String loc = result.getString("loc");
            System.out.println(result.getRow() + ": " + deptno + "   " + dname + "   " + loc);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
            // 要按照从小到大的顺序依次关闭资源，并且分别使用try..catch语句
            if (statement != null) {
                try {
                    statement.close();  // 先关闭数据库操作对象
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();  // 再关闭连接对象
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {

        String insertSql = "insert into dept(deptno, dname, loc) values(50, '财务部', '北京')";
        updateSql(insertSql);

        String updateSql = "update dept set loc = '上海' where deptno = 50;";
        updateSql(updateSql);

        String deleteSql = "delete from dept where deptno = 50;";
        updateSql(deleteSql);

        String querySql = "select deptno, dname, loc from dept";
        querySql(querySql);
    }
}
