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

public class PrivacyActivity extends BaseActivity {
    ActivityPrivacyBinding binding;
    @Override
    public int layoutId() {
        return R.layout.activity_privacy;
    }

    @Override
    public IBaseNavagation navagation() {
        AdapterNavagation adapterNavagation = new AdapterNavagation(this);
        adapterNavagation.setTitle("隐私服务", 16, R.color.white);
        adapterNavagation.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
        adapterNavagation.setBack();
        return adapterNavagation;
    }

    @Override
    public void initView() {
        binding.btnNex.setOnClickListener(v->{
            if(!binding.isRead.isChecked()){
                toast("请阅读用户协议并且勾选");
            }else{
                CreateMemorizingActivity.openActivity(PrivacyActivity.this,CreateMemorizingActivity.class);
                finish();
            }
        });
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
