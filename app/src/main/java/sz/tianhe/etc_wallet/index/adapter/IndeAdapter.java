package sz.tianhe.etc_wallet.index.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.index.bean.AsssertBean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 10:26
 */
public class IndeAdapter extends BaseQuickAdapter<AsssertBean,BaseViewHolder> {
    public IndeAdapter(@Nullable List<AsssertBean> data) {
        super(R.layout.item_index,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AsssertBean item) {
        helper.setBackgroundColor(R.id.root,mContext.getResources().getColor(R.color.bgColor));
        helper.setImageResource(R.id.circleImageView,item.getIconId())
                .setText(R.id.coin_name,item.getCoinTilte())
                .setText(R.id.coin_number,String.format("%.2f",item.getCoinNumber()))
                .setText(R.id.tv_value,String.format("≈%.2f￥",item.getValue()));
    }
}
