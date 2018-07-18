package sz.tianhe.etc_wallet.index.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;

import com.google.gson.Gson;
import com.google.zxing.WriterException;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityReciveBinding;
import sz.tianhe.etc_wallet.index.bean.AsssertBean;
import sz.tianhe.etc_wallet.utils.QRCodeUtils;

public class ReciveActivity extends BaseActivity {

    AdapterNavagation adapterNavagation;

    ActivityReciveBinding binding;

    AsssertBean asssertBean;

    Bitmap bitmap;

    @Override
    public void getIntenData() {
        super.getIntenData();
        asssertBean = (AsssertBean) getIntent().getSerializableExtra("data");
    }

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
        binding.icCoin.setImageResource(asssertBean.getIconId());
        binding.coinTitle.setText(asssertBean.getCoinTilte());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        productQRCode();
    }

    private void productQRCode(){
        if(bitmap == null){
            try {
                bitmap = QRCodeUtils.encodeAsBitmap(new Gson().toJson(asssertBean),
                        binding.code.getWidth(),binding.code.getHeight());
                binding.code.setImageBitmap(bitmap);
            } catch (WriterException e) {
                e.printStackTrace();
            }
        }else{
            binding.code.setImageBitmap(bitmap);
        }
    }

    @Override
    public void findViews() {
        binding.btnConfirm.setOnClickListener(view -> {
            //获取剪贴板管理器：
            ClipboardManager cm = (ClipboardManager) ReciveActivity.this.getSystemService(Context.CLIPBOARD_SERVICE);
            // 创建普通字符型ClipData
            ClipData mClipData = ClipData.newPlainText("Label", "这里是要复制的文字");
            // 将ClipData内容放到系统剪贴板里。
            cm.setPrimaryClip(mClipData);
            toast("复制成功");
        });
    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }
}
