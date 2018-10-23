package sz.tianhe.etc_wallet.index.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.fragment.BaseFragment;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.FragmentIndexBinding;
import sz.tianhe.etc_wallet.guide.view.LoginActivity;
import sz.tianhe.etc_wallet.home.activity.SetWalletPassActivity;
import sz.tianhe.etc_wallet.index.adapter.IndeAdapter;
import sz.tianhe.etc_wallet.index.presenter.IndexPresenter;
import sz.tianhe.etc_wallet.recive.AmountChangeBroadCastRecive;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 11:01
 */
public class IndexFragment extends BaseFragment implements IndexPresenter.OnIndexFragmentView {

    FragmentIndexBinding binding;

    AdapterNavagation adapterNavagation;

    TextView tvNumbers;

    private IndeAdapter adapter;

    private List<WalletItemBean> data = new ArrayList<>();

    IndexPresenter indexPresenter;

    int page = 1;

    @Override
    public int layoutId() {
        return R.layout.fragment_index;
    }

    @Override
    public IBaseNavagation navagation() {

        return null;
    }


    @Override
    protected View bindViews(LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_index, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews() {
        indexPresenter = new IndexPresenter(getContext(), this);
        adapter = new IndeAdapter(data);
        binding.getRoot().setBackgroundColor(getContext().getResources().getColor(R.color.bgColor));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            if(data.size() == 0){
                return;
            }
            Intent intent = new Intent(getContext(), WalletInfoActivity.class);
            intent.putExtra("data", data.get(position));
            startActivity(intent);
        });
        binding.swipeLayout.setOnRefreshListener(() -> {
            page = 1;
            getData(page);
        });
        getData(1);
    }


    public void getData(int page) {
    }


    @Override
    public void totalNumber(BigDecimal total) {
        this.tvNumbers.setText(total.setScale(4).toString());
    }

    private boolean isFirst = true;
    @Override
    public void walletList(List<WalletItemBean> pageBean) {
        this.binding.swipeLayout.setRefreshing(false);
        if (pageBean == null || pageBean.size() == 0 ) {
            if(isFirst) {
                isFirst = false;
                ToastUtils.showShort("没有钱包，请前往设置");
                startActivity(new Intent(getContext(), SetWalletPassActivity.class));
                return;
            }
        }

        this.data.clear();
        isFirst = false;
        this.data.addAll(pageBean);
        setAll(this.data);
        this.adapter.notifyDataSetChanged();
    }


    private void setAll(List<WalletItemBean> data){
        BigDecimal bigDecimal = new BigDecimal(0);
        for(WalletItemBean item:data){
            bigDecimal = bigDecimal.add(new BigDecimal(item.getBanlance()));
        }
        tvNumbers.setText(bigDecimal.toString());
    }

    BroadcastReceiver amountChangetReceiver;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(null == amountChangetReceiver){
            amountChangetReceiver = new AmountChangeBroadCastRecive(() -> {
                getData(1);
            });
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(AmountChangeBroadCastRecive.ACTION_AMOUNT_CHANGE);
            getContext().registerReceiver(amountChangetReceiver,intentFilter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(null!=amountChangetReceiver){
            getContext().unregisterReceiver(amountChangetReceiver);
        }
    }
}
