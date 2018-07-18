package sz.tianhe.etc_wallet.index.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityWalletInfoBinding;
import sz.tianhe.etc_wallet.index.adapter.TanscationAdaper;
import sz.tianhe.etc_wallet.index.bean.AsssertBean;
import sz.tianhe.etc_wallet.index.bean.TanscationBean;

public class WalletInfoActivity extends BaseActivity implements View.OnClickListener{

    AdapterNavagation adapterNavagation;

    AsssertBean asssertBean;

    ActivityWalletInfoBinding binding;

    TanscationAdaper adaper = null;

    List<TanscationBean> data = new ArrayList<>();

    @Override
    public void getIntenData() {
        super.getIntenData();
        asssertBean = (AsssertBean) getIntent().getSerializableExtra("data");
    }

    @Override
    public int layoutId() {
        return R.layout.activity_wallet_info;
    }

    @Override
    public IBaseNavagation navagation() {
        adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setBack()
                .setTitle(asssertBean.getCoinTilte(), 16, R.color.white)
                .setRightImage(R.mipmap.ic_scan, v -> ToastUtils.showShort("scan"));
        return adapterNavagation;
    }

    @Override
    public void initView() {
        binding.icon.setImageResource(asssertBean.getIconId());
        binding.coinNumber.setText(String.format("%.4f",asssertBean.getCoinNumber()));
        binding.value.setText(String.format("≈%.4f",asssertBean.getValue())+"￥");
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adaper = new TanscationAdaper(data);
        binding.recyclerView.setAdapter(adaper);

        binding.rlRecive.setOnClickListener(this);
        test();
    }

    private void test(){
        data.add(new TanscationBean("0x715d456ds15748das53465da13fg",0,"2017/04/01 13:41:01",20));
        data.add(new TanscationBean("0x7ffafasds15748das53465da13a7",1,"2016/05/04 09:40:01",25));
//        data.add(new TanscationBean("0x615d456dadadadassda465da1326",0,"2016/01/04 12:05:01",23));
//        data.add(new TanscationBean("0x115d456ds15748das53465da1327",0,"2014/10/01 09:03:01",100));
//        data.add(new TanscationBean("0x515ad45f7aga48ddasads5aa327g",1,"2014/09/25 11:20:01",1000));
        adaper.notifyDataSetChanged();
    }

    @Override
    public void findViews() {

    }


    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this),layoutId(),null,false);
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl_transcation:
                break;
            case R.id.rl_recive:
                Intent intent = new Intent(this,ReciveActivity.class);
                intent.putExtra("data",asssertBean);
                startActivity(intent);
                break;
        }
    }
}
