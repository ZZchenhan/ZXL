package sz.tianhe.etc_wallet.guide.view;

import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;

/**
 * 创建助记词
 */
public class CreateMemorizingActivity extends BaseActivity {
    AdapterNavagation adapterNavagation;
    @Override
    public int layoutId() {
        return R.layout.activity_create_memorizing;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setTitle(getResources().getString(R.string.create_memorizing_world),
                        16, R.color.white)
                .setNavagationBackgroudColor(R.color.colorPrimary);
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
