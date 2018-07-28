package sz.tianhe.etc_wallet.index.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.math.BigDecimal;
import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.index.bean.AsssertBean;
import sz.tianhe.etc_wallet.requst.vo.WalletItemBean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 10:26
 */
public class IndeAdapter extends BaseQuickAdapter<WalletItemBean,BaseViewHolder> {
    public IndeAdapter(@Nullable List<WalletItemBean> data) {
        super(R.layout.item_index,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WalletItemBean item) {
        helper.setBackgroundColor(R.id.root,mContext.getResources().getColor(R.color.bgColor));
        Glide.with(mContext).applyDefaultRequestOptions(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .load(item.getCoinImg()).into((ImageView) helper.getView(R.id.circleImageView));
        helper.setText(R.id.coin_name,item.getCoinName())
                .setText(R.id.coin_number, item.getAmount().setScale(4).toString())
                .setText(R.id.tv_value,item.getFreeAmount().setScale(4).toString());
    }
}
