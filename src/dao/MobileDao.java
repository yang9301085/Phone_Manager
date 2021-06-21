package dao;

import mod.Mobile;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname MobileDao
 * @Description TODO
 * @Date 2021/5/25 8:28 下午
 * @Created by 杨启仁
 */
public class MobileDao {

    Statement statement=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

    /**
     * 查询手机总数
     * @return 手机总数
     */
    public int countMobile(){
        DBUtil dbUtil=new DBUtil();
        statement=dbUtil.getStat();
        String sql="select count(*) from tb_mobile";
        try {
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    /**
     * 查找所有手机型号
     * @return list 返回手机型号list集合
     */
    public List<String> searchMobileModel(){
        List<String> list=new ArrayList<>();
        DBUtil dbUtil=new DBUtil();
        statement=dbUtil.getStat();
        String sql="select model from tb_mobile";
        try {
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                list.add(resultSet.getString(1));
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }



    /**
     * 查询所有字段，封装进list并返回
     * @return
     */
    public List<Mobile> searchAllMobile(){
        List<Mobile> list=new ArrayList<>();
        DBUtil dbUtil=new DBUtil();
        String sql="select *from tb_mobile";
        statement=dbUtil.getStat();
        try {
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                //int id, String model, String factory, double value
                Mobile mobile=new Mobile(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getDouble(3)
                );
                list.add(mobile);
            }
            System.out.println(list);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    /**
     * 增加手机
     * @param mobile mobile类
     * @return 增加是否成功
     */
    public boolean insertMobile(Mobile mobile){
        DBUtil dbUtil=new DBUtil();
        //INSERT INTO `manager`.`tb_mobile` (`model`, `value`, `factory`) VALUES ('samsung-4', 2332, 'samsung')
        String sql="INSERT INTO tb_mobile (model, value, factory) VALUES (?, ?, ?)";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setString(1,mobile.getModel());
            preparedStatement.setDouble(2,mobile.getValue());
            preparedStatement.setString(3,mobile.getFactory());
            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 通过id删除手机
     * @param id 手机id
     * @return 删除是否成功
     */
    public boolean deleteMobileById(int id){
        DBUtil dbUtil=new DBUtil();
        //DELETE FROM `manager`.`tb_mobile` WHERE `id` = 28
        String sql="DELETE FROM tb_mobile WHERE id = ?";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 更新手机信息
     * @param mobile 手机类
     * @return 更新是否成功
     */
    public boolean updateMobile(Mobile mobile){
        DBUtil dbUtil=new DBUtil();
        //UPDATE `manager`.`tb_mobile` SET `model` = 'samsung-4', `value` = 2233, `factory` = 'apple' WHERE `id` = 27
        String sql="UPDATE tb_mobile SET model = ?, value = ?, factory = ? WHERE id = ?";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setString(1,mobile.getModel());
            preparedStatement.setDouble(2,mobile.getValue());
            preparedStatement.setString(3,mobile.getFactory());
            preparedStatement.setInt(4,mobile.getId());
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 通过索引查询
     * @param index
     * @return
     */
    public List<Mobile> searchMobileByIndex(int index){
        List<Mobile> list=new ArrayList<>();
        DBUtil dbUtil=new DBUtil();
        String sql="select * from tb_mobile limit ?,5";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setInt(1,index);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Mobile mobile=new Mobile(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getDouble(3)
                );
                list.add(mobile);
            }
            System.out.println(list);
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    public Mobile searchById(int id) {
        DBUtil dbUtil=new DBUtil();
        Mobile mobile=null;
        String sql="select * from tb_mobile where id=?";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                mobile=new Mobile(
                        id,
                        resultSet.getString(2),
                        resultSet.getString(4),
                        resultSet.getDouble(3)
                );
            }
            return mobile;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mobile;
    }

    /**
     * tongg型号查询
     * @param model
     * @return
     */
    public Mobile selectByModel(String model){
        Mobile mobile=new Mobile();
        DBUtil dbUtil=new DBUtil();
        statement=dbUtil.getStat();
        String sql="select *from tb_mobile where model='"+model+"';";
        try {
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                //String model, String factory, double value
                return new Mobile(model,resultSet.getString("factory"),resultSet.getDouble("value"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mobile;
    }


}
