package sz.tianhe.etc_wallet.home.activity;

import android.app.Dialog;
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
import sz.tianhe.etc_wallet.databinding.ActivityTransferHistoryBinding;
import sz.tianhe.etc_wallet.home.adapter.ManageTransferAdapter;
import sz.tianhe.etc_wallet.requst.vo.ETHList;
import sz.tianhe.etc_wallet.requst.vo.TanscationTotalBean;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;
import sz.tianhe.etc_wallet.weight.MonthDialog;

public class TransferHistoryActivity extends BaseActivity{
    ActivityTransferHistoryBinding binding;

    private ManageTransferAdapter adapter = null;
    private List<ETHList.ResultBean> data = new ArrayList<>();
    Dialog popDialog;



    @Override
    public int layoutId() {
        return R.layout.activity_transfer_history;
    }


    @Override
    public IBaseNavagation navagation() {

        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
        adapter = new ManageTransferAdapter(data);
        adapter.setMeAddrss("0x25C101Da7B6B5557bFF7D1FC840e28A1E00EB96f");
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.time.setOnClickListener(view -> {
            if (popDialog == null) {
                popDialog = new MonthDialog.Builder(TransferHistoryActivity.this).onConfirmListenr(coinBean -> {
                    page = 1;
                    binding.time.setText(coinBean);
                    getData(page);
                }).Builder();

            }
            popDialog.show();
        });
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            this.data.clear();
            page = 1;
            getData(page);
        });

//        adapter.setOnLoadMoreListener(() -> {
//            getData();
//        },binding.recyclerView);
        getData(page);
    }

    int page = 1;


    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }


    public void getData(int page) {
        this.data.add(new ETHList.ResultBean());
        this.data.add(new ETHList.ResultBean());
        this.data.add(new ETHList.ResultBean());
        this.data.add(new ETHList.ResultBean());
        this.adapter.notifyDataSetChanged();
    }




    public String change(String moth) {
        return moth;
    }
}
