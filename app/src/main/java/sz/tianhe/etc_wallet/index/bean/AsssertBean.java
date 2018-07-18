package sz.tianhe.etc_wallet.index.bean;

import java.io.Serializable;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 10:46
 */
public class AsssertBean implements Serializable{
    private int iconId;
    private String coinTilte;
    private double coinNumber;
    private double value;

    public AsssertBean(int iconId, String coinTilte, double coinNumber, double value) {
        this.iconId = iconId;
        this.coinTilte = coinTilte;
        this.coinNumber = coinNumber;
        this.value = value;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getCoinTilte() {
        return coinTilte;
    }

    public void setCoinTilte(String coinTilte) {
        this.coinTilte = coinTilte;
    }

    public double getCoinNumber() {
        return coinNumber;
    }

    public void setCoinNumber(double coinNumber) {
        this.coinNumber = coinNumber;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
