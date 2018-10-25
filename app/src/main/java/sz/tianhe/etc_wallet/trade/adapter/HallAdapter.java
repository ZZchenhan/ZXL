package sz.tianhe.etc_wallet.trade.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import sz.tianhe.etc_wallet.R;

/**
 * 大厅适配器
 */
public class HallAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public HallAdapter(@Nullable List<String> data) {
        super(R.layout.item_hall, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
