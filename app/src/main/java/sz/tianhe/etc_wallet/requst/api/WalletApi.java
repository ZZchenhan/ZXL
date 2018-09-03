package sz.tianhe.etc_wallet.requst.api;


import java.math.BigDecimal;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.OPTIONS;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import sz.tianhe.baselib.model.bean.Result;
import sz.tianhe.etc_wallet.home.bean.SetPassVo;
import sz.tianhe.etc_wallet.home.bean.TransferVo;
import sz.tianhe.etc_wallet.index.bean.AddCoinVo;
import sz.tianhe.etc_wallet.index.bean.ETHCoinVo;
import sz.tianhe.etc_wallet.index.bean.ETHConcatBanclance;
import sz.tianhe.etc_wallet.index.bean.SelectCoinVo;
import sz.tianhe.etc_wallet.requst.vo.EHBBanlance;
import sz.tianhe.etc_wallet.requst.vo.ETHList;
import sz.tianhe.etc_wallet.requst.vo.ManagerItem;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;
import sz.tianhe.etc_wallet.requst.vo.PageBean;
import sz.tianhe.etc_wallet.requst.vo.TanscationTotalBean;
import sz.tianhe.etc_wallet.requst.vo.User;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;
import sz.tianhe.etc_wallet.requst.vo.YesterDayProfit;

/**
 * 钱包接口相关接口
 */
public interface WalletApi {

    @GET("bechatwallet/wallet/queryUserWalletTotal")
    Observable<Result<BigDecimal>> queryUserWalletTotal(@Query("userId") int userId);


    @GET("bechatwallet/wallet/queryUserWalletList")
    Observable<Result<List<WalletItemBean>>> queryUserWalletCoinList(@Query("userId")int userId);


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


    /**
     * 查询钱包余额 走ETH接口
     */
    @GET("/tx/address/{address}")
    Observable<EHBBanlance> getETHBanlance(@Path("address")String address);


    @GET("/tx/address/{address}")
    Call<EHBBanlance> getSynchronizationETHBanlance(@Path("address")String address);

    /**
     * 查询钱转账记录
     * @param address eth地址
     * @param page 页数
     * @param limit 忽略
     */
    @GET("/tx/address/list/{address}/{page}/{limit}")
    Observable<ETHList> getETHList(@Path("address")String address,@Path("page") int page,@Path("limit")int limit);


    /**
     * 获取交易
     * @param contractAddress
     * @param address
     * @return
     */
    @GET("/tx/token/{contractAddress}/{address}")
    Observable<ETHList> getTokenList(@Path("contractAddress")String contractAddress,@Path("address")String address);


    /**
     * 创建ETH钱包
     * @param user
     * @return
     */
    @POST("/bechatwallet/wallet/createWalletInfo")
    Observable<Result<String>> createETHWallet(@Body SetPassVo user);


    /**
     * 转账
     * @param vo
     * @return
     */
    @POST("/bechatwallet/wallet/modifyWithdrawMoney")
    Observable<Result<String>> transferETH(@Body TransferVo vo);

    /**
     * 查询币种
     */
    @GET("/token/searchHandler/{item}")
    Observable<List<ETHCoinVo>> searchItem(@Path("item")String coinName);


    /**
     * 添加合约币到数据
     */
    @POST("/bechatwallet/wallet/createContractWalletInfo")
    Observable<Result<String>> addEthCoint(@Body AddCoinVo addCoinVo);


    /**
     * 添加合约币到数据
     */
    @POST("bechatwallet/wallet/deleteUserContractAddr")
    Observable<Result<String>> delEthCoint(@Body AddCoinVo addCoinVo);


    /**
     * 获取合约币余额
     * @return
     */
    @GET("/token/balance/{contractAddr}/{from}")
    Observable<ETHConcatBanclance> getContactBanlance(@Path("contractAddr")String contractAddr, @Path("from")String address);

    /**
     * 同步获取合约币余额
     * @return
     */
    @GET("/token/balance/{contractAddr}/{from}")
    Call<ETHConcatBanclance> getSynchronizationtContactBanlance(@Path("contractAddr")String contractAddr,@Path("from")String address);


    /**
     * 查询添加的合约币
     */
    @GET("/bechatwallet/wallet/queryUserWalletListStatus")
    Call<Result<List<SelectCoinVo>>> querySelector(@Query("userId") long  userId,@Query("list") String list);
}
