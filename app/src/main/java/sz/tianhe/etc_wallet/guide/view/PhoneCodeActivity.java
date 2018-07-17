package sz.tianhe.etc_wallet.guide.view;

import android.databinding.DataBindingUtil;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityPhoneCodeBinding;

public class PhoneCodeActivity extends BaseActivity implements View.OnClickListener, TextWatcher {

    ActivityPhoneCodeBinding binding;

    @Override
    public int layoutId() {
        return R.layout.activity_phone_code;
    }
    AdapterNavagation adapterNavagation;
    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setBack()
                .setNavagationBackgroudColor(R.color.colorPrimary);
        return adapterNavagation;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findViews() {
        binding.code.addTextChangedListener(this);
        binding.phone.addTextChangedListener(this);
        binding.tvGetCode.setOnClickListener(this);
    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_get_code:
                getCode();
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (binding.phone.getText().toString().length() == 11 && binding.code.getText().toString().length() == 4) {
            SetLoginPassActivity.openActivity(this,SetLoginPassActivity.class);
        }
    }

    private void getCode(){
        if(!RegexUtils.isMobileExact(binding.phone.getText().toString())){
            meTost("手机号码有误无法获得验证码");
            return;
        }
        Observable.interval(1, TimeUnit.SECONDS)
                .take(59)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        binding.tvGetCode.setClickable(false);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        binding.tvGetCode.setText("剩余"+(60-aLong)+"秒");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        binding.tvGetCode.setClickable(true);
                        binding.tvGetCode.setText("获取验证码");
                    }
                });
    }


    private void jump(){
        toast("跳转到确认登录密码页面");
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
}
