package sz.tianhe.etc_wallet.index.presenter;

import android.content.Context;

import retrofit2.http.Query;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.home.bean.TransferVo;
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
    public void  transfer(int id,String amount,String address,String coinName,String remark,String pass){
        TransferVo transferVo = new TransferVo();
        transferVo.setUserId(id);
        transferVo.setCoinName(coinName);
        transferVo.setPasswd(pass);
        transferVo.setAddress(address);
        transferVo.setValue(amount);
        transferVo.setRemark(remark);
        requst(MyApplication.tranferClient.create(WalletApi.class).transferETH(transferVo), new IResultListener<String>() {
            @Override
            public void onListener(String s) {
                onTransferListener.onTransfer(s);
            }
        });
    }

    public interface  OnTransferListener{
        void onTransfer(String string);
    }
}
