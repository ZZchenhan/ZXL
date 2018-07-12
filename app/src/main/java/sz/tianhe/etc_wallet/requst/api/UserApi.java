package sz.tianhe.etc_wallet.requst.api;



import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;

import retrofit2.http.Query;
import sz.tianhe.baselib.api.Api;

import sz.tianhe.baselib.model.bean.Result;
import sz.tianhe.etc_wallet.requst.vo.UserVo;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 15:13
 */

public interface UserApi{

    /**
     * 用户登录
     * @return
     */
    @POST("/user/login")
    Observable<Result<UserVo>> login(@Query("phone") String phone, @Query("pass") String pass);

}
