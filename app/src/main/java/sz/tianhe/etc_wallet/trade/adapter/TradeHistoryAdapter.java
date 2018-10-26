package sz.tianhe.etc_wallet.trade.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import sz.tianhe.etc_wallet.R;

/**
 * 交易历史记录
 */
public class TradeHistoryAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public TradeHistoryAdapter(@Nullable List<String> data) {
        super(R.layout.item_trade_history, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
