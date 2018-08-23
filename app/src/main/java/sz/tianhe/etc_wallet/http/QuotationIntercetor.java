package sz.tianhe.etc_wallet.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 86936 on 2018/7/23.
 *
 * @QQ 869360026
 */

public class QuotationIntercetor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original  = chain.request();
        Request.Builder requestBuilder = original.newBuilder();
        requestBuilder.url("http://www.baidu.com/");
        return chain.proceed(requestBuilder.build());
    }
}
