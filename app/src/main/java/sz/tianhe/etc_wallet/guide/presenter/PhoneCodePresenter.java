package sz.tianhe.etc_wallet.guide.presenter;

import android.content.Context;

import sz.tianhe.baselib.http.IResultListener;
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
        requst(MyApplication.retrofitClient.create(CodeApi.class).getCode(phone, "4"), new IResultListener<String>() {
                    @Override
                    public void onListener(String s) {
                      toast(s);
                    }
                }
                , true);
    }

    public void chekCode(String phone, String code) {
        requst(MyApplication.retrofitClient.create(CodeApi.class).check(phone, code), new IResultListener<String>() {
                    @Override
                    public void onListener(String s) {
                        iPhoneCodeView.checkSuccess();
                    }
                }
                , true);
    }

    public interface IPhoneCodeView {
        void checkSuccess();
    }
}
