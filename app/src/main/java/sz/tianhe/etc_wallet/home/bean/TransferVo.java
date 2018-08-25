package sz.tianhe.etc_wallet.home.bean;

public class TransferVo {
    /**
     * 用户Id
     */
    private long userId;

    /**
     * 币种名称
     */
    private String coinName;

    /**
     * 交易地址
     */
    private String passwd;

    /**
     * 地址
     */
    private String address;
    /**
     * 数量
     */
    private String value;
    /**
     *
     */
    private String remark;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
