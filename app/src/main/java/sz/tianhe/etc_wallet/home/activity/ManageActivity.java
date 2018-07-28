package sz.tianhe.etc_wallet.home.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityMainBinding;
import sz.tianhe.etc_wallet.databinding.ActivityManageBinding;
import sz.tianhe.etc_wallet.guide.view.CreateWalletActivity;
import sz.tianhe.etc_wallet.home.adapter.ManagerAdapter;
import sz.tianhe.etc_wallet.home.presenter.ManagerPreseter;
import sz.tianhe.etc_wallet.home.view.MangerPopDialog;
import sz.tianhe.etc_wallet.requst.vo.ManagerItem;
import sz.tianhe.etc_wallet.requst.vo.PageBean;

public class ManageActivity extends BaseActivity implements ManagerPreseter.OnManagerListener {

    ActivityManageBinding binding;

    MangerPopDialog dialog;

    private ManagerAdapter managerAdapter;

    private List<ManagerItem> datas = new ArrayList<>();

    private ManagerPreseter managerPreseter;

    @Override
    public int layoutId() {
        return R.layout.activity_manage;
    }

    @Override
    public IBasePresenter createPrensenter() {
        managerPreseter = new ManagerPreseter(this,this);
        return super.createPrensenter();
    }

    @Override
    public IBaseNavagation navagation() {
        AdapterNavagation adapterNavagation = new AdapterNavagation(this);
        adapterNavagation.setTitle("钱包管理", 16, R.color.white);
        adapterNavagation.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
        adapterNavagation.setBack();
        return adapterNavagation;
    }

    @Override
    public void initView() {
        initSwiplayout(binding.swipeRefreshLayout);
        managerAdapter = new ManagerAdapter(datas);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(managerAdapter);
        binding.swipeRefreshLayout.setRefreshing(true);
        binding.swipeRefreshLayout.postDelayed(() -> {page = 1;initData();}, 500);

        managerAdapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(ManageActivity.this,HomeWalletInfoActivity.class);
            intent.putExtra("data",datas.get(position));
            startActivity(intent);
        });

    }

    @Override
    public void findViews() {

    }

    @Override
    public void initData() {
        super.initData();
        managerPreseter.getList(page);
    }
    int page = 1;

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onManagerListen(PageBean<ManagerItem> pageBean) {
        this.binding.swipeRefreshLayout.setRefreshing(false);
        this.datas.addAll(pageBean.getItems());
        this.managerAdapter.notifyDataSetChanged();
        this.managerAdapter.loadMoreComplete();
        if(pageBean.getItems().size() < pageBean.getCurrentSize()){
            this.managerAdapter.loadMoreEnd();
        }
        page = page+1;
    }
}
