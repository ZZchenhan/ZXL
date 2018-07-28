package sz.tianhe.etc_wallet.requst.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class WalletItemBean implements Serializable{
    /**
     * id : 1
     * coinId : 1
     * address : 57d4e6bfb85d49e8b0afee018e6c934d
     * freeAmount : 105
     * amount : 225
     * coinName : BTS
     * coinImg : http://img011.hc360.cn/k1/M07/6F/49/wKhQw1eDl9-EERlQAAAAANiIdPo336.jpg
     */

    private int id;
    private int coinId;
    private String address;
    private BigDecimal freeAmount;
    private BigDecimal amount;
    private String coinName;
    private String coinImg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoinId() {
        return coinId;
    }

    public void setCoinId(int coinId) {
        this.coinId = coinId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(BigDecimal freeAmount) {
        this.freeAmount = freeAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinImg() {
        return coinImg;
    }

    public void setCoinImg(String coinImg) {
        this.coinImg = coinImg;
    }
}
