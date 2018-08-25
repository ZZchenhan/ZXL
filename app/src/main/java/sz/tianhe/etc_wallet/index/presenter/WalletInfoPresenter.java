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
     * 获取钱包详情
     */
    public void getDetails(String adress) {
        MyApplication.tranferClient.create(WalletApi.class)
                .getETHBanlance(adress).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EHBBanlance>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (dialog == null)
                            dialog = new ProgrossDialog(mContext);
                        dialog.show();
                    }

                    @Override
                    public void onNext(EHBBanlance s) {
                        dialog.dismiss();
                        dialog.cancel();
                        if (mIWlletInfoView != null) {
                            mIWlletInfoView.details(s.getResult());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                        dialog.cancel();
                        erro(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void getTranList(int page, String adress) {
//        requst(MyApplication.retrofitClient.create(WalletApi.class)
//                .queryUserCoinTransactionList(page, 10, MyApplication.user.getId(), adress), new IResultListener<PageBean<TanscationBean>>() {
//            @Override
//            public void onListener(PageBean<TanscationBean> tanscationBeanPageBean) {
//                mIWlletInfoView.transcationList(tanscationBeanPageBean);
//            }
//        });

        MyApplication.tranferClient.create(WalletApi.class).getETHList(adress)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ETHList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (dialog == null)
                            dialog = new ProgrossDialog(mContext);
                        dialog.show();
                    }

                    @Override
                    public void onNext(ETHList ethList) {
                        dialog.dismiss();
                        dialog.cancel();
                        if (mIWlletInfoView != null) {
                            mIWlletInfoView.transcationList(ethList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                        dialog.cancel();
                        erro(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void getTokenList(String contactAdreess,String address){
        MyApplication.tranferClient.create(WalletApi.class).getTokenList(contactAdreess,address)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ETHList>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (dialog == null)
                            dialog = new ProgrossDialog(mContext);
                        dialog.show();
                    }

                    @Override
                    public void onNext(ETHList ethList) {
                        dialog.dismiss();
                        dialog.cancel();
                        if (mIWlletInfoView != null) {
                            mIWlletInfoView.transcationList(ethList);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                        dialog.cancel();
                        erro(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface IWlletInfoView {
        void details(String balnce);

        void transcationList(ETHList pageBean);
    }
}
