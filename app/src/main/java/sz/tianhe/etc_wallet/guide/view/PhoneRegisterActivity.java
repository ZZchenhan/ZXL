package sz.tianhe.etc_wallet.guide.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityPhoneRegisterBinding;
import sz.tianhe.etc_wallet.main.MainActivity;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class PhoneRegisterActivity extends BaseActivity {
    ActivityPhoneRegisterBinding binding;

    @Override
    public int layoutId() {
        return R.layout.activity_phone_register;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
    }

    @Override
    public void findViews() {
        binding.toolbar.setNavigationOnClickListener(v -> finish());
        binding.register.setOnClickListener(v -> {
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
}
