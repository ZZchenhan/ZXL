package sz.tianhe.etc_wallet.assets.bean;

public class QutaiorBean {


    /**
     * result : true
     * last : 0.1
     * lowestAsk : 0.1
     * highestBid : 0.00000000
     * percentChange : 0
     * baseVolume : 0.001
     * quoteVolume : 0.01
     * high24hr : 0.1
     * low24hr : 0.1
     */

    private String coinName;

    /**
     * quoteVolume : 645613.1328816172
     * baseVolume : 133815.20061995024416
     * highestBid : 0.2034
     * high24hr : 0.2128
     * last : 0.2055
     * lowestAsk : 0.206
     * elapsed : 2006ms
     * result : true
     * low24hr : 0.1978
     * percentChange : 0.88365243004418
     */

    private String quoteVolume;
    private String baseVolume;
    private String highestBid;
    private String high24hr;
    private String last;
    private String lowestAsk;
    private String elapsed;
    private String result;
    private String low24hr;
    private String percentChange;

    public String getQuoteVolume() {
        return quoteVolume;
    }

    public void setQuoteVolume(String quoteVolume) {
        this.quoteVolume = quoteVolume;
    }

    public String getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(String baseVolume) {
        this.baseVolume = baseVolume;
    }

    public String getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(String highestBid) {
        this.highestBid = highestBid;
    }

    public String getHigh24hr() {
        return high24hr;
    }

    public void setHigh24hr(String high24hr) {
        this.high24hr = high24hr;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(String lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLow24hr() {
        return low24hr;
    }

    public void setLow24hr(String low24hr) {
        this.low24hr = low24hr;
    }

    public String getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(String percentChange) {
        this.percentChange = percentChange;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }
}
