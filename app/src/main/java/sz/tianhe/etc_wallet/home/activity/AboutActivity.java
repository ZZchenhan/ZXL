package sz.tianhe.etc_wallet.home.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;



import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class AboutActivity extends BaseActivity {
    private Toolbar toolbar;
    @Override
    public int layoutId() {
        return R.layout.activity_about;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());

    }

    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        return null;
    }
}
