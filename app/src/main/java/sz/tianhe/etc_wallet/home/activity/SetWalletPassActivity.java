package sz.tianhe.etc_wallet.home.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivitySetLoginPassBinding;
import sz.tianhe.etc_wallet.guide.bean.RegisterBean;
import sz.tianhe.etc_wallet.guide.view.ConfirmPassActivity;
import sz.tianhe.etc_wallet.guide.view.PhoneCodeActivity;
import sz.tianhe.etc_wallet.utils.SoftUtils;

public class SetWalletPassActivity extends BaseActivity implements TextWatcher{
    AdapterNavagation adapterNavagation;
    ActivitySetLoginPassBinding binding;
    @Override
    public int layoutId() {
        return R.layout.activity_set_login_pass;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setBack()
                .setNavagationBackgroudColor(R.color.colorPrimary);
        return adapterNavagation;
    }

    @Override
    public void initView() {
        binding.input.addTextChangedListener(this);
        binding.textView4.setText("设置支付密码");
        binding.textView5.setText("支付密码用于转账");
        binding.textView6.setOnClickListener(v -> finish());
        binding.textView6.setVisibility(View.VISIBLE);
        SoftUtils.showSoftInputFromWindow(binding.input);
    }

    @Override
    public void findViews() {

    }


    @Override
    protected View bindViews() {
        binding =  DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }

    public void meTost(String str){
        Toast toast = new Toast(this);
        View view = LayoutInflater.from(this).inflate(R.layout.toast_erro,null,false);
        TextView textView = view.findViewById(R.id.text);
        textView.setText(str);
        view.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        toast.setView(view);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(binding.input.getText().toString().length() == 6) {
            startActivity(new Intent(this,ConfirmWallentPassActivity.class).
                    putExtra("data",binding.input.getText().toString()));
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_OK){
            finish();
        }
    }

    /**
     * 传递助记词到最后一部进行校验
     * @param context
     * @param
     */
    public static void openActivity(Context context, RegisterBean registerBean) {
        context.startActivity(new Intent(context, PhoneCodeActivity.class).putExtra("data", registerBean));
    }




}
