package sz.tianhe.etc_wallet.main.prensenter;

import android.app.Dialog;
import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.main.customview.NormalDialog;
import sz.tianhe.etc_wallet.requst.api.UserApi;
import sz.tianhe.etc_wallet.requst.vo.User;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/13 16:29
 */
public class MainPrensenter extends AbstarctPresenter {

    Dialog upateDialog;
    OnRefreshUser onRefreshUser;

    public MainPrensenter(Context context, OnRefreshUser onRefreshUser) {
        super(context);
        this.onRefreshUser = onRefreshUser;
    }

    @Override
    public void init() {
        chekUpdate();
    }


    /**
     * 检查当前版本是否需要更新
     */
    private void chekUpdate() {
        showUpdateDialog("1、增加撒币功能。\n2、增加发送糖果功能");
    }


    private void showUpdateDialog(String hinit) {
        if (null == this.upateDialog) {
            TextView tvHinit = new TextView(this.mContext);
            tvHinit.setText(hinit);
            tvHinit.setTextColor(this.mContext.getResources().getColor(R.color.black));
            tvHinit.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int pading = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, this.mContext.getResources().getDisplayMetrics());
            tvHinit.setPadding(pading, 0, pading, pading);
            tvHinit.setMinWidth((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 45, this.mContext.getResources().getDisplayMetrics()));

            this.upateDialog =
                    new NormalDialog.Builder(this.mContext).setTitle("有新的版本")
                            .setConentView(tvHinit)
                            .setLeftString("暂不更新")
                            .setRightString("马上更新")
                            .setRightOnclickListner(onClickListener -> {
                                toast("下载新版本");
                                this.upateDialog.dismiss();
                            })
                            .create();

        }
        this.upateDialog.show();
    }


    public void refreshUserInfo() {
        requst(MyApplication.retrofitClient.create(UserApi.class).getUserInfo(),
                new IResultListener<User>() {
                    @Override
                    public void onListener(User user) {
                        MyApplication.user = user;
                        onRefreshUser.onRefreh(user);
                    }
                }, false
        );
    }

    public interface OnRefreshUser {
        void onRefreh(User user);
    }
}
