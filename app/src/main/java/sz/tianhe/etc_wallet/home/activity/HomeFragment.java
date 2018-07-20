package sz.tianhe.etc_wallet.home.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sz.tianhe.baselib.navagation.AdapterNavagation;
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
public class HomeFragment extends BaseFragment implements View.OnClickListener{

    FragmentHomeBinding binding;
    AdapterNavagation adapterNavagation;

    @Override
    public int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(getContext())
                .setNavagationBackgroudColor(R.color.colorPrimary)
                .setTitle("我", 16, R.color.white);
        return adapterNavagation;
    }


    @Override
    protected View bindViews(LayoutInflater inflater, @Nullable ViewGroup container) {
        this.binding = DataBindingUtil.inflate(inflater, layoutId(), container, false);
        return this.binding.getRoot();
    }


    @Override
    protected void initViews() {
        binding.head.setOnClickListener(this);
        binding.rlWallet.setOnClickListener(this);
        binding.rlMsg.setOnClickListener(this);
        binding.rlTransfer.setOnClickListener(this);
        binding.userPermission.setOnClickListener(this);
        binding.aboutMe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.head:
                MeInfoActivity.openActivity(getContext(),MeInfoActivity.class);
                break;
            case R.id.rl_wallet:
                ManageActivity.openActivity(getContext(),ManageActivity.class);
                break;
            case R.id.rl_msg:
                MsgActivity.openActivity(getContext(),MsgActivity.class);
                break;
            case R.id.rl_transfer:
                TransferHistoryActivity.openActivity(getContext(),TransferHistoryActivity.class);
                break;
            case R.id.user_permission:
                PrivacyActivity.openActivity(getContext(),PrivacyActivity.class);
                break;
            case R.id.about_me:
                AboutActivity.openActivity(getContext(),AboutActivity.class);
                break;
        }
    }
}
