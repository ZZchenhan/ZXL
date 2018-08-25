package sz.tianhe.etc_wallet.index.presenter;

import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;

import java.math.BigDecimal;
import java.util.List;


import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.model.bean.Result;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.weight.ProgrossDialog;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;

public class IndexPresenter extends AbstarctPresenter {
    OnIndexFragmentView mOnIndexFragmentView;

    public IndexPresenter(Context context, OnIndexFragmentView onIndexFragmentView) {
        super(context);
        this.mOnIndexFragmentView = onIndexFragmentView;
    }

    @Override
    public void init() {

    }


    /**
     * 获取用户总资金
     */
    public void getTotal() {
//        requst(MyApplication.retrofitClient.create(WalletApi.class).queryUserWalletTotal(MyApplication.user.getId()), new IResultListener<BigDecimal>() {
//            @Override
//            public void onListener(BigDecimal bigDecimal) {
//                mOnIndexFragmentView.totalNumber(bigDecimal);
//            }
//        }, false);
    }

    //获取钱包列表需要修改
    public void getWalletList(int page) {
        MyApplication.retrofitClient.create(WalletApi.class).
                queryUserWalletCoinList(MyApplication.user.getId()).subscribeOn(Schedulers.newThread())
                .concatMap((Function<Result<List<WalletItemBean>>,
                        ObservableSource<List<WalletItemBean>>>) pageBeanResult -> Observable.create(new ObservableOnSubscribe<List<WalletItemBean>>() {
                    @Override
                    public void subscribe(ObservableEmitter<List<WalletItemBean>> emitter) throws Exception {
                        for (WalletItemBean walletItemBean : pageBeanResult.getData()) {
                            walletItemBean.setBanlance(MyApplication.tranferClient.create(WalletApi.class).getSynchronizationETHBanlance("0x25C101Da7B6B5557bFF7D1FC840e28A1E00EB96f")
                                    .execute().body().getResult());
                        }
                        emitter.onNext(pageBeanResult.getData());
                    }
                })).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<List<WalletItemBean>>() {
            @Override
            public void onSubscribe(Disposable d) {
//                if(dialog==null){
//                    dialog = new ProgrossDialog(mContext);
//                }
//                dialog.show();
            }

            @Override
            public void onNext(List<WalletItemBean> walletItemBeans) {
                //   dialog.dismiss();
                if (mOnIndexFragmentView != null) {
                    mOnIndexFragmentView.walletList(walletItemBeans);
                }
            }

            @Override
            public void onError(Throwable e) {
                // dialog.dismiss();
                ToastUtils.showShort(e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }


    public interface OnIndexFragmentView {
        void totalNumber(BigDecimal total);

        void walletList(List<WalletItemBean> data);
    }
}
