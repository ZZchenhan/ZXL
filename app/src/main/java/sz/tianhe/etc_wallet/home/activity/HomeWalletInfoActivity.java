package sz.tianhe.etc_wallet.home.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityHomeWalletInfoBinding;
import sz.tianhe.etc_wallet.home.adapter.ManageTransferAdapter;
import sz.tianhe.etc_wallet.home.adapter.ManagerAdapter;

public class HomeWalletInfoActivity extends BaseActivity {
    AdapterNavagation adapterNavagation;
    private List<String> data = new ArrayList<>();
    private ManageTransferAdapter adapter = null;
    ActivityHomeWalletInfoBinding  binding;
    @Override
    public int layoutId() {
        return R.layout.activity_home_wallet_info;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.colorPrimary)
                .setBack()
                .setTitle("EOS", 16, R.color.white);
        return adapterNavagation;
    }

    @Override
    public void initView() {
        test();
    }

    @Override
    public void findViews() {
        adapter = new ManageTransferAdapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    public void test(){
        data.add("0");
        data.add("3");
        data.add("2");
        data.add("3");
        data.add("1");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected View bindViews() {
        binding =  DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }
}
