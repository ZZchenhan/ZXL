package sz.tianhe.etc_wallet.assets.activity;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.fragment.BaseFragment;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.FragmentAssertBinding;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 11:05
 */
public class AssetsFragment extends BaseFragment {

    FragmentAssertBinding binding;

    AdapterNavagation adapterNavagation;


    @Override
    public int layoutId() {
        return R.layout.fragment_assert;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(getContext())
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setTitle("行情", 16, R.color.white);
        return adapterNavagation;
    }


    @Override
    protected View bindViews(LayoutInflater inflater, @Nullable ViewGroup container) {
        if(binding == null){
            binding = DataBindingUtil.inflate(inflater,layoutId(),container,false);
        }
        return binding.getRoot();
    }

    @Override
    protected void initViews() {

    }
}
