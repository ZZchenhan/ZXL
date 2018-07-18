package sz.tianhe.etc_wallet.main;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.assets.activity.AssetsFragment;
import sz.tianhe.etc_wallet.databinding.ActivityMainBinding;
import sz.tianhe.etc_wallet.home.activity.HomeFragment;
import sz.tianhe.etc_wallet.index.activity.IndexFragment;
import sz.tianhe.etc_wallet.main.customview.MyNormalItem;
import sz.tianhe.etc_wallet.main.prensenter.MainPrensenter;

public class MainActivity extends BaseActivity {

    private String[] fragmentTitles = new String[]{"钱包", "行情", "我的"};
    ActivityMainBinding binding;

    MainPrensenter prensenter;

    @Override
    public int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        initFragment();
        initBottom();
        prensenter = new MainPrensenter(this);
//        prensenter.init();
    }

    private void initFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment indexFragment = new IndexFragment();
        transaction.add(R.id.content, indexFragment, fragmentTitles[0]);
        transaction.commit();
    }

    private NavigationController controller;

    private void initBottom() {
        controller = binding.bootm.custom()
                .addItem(newItem(R.mipmap.ic_nagavation_assert_nomarl, R.mipmap.ic_nagavation_assert_select, fragmentTitles[0]))
                .addItem(newItem(R.mipmap.ic_nagavation_quotation_nomarl,R.mipmap.ic_nagavation_quotation_select, fragmentTitles[1]))
                .addItem(newItem(R.mipmap.ic_nagavation_me_nomarl, R.mipmap.ic_nagavation_me_select, fragmentTitles[2]))
                .build();
        controller.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                Fragment oldFragment = fragmentManager.findFragmentByTag(fragmentTitles[old]);
                Fragment newFragment = fragmentManager.findFragmentByTag(fragmentTitles[index]);

                if (newFragment == null) {
                    if (index == 0) {
                        newFragment = new IndexFragment();
                    }
                    if (index == 1) {
                        newFragment = new AssetsFragment();
                    }
                    if (index == 2) {
                        newFragment = new HomeFragment();
                    }
                    transaction.add(R.id.content, newFragment, fragmentTitles[index]);
                }
                transaction.hide(oldFragment).show(newFragment);
                transaction.commit();
            }

            @Override
            public void onRepeat(int index) {

            }
        });
    }

    //创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        MyNormalItem normalItemView = new MyNormalItem(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(0xff8E8E93);
        normalItemView.setTextCheckedColor(0xff3975E2);
        return normalItemView;
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
