package sz.tianhe.etc_wallet.guide.presenter;

import android.content.Context;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.utils.PhoneUtils;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.requst.api.UserApi;
import sz.tianhe.etc_wallet.requst.vo.User;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 14:13
 */
public class LoginPresenter extends AbstarctPresenter {

    ILoginView mIloginView;
    public LoginPresenter(Context context,ILoginView iLoginView) {
        super(context);
        this.mIloginView  = iLoginView;
    }

    /**
     * 登录
     */
    public void login(String phone, String pass) {
        requst(MyApplication.retrofitClient.create(UserApi.class).login(phone, pass), user -> {
            if(null != mIloginView){

                mIloginView.loginSuccess();
            }
        }, false);
    }

    @Override
    public void init() {

    }


    public interface ILoginView{
        void loginSuccess();
    }
}
