package mod;

/**
 * @Classname Factory
 * @Description TODO
 * @Date 2021/7/6 11:37 上午
 * @Created by 杨启仁
 */
public class Factory {
    private int id;
    private String name;
    private String addr;
    private String phone;
    /**
     * 经度
     */
    private double longitude;
    /**
     * 纬度
     */
    private double latitude;


    public Factory(int id,  String name,String addr, String phone, double longitude, double latitude) {
        this.id = id;
        this.name=name;
        this.addr = addr;
        this.phone = phone;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Factory(int id, String name,String addr, String phone) {
        this.id = id;
        this.name=name;
        this.addr = addr;
        this.phone = phone;
    }

    public Factory() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
