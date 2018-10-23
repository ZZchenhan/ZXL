package sz.tianhe.etc_wallet.index.presenter;

import android.content.Context;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.weight.ProgrossDialog;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.index.bean.ETHConcatBanclance;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.requst.vo.EHBBanlance;
import sz.tianhe.etc_wallet.requst.vo.ETHList;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;

public class WalletInfoPresenter extends AbstarctPresenter {
    IWlletInfoView mIWlletInfoView;

    public WalletInfoPresenter(Context context, IWlletInfoView wlletInfoView) {
        super(context);
        this.mIWlletInfoView = wlletInfoView;
    }

    @Override
    public void init() {

    }

    /**
     * 获取ETH详情
     */
    public void getDetails(String adress) {

    }


    /**
     * 获取ETH列表
     * @param page
     * @param adress
     */
    public void getTranList(int page, String adress) {

    }


    /**
     *
     * @param contactAdreess
     * @param address
     */
    public void getToken(String contactAdreess,String address){

    }

    /**
     *
     * @param contactAdreess
     * @param address
     */
    public void getTokenList(String contactAdreess,String address,int page){

    }

    public interface IWlletInfoView {
        void details(String balnce);

        void transcationList(ETHList pageBean);
    }
}
