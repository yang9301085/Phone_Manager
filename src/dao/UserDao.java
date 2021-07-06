package dao;

import jdk.nashorn.internal.objects.annotations.Where;
import mod.PageBean;
import mod.User;
import org.w3c.dom.ls.LSInput;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2021/5/25 8:28 下午
 * @Created by 杨启仁
 */
public class UserDao {
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    /**
     * 用户登陆检查
     * @param user
     * @return
     */
    public boolean loginCheck(User user){
        DBUtil dbUtil=new DBUtil();
        String sql="select count(*) from tb_user where name=? and password=?";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                if(resultSet.getInt(1)>0){
                    resultSet.close();
                    preparedStatement.close();
                    return true;
                }
            }


            dbUtil.close(resultSet,preparedStatement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    public boolean registerUser(User user){
        DBUtil dbUtil=new DBUtil();
        //INSERT INTO `manager`.`tb_user` (`name`, `password`, `email`) VALUES ('1ee2', '11', '11@qq.com')
        String sql="insert into tb_user (name, password, email ,sex ,isbuy) VALUES (?, ?, ?, ?, ?)";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setInt(4,user.getGender().equals("男")?1:0);
            preparedStatement.setBoolean(5,user.isBus());
            if (preparedStatement.executeUpdate()>0){
                preparedStatement.close();

                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 检查用户角色
     * @param name 角色
     * @return 如果是管理员返回true 否则返回 false
     */
    public boolean checkUserRole(String name){
        DBUtil dbUtil=new DBUtil();
        String sql="select isbuy from tb_user where name='"+name+"';";
        statement=dbUtil.getStat();
        try {
            resultSet= statement.executeQuery(sql);
            while (resultSet.next()){


                return resultSet.getBoolean(1);
            }
            resultSet.close();
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 检查用户名是否唯一
     * @param name 用户名
     * @return 唯一返回true 重复返回false
     */
    public boolean checkUserName(String name){
        DBUtil dbUtil=new DBUtil();
        String sql="select count(*) from tb_user where name='"+name+"';";
        statement=dbUtil.getStat();
        try {
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                if (resultSet.getInt(1)==0){
//                    resultSet.close();
//                    preparedStatement.close();
                    return true;
                }
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 查询用户名是否重复
     * @param name
     * @return
     */
    public boolean selectUserByName(String name){
        DBUtil dbUtil=new DBUtil();
        String sql="select count(*) from tb_user where name= ?";
        System.out.println("selectUserByName:"+name);
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setString(1,name);
            resultSet= preparedStatement.executeQuery();
            System.out.println(preparedStatement);
            while (resultSet.next()){
                if (resultSet.getInt(1)>0){

                    return true;
                }
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 查询所有用户
     * @return List<user>
     */
    public List<User> searchAll(){
        DBUtil dbUtil=new DBUtil();
        String sql="select *from tb_user";
        try {
            resultSet=dbUtil.getStat().executeQuery(sql);
            System.out.println(resultSet.toString());
            List<User> list=new ArrayList<>();
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(4));
                int sex=resultSet.getInt(5);
                if (sex==1){
                    user.setGender("男");
                }else {
                    user.setGender("女");
                }
//                System.out.println("userDao::"+user);
                list.add(user);
//                System.out.println("userDao::("+list.size()+")"+list);
            }
            System.out.println("userDao::"+list);
            resultSet.close();
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }

    /**
     * 分页查询
     * @return
     */
    public List<User> searchByPageIndex(int start){
        DBUtil dbUtil=new DBUtil();
        String sql="select * from tb_user limit ?,5";
        preparedStatement=dbUtil.getPrStat(sql);
        List<User> list=null;
        try {
            preparedStatement.setInt(1,start);
            resultSet=dbUtil.getResultSet();
            list=new ArrayList<>();
            while (resultSet.next()){
                User user=new User();
                user.setId(resultSet.getInt(1));
                user.setName(resultSet.getString(2));
                user.setEmail(resultSet.getString(4));
                int sex=resultSet.getInt(5);
                user.setBalance(resultSet.getDouble("balance"));
                if (sex==1){
                    user.setGender("男");
                }else {
                    user.setGender("女");
                }
//                System.out.println("userDao::"+user);
                list.add(user);
//                System.out.println("userDao::("+list.size()+")"+list);
            }

            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 按id查询用户所有信息
     * @param id
     * @return
     */
    public User searchById(int id){
        DBUtil dbUtil=new DBUtil();
        String sql="select * from tb_user where id=?";
        preparedStatement=dbUtil.getPrStat(sql);
        User user=null;
        try {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement.toString());
            ResultSet resultSet= dbUtil.getResultSet();
            List<User> list=new ArrayList<>();
            while (resultSet.next()){
                int sexInt=resultSet.getInt(5);
                String sexStr=sexInt==1?"男":"女";
                user=new User(resultSet.getString(2),resultSet.getString(4),sexStr);
                System.out.println(user);
                list.add(user);
            }
            resultSet.close();
            preparedStatement.close();
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    /**
     * 更新用户姓名，邮箱，性别
     * @param user
     * @return
     */
    public int updateUserInfo(User user){
        DBUtil dbUtil=new DBUtil();
        //UPDATE `manager`.`tb_user` SET `name` = 'olo', `password` = 'olo', `email` = '21@qq.com', `sex` = 0 WHERE `id` = 27
        String sql="update tb_user set name=?,email=?,sex=? where id=?";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            System.out.println("user.getGender().equals(\"男\")="+user.getGender().equals("男"));
            if (user.getGender().equals("男")){
                preparedStatement.setInt(3,1);
            }else {
                preparedStatement.setInt(3,0);

            }
            preparedStatement.setInt(4,user.getId());
            System.out.println("updateUserInfo:"+preparedStatement.toString());
            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public boolean updateUserPwd(String name,String pwd){
        DBUtil dbUtil=new DBUtil();
        String sql="update tb_user set password=? where name=?";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setString(1,pwd);
            preparedStatement.setString(2,name);
            System.out.println(preparedStatement.toString());
            if (preparedStatement.executeUpdate()>0){

                return true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public boolean deleteUserById(int id){
        DBUtil dbUtil=new DBUtil();
        //DELETE FROM `manager`.`tb_user` WHERE `id` = 32
        String sql="DELETE FROM tb_user WHERE id = ?";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement.toString());
            if (preparedStatement.executeUpdate()>0) {
                return true;
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 查询所有用户姓名
     * @return
     */
    public List<String> selectUserName(){
        List<String> list=new ArrayList<>();
        statement=new DBUtil().getStat();
        String sql="select name from tb_user";
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

    public User selectUserInfoByName(String name){
        User user=new User();
        String sql="select id,balance from tb_user where name=?";
        preparedStatement=new DBUtil().getPrStat(sql);
        try {
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setBalance(resultSet.getDouble("balance"));
            }

            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    /**
     * 更新余额
     * @param id
     * @param balance
     * @return
     */
    public boolean updateBalanceById(int id, double balance){
        DBUtil dbUtil=new DBUtil();
        //UPDATE `manager`.`tb_user` SET `balance` = 1 WHERE `id` = 10
        String sql="UPDATE tb_user SET balance = ? WHERE id = ?";
        preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setInt(2,id);
            preparedStatement.setDouble(1,balance);
            if (preparedStatement.executeUpdate()>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public double getBalance(int id){
        double balance=0;
        String sql="select balance from tb_user where id=?";
        preparedStatement=new DBUtil().getPrStat(sql);
        try {
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                balance=resultSet.getDouble(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return balance;
    }
}
