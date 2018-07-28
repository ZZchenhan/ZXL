package sz.tianhe.etc_wallet.index.presenter;

import android.content.Context;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;

public class WalletInfoPresenter extends AbstarctPresenter {
    IWlletInfoView mIWlletInfoView;
    public WalletInfoPresenter(Context context,IWlletInfoView wlletInfoView) {
        super(context);
        this.mIWlletInfoView = wlletInfoView;
    }

    @Override
    public void init() {

    }

    /**
     * 获取钱包详情
     */
    public void getDetails(String coiName){
        requst(MyApplication.retrofitClient.create(WalletApi.class)
                .queryUserWalletDetail(1, 10, MyApplication.user.getId(), coiName), pageBean -> {
                    if(pageBean.getItems().size() == 0){
                        //toast("获取数据失败");
                    }else{
                        mIWlletInfoView.details(pageBean.getItems().get(0));
                    }
                });
    }


    public void getTranList(int page,String coiName){
        requst(MyApplication.retrofitClient.create(WalletApi.class)
                .queryUserCoinTransactionList(page, 10, MyApplication.user.getId(), coiName), pageBean -> mIWlletInfoView.transcationList(pageBean));
    }

    public interface IWlletInfoView{
        void details(WalletItemBean walletItemBean);
        void transcationList(PageBean<TanscationBean> pageBean);
    }
}
