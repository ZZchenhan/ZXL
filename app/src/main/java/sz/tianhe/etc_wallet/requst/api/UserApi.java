package sz.tianhe.etc_wallet.requst.api;



import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Query;

import sz.tianhe.baselib.model.bean.Result;
import sz.tianhe.etc_wallet.requst.vo.User;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 15:13
 */

public interface UserApi{

    @GET("/common/mnemonit")
    Observable<Result<String>> mnemonit();

    @POST("/common/register")
    Observable<Result<String>> register(@Query("phone")String phone,@Query("pass")String pass,@Query("invitationCode")String invitationCode,@Query("keyWords")String keyWords);

    @POST("/common/login")
    Observable<Result<User>> login(@Query("tel") String tel,@Query("password") String password);

    @GET("/user/user")
    Observable<Result<User>> getUserInfo();
}
