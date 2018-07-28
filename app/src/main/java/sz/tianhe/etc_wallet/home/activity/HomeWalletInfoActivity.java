package sz.tianhe.etc_wallet.home.activity;

import android.content.Intent;
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
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;

public class HomeWalletInfoActivity extends BaseActivity implements View.OnClickListener {
    AdapterNavagation adapterNavagation;
    private List<TanscationBean> data = new ArrayList<>();
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

    }

    @Override
    public void findViews() {
        adapter = new ManageTransferAdapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.rlRecive.setOnClickListener(this);
        binding.rlTranscation.setOnClickListener(this);
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
}
