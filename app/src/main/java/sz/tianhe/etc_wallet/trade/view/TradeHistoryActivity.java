package sz.tianhe.etc_wallet.trade.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTradeHistoryBinding;
import sz.tianhe.etc_wallet.trade.adapter.TradeHistoryAdapter;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class TradeHistoryActivity extends BaseActivity {

    ActivityTradeHistoryBinding binding;

    TradeHistoryAdapter adapter;

    private List<String> mDatas = new ArrayList<>();

    @Override
    public int layoutId() {
        return R.layout.activity_trade_history;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
        adapter = new TradeHistoryAdapter(this.mDatas);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter, view, position) -> startActivity(new Intent(this, TradeDetailActivity.class)));
        requestData();
    }

    private void requestData() {
        mDatas.add("");
        mDatas.add("");
        mDatas.add("");
        mDatas.add("");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void findViews() {

    }


    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(getLayoutInflater(), layoutId(), null, false);
        return binding.getRoot();
    }
}
