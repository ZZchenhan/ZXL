package sz.tianhe.etc_wallet.home.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.guide.view.CreateWalletActivity;
import sz.tianhe.etc_wallet.home.view.MangerPopDialog;

public class MsgActivity extends BaseActivity {

    @Override
    public int layoutId() {
        return R.layout.activity_msg;
    }

    @Override
    public IBaseNavagation navagation() {
        AdapterNavagation adapterNavagation = new AdapterNavagation(this);
        adapterNavagation.setTitle("消息中心", 16, R.color.white);
        adapterNavagation.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
        adapterNavagation.setBack();
        adapterNavagation.setRightText("全部已读",12,R.color.white,v->{toast("标记全部已读");});
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
