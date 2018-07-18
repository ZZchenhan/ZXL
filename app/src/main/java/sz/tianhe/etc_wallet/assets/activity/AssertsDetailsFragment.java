package sz.tianhe.etc_wallet.assets.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.ToastUtils;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 17:14
 */
public class AssertsDetailsFragment extends BaseActivity{


    @Override
    public int layoutId() {
        return R.layout.fragment_asserts_detail;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findViews() {

    }

    @Override
    protected View bindViews() {
        return null;
    }

    public void refresh(String key){//刷新

        ToastUtils.showShort(key);
    }
}
