package sz.tianhe.etc_wallet.requst.vo;

import java.math.BigDecimal;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 11:40
 */
public class TanscationBean {

            /**
             * id : 3
             * txType : 2
             * amount : -5
             * to : 44b0e722ec3a4448bb06fb5ea4417db2
             * hash : 57d4e6bfb85d49e8b0afee018e6c934d
             * createTime : 1529806060000
             */

            private int id;
            /**
             * 1 转入
             * 2 转出
             */
             private int txType;
            private BigDecimal amount;
            private String to;
            private String hash;
            private long createTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTxType() {
                return txType;
            }

            public void setTxType(int txType) {
                this.txType = txType;
            }

            public BigDecimal getAmount() {
                return amount;
            }

            public void setAmount(BigDecimal amount) {
                this.amount = amount;
            }

            public String getTo() {
                return to;
            }

            public void setTo(String to) {
                this.to = to;
            }

            public String getHash() {
                return hash;
            }

            public void setHash(String hash) {
                this.hash = hash;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
}

