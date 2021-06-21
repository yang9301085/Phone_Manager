package mod;

import jdk.nashorn.internal.objects.annotations.Where;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Classname PageBean
 * @Description TODO
 * @Date 2021/5/27 12:10 下午
 * @Created by 杨启仁
 */
public class PageBean<T> {
    /** 总记录数*/
    private int totalCount;
    /** 总页数*/
    private int totalPage;
    /** 每页的数据*/
    private List<T> list;
    /** 当前页码*/
    private int currentPage;
    /** 每页显示的记录数*/
    private final int ROWS =5;

    /**
     * 无参构造方法：设置totalCount和totalPage
     */
    public PageBean() {
        DBUtil dbUtil=new DBUtil();
        String sql="select count(*) from tb_user";
        System.out.println("PageBean()::"+sql);
        ResultSet resultSet=dbUtil.getResultSet(sql);
        try {
            while (resultSet.next()){
                totalCount=resultSet.getInt(1);
                totalPage=(totalCount%ROWS==0)?totalCount/ROWS:(totalCount/ROWS+1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 有参构造，通过表名设置totalCount和totalPage
     * @param tb_name 表名
     */
    public PageBean(String tb_name){
        DBUtil dbUtil=new DBUtil();
        String sql="select count(*) from "+tb_name+";";
        Statement stat=dbUtil.getStat();
        try {
            System.out.println(stat);
            ResultSet rs=stat.executeQuery(sql);
            while (rs.next()){
                totalCount=rs.getInt(1);
                totalPage=(totalCount%ROWS==0)?totalCount/ROWS:(totalCount/ROWS+1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public PageBean(int totalCount, int totalPage, List<T> list, int currentPage) {
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.list = list;
        this.currentPage = currentPage;
    }

    public int getTotalCount() {


        return totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return ROWS;
    }



    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPage=" + currentPage +
                ", rows=" + ROWS +
                '}';
    }
}