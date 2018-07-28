package sz.tianhe.etc_wallet.home.activity;

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
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTransferHistoryBinding;
import sz.tianhe.etc_wallet.home.adapter.ManageTransferAdapter;
import sz.tianhe.etc_wallet.home.presenter.TransferHistoryPresenter;
import sz.tianhe.etc_wallet.home.view.TransferListPopDialog;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationTotalBean;

public class TransferHistoryActivity extends BaseActivity implements TransferHistoryPresenter.ITransfer {
    ActivityTransferHistoryBinding binding;
    AdapterNavagation adapterNavagation;
    private ManageTransferAdapter adapter = null;
    private List<TanscationBean> data = new ArrayList<>();
    TransferListPopDialog popDialog;

    TransferHistoryPresenter transferHistoryPresenter;

    @Override
    public int layoutId() {
        return R.layout.activity_transfer_history;
    }

    @Override
    public IBasePresenter createPrensenter() {
        transferHistoryPresenter = new TransferHistoryPresenter(this,this);
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
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
        binding.time.setOnClickListener(view -> {
            if(popDialog == null){
                popDialog = new TransferListPopDialog(TransferHistoryActivity.this);
                popDialog.setmOnSelectedListener(string -> {
                    binding.time.setText(string);//数据
                    popDialog.dismiss();
                    page = 1;
                    getData();
                    transferHistoryPresenter.getTotal(change(binding.time.getText().toString()));
                });
                popDialog.setOnDismissListener(() -> {
                    drawbackgroud(1);
                });
            }
            popDialog.showAsDropDown(view);
            drawbackgroud(0.4f);
        });
        binding.swipeRefreshLayout.setOnRefreshListener(() -> {
            this.data.clear();
            page = 1;
            getData();
        });
        adapter.setOnLoadMoreListener(() -> {
            getData();
        },binding.recyclerView);
        getData();
        transferHistoryPresenter.getTotal(change(binding.time.getText().toString()));
    }

    int page = 1;


    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        binding =    DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }


    public void getData(){
        transferHistoryPresenter.getList(page,change(binding.time.getText().toString()));
    }


    @Override
    public void total(TanscationTotalBean total) {
        if(null == total){
            return;
        }
        binding.textView9.setText(String.format("支出 ¥%s 收入 ¥%s",total.getTurnTo().setScale(4).toString(),total.getToChangeInto().setScale(4).toString()));
    }

    @Override
    public void list(PageBean<TanscationBean> page) {
        binding.swipeRefreshLayout.setRefreshing(false);
        this.data.addAll(page.getItems());
        this.adapter.loadMoreComplete();
        this.adapter.notifyDataSetChanged();
        if(page.getItems().size()<page.getCurrentSize()){
            this.adapter.loadMoreEnd();
        }
    }

    public String change(String moth){
        if(moth.equals("全部")){
            return "";
        }
        moth.replace("年","-");
        moth.replace("月","");
        StringBuffer sb = new StringBuffer();
        sb.append(moth.substring(0,4));
        sb.append("-");
        sb.append(moth.substring(5,moth.length()-1));
        return sb.toString();
    }
}
