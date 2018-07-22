package sz.tianhe.etc_wallet.assets.bean;

import java.util.List;

/**
 * Created by 86936 on 2018/7/23.
 *
 * @QQ 869360026
 */

public class CoinVo {
    private String coinName;
    private List<String> marketNames;

    public CoinVo(String coinName, List<String> marketNames) {
        this.coinName = coinName;
        this.marketNames = marketNames;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public List<String> getMarketNames() {
        return marketNames;
    }

    public void setMarketNames(List<String> marketNames) {
        this.marketNames = marketNames;
    }
}
