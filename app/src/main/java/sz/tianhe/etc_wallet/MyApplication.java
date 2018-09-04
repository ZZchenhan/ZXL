package sz.tianhe.etc_wallet;

import android.app.Application;
import android.graphics.Color;
import android.os.Build;

import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import sz.tianhe.baselib.http.RetrofitClient;
import sz.tianhe.etc_wallet.requst.inteceptor.LoginInterceptor;
import sz.tianhe.etc_wallet.requst.vo.User;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 11:54
 */
public class MyApplication extends Application {
    public static Retrofit retrofitClient;

    public static String deviceId;

    //    public static String baseUrl = "http://103.65.180.165:8080/";
    public static String baseUrl = "http://192.168.10.118:8090/";

    public static User user;

    public static String aluyun = "http://tongyongbucket.oss-cn-hangzhou.aliyuncs.com/";

    public static String buck = "tongyongbucket";

    public static OSS oss = null;


    /**
     * 交易记录
     */
    public static Retrofit tranferClient;

    @Override
    public void onCreate() {
        super.onCreate();
        String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider("LTAIqNxd4rFLe0l6", "xZEViV4zH0VaVza8kd4cdNZ8TGvFLS");
        oss = new OSSClient(this, endpoint, credentialProvider);
        retrofitClient = new RetrofitClient(this, baseUrl) {
            @Override
            public void addInterceptor(OkHttpClient.Builder builder) {
                super.addInterceptor(builder);
                builder.addInterceptor(new LoginInterceptor(MyApplication.this));
            }
        }.getRetrofit();

        tranferClient = new RetrofitClient(this, "http://39.105.26.249:9090/").getRetrofit();
        deviceId = Build.SERIAL;
        Utils.init(this);
        ToastUtils.setMsgColor(Color.BLACK);
    }
}
