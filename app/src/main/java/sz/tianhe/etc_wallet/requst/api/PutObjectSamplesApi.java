package sz.tianhe.etc_wallet.requst.api;

import android.util.Log;

import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.etc_wallet.MyApplication;


/**
 * Created by zhouzhuo on 12/3/15.
 */
public class PutObjectSamplesApi extends BaseSamples {

    public static Observable<String> upload(OSS client,String object,String filePath,String buncket){
        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
            PutObjectRequest put = new PutObjectRequest(buncket, object, filePath);
            PutObjectResult putResult = client.putObject(put);
            emitter.onNext(MyApplication.aluyun+object);
            emitter.onComplete();
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
