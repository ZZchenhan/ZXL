package sz.tianhe.etc_wallet.requst.api;


import java.math.BigDecimal;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.OPTIONS;
import retrofit2.http.POST;
import retrofit2.http.Query;
import sz.tianhe.baselib.model.bean.Result;
import sz.tianhe.etc_wallet.requst.vo.ManagerItem;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationTotalBean;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;
import sz.tianhe.etc_wallet.requst.vo.YesterDayProfit;

/**
 * 钱包接口相关接口
 */
public interface WalletApi {

    @GET("bechatwallet/wallet/queryUserWalletTotal")
    Observable<Result<BigDecimal>> queryUserWalletTotal(@Query("userId") int userId);


    @GET("bechatwallet/wallet/queryUserWalletCoinList")
    Observable<Result<PageBean<WalletItemBean>>> queryUserWalletCoinList(@Query("currentPage") int currentPage, @Query("currentSize") int currentSize, @Query("userId")int userId);


    @GET("bechatwallet/wallet/queryUserWalletCoinList")
    Observable<Result<PageBean<WalletItemBean>>> queryUserWalletDetail(@Query("currentPage") int currentPage, @Query("currentSize") int currentSize, @Query("userId")int userId
    ,@Query("coinName") String coinName);


    @GET("bechatwallet/transaction/queryUserCoinTransactionList")
    Observable<Result<PageBean<TanscationBean>>> queryUserCoinTransactionList(@Query("currentPage") int currentPage, @Query("currentSize") int currentSize, @Query("userId")int userId
            , @Query("coinType") String coinType);

    @POST("bechatwallet/wallet/modifyWalletTurnOut")
    Observable<Result<String>> transfer(@Query("id") int id,@Query("amount")String amount,@Query("address")String address,@Query("coinName")String coinName,@Query("remark")String remark);

    /**
     * 查询交易记录
     * @return
     */
    @GET("bechatwallet/transaction/queryUserCoinTransactionListInfo")
    Observable<Result<PageBean<TanscationBean>>> getTransferHistory(@Query("currentPage")
                                                                                          int currentPage,
                                                                                  @Query("currentSize")int currentSize,
                                                                                  @Query("userId") int userId,@Query("startTime") String startTime);

    @GET("bechatwallet/transaction/queryUserCoinTransactionTotal")
    Observable<Result<List<TanscationTotalBean>>> getTransferTotal(@Query("userId") int userId, @Query("startTime") String startTime);


    @GET("bechatwallet/wallet/queryUserWalletCoinStraightOrInterest")
    Observable<Result<PageBean<ManagerItem>>> getManager(@Query("currentPage") int currentPage,@Query("currentSize") int currentSize,@Query("userId") int userId);


    @GET("bechatwallet/wallet/queryYesterdayProfit")
    Observable<Result<List<YesterDayProfit>>> getYestdatProfit(@Query("userId") int userId, @Query("coinId") int coinId);


    @GET("bechatwallet/transaction/queryWalletUserCoinTransactionList")
    Observable<Result<PageBean<TanscationBean>>> getManagerList(@Query("currentPage") int currentPage,@Query("currentSize") int currentSize,@Query("userId") int userId,@Query("coinType")String coinType);

}
