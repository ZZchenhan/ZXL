package sz.tianhe.etc_wallet.assets.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import sz.tianhe.etc_wallet.R;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 18:11
 */
public class AssertsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public AssertsAdapter(@Nullable List<String> data) {
        super(R.layout.item_asserts, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

    }
}
