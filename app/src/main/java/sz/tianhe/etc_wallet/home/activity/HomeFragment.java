package sz.tianhe.etc_wallet.home.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.fragment.BaseFragment;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.FragmentHomeBinding;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 11:01
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {

    FragmentHomeBinding binding;

    @Override
    public int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }


    @Override
    protected View bindViews(LayoutInflater inflater, @Nullable ViewGroup container) {
        this.binding = DataBindingUtil.inflate(inflater, layoutId(), container, false);
        return this.binding.getRoot();
    }


    @Override
    protected void initViews() {
        binding.head.setOnClickListener(this);
        binding.userPermission.setOnClickListener(this);
        binding.aboutMe.setOnClickListener(this);
        binding.trans.setOnClickListener(this);
        binding.msg.setOnClickListener(this);
        binding.order.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.head:
                MeInfoActivity.openActivity(getContext(), MeInfoActivity.class);
                break;
            case R.id.user_permission:
                Intent intent = new Intent(getContext(), PrivacyActivity.class);
                intent.putExtra("isSee", "dada");
                startActivity(intent);
                break;
            case R.id.about_me:
                AboutActivity.openActivity(getContext(), AboutActivity.class);
                break;
            case R.id.trans:
                startActivity(new Intent(getContext(),TransferHistoryActivity.class));
                break;
            case R.id.msg:
                startActivity(new Intent(getContext(),MsgActivity.class));
                break;
            case R.id.order:

                break;
        }
    }

}
