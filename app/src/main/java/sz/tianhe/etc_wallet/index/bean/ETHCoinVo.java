package sz.tianhe.etc_wallet.index.bean;

/**
 *
 */
public class ETHCoinVo {

    /**
     * contractAddress : 0xef15aeca03d364c228049dd997546dbee9afb6b2
     * name : HUC Coin (HUC)
     * symbol : HUC
     */

    private String contractAddress;
    private String name;
    private String symbol;
    private boolean isAdd;

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isAdd() {
        return isAdd;
    }

    public void setAdd(boolean add) {
        isAdd = add;
    }
}
