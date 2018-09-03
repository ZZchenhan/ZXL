package sz.tianhe.etc_wallet.index.activity;

import android.content.Intent;
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
import sz.tianhe.etc_wallet.recive.AmountChangeBroadCastRecive;
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
            walletItemBean = new Gson().fromJson(jsonString,WalletItemBean.class);
            binding.address.setText(walletItemBean.getAddress());
        }
        adapterNavagation.setTitle(walletItemBean.getCoinName()+"转账",16,R.color.white);
        binding.button2.setOnClickListener(view -> submit());
        binding.button2.setEnabled(false);
        //可转出
        canUse = new BigDecimal(walletItemBean.getBanlance() == null?"0":walletItemBean.getBanlance());
        binding.value.setText("可提现："+canUse.toString());
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
//            if(new BigDecimal(binding.numbers.getText().toString()).compareTo(canUse)>0){
//                binding.value.setText("最大可提现："+canUse.toString());
//                binding.value.setTextColor(Color.RED);
//                binding.button2.setEnabled(false);
//            }else{
//                binding.button2.setEnabled(true);
//            }
        }
    }

    public void submit(){
        if(binding.numbers.getText().toString().length() == 0){
            toast("输入正确的金额");
            return;
        }
        if(binding.pass.getText().toString().length() != 6){
            toast("输入正确的交易密码格式");
            return;
        }
        if( (binding.address.getText().toString().length() == 42
                && binding.address.getText().toString().toUpperCase().startsWith("0X"))
                || binding.address.getText().toString().length() == 40
                ) {
            //弹出支付密码框
            transferPresenter.transfer(MyApplication.user.getId(), binding.numbers.getText().toString(),
                    binding.address.getText().toString(), walletItemBean.getCoinName(), binding.reamark.getText().toString(), binding.pass.getText().toString());
        }else{
            toast("输入正确的交易地址");
        }
    }

    @Override
    public void onTransfer(String string) {
        //支付成功，发送广播
        sendBroadcast(new Intent().setAction(AmountChangeBroadCastRecive.ACTION_AMOUNT_CHANGE));
        toast(string);
        finish();
    }
}
