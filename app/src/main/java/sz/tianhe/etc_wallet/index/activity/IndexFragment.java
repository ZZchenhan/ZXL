package sz.tianhe.etc_wallet.index.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.FragmentIndexBinding;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 11:01
 */
public class IndexFragment extends Fragment{

    FragmentIndexBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(null == binding) {
            binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_index, container, false);
        }
        return binding.getRoot();
    }
}
