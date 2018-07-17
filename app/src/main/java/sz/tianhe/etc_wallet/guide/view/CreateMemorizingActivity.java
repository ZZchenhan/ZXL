package sz.tianhe.etc_wallet.guide.view;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityCreateMemorizingBinding;

/**
 * 创建助记词
 */
public class CreateMemorizingActivity extends BaseActivity implements View.OnClickListener{

    AdapterNavagation adapterNavagation;

    ActivityCreateMemorizingBinding binding;


    @Override
    public int layoutId() {
        return R.layout.activity_create_memorizing;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setTitle(getResources().getString(R.string.create_memorizing_world),
                        16, R.color.white)
                .setBack()
                .setNavagationBackgroudColor(R.color.colorPrimary);
        return adapterNavagation;
    }

    @Override
    public void initView() {
        binding.sure.setOnClickListener(this);
        binding.wait.setOnClickListener(this);
        test();
    }

    private void test(){

    }

    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
         binding = DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sure:
                ConfirmMemoriActivity.openActivity(this,ConfirmMemoriActivity.class);
                break;
            case R.id.wait:
                PhoneCodeActivity.openActivity(this,PhoneCodeActivity.class);
                break;
        }
    }
}
