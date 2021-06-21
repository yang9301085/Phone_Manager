package dao;

import com.sun.tools.corba.se.idl.constExpr.Or;
import mod.Mobile;
import mod.Order;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname OrderDao
 * @Description TODO
 * @Date 2021/6/9 9:15 下午
 * @Created by 杨启仁
 */
public class OrderDao {
    Statement statement=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;

//    public static void main(String[] args) {
//        List<Order> list=new OrderDao().selectAllOrder();
//        System.out.println(list);
//
//    }

    public List<Order> selectAllOrder(){
        List<Order> orderList=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        List<String> listModel=new MobileDao().searchMobileModel();
        String sql="select *from tb_order";
        statement=new DBUtil().getStat();
        try {
            resultSet=statement.executeQuery(sql);
            Iterator iterator=listModel.iterator();
            while (resultSet.next()){
                Order<Integer> order=new Order<>();
                order.setId(resultSet.getInt("id"));
                order.setUserName(selectUserNameById(order.getId()));
                while (iterator.hasNext()){
                    list.add(resultSet.getInt((String) iterator.next()));
                }
                order.setListModelCount(list);
                orderList.add(order);
            }
            return orderList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }

    public String selectUserNameById(int id){
        DBUtil dbUtil=new DBUtil();
        String sql="select name from tb_user where id=?";
        PreparedStatement preparedStatement=dbUtil.getPrStat(sql);
        try {
            preparedStatement.setInt(1,id);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                return resultSet.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "";
    }
}
