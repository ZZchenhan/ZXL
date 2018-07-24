package sz.tianhe.etc_wallet;

import android.app.Application;
import android.graphics.Color;
import android.os.Build;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import sz.tianhe.baselib.http.RetrofitClient;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 11:54
 */
public class MyApplication extends Application{
    public static Retrofit retrofitClient;

    public static String deviceId;

    public static String baseUrl = "http://192.168.10.10:8083/";

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient(this,baseUrl){
            @Override
            public void addInterceptor(OkHttpClient.Builder builder) {
                super.addInterceptor(builder);
            }
        }.getRetrofit();
        deviceId = Build.SERIAL;
        Utils.init(this);
        ToastUtils.setMsgColor(Color.BLACK);
    }
}
