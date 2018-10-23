package sz.tianhe.etc_wallet.home.activity;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityPrivacyBinding;
import sz.tianhe.etc_wallet.guide.view.CreateMemorizingActivity;
import sz.tianhe.etc_wallet.guide.view.PhoneRegisterActivity;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class PrivacyActivity extends BaseActivity {
    ActivityPrivacyBinding binding;
    @Override
    public int layoutId() {
        return R.layout.activity_privacy;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.statusDak(this);
        binding.btnNex.setOnClickListener(v->{
            if(!binding.isRead.isChecked()){
                toast("请阅读用户协议并且勾选");
            }else{
                PhoneRegisterActivity.openActivity(PrivacyActivity.this,PhoneRegisterActivity.class);
                finish();
            }
        });
        if(getIntent().getStringExtra("isSee") != null){
            binding.llSee.setVisibility(View.GONE);
        }
    }

    @Override
    public void findViews() {
    }

    @Override
    protected View bindViews() {
        binding =  DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }


}
