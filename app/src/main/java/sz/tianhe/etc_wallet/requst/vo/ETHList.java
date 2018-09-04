package sz.tianhe.etc_wallet.requst.vo;

import java.math.BigDecimal;
import java.util.List;

public class ETHList {

    /**
     * code : 200
     * data : {"items":[]}
     * message : ok
     * type : ok
     */

    private int code;
    private DataBean data;
    private String message;
    private String type;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class DataBean {
        private List<ResultBean> items;

        public List<ResultBean> getItems() {
            return items;
        }

        public void setItems(List<ResultBean> items) {
            this.items = items;
        }
    }


    public static class ResultBean{

        /**
         * blockHash : 0xd59fec9197e359285566b715c62f97357b9b2215e1f97669c29401c190774cae
         * contractAddress :
         * transactionIndex : 14
         * confirmations : 48924
         * nonce : 15
         * timeStamp : 1535337761
         * input : 0xa9059cbb000000000000000000000000578cf2058ef501a28b93ccfed53d51c5175532790000000000000000000000000000000000000000000000009819bdee72480000
         * gasUsed : 37003
         * isError : 0
         * txreceipt_status : 1
         * blockNumber : 6220458
         * gas : 200000
         * cumulativeGasUsed : 545173
         * from : 0x578cf2058ef501a28b93ccfed53d51c517553279
         * to : 0xa5feeb8d6fd6bfb46df35924a34aebf7a36ab8bd
         * value : 0
         * hash : 0xf9d66cfbffa153991e26cc7f3ecdbf6a5259fc638fe7c30c218b5223c21896d7
         * gasPrice : 30000000000
         */

        private String blockHash;
        private String contractAddress;
        private String transactionIndex;
        private String confirmations;
        private String nonce;
        private long timeStamp;
        private String input;
        private String gasUsed;
        private String isError;
        private String txreceipt_status;
        private String blockNumber;
        private String gas;
        private String cumulativeGasUsed;
        private String from;
        private String to;
        private BigDecimal value;
        private String hash;
        private String gasPrice;

        public String getBlockHash() {
            return blockHash;
        }

        public void setBlockHash(String blockHash) {
            this.blockHash = blockHash;
        }

        public String getContractAddress() {
            return contractAddress;
        }

        public void setContractAddress(String contractAddress) {
            this.contractAddress = contractAddress;
        }

        public String getTransactionIndex() {
            return transactionIndex;
        }

        public void setTransactionIndex(String transactionIndex) {
            this.transactionIndex = transactionIndex;
        }

        public String getConfirmations() {
            return confirmations;
        }

        public void setConfirmations(String confirmations) {
            this.confirmations = confirmations;
        }

        public String getNonce() {
            return nonce;
        }

        public void setNonce(String nonce) {
            this.nonce = nonce;
        }

        public long getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getGasUsed() {
            return gasUsed;
        }

        public void setGasUsed(String gasUsed) {
            this.gasUsed = gasUsed;
        }

        public String getIsError() {
            return isError;
        }

        public void setIsError(String isError) {
            this.isError = isError;
        }

        public String getTxreceipt_status() {
            return txreceipt_status;
        }

        public void setTxreceipt_status(String txreceipt_status) {
            this.txreceipt_status = txreceipt_status;
        }

        public String getBlockNumber() {
            return blockNumber;
        }

        public void setBlockNumber(String blockNumber) {
            this.blockNumber = blockNumber;
        }

        public String getGas() {
            return gas;
        }

        public void setGas(String gas) {
            this.gas = gas;
        }

        public String getCumulativeGasUsed() {
            return cumulativeGasUsed;
        }

        public void setCumulativeGasUsed(String cumulativeGasUsed) {
            this.cumulativeGasUsed = cumulativeGasUsed;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public BigDecimal getValue() {
            return value;
        }

        public void setValue(BigDecimal value) {
            this.value = value;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            this.hash = hash;
        }

        public String getGasPrice() {
            return gasPrice;
        }

        public void setGasPrice(String gasPrice) {
            this.gasPrice = gasPrice;
        }
    }
}
