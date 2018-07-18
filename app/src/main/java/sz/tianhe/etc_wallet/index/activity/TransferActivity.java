package sz.tianhe.etc_wallet.index.activity;

import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTransferBinding;

public class TransferActivity extends BaseActivity implements TextWatcher {
    public static final String EXTRA_ADDRESS = "ADDRESS";
    AdapterNavagation adapterNavagation;

    ActivityTransferBinding binding;

    @Override
    public int layoutId() {
        return R.layout.activity_transfer;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setBack()
                .setTitle("转账", 16, R.color.white)
                .setRightImage(R.mipmap.ic_scan, v -> {
                    ScanActivity.openActivity(TransferActivity.this, ScanActivity.class);
                });
        return adapterNavagation;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findViews() {
        binding.address.addTextChangedListener(this);
        binding.numbers.addTextChangedListener(this);
        if (getIntent().getStringExtra(EXTRA_ADDRESS) != null) {
            binding.address.setText(getIntent().getStringExtra(EXTRA_ADDRESS));
        }
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
        }
        if(binding.numbers.getText().length()!=0){
            binding.value.setText(binding.numbers.getText()+"00 CNY");
        }else{
            binding.value.setText("");
        }
    }
}
