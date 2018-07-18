package sz.tianhe.etc_wallet.guide.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityConfirmPassBinding;
import sz.tianhe.etc_wallet.main.MainActivity;

public class ConfirmPassActivity extends BaseActivity implements TextWatcher{
    AdapterNavagation adapterNavagation;
    ActivityConfirmPassBinding binding;
    @Override
    public int layoutId() {
        return R.layout.activity_confirm_pass;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.colorPrimary)
                .setBack()
                .setLeftText("设置登录密码",14,R.color.white,v->finish());
        return adapterNavagation;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findViews() {
        binding.input.addTextChangedListener(this);
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
            Intent intent = new Intent(ConfirmPassActivity.this, FirstChooseActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("data","登录");
            startActivity(intent);
        }
    }
}

