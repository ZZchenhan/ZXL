package sz.tianhe.etc_wallet.utils;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

public class StatusBarUtils {


    /***
     * 设置白色状态栏
     * 5.0以上有效
     * @param activity
     */
    public static void hideStatus(Activity activity){
        View decorView = activity.getWindow().getDecorView();
        int options = 0;
        //5.0以上以上透明钻状态栏 否则走下面
        if(Build.VERSION.SDK_INT >= 21){
             options = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                     | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(options);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }else {
            //填充屏幕
            options = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(options);

        }
    }

    /**
     * 设置黑色状态栏
     * 5.0以上有效
     */
    public static void statusDak(Activity activity){
        View decorView = activity.getWindow().getDecorView();
        int options = 0;
        //5.0以上以上透明钻状态栏 否则走下面
        if(Build.VERSION.SDK_INT >= 21){
            options = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            decorView.setSystemUiVisibility(options);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }else {
            //填充屏幕
            options = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(options);

        }
    }
}
