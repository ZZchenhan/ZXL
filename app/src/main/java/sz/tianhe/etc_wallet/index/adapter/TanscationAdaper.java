package sz.tianhe.etc_wallet.index.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.index.bean.TanscationBean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 11:39
 */
public class TanscationAdaper extends BaseQuickAdapter<TanscationBean,BaseViewHolder>{

    public TanscationAdaper(@Nullable List<TanscationBean> data) {
        super(R.layout.item_transcation,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TanscationBean item) {
        helper.setText(R.id.address,item.getAddress().substring(0,6)+"..."+item.getAddress().substring(item.getAddress().length()-6,item.getAddress().length()))
                .setText(R.id.time,item.getTime())
                .setText(R.id.money,(item.getType() == 0?"+":"-")+String.format("%.4f",item.getMoney()));


        helper.setTextColor(R.id.money,item.getType() == 0?mContext.getResources().getColor(R.color.color286cff)
                :mContext.getResources().getColor(R.color.color262626));
    }
}
