package sz.tianhe.etc_wallet.guide.view;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityCreateWalletBinding;
import sz.tianhe.etc_wallet.guide.presenter.CreateWalletPresenter;

public class CreateWalletActivity extends BaseActivity {
    ActivityCreateWalletBinding binding;
    @Override
    public int layoutId() {
        return R.layout.activity_create_wallet;
    }

    AdapterNavagation adapterNavagation;

    CreateWalletPresenter createWalletPresenter;

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setTitle(getResources().getString(R.string.create_wallet_title), 16, R.color.white)
                .setNavagationBackgroudColor(R.color.colorPrimary);
        if(getIntent().getBooleanExtra("back",false)){
            adapterNavagation.setBack();
        }
        return adapterNavagation;
    }

    @Override
    public void initView() {
        createWalletPresenter.init();
    }

    @Override
    public void findViews() {
        createWalletPresenter = new CreateWalletPresenter(this,binding);
    }

    @Override
    protected View bindViews() {
      binding =  DataBindingUtil.inflate(LayoutInflater.from(this),
                layoutId(),null,false);
        return binding.getRoot();
    }
}
