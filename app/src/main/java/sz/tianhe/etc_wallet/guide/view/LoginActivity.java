package sz.tianhe.etc_wallet.guide.view;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityLoginBinding;
import sz.tianhe.etc_wallet.guide.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity {

    ActivityLoginBinding binding;

    LoginPresenter loginPresenter;

    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public IBaseNavagation navagation() {
        AdapterNavagation adapterNavagation = new AdapterNavagation(this)
                .setTitle("登录", 17, R.color.black)
                .setLineColor(R.color.lineColor);
        return adapterNavagation;
    }

    @Override
    public void initView() {
        loginPresenter.init();
    }

    @Override
    public void findViews() {
        loginPresenter = new LoginPresenter(this,binding.phone,binding.etPass,binding.login,binding.tvRegister);
    }

    @Override
    protected View bindViews() {
         binding =  DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }
}
