package sz.tianhe.etc_wallet.home.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityMsgBinding;
import sz.tianhe.etc_wallet.home.adapter.MsgAdapter;

public class MsgActivity extends BaseActivity {

    ActivityMsgBinding binding;
    MsgAdapter adapter;
    List<String> data = new ArrayList();
    @Override
    public int layoutId() {
        return R.layout.activity_msg;
    }

    @Override
    public IBaseNavagation navagation() {
        AdapterNavagation adapterNavagation = new AdapterNavagation(this);
        adapterNavagation.setTitle("消息中心", 16, R.color.white);
        adapterNavagation.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
        adapterNavagation.setBack();
        return adapterNavagation;
    }

    @Override
    public void initView() {
        adapter = new MsgAdapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }



    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
      binding =  DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
     return binding.getRoot();
    }
}
