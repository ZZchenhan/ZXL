package sz.tianhe.etc_wallet.home.activity;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTransferFundsBinding;

public class TransferFundsActivity extends BaseActivity {
    public static final String TYPE = "TYPE";
    //转入
    public static final int TYPE_IN = 0;
    //转出
    public static final int TYPE_OUT = 1;
    AdapterNavagation adapterNavagation;

    ActivityTransferFundsBinding binding;
    @Override
    public int layoutId() {
        return R.layout.activity_transfer_funds;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this);
        adapterNavagation.setTitle(TYPE_IN == getIntent().getIntExtra(TYPE,0)?"转入":"转出",
                16, R.color.white);
        adapterNavagation.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
        adapterNavagation.setBack();
        return adapterNavagation;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findViews() {
        binding.button2.setText(getIntent().getIntExtra(TYPE,0) == TYPE_IN?"确定转入":"确定转出");
        binding.value.setText("最大可"+(getIntent().getIntExtra(TYPE,0) == TYPE_IN?"转入":"转出")+"1000");
    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }
}
