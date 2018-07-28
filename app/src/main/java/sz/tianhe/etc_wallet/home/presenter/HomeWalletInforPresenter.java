package sz.tianhe.etc_wallet.home.presenter;

import android.content.Context;

import java.util.List;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.requst.vo.YesterDayProfit;

public class HomeWalletInforPresenter extends AbstarctPresenter {
    IHomeWalletInfoListener mIHomeWalletInfoListener;
    public HomeWalletInforPresenter(Context context,IHomeWalletInfoListener iHomeWalletInfoListener) {
        super(context);
        this.mIHomeWalletInfoListener = iHomeWalletInfoListener;
    }

    @Override
    public void init() {

    }


    public void getProfit(int coinId){
        requst(MyApplication.retrofitClient.create(WalletApi.class).getYestdatProfit(MyApplication.user.getId(), coinId), new IResultListener<List<YesterDayProfit>>() {
            @Override
            public void onListener(List<YesterDayProfit> yesterDayProfits) {
                if(yesterDayProfits.size()!=0)
                     mIHomeWalletInfoListener.profit(yesterDayProfits.get(0));
            }
        });
    }

    public void getTranslist(int page,String coinName){
        requst(MyApplication.retrofitClient.create(WalletApi.class).getManagerList(page, 10, MyApplication.user.getId(), coinName), new IResultListener<PageBean<TanscationBean>>() {
            @Override
            public void onListener(PageBean<TanscationBean> pageBean) {
                mIHomeWalletInfoListener.list(pageBean);
            }
        });
    }

    public interface IHomeWalletInfoListener{
        void profit(YesterDayProfit profit);
        void list(PageBean<TanscationBean> pageBean);
    }
}
