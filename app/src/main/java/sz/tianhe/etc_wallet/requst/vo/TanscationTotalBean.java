package sz.tianhe.etc_wallet.requst.vo;

import java.math.BigDecimal;

public class TanscationTotalBean {
    private BigDecimal turnTo;
    private BigDecimal  toChangeInto;

    public BigDecimal getTurnTo() {
        return turnTo;
    }

    public void setTurnTo(BigDecimal turnTo) {
        this.turnTo = turnTo;
    }

    public BigDecimal getToChangeInto() {
        return toChangeInto;
    }

    public void setToChangeInto(BigDecimal toChangeInto) {
        this.toChangeInto = toChangeInto;
    }
}
