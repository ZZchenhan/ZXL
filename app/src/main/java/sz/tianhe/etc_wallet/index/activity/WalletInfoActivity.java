package sz.tianhe.etc_wallet.index.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityWalletInfoBinding;
import sz.tianhe.etc_wallet.index.adapter.TanscationAdaper;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.index.presenter.WalletInfoPresenter;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;

public class WalletInfoActivity extends BaseActivity implements View.OnClickListener,WalletInfoPresenter.IWlletInfoView {

    AdapterNavagation adapterNavagation;

    WalletItemBean walletItemBean;

    ActivityWalletInfoBinding binding;

    TanscationAdaper adaper = null;

    List<TanscationBean> data = new ArrayList<>();

    WalletInfoPresenter walletInfoPresenter;

    private int page = 1;

    @Override
    public void getIntenData() {
        super.getIntenData();
        walletItemBean = (WalletItemBean) getIntent().getSerializableExtra("data");
    }

    @Override
    public IBasePresenter createPrensenter() {
        walletInfoPresenter = new WalletInfoPresenter(this,this);
        return super.createPrensenter();
    }

    @Override
    public int layoutId() {
        return R.layout.activity_wallet_info;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setBack()
                .setTitle(walletItemBean.getCoinName(), 16, R.color.white)
                .setRightImage(R.mipmap.ic_scan, v -> {ScanActivity.openActivity(WalletInfoActivity.this, ScanActivity.class);});
        return adapterNavagation;
    }

    @Override
    public void initView() {
        Glide.with(this).load(walletItemBean.getCoinImg()).into(binding.icon);
        binding.coinNumber.setText("总量："+walletItemBean.getAmount().setScale(4).toString());
        binding.value.setText("冻结："+walletItemBean.getFreeAmount().setScale(4).toString());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaper = new TanscationAdaper(data);
        binding.recyclerView.setAdapter(adaper);

        binding.rlRecive.setOnClickListener(this);
        binding.rlTranscation.setOnClickListener(this);
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            this.page = 1;
            this.walletInfoPresenter.getTranList( this.page, this.walletItemBean.getCoinName());
        });
        adaper.setOnLoadMoreListener(() -> {
            this.walletInfoPresenter.getTranList(this.page,this.walletItemBean.getCoinName());
        },binding.recyclerView);
//        View empty = LayoutInflater.from(this).inflate(R.layout.layout_empty,null);
//        adaper.setEmptyView(empty);
    }



    @Override
    public void findViews() {

    }


    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", walletItemBean);
        switch (view.getId()){
            case R.id.rl_transcation:
                intent.setClass(this,TransferActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_recive:
                intent.setClass(this,ReciveActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    public void getData(){
        this.walletInfoPresenter.getDetails(walletItemBean.getCoinName());
        this.walletInfoPresenter.getTranList(page,walletItemBean.getCoinName());
    }



    @Override
    public void details(WalletItemBean walletItemBean) {
        Glide.with(this).load(walletItemBean.getCoinImg()).into(binding.icon);
        binding.coinNumber.setText("总量："+walletItemBean.getAmount().setScale(4).toString());
        binding.value.setText("冻结："+walletItemBean.getFreeAmount().setScale(4).toString());
    }



    @Override
    public void transcationList(PageBean<TanscationBean> pageBean) {
        this.binding.swipeRefreshLayout.setRefreshing(false);
        this.data.addAll(pageBean.getItems());
        this.adaper.notifyDataSetChanged();
        this.adaper.loadMoreComplete();
        if(pageBean.getItems().size() == 0){
            this.adaper.loadMoreEnd();
        }
        this.page = pageBean.getCurrentPage()+1;
    }
}
