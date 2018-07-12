package sz.tianhe.etc_wallet.guide.presenter;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.utils.PhoneUtils;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.requst.api.UserApi;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 15:22
 */
public class RegisterPresenter extends AbstarctPresenter<UserApi> {

    private EditText tvPhone;

    private EditText tvPass;

    private EditText code;

    private Button btnGetCode;

    private Button btnRegister;



    public RegisterPresenter(Context context) {
        super(context);
    }

    @Override
    public UserApi baseModel() {
        return null;
    }

    @Override
    public void init() {

    }


    private void getCode(){
        if(!PhoneUtils.isMobile0(tvPhone.getText().toString())){
            toast(R.string.phone_erro);
            return;
        }
        btnGetCode.setClickable(false);

    }

}
