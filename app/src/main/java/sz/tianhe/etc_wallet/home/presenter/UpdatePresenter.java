package sz.tianhe.etc_wallet.home.presenter;

import android.annotation.SuppressLint;
import android.content.Context;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.UUID;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;
import sz.tianhe.baselib.http.IResultListener;
import sz.tianhe.baselib.http.erro.ApiErro;
import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.baselib.weight.ProgrossDialog;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.requst.api.PutObjectSamplesApi;
import sz.tianhe.etc_wallet.requst.api.UserApi;

public class UpdatePresenter extends AbstarctPresenter {

    public UpdatePresenter(Context context, OnUpdateViewSuccss onUpdateViewSuccss) {
        super(context);
        this.onUpdateViewSuccss = onUpdateViewSuccss;
    }

    @Override
    public void init() {

    }

    public void updateUserInfo(String url,String name,String strSex) {
        int sex = 0;
        if(strSex.equals("女")){
            sex = 1;
        }

        requst(MyApplication.retrofitClient.create(UserApi.class).updateUserInfo(MyApplication.user.getId(), name, sex, url == null ? MyApplication.user.getHeadImg() : url), new IResultListener<String>() {
            @Override
            public void onListener(String s) {
                onUpdateViewSuccss.updateUserInfoSuccss();
            }
        }, true);
    }

    @SuppressLint("CheckResult")
    public void uploade(String file) {
        UUID uuid = UUID.randomUUID();
        PutObjectSamplesApi.upload(MyApplication.oss, uuid.toString(), file, MyApplication.buck).subscribeOn(Schedulers.newThread())
                .doOnSubscribe(disposable -> {
                    dialog = new ProgrossDialog(mContext);
                    dialog.show();
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {onUpdateViewSuccss.onUploadSuccss(t);dialog.dismiss();}, e -> {
                    dialog.dismiss();
                    if (e == null) {
                        return;
                    }
                    if (e instanceof HttpException) {
                        /*网络异常*/
                        if (((HttpException) e).code() == 404) {
                            toast(sz.tianhe.baselib.R.string.notfound_erro);
                        } else if (((HttpException) e).code() > 500) {
                            toast(sz.tianhe.baselib.R.string.service_erro);
                        } else {
                            toast(sz.tianhe.baselib.R.string.net_erro);
                        }
                    } else if (e instanceof ApiErro) {
                        toast(((ApiErro) e).getMsg());
                    } else if (e instanceof ConnectException || e instanceof SocketTimeoutException) {
                        /*链接异常*/
                        toast(sz.tianhe.baselib.R.string.connet_erro);
                    } else if (e instanceof JSONException || e instanceof ParseException) {
                        /*fastjson解析异常*/
                        toast(sz.tianhe.baselib.R.string.json_erro);
                    } else if (e instanceof UnknownHostException) {
                        /*无法解析该域名异常*/
                        toast(sz.tianhe.baselib.R.string.host_erro);
                    } else {
                        toast(e.getMessage());
                    }
                });
    }

    OnUpdateViewSuccss onUpdateViewSuccss;

    public interface OnUpdateViewSuccss {
        void onUploadSuccss(String url);
        void updateUserInfoSuccss();
    }
}
