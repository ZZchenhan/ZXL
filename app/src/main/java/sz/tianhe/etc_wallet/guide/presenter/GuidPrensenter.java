package sz.tianhe.etc_wallet.guide.presenter;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.baselib.api.Api;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.utils.VersionUtils;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.assets.activity.AssetsFragment;
import sz.tianhe.etc_wallet.databinding.ActivityGuideBinding;
import sz.tianhe.etc_wallet.guide.view.CreateWalletActivity;
import sz.tianhe.etc_wallet.guide.view.FirstChooseActivity;
import sz.tianhe.etc_wallet.guide.view.LoginActivity;
import sz.tianhe.etc_wallet.main.MainActivity;
import sz.tianhe.etc_wallet.requst.api.QutaiorApi;

/**
 * 引导页导航
 *
 * @author ch
 * @微信 xrbswo
 * @qq 869360026
 * @email 869360026@qq.com
 * @创建时间 2018/6/24 18:29
 */
public class GuidPrensenter extends AbstarctPresenter {

    ActivityGuideBinding binding;

    private final int REQUSET_PERMISSION = 1;

    /**
     * 需要检查的权限
     */
    String[] permissions = new String[]{
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    //用户需要申请的权限
    List<String> mPermissionList = new ArrayList<>();

    private GuidPrensenter(Context context) {
        super(context);
    }


    public GuidPrensenter(Context context, ActivityGuideBinding binding) {
        super(context);
        this.binding = binding;
    }


    private void checkPermision() {
        mPermissionList.clear();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(mContext, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                //检查所需要的所有权限 当权限不为允许的时候 添加到需要申请表中
                mPermissionList.add(permissions[i]);
            }
        }
        if (mPermissionList.size() == 0) {
            //没有需要申请的权限
            handOver();
            return;
        }

        String[] permissions = mPermissionList.toArray(new String[mPermissionList.size()]);
        //申请权限
        ActivityCompat.requestPermissions((Activity) mContext, permissions, REQUSET_PERMISSION);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUSET_PERMISSION) {
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    //判断是否勾选禁止后不再询问
                    boolean showRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContext, permissions[i]);
                    if (showRequestPermission) {
                        //有权限被拒绝

                        return;
                    }
                }
            }
            handOver();
        }
    }


    @Override
    public void init() {

        loadVersion();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //6.0以上需要检查权限
            checkPermision();
        }else{
            handOver();
        }

    }


    public void loadVersion() {

    }

    /**
     * 延迟跳转
     */
    public void handOver() {
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(binding.image, "scaleX", 0.5f,0.9f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(binding.image, "scaleY", 0.5f, 0.9f, 1f);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(binding.image, "alpha", 0f, 0.8f, 1f);
        // 步骤2：创建组合动画的对象
        AnimatorSet animSet = new AnimatorSet();

        // 步骤3：根据需求组合动画
        animSet.play(scaleX).with(scaleY).with(alpha);
        animSet.setDuration(3000);
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                jumpView();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        // 步骤4：启动动画
        animSet.start();

    }

    private void jumpView() {
        FirstChooseActivity.openActivity(mContext, FirstChooseActivity.class);
        ((Activity)mContext).finish();
    }

}
