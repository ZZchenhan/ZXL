package sz.tianhe.etc_wallet.home.activity;

import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;

public class AboutActivity extends BaseActivity {
    AdapterNavagation adapterNavagation;

    @Override
    public int layoutId() {
        return R.layout.activity_about;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.colorPrimary)
                .setBack()
                .setTitle("关于", 16, R.color.white);
        return adapterNavagation;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        return null;
    }
}
