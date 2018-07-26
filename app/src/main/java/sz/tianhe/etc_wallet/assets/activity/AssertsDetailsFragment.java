package sz.tianhe.etc_wallet.assets.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.fragment.BaseFragment;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.assets.adapter.AssertsAdapter;
import sz.tianhe.etc_wallet.requst.api.QutaiorApi;
import sz.tianhe.etc_wallet.assets.bean.QutaiorBean;
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

    AdapterNavagation adapterNavagation;
    AssertsAdapter adapter;

    List<QutaiorBean> datas = new ArrayList();

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
        adapterNavagation = new AdapterNavagation(getContext())
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setTitle("行情", 16, R.color.white);
        return adapterNavagation;
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
        getQutais();
        binding.swipeLayout.setOnRefreshListener(() -> getQutais());
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void getQutais() {
       List<String> input =  new ArrayList<>();
       input.add("bts_usdt");
       input.add("eos_usdt");
       input.add("btc_usdt");
       input.add("eth_usdt");
       binding.swipeLayout.setRefreshing(true);
       QutaiorApi.getQutations(input)
                .subscribe(new Observer<List<QutaiorBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<QutaiorBean> qutaiorBeans) {
                        binding.swipeLayout.setRefreshing(false);
                        datas.clear();
                        datas.addAll(qutaiorBeans);
                        adapter.notifyDataSetChanged();
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
