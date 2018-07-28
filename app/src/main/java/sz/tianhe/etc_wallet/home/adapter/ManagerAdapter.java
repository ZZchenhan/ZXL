package sz.tianhe.etc_wallet.home.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.requst.vo.ManagerItem;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/16 14:33
 */
public class ManagerAdapter  extends BaseQuickAdapter<ManagerItem,BaseViewHolder>{
    public ManagerAdapter(@Nullable List<ManagerItem> data) {
        super(R.layout.item_manage_wallet,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ManagerItem item) {
        Glide.with(mContext)
                .load(item.getCoinImg())
                .into((ImageView) helper.getView(R.id.ic_coin));
        helper.setText(R.id.coinName,item.getCoinName())
                .setText(R.id.address,item.getAddress())
                .setText(R.id.straight_push,"直:"+item.getStraightPush().setScale(4).toString())
                .setText(R.id.tv_interest,"息："+item.getInterest().setScale(2).toString())
                .setText(R.id.total,item.getAmount().setScale(2).toString())
                .setText(R.id.unit,item.getCoinName());
    }
}
