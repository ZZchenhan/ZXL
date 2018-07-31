package sz.tianhe.etc_wallet.home.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityHomeWalletInfoBinding;
import sz.tianhe.etc_wallet.home.adapter.ManageTransferAdapter;
import sz.tianhe.etc_wallet.home.presenter.HomeWalletInforPresenter;
import sz.tianhe.etc_wallet.requst.vo.ManagerItem;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.requst.vo.YesterDayProfit;

public class HomeWalletInfoActivity extends BaseActivity implements View.OnClickListener ,HomeWalletInforPresenter.IHomeWalletInfoListener {
    AdapterNavagation adapterNavagation;
    private List<TanscationBean> data = new ArrayList<>();
    private ManageTransferAdapter adapter = null;
    ActivityHomeWalletInfoBinding  binding;
    HomeWalletInforPresenter homeWalletInforPresenter;
    ManagerItem managerItem;
    @Override
    public int layoutId() {
        return R.layout.activity_home_wallet_info;
    }

    @Override
    public IBasePresenter createPrensenter() {
        homeWalletInforPresenter = new HomeWalletInforPresenter(this,this);
        return super.createPrensenter();
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.colorPrimary)
                .setBack();
        return adapterNavagation;
    }

    @Override
    public void initView() {
        managerItem = (ManagerItem) getIntent().getSerializableExtra("data");
        adapterNavagation .setTitle(managerItem.getCoinName(), 16, R.color.white);
        binding.coinTitle.setText("昨日收益（"+managerItem.getCoinName()+"）");
        homeWalletInforPresenter.getProfit(managerItem.getCoinId());
        homeWalletInforPresenter.getTranslist(page,managerItem.getCoinName());
    }
    private int page = 1;

    @Override
    public void findViews() {
        adapter = new ManageTransferAdapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.rlRecive.setOnClickListener(this);
        binding.rlTranscation.setOnClickListener(this);
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                homeWalletInforPresenter.getTranslist(page,managerItem.getCoinName());
            }
        });
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                homeWalletInforPresenter.getTranslist(page,managerItem.getCoinName());
            }
        },binding.recyclerView);
    }



    @Override
    protected View bindViews() {
        binding =  DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this,TransferFundsActivity.class);
        switch (view.getId()){
            case R.id.rl_transcation:
                intent.putExtra(TransferFundsActivity.TYPE,TransferFundsActivity.TYPE_OUT);
                startActivity(intent);
                break;
            case R.id.rl_recive:
                intent.putExtra(TransferFundsActivity.TYPE,TransferFundsActivity.TYPE_IN);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void profit(YesterDayProfit profit) {
        if(profit == null){
            return;
        }
        binding.tvProfit.setText(profit.getYesterdayProfit()!=null?profit.getYesterdayProfit().setScale(4).toString():"0");
        if(profit.getFreeAmount() == null){
            binding.total.setText("总量 " + 0 + " " + managerItem.getCoinName());
            return;
        }else {
            binding.total.setText("总量 " + profit.getFreeAmount().setScale(4).toString() + " " + managerItem.getCoinName());
        }
    }

    @Override
    public void list(PageBean<TanscationBean> pageBean) {
        this.data.addAll(pageBean.getItems());
        this.adapter.notifyDataSetChanged();
        this.adapter.loadMoreComplete();
        this.binding.swipeRefreshLayout.setRefreshing(false);
        if(pageBean.getCurrentSize() > pageBean.getItems().size()){
            this.adapter.loadMoreEnd();
        }
        this.page = this.page +1;
    }
}
