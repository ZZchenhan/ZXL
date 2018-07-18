package sz.tianhe.etc_wallet.index.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;

public class ReciveActivity extends BaseActivity {
    AdapterNavagation adapterNavagation;
    @Override
    public int layoutId() {
        return R.layout.activity_recive;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setBack()
                .setTitle("收款码", 16, R.color.white);
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
