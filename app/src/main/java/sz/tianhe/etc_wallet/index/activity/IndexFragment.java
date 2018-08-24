package sz.tianhe.etc_wallet.index.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
import sz.tianhe.etc_wallet.index.adapter.IndeAdapter;
import sz.tianhe.etc_wallet.index.presenter.IndexPresenter;
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
        adapterNavagation = new AdapterNavagation(getContext())
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setTitle("钱包", 16, R.color.white)
                .setRightImage(R.mipmap.ic_scan, v -> startActivity(new Intent(getContext(), ScanActivity.class)));
        return adapterNavagation;
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
        View header = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_index_head, null, false);
        tvNumbers = header.findViewById(R.id.total);
        header.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        adapter.addHeaderView(header);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(getContext(), WalletInfoActivity.class);
            intent.putExtra("data", data.get(position));
            startActivity(intent);
        });
        adapter.setOnLoadMoreListener(() -> {
            this.indexPresenter.getWalletList(page);
        }, binding.recyclerView);
        binding.swipeLayout.setOnRefreshListener(() -> {
            page = 1;
            getData(page);
        });
        binding.swipeLayout.postDelayed(() -> {
            //getData(page);
            binding.swipeLayout.setRefreshing(true);
        },200);
    }


    public void getData(int page) {
        this.page = page;
        this.data.clear();
        if(MyApplication.user == null){
            startActivity(new Intent(getContext(), LoginActivity.class));
            (getActivity()).finish();
            return;
        }
        this.indexPresenter.getTotal();
        this.indexPresenter.getWalletList(page);
    }


    @Override
    public void totalNumber(BigDecimal total) {
        this.tvNumbers.setText(total.setScale(4).toString());
    }

    @Override
    public void walletList(PageBean<WalletItemBean> pageBean) {
        this.data.addAll(pageBean.getItems());
        this.adapter.notifyDataSetChanged();
        this.adapter.loadMoreComplete();
        this.binding.swipeLayout.setRefreshing(false);
        if (pageBean.getItems().size() < pageBean.getCurrentSize()) {
            this.adapter.loadMoreEnd();
        }
        this.page = pageBean.getCurrentSize() + 1;
    }
}
