package sz.tianhe.etc_wallet.home.presenter;

import android.content.Context;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.requst.vo.ManagerItem;
import sz.tianhe.etc_wallet.requst.vo.PageBean;

public class ManagerPreseter extends AbstarctPresenter {

    private OnManagerListener onManagerListener;

    public ManagerPreseter(Context context,OnManagerListener onManagerListener) {
        super(context);
        this.onManagerListener = onManagerListener;
    }

    @Override
    public void init() {

    }

    public void getList(int page){
        requst(MyApplication.retrofitClient.create(WalletApi.class)
                .getManager(page, 10, MyApplication.user.getId()), new IResultListener<PageBean<ManagerItem>>() {
            @Override
            public void onListener(PageBean<ManagerItem> managerItemPageBean) {
                onManagerListener.onManagerListen(managerItemPageBean);
            }
        });
    }

    public interface OnManagerListener{
        void onManagerListen(PageBean<ManagerItem> pageBean);
    }
}
