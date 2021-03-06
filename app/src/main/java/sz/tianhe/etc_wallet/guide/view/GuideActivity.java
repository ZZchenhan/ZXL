package sz.tianhe.etc_wallet.guide.view;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityGuideBinding;
import sz.tianhe.etc_wallet.guide.presenter.GuidPrensenter;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class GuideActivity extends BaseActivity {

    ActivityGuideBinding binding;

    GuidPrensenter guidPrensenter;

    @Override
    public int layoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.statusDak(this);
        guidPrensenter = new GuidPrensenter(this,
                binding);
        guidPrensenter.init();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        guidPrensenter.onRequestPermissionsResult(requestCode,permissions,grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }
}
