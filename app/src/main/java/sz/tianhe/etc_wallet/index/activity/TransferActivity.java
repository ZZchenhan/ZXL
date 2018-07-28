package sz.tianhe.etc_wallet.index.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;

import java.math.BigDecimal;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTransferBinding;
import sz.tianhe.etc_wallet.index.presenter.TransferPresenter;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;

public class TransferActivity extends BaseActivity implements TextWatcher,TransferPresenter.OnTransferListener {
    public static final String EXTRA_ADDRESS = "ADDRESS";
    AdapterNavagation adapterNavagation;

    ActivityTransferBinding binding;

    WalletItemBean walletItemBean;

    TransferPresenter transferPresenter;

    @Override
    public int layoutId() {
        return R.layout.activity_transfer;
    }

    @Override
    public IBasePresenter createPrensenter() {
        transferPresenter = new TransferPresenter(this,this);
        return super.createPrensenter();
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setBack()
                .setRightImage(R.mipmap.ic_scan, v -> {
                    ScanActivity.openActivity(TransferActivity.this, ScanActivity.class);
                });
        return adapterNavagation;
    }

    @Override
    public void initView() {

    }
    BigDecimal canUse;
    @Override
    public void findViews() {
        walletItemBean = (WalletItemBean) getIntent().getSerializableExtra("data");
        binding.address.addTextChangedListener(this);
        binding.numbers.addTextChangedListener(this);
        if (getIntent().getStringExtra(EXTRA_ADDRESS) != null) {
            String jsonString = getIntent().getStringExtra(EXTRA_ADDRESS);
            WalletItemBean scan = new Gson().fromJson(jsonString,WalletItemBean.class);
            binding.address.setText(scan.getAddress());
        }
        adapterNavagation.setTitle(walletItemBean.getCoinName()+"转账",16,R.color.white);
        binding.button2.setOnClickListener(view -> submit());
        binding.button2.setEnabled(false);
        //可转出
        canUse = walletItemBean.getAmount().subtract(walletItemBean.getFreeAmount());
        binding.value.setText("可提现："+canUse.setScale(4,BigDecimal.ROUND_DOWN).toString());
    }


    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (binding.numbers.getText().length() == 0 || binding.address.getText().length() == 0) {
            binding.button2.setEnabled(false);
        } else {
            binding.button2.setEnabled(true);
            if(new BigDecimal(binding.numbers.getText().toString()).compareTo(canUse)>0){
                binding.value.setText("最大可提现："+canUse.setScale(4,BigDecimal.ROUND_DOWN).toString());
                binding.value.setTextColor(Color.RED);
                binding.button2.setEnabled(false);
            }else{
                binding.button2.setEnabled(true);
            }
        }
    }

    public void submit(){
        transferPresenter.transfer(MyApplication.user.getId(),binding.numbers.getText().toString(),binding.address.getText().toString(),walletItemBean.getCoinName(),binding.reamark.getText().toString());
    }

    @Override
    public void onTransfer(String string) {
        toast(string);
        finish();
    }
}
