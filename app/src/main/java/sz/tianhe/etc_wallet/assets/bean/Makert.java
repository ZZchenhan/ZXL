package sz.tianhe.etc_wallet.assets.bean;

/**
 * Created by 86936 on 2018/7/23.
 *
 * @QQ 869360026
 */

public class Makert {
    private String amountScale;//数量小数点位数
    private String priceScale;//价格小数点位数

    public String getAmountScale() {
        return amountScale;
    }

    public void setAmountScale(String amountScale) {
        this.amountScale = amountScale;
    }

    public Makert(String amountScale, String priceScale) {

        this.amountScale = amountScale;
        this.priceScale = priceScale;
    }

    public String getPriceScale() {

        return priceScale;
    }

    public void setPriceScale(String priceScale) {
        this.priceScale = priceScale;
    }
}
