package sz.tianhe.etc_wallet.index.presenter;

import android.content.Context;

import com.blankj.utilcode.util.ToastUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
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

    }

    //获取钱包列表需要修改
    public void getWalletList(int page) {

    }


    public interface OnIndexFragmentView {
        void totalNumber(BigDecimal total);

        void walletList(List<WalletItemBean> data);
    }
}
