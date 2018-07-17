package sz.tianhe.etc_wallet.guide.view;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.Utils;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityFirstChooseBinding;
import sz.tianhe.etc_wallet.home.activity.PrivacyActivity;

/**
 * 系统经过引导页之后判断第一次进入
 */
public class FirstChooseActivity extends BaseActivity implements View.OnClickListener{
    ActivityFirstChooseBinding binding;
    @Override
    public int layoutId() {
        return R.layout.activity_first_choose;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        BarUtils.setStatusBarColor(this, Color.parseColor("#FFFFFFFF"));
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
                toast("登录");
                break;
        }
    }
}
