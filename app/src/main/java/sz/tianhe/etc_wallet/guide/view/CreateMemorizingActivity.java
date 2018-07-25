package sz.tianhe.etc_wallet.guide.view;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityCreateMemorizingBinding;
import sz.tianhe.etc_wallet.guide.bean.RegisterBean;
import sz.tianhe.etc_wallet.guide.presenter.MemotizingPrensenter;

/**
 * 创建助记词
 */
public class CreateMemorizingActivity extends BaseActivity implements View.OnClickListener, MemotizingPrensenter.IMemotizinView {

    AdapterNavagation adapterNavagation;

    ActivityCreateMemorizingBinding binding;

    MemotizingPrensenter memotizingPrensenter;

    @Override
    public int layoutId() {
        return R.layout.activity_create_memorizing;
    }


    @Override
    public IBasePresenter createPrensenter() {
        memotizingPrensenter = new MemotizingPrensenter(this, this);
        return memotizingPrensenter;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setTitle(getResources().getString(R.string.create_memorizing_world),
                        16, R.color.white)
                .setBack()
                .setNavagationBackgroudColor(R.color.colorPrimary);
        return adapterNavagation;
    }

    @Override
    public void initView() {
        binding.sure.setOnClickListener(this);
        binding.wait.setOnClickListener(this);
        memotizingPrensenter.init();
    }

    private void test() {

    }

    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sure:
                ConfirmMemoriActivity.openActivity(this,binding.world.getText().toString());
                break;
            case R.id.wait:
                RegisterBean registerBean = new RegisterBean();
                registerBean.setWords(binding.world.getText().toString());
                PhoneCodeActivity.openActivity(this,registerBean);
                break;
        }
    }


    @Override
    public void memotizingSuccess(String world) {
        binding.world.setText(world);
    }
}
