package sz.tianhe.etc_wallet.index.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.index.bean.ETHCoinVo;

public class AddCoinAdapter extends BaseQuickAdapter<ETHCoinVo,BaseViewHolder> {

    public AddCoinAdapter(@Nullable List<ETHCoinVo> data) {
        super(R.layout.layout_item_add_coin,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ETHCoinVo item) {
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

    }


    /**
     *  删除
     * @param postion
     */
    private void deleteCoin(int postion){

    }

}
