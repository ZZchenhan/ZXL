package sz.tianhe.etc_wallet.guide.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityLoginBinding;
import sz.tianhe.etc_wallet.guide.presenter.LoginPresenter;
import sz.tianhe.etc_wallet.main.MainActivity;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class LoginActivity extends BaseActivity implements LoginPresenter.ILoginView {

    ActivityLoginBinding binding;

    LoginPresenter loginPresenter;


    @Override
    public int layoutId() {
        return R.layout.activity_login;
    }

    @Override
    public IBaseNavagation navagation() {
       return null;
    }

    @Override
    public IBasePresenter createPrensenter() {
        loginPresenter = new LoginPresenter(this, this);
        return super.createPrensenter();
    }

    @Override
    public void initView() {
        StatusBarUtils.statusDak(this);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    public void findViews() {
        binding.btnLogin.setOnClickListener(v ->
        {
//            loginPresenter.login(binding.phone.getText().toString(),binding.pass.getText().toString());
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
