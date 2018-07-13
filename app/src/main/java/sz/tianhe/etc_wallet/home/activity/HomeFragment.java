package sz.tianhe.etc_wallet.home.activity;

import android.app.Dialog;
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
import sz.tianhe.etc_wallet.main.customview.NormalDialog;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 11:01
 */
public class HomeFragment extends BaseFragment {

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
                .setTitle("个人中心", 16, R.color.white);
        return adapterNavagation;
    }


    @Override
    protected View bindViews(LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false);
        return binding.getRoot();
    }

    Dialog updateDialog;

    @Override
    protected void initViews() {
        binding.button2.setOnClickListener(view -> {
            if(updateDialog == null){
                updateDialog = new NormalDialog.Builder(getContext())
                        .create();
            }
            updateDialog.show();
        });
    }
}
