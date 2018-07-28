package sz.tianhe.etc_wallet.requst.vo;

import java.util.List;

public class PageBean<T>{
    /**
     * currentPage : 1
     * currentSize : 20
     * totalNum : 3
     * items : [{"id":1,"coinId":1,"address":"57d4e6bfb85d49e8b0afee018e6c934d","freeAmount":105,"amount":225,"coinName":"BTS","coinImg":"http://img011.hc360.cn/k1/M07/6F/49/wKhQw1eDl9-EERlQAAAAANiIdPo336.jpg"},{"id":2,"coinId":2,"address":"2a10b48c6fc64a4e8e411e10d6181988","freeAmount":100.123,"amount":300.123,"coinName":"BTC","coinImg":"http://img011.hc360.cn/k1/M07/6F/49/wKhQw1eDl9-EERlQAAAAANiIdPo336.jpg"},{"id":4,"coinId":4,"address":"167deabc8d2f493cbfe879aa49585399","freeAmount":310,"amount":360,"coinName":"EOS","coinImg":"http://img011.hc360.cn/k1/M07/6F/49/wKhQw1eDl9-EERlQAAAAANiIdPo336.jpg"}]
     */

    private int currentPage;
    private int currentSize;
    private int totalNum;
    private List<T> items;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

}
