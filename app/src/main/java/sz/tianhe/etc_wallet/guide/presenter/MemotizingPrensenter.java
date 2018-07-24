package sz.tianhe.etc_wallet.guide.presenter;

import android.content.Context;

import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.UserApi;

/**
 * 助记词帮助
 */
public class MemotizingPrensenter extends AbstarctPresenter{
    /**
     *
     */
    private IMemotizinView memotizinView;

    public MemotizingPrensenter(Context context,IMemotizinView memotizinView) {
        super(context);
        this.memotizinView = memotizinView;
    }

    @Override
    public void init() {
        requst(MyApplication.retrofitClient.create(UserApi.class).mnemonit(), s -> {
            memotizinView.memotizingSuccess(s);
        })
        ;
    }


    public interface IMemotizinView{
        void memotizingSuccess(String world);
    }
}
