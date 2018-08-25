package sz.tianhe.etc_wallet.requst.vo;

import java.io.Serializable;

public class WalletItemBean implements Serializable{

    /**
     * id : 22
     * address : e5144702e8a7728f005dbd5c7ee4a0276b8c5139
     * contractAddr : 0xa5feeb8d6fd6bfb46df35924a34aebf7a36ab8bd
     * coinName : HUC
     * coinImg : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1535107678063&di=3edb7ba93dad1f79bac072909cedc46d&imgtype=0&src=http%3A%2F%2Fcimg.pcstore.com.tw%2Fcprd%2FC1124031499_big.png%3Fpimg%3Dstatic%26P%3D1506092677
     * userId : 1
     */

    private int id;
    private String address;
    private String contractAddr;
    private String coinName;
    private String coinImg;
    private int userId;
    private String banlance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContractAddr() {
        return contractAddr;
    }

    public void setContractAddr(String contractAddr) {
        this.contractAddr = contractAddr;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBanlance() {
        return banlance;
    }

    public void setBanlance(String banlance) {
        this.banlance = banlance;
    }
}
