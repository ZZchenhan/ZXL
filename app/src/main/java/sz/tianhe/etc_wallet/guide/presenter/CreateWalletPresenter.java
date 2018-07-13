package sz.tianhe.etc_wallet.guide.presenter;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.databinding.ActivityCreateWalletBinding;
import sz.tianhe.etc_wallet.guide.view.CreateMemorizingActivity;


/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 17:08
 */
public class CreateWalletPresenter extends AbstarctPresenter implements View.OnFocusChangeListener {

    ActivityCreateWalletBinding binding;

    private CreateWalletPresenter(Context context) {
        super(context);
    }

    public CreateWalletPresenter(Context context, ActivityCreateWalletBinding binding) {
        super(context);
        this.binding = binding;
    }


    @Override
    public void init() {
        binding.pass2.setOnFocusChangeListener(this);
        binding.repeatPass.setOnFocusChangeListener(this);
        binding.button.setOnClickListener(view -> submit());
        binding.pass2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                checkPassword();
            }
        });
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (view == binding.pass2 && !b) {
            //cheke pass rule
            checkPassword();
        } else if (view == binding.repeatPass && !b) {
            //check pass is same
            checkPassSame();
        }
    }


    public boolean checkPassSame() {
        if (!binding.repeatPass.getText().toString().equals(binding.pass2.getText().toString())) {
            binding.repeatPassLayout.setError("两次输入密码不一致");
            return false;
        } else {
            binding.repeatPassLayout.setErrorEnabled(false);
            return true;
        }
    }

    public boolean checkPassword() {
        String password = binding.pass2.getText().toString();

        if (password.length() < 10) {
            binding.passLayou1.setError("密码不小于10位");
            return false;
        }

        if (password.matches("\\w+")) {
            Pattern p1 = Pattern.compile("[a-z]+");
            Pattern p2 = Pattern.compile("[A-Z]+");
            Pattern p3 = Pattern.compile("[0-9]+");
            Matcher m = p1.matcher(password);
            if (!m.find()) {
                binding.passLayou1.setError("至少包含一位小写字母");
                return false;
            } else {
                m.reset().usePattern(p2);
                if (!m.find()) {
                    binding.passLayou1.setError("至少包含一位大写字母");
                    return false;
                } else {
                    m.reset().usePattern(p3);
                    if (!m.find()) {
                        binding.passLayou1.setError("至少包含一位数字");
                        return false;
                    } else {
                        binding.passLayou1.setErrorEnabled(false);
                        return true;
                    }
                }
            }
        } else {
            binding.passLayou1.setError("密码不能包含符号");
            return false;
        }

    }


    public boolean checkName() {
        if (binding.etName.getText().toString().length() == 0) {
            binding.nameLayout.setError("请填写钱包名称");
            return false;
        }
        binding.nameLayout.setErrorEnabled(false);
        return true;
    }

    public void submit() {
        if (checkName() && checkPassword() && checkPassSame()) {
            //这里请求数据
            CreateMemorizingActivity.openActivity(mContext,CreateMemorizingActivity.class);
        }
    }

}
