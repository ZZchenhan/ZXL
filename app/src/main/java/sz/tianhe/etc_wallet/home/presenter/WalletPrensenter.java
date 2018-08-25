package sz.tianhe.etc_wallet.home.presenter;

import android.content.Context;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.home.bean.SetPassVo;
import sz.tianhe.etc_wallet.requst.api.WalletApi;

public class WalletPrensenter extends AbstarctPresenter {
    private IConfimrWalletPresenter iConfimrWalletPresenter;
    public WalletPrensenter(Context context,IConfimrWalletPresenter iConfimrWalletPresenter) {
        super(context);
        this.iConfimrWalletPresenter = iConfimrWalletPresenter;
    }

    @Override
    public void init() {

    }


    public void createWallet(String phone,String pass){
        requst(MyApplication.retrofitClient.create(WalletApi.class).
                        createETHWallet(new SetPassVo(phone,pass)),
                new IResultListener<String>() {
            @Override
            public void onListener(String t) {
                if(iConfimrWalletPresenter!=null){
                    iConfimrWalletPresenter.onConfimrSuccess();
                }
            }
        },true);
    }


    public interface IConfimrWalletPresenter{
        void onConfimrSuccess();
    }
}
