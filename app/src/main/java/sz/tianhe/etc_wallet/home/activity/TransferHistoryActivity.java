package sz.tianhe.etc_wallet.home.activity;

import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.presenter.IBasePresenter;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTransferHistoryBinding;
import sz.tianhe.etc_wallet.home.adapter.ManageTransferAdapter;
import sz.tianhe.etc_wallet.home.presenter.TransferHistoryPresenter;
import sz.tianhe.etc_wallet.home.view.TransferListPopDialog;
import sz.tianhe.etc_wallet.requst.vo.ETHList;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationTotalBean;
import sz.tianhe.etc_wallet.weight.MonthDialog;

public class TransferHistoryActivity extends BaseActivity implements TransferHistoryPresenter.ITransfer {
    ActivityTransferHistoryBinding binding;
    AdapterNavagation adapterNavagation;
    private ManageTransferAdapter adapter = null;
    private List<ETHList.ResultBean> data = new ArrayList<>();
    Dialog popDialog;

    TransferHistoryPresenter transferHistoryPresenter;

    @Override
    public int layoutId() {
        return R.layout.activity_transfer_history;
    }

    @Override
    public IBasePresenter createPrensenter() {
        transferHistoryPresenter = new TransferHistoryPresenter(this, this);
        return super.createPrensenter();
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.colorPrimary)
                .setBack()
                .setTitle("交易记录", 16, R.color.white);
        return adapterNavagation;
    }

    @Override
    public void initView() {
        adapter = new ManageTransferAdapter(data);
        adapter.setMeAddrss("0x25C101Da7B6B5557bFF7D1FC840e28A1E00EB96f");
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.time.setOnClickListener(view -> {
            if (popDialog == null) {
                popDialog = new MonthDialog.Builder(TransferHistoryActivity.this).onConfirmListenr(coinBean -> {
                    page = 1;
                    binding.time.setText(coinBean);
                    getData();
                    transferHistoryPresenter.getTotal(change(binding.time.getText().toString()));
                }).Builder();

            }
            popDialog.show();
        });
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            this.data.clear();
            page = 1;
            getData();
        });
//        adapter.setOnLoadMoreListener(() -> {
//            getData();
//        },binding.recyclerView);
        getData();
        transferHistoryPresenter.getTotal(change(binding.time.getText().toString()));
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


    public void getData() {
        transferHistoryPresenter.getList(MyApplication.user.getAddress());
    }


    @Override
    public void total(TanscationTotalBean total) {
        if (null == total) {
            return;
        }
        binding.textView9.setText(String.format("支出 ¥%s 收入 ¥%s", total.getTurnTo().setScale(4).toString(), total.getToChangeInto().setScale(4).toString()));
    }

    @Override
    public void list(ETHList page) {
        binding.swipeRefreshLayout.setRefreshing(false);
        this.data.addAll(page.getResult());
        this.adapter.loadMoreComplete();
        this.adapter.notifyDataSetChanged();

    }

    public String change(String moth) {
        return moth;
    }
}
