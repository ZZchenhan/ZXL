package sz.tianhe.etc_wallet.guide.presenter;

import android.content.Context;

import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.CodeApi;

public class PhoneCodePresenter extends AbstarctPresenter {
    IPhoneCodeView iPhoneCodeView;

    public PhoneCodePresenter(Context context, IPhoneCodeView iPhoneCodeView) {
        super(context);
        this.iPhoneCodeView = iPhoneCodeView;
    }

    @Override
    public void init() {

    }

    public void getCode(String phone) {
        requst(MyApplication.retrofitClient.create(CodeApi.class).getCode(phone, "4"), t -> toast(t)
                , true);
    }

    public void chekCode(String phone, String code) {
        requst(MyApplication.retrofitClient.create(CodeApi.class).check(phone, code), t -> iPhoneCodeView.checkSuccess()
                , true);
    }

    public interface IPhoneCodeView {
        void checkSuccess();
    }
}
