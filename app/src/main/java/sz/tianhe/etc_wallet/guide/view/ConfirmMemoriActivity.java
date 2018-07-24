package sz.tianhe.etc_wallet.guide.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.GridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    private List<String> keyWorkds = new ArrayList<>();

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
        //获取真实助记词
        String[] worlds = getIntent().getStringExtra("keyWord").split(" ");
        this.keyWorkds.addAll(Arrays.asList(worlds));
        this.worlds.addAll(Arrays.asList(worlds));
        initDatas();
        this.binding.sure.setOnClickListener(view -> {
            if(this.selectData.size() != 12){
                toast("助记词输入不正确");
                return;
            }
            if(compare(this.selectData,this.keyWorkds)){
                PhoneCodeActivity.openActivity(this,getIntent().getStringExtra("keyWord"));
            }else{
                toast("助记词输入不正确");
            }
        });
    }


    /**
     *
     * @param selectWorld
     * @param keyWorkds
     * @return 相同 true 不同false
     */
    private boolean compare(List<String> selectWorld,List<String> keyWorkds){
        for (int i=0;i<12;i++){
            if(!selectWorld.get(i).equals(keyWorkds.get(i))){
                return false;
            }
        }
        return true;
    }

    //
    private void initDatas() {
        Collections.shuffle(worlds);
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

    public static void openActivity(Context context,String words){
        context.startActivity(new Intent(context,ConfirmMemoriActivity.class).putExtra("keyWord",words));
    }


}
