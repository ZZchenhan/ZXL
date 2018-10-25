package sz.tianhe.etc_wallet.trade.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.FragmentHallBinding;
import sz.tianhe.etc_wallet.trade.adapter.HallAdapter;

/**
 * 交易大厅页面-列表页面
 */
public class HallFragment extends Fragment {
    /**
     * 卖出类型
     */
    public static final int TYPE_SELL = 1;

    /**
     * 买入类型
     */
    public static final int TYPE_BUY = 2;

    /**
     * 附加类型
     */
    public static final String EXTRA_TYPE = "extra_type";


    FragmentHallBinding binding;


    HallAdapter hallAdapter;

    private List<String> mDatas = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hall, container, false);
            initData();
        }
        return binding.getRoot();
    }

    private void initData() {
        hallAdapter = new HallAdapter(mDatas);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(hallAdapter);
        hallAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                assert getArguments() != null;
                startActivity(new Intent(getContext(), TradeActivity.class).putExtra(HallFragment.EXTRA_TYPE, getArguments().getInt(EXTRA_TYPE)));
            }
        });
        refresh();
    }


    /**
     * 刷新页面及其数据
     */
    public void refresh() {
        if (hallAdapter == null) {
            return;
        }
        this.mDatas.clear();
        hallAdapter.notifyDataSetChanged();
        binding.swipeLayout.setRefreshing(true);
        binding.recyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                getData(0);
            }
        }, 1000);

    }


    public void getData(int page) {
        assert getArguments() != null;
        Log.e("Type", getArguments().getInt(EXTRA_TYPE) + "");
        binding.swipeLayout.setRefreshing(false);
        this.mDatas.add("");
        this.mDatas.add("");
        this.mDatas.add("");
        this.mDatas.add("");
        this.hallAdapter.notifyDataSetChanged();
    }
}
