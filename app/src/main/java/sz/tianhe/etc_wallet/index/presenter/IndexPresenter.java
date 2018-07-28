package sz.tianhe.etc_wallet.index.presenter;

import android.content.Context;

import java.math.BigDecimal;
import java.util.List;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;

public class IndexPresenter extends AbstarctPresenter {
    OnIndexFragmentView mOnIndexFragmentView;
    public IndexPresenter(Context context,OnIndexFragmentView onIndexFragmentView) {
        super(context);
        this.mOnIndexFragmentView = onIndexFragmentView;
    }

    @Override
    public void init() {

    }


    /**
     * 获取用户总资金
     */
    public void getTotal(){
        requst(MyApplication.retrofitClient.create(WalletApi.class).queryUserWalletTotal(MyApplication.user.getId()), bigDecimal -> {
            this.mOnIndexFragmentView.totalNumber(bigDecimal);
        },false);
    }

    public void getWalletList(int page){
        requst(MyApplication.retrofitClient.create(WalletApi.class).queryUserWalletCoinList(page, 20, MyApplication.user.getId()), s -> {
            this.mOnIndexFragmentView.walletList(s);
        }, false);
    }


    public interface OnIndexFragmentView{
        void totalNumber(BigDecimal total);
        void walletList(PageBean<WalletItemBean> page);
    }
}
