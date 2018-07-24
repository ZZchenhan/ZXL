package sz.tianhe.etc_wallet.assets.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.fragment.BaseFragment;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.requst.api.QutaiorApi;
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

    List<AssertsDetailsFragment> fragmentList = new ArrayList<>();

    private List<String> tiles = new ArrayList<>();

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
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, layoutId(), container, false);
            getMarkets();
        }
        return binding.getRoot();
    }

    FragmentPagerAdapter adapter;

    @Override
    protected void initViews() {
        adapter = new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tiles.get(position);
            }
        };
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //tab被选的时候回调
                binding.viewPage.setCurrentItem(tab.getPosition(),true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //tab未被选择的时候回调
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //tab重新选择的时候回调
            }
        });
        binding.viewPage.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.viewPage);
    }

    private void initTab(Map<String, List<String>> keysMarkets){
       Set<Map.Entry<String,List<String>>> entries =  keysMarkets.entrySet();
        Iterator<Map.Entry<String,List<String>>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,List<String>> entry = iterator.next();
            tiles.add(entry.getKey().toUpperCase());
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(entry.getKey().toUpperCase()));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("data", (ArrayList<String>) entry.getValue());
            AssertsDetailsFragment assertsDetailsFragment =  new AssertsDetailsFragment();
            assertsDetailsFragment.setArguments(bundle);
            fragmentList.add(assertsDetailsFragment);
        }
        adapter.notifyDataSetChanged();
    }


    private void getMarkets(){
        QutaiorApi.getMarkets()
        .subscribe(new Observer<Map<String, List<String>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Map<String, List<String>> stringListMap) {
                initTab(stringListMap);
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
