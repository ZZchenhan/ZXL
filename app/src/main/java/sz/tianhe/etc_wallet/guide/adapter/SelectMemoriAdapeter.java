package sz.tianhe.etc_wallet.guide.adapter;

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
 * 创建时间:2018/7/16 20:17
 */
public class SelectMemoriAdapeter extends BaseQuickAdapter<String,BaseViewHolder> {
    public SelectMemoriAdapeter(@Nullable List<String> data) {
        super(R.layout.item_memori_select,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tag,item);
        helper.addOnClickListener(R.id.tag);
    }
}
