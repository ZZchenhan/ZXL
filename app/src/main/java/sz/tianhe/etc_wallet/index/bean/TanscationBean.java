package sz.tianhe.etc_wallet.index.bean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 11:40
 */
public class TanscationBean {
    private String address;
    private int type;
    private String time;
    private double money;

    public TanscationBean(String address, int type, String time, double money) {
        this.address = address;
        this.type = type;
        this.time = time;
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
