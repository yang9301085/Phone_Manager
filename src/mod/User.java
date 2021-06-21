package mod;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/5/25 8:14 下午
 * @Created by 杨启仁
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private String gender;
    private boolean isBus;
    private double balance;
    public User() {
    }

    public User(int id, String name, String password, String email, String gender) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }

    public User(String name, String password, String email, String gender) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }

    public User(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public User(String name, String password, String email, String gender, boolean isBus) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.isBus = isBus;
    }

    public User(int id, String name, String password, String email, String gender, boolean isBus, double balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.isBus = isBus;
        this.balance = balance;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isBus() {
        return isBus;
    }

    public void setBus(boolean bus) {
        isBus = bus;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", isBus=" + isBus +
                ", balance=" + balance +
                '}';
    }
}
