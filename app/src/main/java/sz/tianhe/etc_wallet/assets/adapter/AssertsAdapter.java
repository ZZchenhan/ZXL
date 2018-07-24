package sz.tianhe.etc_wallet.assets.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.math.BigDecimal;
import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.assets.bean.QutaiorBean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 18:11
 */
public class AssertsAdapter extends BaseQuickAdapter<QutaiorBean, BaseViewHolder> {
    public AssertsAdapter(@Nullable List<QutaiorBean> data) {
        super(R.layout.item_asserts, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, QutaiorBean item) {

        helper.setText(R.id.market_name, item.getCoinName())
                .setText(R.id.volume, "24h成交：" + new BigDecimal(item.getBaseVolume()).setScale(2,BigDecimal.ROUND_DOWN))
                .setText(R.id.cny_value, "高：" + item.getHigh24hr())
                .setText(R.id.dola_value, "低：" + item.getLow24hr());

        BigDecimal zd = new BigDecimal(item.getPercentChange()).setScale(2,BigDecimal.ROUND_DOWN);

        if(zd.doubleValue()<0){
            helper.setBackgroundRes(R.id.button3,R.drawable.bg_33cc66_c_4);
            helper.setText(R.id.button3, zd+"%");
        }else{helper.setText(R.id.button3, "+"+zd+"%");
            helper.setBackgroundRes(R.id.button3,R.drawable.bg_fa4b57_c_4);
        }
    }
}
