package sz.tianhe.etc_wallet.guide.view;

import android.view.View;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class PhoneRegisterActivity extends BaseActivity {

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

    }



    @Override
    protected View bindViews() {
        return null;
    }
}
