package sz.tianhe.etc_wallet.index.bean;

/**
 * 已选择或没选则的地址
 */
public class SelectCoinVo {
    private String contractAddr;
    private boolean status;

    public String getContractAddr() {
        return contractAddr;
    }

    public void setContractAddr(String contractAddr) {
        this.contractAddr = contractAddr;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
