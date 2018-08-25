package sz.tianhe.etc_wallet.home.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityConfirmPassBinding;
import sz.tianhe.etc_wallet.guide.bean.RegisterBean;
import sz.tianhe.etc_wallet.guide.presenter.RegisterPresenter;
import sz.tianhe.etc_wallet.guide.view.FirstChooseActivity;
import sz.tianhe.etc_wallet.home.presenter.WalletPrensenter;
import sz.tianhe.etc_wallet.main.MainActivity;
import sz.tianhe.etc_wallet.utils.SoftUtils;

public class ConfirmWallentPassActivity extends BaseActivity implements TextWatcher,WalletPrensenter.IConfimrWalletPresenter {
    AdapterNavagation adapterNavagation;
    ActivityConfirmPassBinding binding;
    WalletPrensenter registerPresenter;
    @Override
    public int layoutId() {
        return R.layout.activity_confirm_pass;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.colorPrimary)
                .setBack()
                .setLeftText("设置支付密码",14,R.color.white,v->finish());
        return adapterNavagation;
    }

    @Override
    public IBasePresenter createPrensenter() {
        registerPresenter = new WalletPrensenter(this,this);
        return registerPresenter;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findViews() {
        binding.input.addTextChangedListener(this);
        binding.textView4.setText("确认支付密码");
        binding.textView5.setText("再次确认支付密码");
        binding.textView6.setOnClickListener(v -> finish());
        binding.textView6.setVisibility(View.VISIBLE);
        SoftUtils.showSoftInputFromWindow(this,binding.input);
    }

    @Override
    protected View bindViews() {
        binding =  DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(binding.input.getText().toString().length() == 6){
            if(getIntent().getStringExtra("data").equals(binding.input.getText().toString())){
                registerPresenter.createWallet(MyApplication.user.getPhoneNum(),binding.input.getText().toString());
            }else{
                toast("两次数据密码不正确");
            }
        }
    }



    @Override
    public void onConfimrSuccess() {
        finish();
    }
}

