package sz.tianhe.etc_wallet.guide.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityConfirmMemoriBinding;
import sz.tianhe.etc_wallet.guide.adapter.FlowLayoutManager;
import sz.tianhe.etc_wallet.guide.adapter.GridItemDecoration;
import sz.tianhe.etc_wallet.guide.adapter.MemoriAdapeter;
import sz.tianhe.etc_wallet.guide.adapter.SelectMemoriAdapeter;
import sz.tianhe.etc_wallet.guide.adapter.SpaceItemDecoration;

public class ConfirmMemoriActivity extends BaseActivity {
    AdapterNavagation adapterNavagation;
    ActivityConfirmMemoriBinding binding;

    private List<String> selectData = new ArrayList<>();
    private SelectMemoriAdapeter adapeter = null;
    private List<String> worlds = new ArrayList<>();
    private MemoriAdapeter memoriAdapeter = null;

    @Override
    public int layoutId() {
        return R.layout.activity_confirm_memori;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setBack()
                .setNavagationBackgroudColor(R.color.colorPrimary);
        return adapterNavagation;
    }

    @Override
    public void initView() {
        this.adapeter = new SelectMemoriAdapeter(this.selectData);
        this.binding.recyclerView.setLayoutManager(new FlowLayoutManager());
        this.binding.recyclerView.addItemDecoration(new SpaceItemDecoration((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3.5f, this.getResources().getDisplayMetrics())));
        this.binding.recyclerView.setAdapter(this.adapeter);
        this.adapeter.setOnItemChildClickListener((adapter, view, position) -> {
            this.adapeter.remove(position);
        });

        this.memoriAdapeter = new MemoriAdapeter(this.worlds);
        this.binding.checkRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        this.binding.checkRecyclerView.addItemDecoration(new GridItemDecoration((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 7, this.getResources().getDisplayMetrics())));
        this.binding.checkRecyclerView.setAdapter(this.memoriAdapeter);
        this.memoriAdapeter.setOnItemChildClickListener((adapter, view, position) -> {
            if (this.selectData.size() < 12) {
                this.adapeter.add(selectData.size(),worlds.get(position));
            }
        });
        initDatas();
        this.binding.sure.setOnClickListener(view -> PhoneCodeActivity.openActivity(this,PhoneCodeActivity.class));
    }

    private void initDatas() {
        worlds.add("world");
        worlds.add("can");
        worlds.add("earth");
        worlds.add("easy");
        worlds.add("can");
        worlds.add("how");
        worlds.add("what");
        worlds.add("doing");
        worlds.add("what");
        worlds.add("doing");
        worlds.add("what");
        worlds.add("doing");
        memoriAdapeter.notifyDataSetChanged();
    }


    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }
}
