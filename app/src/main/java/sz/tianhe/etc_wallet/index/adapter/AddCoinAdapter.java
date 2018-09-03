package sz.tianhe.etc_wallet.index.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.CompoundButton;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.baselib.model.bean.Result;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.index.bean.AddCoinVo;
import sz.tianhe.etc_wallet.index.bean.ETHCoinVo;
import sz.tianhe.etc_wallet.recive.AmountChangeBroadCastRecive;
import sz.tianhe.etc_wallet.requst.api.WalletApi;

public class AddCoinAdapter extends BaseQuickAdapter<ETHCoinVo,BaseViewHolder> {

    public AddCoinAdapter(@Nullable List<ETHCoinVo> data) {
        super(R.layout.layout_item_add_coin,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ETHCoinVo item) {
        //清除
        helper.setOnCheckedChangeListener(R.id.checkBox,null);
        helper.setChecked(R.id.checkBox,item.isAdd())
                .setText(R.id.symbol,item.getSymbol())
                .setText(R.id.textView13,item.getName())
                .setText(R.id.textView14,item.getName());
        //加载
        helper.setOnCheckedChangeListener(R.id.checkBox, (buttonView, isChecked) -> {
            if(isChecked){
                addCoin(getData().indexOf(item));
            }else{
                deleteCoin(getData().indexOf(item));
            }
        });
    }


    /**
     *  添加币种
     * @param postion
     */
    private void addCoin(int postion){
        AddCoinVo addCoinVo = new AddCoinVo();
        addCoinVo.setUserId(MyApplication.user.getId());
        addCoinVo.setName(getData().get(postion).getName());
        addCoinVo.setCoinName(getData().get(postion).getSymbol());
        addCoinVo.setContractAddr(getData().get(postion).getContractAddress());
        MyApplication.retrofitClient.create(WalletApi.class)
                .addEthCoint(addCoinVo)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<String> stringResult) {
                        mContext.sendBroadcast(new Intent().setAction(AmountChangeBroadCastRecive.ACTION_AMOUNT_CHANGE));
                        ToastUtils.showShort(stringResult.getMessage());
                        if(stringResult.getCode() == 200){
                            getData().get(postion).setAdd(true);
                            notifyItemChanged(postion);
                            ((Activity)mContext).setResult(Activity.RESULT_OK);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showShort("请求出错");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     *  删除
     * @param postion
     */
    private void deleteCoin(int postion){
        AddCoinVo addCoinVo = new AddCoinVo();
        addCoinVo.setUserId(MyApplication.user.getId());
        addCoinVo.setName(getData().get(postion).getName());
        addCoinVo.setCoinName(getData().get(postion).getSymbol());
        addCoinVo.setContractAddr(getData().get(postion).getContractAddress());
        MyApplication.retrofitClient.create(WalletApi.class)
                .delEthCoint(addCoinVo)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result<String>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result<String> stringResult) {
                        ToastUtils.showShort(stringResult.getMessage());
                        if(stringResult.getCode() == 200){
                            mContext.sendBroadcast(new Intent().setAction(AmountChangeBroadCastRecive.ACTION_AMOUNT_CHANGE));
                            getData().get(postion).setAdd(false);
                            notifyItemChanged(postion);
                            ((Activity)mContext).setResult(Activity.RESULT_OK);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtils.showShort("请求出错");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
