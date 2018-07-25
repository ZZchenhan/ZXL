package sz.tianhe.etc_wallet.guide.presenter;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.utils.PhoneUtils;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.guide.bean.RegisterBean;
import sz.tianhe.etc_wallet.requst.api.UserApi;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 15:22
 */
public class RegisterPresenter extends AbstarctPresenter {


    public RegisterPresenter(Context context,IRegister iRegister) {
        super(context);
        this.iRegister = iRegister;
    }

    @Override
    public void init() {

    }


    public void register(RegisterBean registerBean){
        requst(MyApplication.retrofitClient.create(UserApi.class).register(registerBean.getPhone(), registerBean.getPass(), registerBean.getInvaldCode(), registerBean.getWords()), s -> {
            if(iRegister!=null){
                iRegister.success();
            }
        },true);
    }


    IRegister iRegister;
    public interface IRegister{
        void success();
    }
}
