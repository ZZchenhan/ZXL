package sz.tianhe.baselib.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import sz.tianhe.baselib.R;
import sz.tianhe.baselib.navagation.IBaseNavagation;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/13 10:46
 */
public abstract class BaseFragment extends Fragment {
    /**
     * baseActivity 根目录
     */

    /**
     * 获得布局文件的layoutId
     *
     * @return
     */
    public abstract int layoutId();

    /**
     * 获取导航栏
     *
     * @return
     */
    public abstract IBaseNavagation navagation();

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.base_activity, container, false);
            LinearLayout root = view.findViewById(R.id.root);
            if (null != navagation()) {
                root.addView(navagation().getNavagation());
            }
            View rootView = bindViews(inflater, container);
            if (rootView == null) {
                rootView = inflater.inflate(layoutId(), container, false);
            }
            rootView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            root.addView(rootView);
        }
        return view;
    }

    protected abstract View bindViews(LayoutInflater inflater, @Nullable ViewGroup container);

    protected abstract void initViews();
}
