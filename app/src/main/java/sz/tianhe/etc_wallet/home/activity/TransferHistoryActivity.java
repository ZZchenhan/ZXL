package sz.tianhe.etc_wallet.home.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTransferHistoryBinding;
import sz.tianhe.etc_wallet.home.adapter.ManageTransferAdapter;
import sz.tianhe.etc_wallet.home.view.TransferListPopDialog;

public class TransferHistoryActivity extends BaseActivity {
    ActivityTransferHistoryBinding binding;
    AdapterNavagation adapterNavagation;
    private ManageTransferAdapter adapter = null;
    private List<String> data = new ArrayList<>();
    TransferListPopDialog popDialog;
    @Override
    public int layoutId() {
        return R.layout.activity_transfer_history;
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
        adapter = new ManageTransferAdapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        test();
        binding.time.setOnClickListener(view -> {
            if(popDialog == null){
                popDialog = new TransferListPopDialog(TransferHistoryActivity.this);
                popDialog.setmOnSelectedListener(string -> {
                    binding.time.setText(string);//数据
                    popDialog.dismiss();
                });
                popDialog.setOnDismissListener(() -> {
                    drawbackgroud(1);
                });
            }
            popDialog.showAsDropDown(view);
            drawbackgroud(0.4f);
        });
    }

    public void test(){
        data.add("0");
        data.add("3");
        data.add("4");
        data.add("2");
        data.add("3");
        data.add("1");
        adapter.notifyDataSetChanged();
    }

    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        binding =    DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }


    public void showTims(){}
}
