package sz.tianhe.baselib.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;


import com.bumptech.glide.load.HttpException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.baselib.R;
import sz.tianhe.baselib.api.Api;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.http.erro.ApiErro;
import sz.tianhe.baselib.model.bean.Result;


/**
 * 项目名称:etc_wallet
 * 类描述 缺省的代理器
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/6/22 15:45
 */
public abstract class AbstarctPresenter<M extends Api> implements IBasePresenter {

    protected Context mContext;

    protected M baseModel;

    public AbstarctPresenter(Context context) {
        this.mContext = context;
        this.baseModel = baseModel();
    }

    /**
     * prensenter强制要求一个请求模型，可以为null
     *
     * @return
     */
    public abstract M baseModel();


    public void toast(int msg) {
        Toast.makeText(mContext, mContext.getResources().getString(msg), Toast.LENGTH_SHORT).show();
    }


    public void toast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }


    /**
     * 解析数据
     *
     * @param observable
     * @param <T>
     * @return
     */
    @SuppressLint("CheckResult")
    public <T> void requst(Observable<Result<T>> observable, final IResultListener<T> resultItf) {
        observable.subscribeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .map(new Function<Result<T>, T>() {
                    @Override
                    public T apply(Result<T> tResult) throws Exception {
                        if (tResult.getCode() == 200) {
                            return tResult.getData();
                        } else {
                            throw new ApiErro(tResult.getCode(), tResult.getMsg());
                        }
                    }
                }).subscribe(new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {
                resultItf.onListener(t);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable e) throws Exception {
                if (e == null) {
                    return;
                }
                if (e instanceof HttpException) {
                    /*网络异常*/
                    toast(R.string.net_erro);
                } else if (e instanceof ApiErro) {
                    toast(((ApiErro) e).getMsg());
                } else if (e instanceof ConnectException || e instanceof SocketTimeoutException) {
                    /*链接异常*/
                    toast(R.string.connet_erro);
                } else if (e instanceof JSONException || e instanceof ParseException) {
                    /*fastjson解析异常*/
                    toast(R.string.json_erro);
                } else if (e instanceof UnknownHostException) {
                    /*无法解析该域名异常*/
                    toast(R.string.host_erro);
                }
            }
        });
    }

}
