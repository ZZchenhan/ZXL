package sz.tianhe.etc_wallet.index.presenter;

import android.content.Context;

import retrofit2.http.Query;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.WalletApi;

public class TransferPresenter extends AbstarctPresenter {
    OnTransferListener onTransferListener;
    public TransferPresenter(Context context,OnTransferListener onTransferListener) {
        super(context);
        this.onTransferListener = onTransferListener;
    }

    @Override
    public void init() {

    }

    /**
     * 用户转账
     * @param id
     * @param amount
     * @param address
     * @param coinName
     * @param remark
     */
    public void  transfer(int id,String amount,String address,String coinName,String remark){
        requst(MyApplication.retrofitClient.create(WalletApi.class)
                .transfer(id, amount, address, coinName, remark), s -> {
                    onTransferListener.onTransfer(s);
                });
    }

    public interface  OnTransferListener{
        void onTransfer(String string);
    }
}
