package sz.tianhe.etc_wallet;

import android.app.Application;
import android.graphics.Color;
import android.os.Build;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import sz.tianhe.baselib.http.RetrofitClient;
import sz.tianhe.baselib.http.interceptor.BaseInterceptor;
import sz.tianhe.etc_wallet.requst.inteceptor.LoginInterceptor;
import sz.tianhe.etc_wallet.requst.vo.User;
import sz.tianhe.etc_wallet.utils.TokenUtil;

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

    public static User user;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofitClient = new RetrofitClient(this,baseUrl){
            @Override
            public void addInterceptor(OkHttpClient.Builder builder) {
                super.addInterceptor(builder);
                builder.addInterceptor(new LoginInterceptor(MyApplication.this));
            }
        }.getRetrofit();
        deviceId = Build.SERIAL;
        Utils.init(this);
        ToastUtils.setMsgColor(Color.BLACK);
    }
}
