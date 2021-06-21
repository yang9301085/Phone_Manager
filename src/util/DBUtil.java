package util;

import mod.Mobile;
import mod.PageBean;

import java.sql.*;

/**
 * @Classname DBUtil
 * @Description TODO
 * @Date 2021/5/26 1:15 下午
 * @Created by 杨启仁
 */
public class DBUtil {
    private final String URL="jdbc:mysql://localhost:3306/manager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=gbk";
    private final String userName="root";
    private final String password="mysql123456";
    private Connection conn;
    private Statement stat;
    private PreparedStatement prStat;
    private ResultSet resultSet;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PageBean<Mobile> pageBean=new PageBean<>("tb_mobile");

    }
    public Connection getConn(){
        try {
            conn= DriverManager.getConnection(URL,userName,password);
            System.out.println(conn.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public Statement getStat(){
        try {
            stat=getConn().createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return stat;
    }
    public PreparedStatement getPrStat(String sql){
        try {
            prStat=getConn().prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return prStat;
    }

    public ResultSet getResultSet(){
        try {
            resultSet=prStat.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getResultSet(String sql){
        try {
            resultSet=getStat().executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
    public void close(ResultSet resultSet,PreparedStatement prStat){
        try {
            resultSet.close();
            prStat.close();
            this.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void close(ResultSet resultSet,Statement Stat){
        try {
            resultSet.close();
            Stat.close();
            this.conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
