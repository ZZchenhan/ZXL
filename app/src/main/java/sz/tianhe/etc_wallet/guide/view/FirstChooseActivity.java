package sz.tianhe.etc_wallet.guide.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.Utils;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityFirstChooseBinding;
import sz.tianhe.etc_wallet.guide.bean.RegisterBean;
import sz.tianhe.etc_wallet.guide.presenter.LoginPresenter;
import sz.tianhe.etc_wallet.home.activity.PrivacyActivity;
import sz.tianhe.etc_wallet.main.MainActivity;
import sz.tianhe.etc_wallet.main.prensenter.MainPrensenter;
import sz.tianhe.etc_wallet.requst.vo.User;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;
import sz.tianhe.etc_wallet.utils.TokenUtil;

/**
 * 系统经过引导页之后判断第一次进入
 */
public class FirstChooseActivity extends BaseActivity implements View.OnClickListener,LoginPresenter.ILoginView{
    ActivityFirstChooseBinding binding;
    LoginPresenter loginPresenter;

    @Override
    public int layoutId() {
        return R.layout.activity_first_choose;
    }

    @Override
    public IBasePresenter createPrensenter() {
        loginPresenter = new LoginPresenter(this,this);
        //mainPrensenter = new MainPrensenter(this,this);
        return super.createPrensenter();
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.statusDak(this);
        if(getIntent().getSerializableExtra("data") != null){
            RegisterBean registerBean = (RegisterBean) getIntent().getSerializableExtra("data");
            loginPresenter.login(registerBean.getPhone(),registerBean.getPass());
        }
    }

    @Override
    public void findViews() {
        binding.createWallet.setOnClickListener(this);
        binding.importWallet.setOnClickListener(this);
    }

    @Override
    protected View bindViews() {
        binding =  DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.create_wallet:
                PrivacyActivity.openActivity(this,PrivacyActivity.class);
                break;
            case R.id.import_wallet:
                LoginActivity.openActivity(this,LoginActivity.class);
                break;
        }
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setClass(this,MainActivity.class);
        startActivity(intent);
    }


}
