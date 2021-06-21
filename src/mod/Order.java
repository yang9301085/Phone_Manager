package mod;

import java.util.List;

/**
 * @Classname Order
 * @Description TODO
 * @Date 2021/6/9 9:10 下午
 * @Created by 杨启仁
 */
public class Order<T>{
    private int id;
    private String userName;
    private List<T> listModelCount;

    public Order(int id, String userName, List<T> listModelCount) {
        this.id = id;
        this.userName = userName;
        this.listModelCount = listModelCount;
    }


    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<T> getListModelCount() {
        return listModelCount;
    }

    public void setListModelCount(List<T> listModelCount) {
        this.listModelCount = listModelCount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", listModelCount=" + listModelCount +
                '}';
    }
}
