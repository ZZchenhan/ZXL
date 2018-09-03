package sz.tianhe.etc_wallet.home.presenter;

import android.content.Context;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.weight.ProgrossDialog;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.requst.vo.ETHList;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationTotalBean;

public class TransferHistoryPresenter extends AbstarctPresenter {
    ITransfer mITransfer;
    public TransferHistoryPresenter(Context context,ITransfer mITransfer) {
        super(context);
        this.mITransfer = mITransfer;
    }

    @Override
    public void init() {

    }

    public void getTotal(String startTime){
//        requst(MyApplication.retrofitClient.create(WalletApi.class)
//                .getTransferTotal(MyApplication.user.getId(), startTime), new IResultListener<List<TanscationTotalBean>>() {
//            @Override
//            public void onListener(List<TanscationTotalBean> tanscationTotalBeans) {
//                mITransfer.total(tanscationTotalBeans.get(0));
//            }
//        });
    }

    /**
     *
     * @param address
     */
    public void getList(String address,int page){
//        requst(MyApplication.retrofitClient.create(WalletApi.class)
//                .getTransferHistory(page, 10, MyApplication.user.getId(), startTime), new IResultListener<PageBean<TanscationBean>>() {
//            @Override
//            public void onListener(PageBean<TanscationBean> tanscationBeanPageBean) {
//                mITransfer.list(tanscationBeanPageBean);
//            }
//        });
        MyApplication.tranferClient.create(WalletApi.class).getETHList(address,page,20)
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
                        if (mITransfer != null) {
                            mITransfer.list(ethList);
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

    public interface ITransfer{
        void total(TanscationTotalBean total);
        void list(ETHList page);
    }
}
