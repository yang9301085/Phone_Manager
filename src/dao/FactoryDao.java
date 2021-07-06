package dao;

import mod.Factory;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname FactoryDao
 * @Description TODO
 * @Date 2021/7/6 11:41 上午
 * @Created by 杨启仁
 */
public class FactoryDao {
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public static void main(String[] args) {
        System.out.println(new FactoryDao().selectAllFactory());
    }
    public List<Factory> selectAllFactory(){
        List<Factory> list=new ArrayList<>();
        DBUtil dbUtil=new DBUtil();
        statement=dbUtil.getStat();
        String sql=" select * from tb_factory";
        try {
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                list.add(
                  new Factory(
                          resultSet.getInt(1),
                          resultSet.getString(2),
                          resultSet.getString(3),
                          resultSet.getString(4),
                          resultSet.getDouble(5),
                          resultSet.getDouble(6)
                  )
                );
            }
            resultSet.close();
            statement.close();
            dbUtil.getConn().close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }
}
