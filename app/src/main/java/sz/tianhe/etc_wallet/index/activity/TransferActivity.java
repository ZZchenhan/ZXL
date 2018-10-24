package sz.tianhe.etc_wallet.index.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
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
import sz.tianhe.etc_wallet.utils.Constacts;
import sz.tianhe.etc_wallet.utils.RSAUtils;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

/**
 * 转账
 */
public class TransferActivity extends BaseActivity implements TextWatcher, TransferPresenter.OnTransferListener {
    public static final String EXTRA_ADDRESS = "ADDRESS";

    ActivityTransferBinding binding;


    @Override
    public int layoutId() {
        return R.layout.activity_transfer;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
        binding.scan.setOnClickListener(v -> startActivity(new Intent(this, ScanActivity.class)));
    }

    @Override
    public void findViews() {
        binding.address.addTextChangedListener(this);
        binding.numbers.addTextChangedListener(this);
        binding.button2.setOnClickListener(view -> submit());
        binding.button2.setEnabled(false);

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

    public void submit() {
        if (binding.numbers.getText().toString().length() == 0) {
            toast("输入正确的金额");
            return;
        }
        if (binding.pass.getText().toString().length() != 6) {
            toast("输入正确的交易密码格式");
            return;
        }
        if ((binding.address.getText().toString().length() == 42
                && binding.address.getText().toString().toUpperCase().startsWith("0X"))
                || binding.address.getText().toString().length() == 40
                ) {
            //弹出支付密码框
            String pass = "";
            if (null == Constacts.publicKey) {
                try {
                    Constacts.publicKey = RSAUtils.getPublicKeyByString(Constacts.PUBLICK_KEY);
                } catch (Exception e) {
                    ToastUtils.showShort("获取公钥失败");
                    return;
                }
            }
            pass = RSAUtils.encryptDataByPublicKey(binding.pass.getText().toString().getBytes(), Constacts.publicKey);

        } else {
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
