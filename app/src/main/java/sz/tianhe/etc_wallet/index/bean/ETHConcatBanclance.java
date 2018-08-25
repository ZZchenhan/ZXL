package sz.tianhe.etc_wallet.index.bean;

public class ETHConcatBanclance {

    /**
     * body : {"balance":"0"}
     * code : 4
     * type : ok
     */

    private BodyBean body;
    private int code;
    private String type;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class BodyBean {
        /**
         * balance : 0
         */

        private String balance="0";

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }
    }
}
