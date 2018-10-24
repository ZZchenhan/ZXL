package sz.tianhe.etc_wallet.index.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityWalletInfoBinding;
import sz.tianhe.etc_wallet.index.adapter.TanscationAdaper;
import sz.tianhe.etc_wallet.index.presenter.WalletInfoPresenter;
import sz.tianhe.etc_wallet.recive.AmountChangeBroadCastRecive;
import sz.tianhe.etc_wallet.requst.vo.ETHList;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

public class WalletInfoActivity extends BaseActivity implements View.OnClickListener {


    ActivityWalletInfoBinding binding;

    TanscationAdaper adaper = null;

    List<ETHList.ResultBean> data = new ArrayList<>();


    private int page = 1;

    @Override
    public void getIntenData() {
        super.getIntenData();
    }

    @Override
    public IBasePresenter createPrensenter() {
        return super.createPrensenter();
    }

    @Override
    public int layoutId() {
        return R.layout.activity_wallet_info;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaper = new TanscationAdaper(data);
        binding.recyclerView.setAdapter(adaper);
        binding.rlRecive.setOnClickListener(this);
        binding.rlTranscation.setOnClickListener(this);
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            this.page = 1;
            this.data.clear();

        });
        View empty = LayoutInflater.from(this).inflate(R.layout.layout_empty, null);
        adaper.setEmptyView(empty);
        getData();
    }


    @Override
    public void findViews() {

    }


    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.rl_transcation:
                intent.setClass(this, TransferActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_recive:
                intent.setClass(this, ReciveActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void getData() {

    }


    /**
     * 广播接收器
     */
    BroadcastReceiver amountChangetReceiver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (null == amountChangetReceiver) {
            amountChangetReceiver = new AmountChangeBroadCastRecive(() -> {
                getData();
            });
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AmountChangeBroadCastRecive.ACTION_AMOUNT_CHANGE);
            registerReceiver(amountChangetReceiver, intentFilter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != amountChangetReceiver) {
            unregisterReceiver(amountChangetReceiver);
        }
    }
}
