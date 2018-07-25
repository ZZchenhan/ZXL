package sz.tianhe.etc_wallet.requst.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import sz.tianhe.baselib.model.bean.Result;


public interface CodeApi {

    @GET("/code/getCode")
    Observable<Result<String>> getCode(@Query("phone") String phone,@Query("length") String length);


    @GET("/code/check")
    Observable<Result<String>> check(@Query("phone")String phone,@Query("code") String code);
}
