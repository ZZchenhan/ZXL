package sz.tianhe.etc_wallet.requst.vo;

import java.math.BigDecimal;

public class YesterDayProfit {
    private BigDecimal freeAmount;
    private BigDecimal yesterdayProfit;

    public BigDecimal getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(BigDecimal freeAmount) {
        this.freeAmount = freeAmount;
    }

    public BigDecimal getYesterdayProfit() {
        return yesterdayProfit;
    }

    public void setYesterdayProfit(BigDecimal yesterdayProfit) {
        this.yesterdayProfit = yesterdayProfit;
    }
}
