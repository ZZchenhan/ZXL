package sz.tianhe.etc_wallet.index.bean;

/**
 * 添加合约币ID
 */
public class AddCoinVo {
    /**
     * 用户Id
     */
    private long userId;
    /**
     * 全称
     */
    private String name;
    /**
     * 简称
     */
    private String coinName;

    /**
     * 合约比地址
     */
    private String contractAddr;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getContractAddr() {
        return contractAddr;
    }

    public void setContractAddr(String contractAddr) {
        this.contractAddr = contractAddr;
    }
}
