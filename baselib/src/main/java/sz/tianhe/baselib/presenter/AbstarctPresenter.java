package sz.tianhe.baselib.presenter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;


import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;


import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import sz.tianhe.baselib.R;
import sz.tianhe.baselib.api.Api;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.http.erro.ApiErro;
import sz.tianhe.baselib.model.bean.Result;
import sz.tianhe.baselib.weight.ProgrossDialog;


/**
 * 项目名称:etc_wallet
 * 类描述 缺省的代理器
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/6/22 15:45
 */
public abstract class AbstarctPresenter implements IBasePresenter {

    protected Context mContext;



    public AbstarctPresenter(Context context) {
        this.mContext = context;
    }



    public void toast(int msg) {
        Toast.makeText(mContext, mContext.getResources().getString(msg), Toast.LENGTH_SHORT).show();
    }


    public void toast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    private ProgrossDialog dialog;

    public <T> void requst(Observable<Result<T>> observable,  IResultListener<T> resultItf){
        requst(observable,resultItf,false);
    }
    /**
     * 解析数据
     *
     * @param observable
     * @param <T>
     * @return
     */
    @SuppressLint("CheckResult")
    public <T> void requst(Observable<Result<T>> observable, final IResultListener<T> resultItf, final boolean isShow) {
        observable.subscribeOn(Schedulers.newThread())
                .doOnSubscribe(disposable -> {
                    if(isShow){
                        dialog = new ProgrossDialog(mContext);
                        dialog.show();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .map(tResult -> {
                    if (tResult.getCode() == 1) {
                        if(isShow && dialog!=null){
                            dialog.dismiss();
                        }
                        return tResult.getData();
                    } else {
                        throw new ApiErro(tResult.getCode(), tResult.getMessage());
                    }
                }).subscribe(t -> resultItf.onListener(t), e -> {
                    if(isShow && dialog!=null){
                       dialog.dismiss();
                    }
                    if (e == null) {
                        return;
                    }
                    if (e instanceof HttpException) {
                        /*网络异常*/
                        if(((HttpException) e).code() == 404){
                            toast(R.string.notfound_erro);
                        }else if(((HttpException) e).code() > 500){
                            toast(R.string.service_erro);
                        }else {
                            toast(R.string.net_erro);
                        }
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
                    }else{
                        toast(e.getMessage());
                    }
                });
    }

}
