package sz.tianhe.etc_wallet.assets.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.baselib.view.fragment.BaseFragment;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.assets.adapter.AssertsAdapter;
import sz.tianhe.etc_wallet.assets.api.QutaiorApi;
import sz.tianhe.etc_wallet.databinding.FragmentAssertsDetailBinding;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 17:14
 */
public class AssertsDetailsFragment extends BaseFragment {

    FragmentAssertsDetailBinding binding;

    AssertsAdapter adapter;

    List<String> datas = new ArrayList();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int layoutId() {
        return R.layout.fragment_asserts_detail;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    protected View bindViews(LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, layoutId(), null, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews() {
        adapter = new AssertsAdapter(datas);
        binding.recylearView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recylearView.setAdapter(adapter);
        List<String> datas = getArguments().getStringArrayList("data");
        QutaiorApi.getQutations(datas).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                Log.i("string",s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
