package sz.tianhe.etc_wallet.guide.presenter;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;

import sz.tianhe.baselib.api.Api;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.utils.PhoneUtils;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.main.MainActivity;
import sz.tianhe.etc_wallet.requst.api.UserApi;
import sz.tianhe.etc_wallet.requst.vo.UserVo;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 14:13
 */
public class LoginPresenter extends AbstarctPresenter{


    public LoginPresenter(Context context) {
        super(context);
    }

    /**
     * 登录
     */
    private void login(String phone,String pass) {
        if (!PhoneUtils.isMobile0(phone)) {
            toast(R.string.phone_erro);
            return;
        }
        if (pass.length() == 0
                ) {
            toast("请输入密码");
            return;
        }
    }

    @Override
    public void init() {

    }
}
