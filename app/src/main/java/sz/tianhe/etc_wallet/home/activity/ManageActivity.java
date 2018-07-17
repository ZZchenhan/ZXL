package sz.tianhe.etc_wallet.home.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import sz.tianhe.etc_wallet.databinding.ActivityMainBinding;
import sz.tianhe.etc_wallet.databinding.ActivityManageBinding;
import sz.tianhe.etc_wallet.guide.view.CreateWalletActivity;
import sz.tianhe.etc_wallet.home.adapter.ManagerAdapter;
import sz.tianhe.etc_wallet.home.view.MangerPopDialog;

public class ManageActivity extends BaseActivity {

    ActivityManageBinding binding;
    /**
     * 创建钱包
     */
    public static final int REQUESET_CREAT_WALLET = 1;

    /**
     * 导入钱包
     */
    public static final int REQUEST_IMPORT_WALLET = 2;

    MangerPopDialog dialog;

    private ManagerAdapter managerAdapter;

    private List<String> datas = new ArrayList<>();

    @Override
    public int layoutId() {
        return R.layout.activity_manage;
    }

    @Override
    public IBaseNavagation navagation() {
        AdapterNavagation adapterNavagation = new AdapterNavagation(this);
        adapterNavagation.setTitle("钱包管理", 16, R.color.white);
        adapterNavagation.setBackgroundColor(this.getResources().getColor(R.color.colorPrimary));
        adapterNavagation.setBack();
        adapterNavagation.setRightImage(R.drawable.icon_add, view -> {
            if (dialog == null) {
                dialog = new MangerPopDialog(ManageActivity.this);
                dialog.setOnDismissListener(() -> drawbackgroud(1));
                dialog.setCreatListener(view1 -> {
                    startActivityForResult(new Intent(ManageActivity.this, CreateWalletActivity.class).putExtra("back", true), REQUESET_CREAT_WALLET);
                    dialog.dismiss();
                });
            }
            dialog.showAsDropDown(view);
            drawbackgroud(0.4f);
        });
        return adapterNavagation;
    }

    @Override
    public void initView() {
        initSwiplayout(binding.swipeRefreshLayout);
        managerAdapter = new ManagerAdapter(datas);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(managerAdapter);
        binding.swipeRefreshLayout.setRefreshing(true);
        binding.swipeRefreshLayout.postDelayed(() -> initData(), 500);
    }

    @Override
    public void findViews() {

    }

    @Override
    public void initData() {
        super.initData();
        datas.clear();
        datas.add("");
        datas.add("");
        datas.add("");
        datas.add("");
        managerAdapter.notifyDataSetChanged();
        binding.swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
