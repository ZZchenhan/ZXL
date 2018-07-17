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

    /**
     * 电话
     */
    private EditText etPhone;

    /**
     * 密码
     */
    private EditText etPass;

    /**
     * 提交按钮
     */
    private Button btnComfinm;

    /**
     * 注册按钮
     */
    private TextView tvRegister;


    private LoginPresenter(Context context) {
        super(context);
    }

    public LoginPresenter(Context context
            , EditText etPhone, EditText etPass, Button btnComfinm, TextView tvRegister) {
        super(context);
        this.etPhone = etPhone;
        this.etPass = etPass;
        this.btnComfinm = btnComfinm;
        this.tvRegister = tvRegister;
    }


    @Override
    public void init() {
        btnComfinm.setOnClickListener(view -> login());
        tvRegister.setOnClickListener(view -> MainActivity.openActivity(mContext, MainActivity.class));
    }


    /**
     * 登录
     */
    private void login() {
        if (!PhoneUtils.isMobile0(etPhone.getText().toString())) {
            toast(R.string.phone_erro);
            return;
        }
        if (etPass.getText().toString().length() > 14
                || etPass.getText().toString().length() < 6
                ) {
            toast(R.string.pass_length_erro);
            return;
        }
    }
}
