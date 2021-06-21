package mod;

/**
 * @Classname Mobile
 * @Description TODO
 * @Date 2021/5/25 8:16 下午
 * @Created by 杨启仁
 */
public class Mobile {
    private int id;
    private String model;
    private String factory;
    private Double value;
    private final String AN="ANDROID";
    private final String AP="IOS";

    public Mobile() {
    }

    public Mobile(String model, String factory, double value) {
        this.model = model;
        this.factory = factory;
        this.value = value;
    }

    public Mobile(int id, String model, String factory, double value) {
        this.id=id;
        this.model = model;
        this.factory = factory;
        this.value = value;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getAN() {
        return AN;
    }

    public String getAP() {
        return AP;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "model='" + model + '\'' +
                ", factory='" + factory + '\'' +
                ", value=" + value +
                ", AN='" + AN + '\'' +
                ", AP='" + AP + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
