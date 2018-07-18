package sz.tianhe.etc_wallet.index.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.fragment.BaseFragment;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.FragmentIndexBinding;
import sz.tianhe.etc_wallet.index.adapter.IndeAdapter;
import sz.tianhe.etc_wallet.index.bean.AsssertBean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 11:01
 */
public class IndexFragment extends BaseFragment {

    FragmentIndexBinding binding;

    AdapterNavagation adapterNavagation;

    TextView tvNumbers;

    private IndeAdapter adapter;

    private List<AsssertBean> data = new ArrayList<>();

    @Override
    public int layoutId() {
        return R.layout.fragment_index;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(getContext())
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setTitle("钱包", 16, R.color.white)
                .setRightImage(R.mipmap.ic_scan, v -> ToastUtils.showShort("scan"));
        return adapterNavagation;
    }

    @Override
    protected View bindViews(LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_index, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initViews() {
        adapter = new IndeAdapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        View header = LayoutInflater.from(getContext())
                .inflate(R.layout.layout_index_head, null, false);
        tvNumbers = header.findViewById(R.id.total);
        header.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        adapter.addHeaderView(header);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(getContext(),WalletInfoActivity.class);
            intent.putExtra("data",data.get(position));
            startActivity(intent);
        });
        test();
    }

    private void test() {
        data.add(new AsssertBean(R.mipmap.ic_coin1,"EOS",200,100));
        data.add(new AsssertBean(R.mipmap.ic_coin2,"ETH",12,3000));
        data.add(new AsssertBean(R.mipmap.ic_coin3,"XRP",1000,3000));

        adapter.notifyDataSetChanged();
    }
}
