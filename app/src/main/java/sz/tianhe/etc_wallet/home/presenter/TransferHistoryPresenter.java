package sz.tianhe.etc_wallet.home.presenter;

import android.content.Context;

import java.util.List;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
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
        requst(MyApplication.retrofitClient.create(WalletApi.class)
                .getTransferTotal(MyApplication.user.getId(), startTime), pageBean -> {
                    mITransfer.total(pageBean.get(0));
                });
    }

    public void getList(int page,String startTime){
        requst(MyApplication.retrofitClient.create(WalletApi.class)
                .getTransferHistory(page, 10, MyApplication.user.getId(), startTime), pageBean -> {
            mITransfer.list(pageBean);
        });
    }

    public interface ITransfer{
        void total(TanscationTotalBean total);
        void list(PageBean<TanscationBean> page);
    }
}
