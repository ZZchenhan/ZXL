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
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

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
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
        adapter = new MsgAdapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        loadData();
    }



    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
      binding =  DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
     return binding.getRoot();
    }

    private void loadData(){
        this.data.add("");
        this.data.add("");
        this.data.add("");
        this.data.add("");
        this.data.add("");
        this.adapter.notifyDataSetChanged();
    }
}
