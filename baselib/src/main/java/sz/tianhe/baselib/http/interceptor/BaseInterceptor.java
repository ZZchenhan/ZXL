package sz.tianhe.baselib.http.interceptor;

import android.support.annotation.Nullable;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

/**
 * 项目名称:etc_wallet
 * 类描述 基类拦截器 给所有请求加上请求头
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/6/22 16:50
 */
public class BaseInterceptor implements Interceptor{

    private Map<String,String> mHeaders;

    public BaseInterceptor(Map<String,String> headers){
        this.mHeaders = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original  = chain.request();
        Request.Builder requestBuilder = original.newBuilder();
        if(null!= this.mHeaders && this.mHeaders.size() >0){
            for (String key:this.mHeaders.keySet()
                 ) {
                requestBuilder.addHeader(key,mHeaders.get(key));
            }
        }
//        requestBuilder.addHeader("Accept","application/json;charset=UTF-8");
        requestBuilder.addHeader("User-agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
