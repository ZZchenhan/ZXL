package sz.tianhe.etc_wallet.home.adapter;

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
 * 创建时间:2018/7/19 18:14
 */
public class ManageTransferAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ManageTransferAdapter(@Nullable List<String> data) {
        super(R.layout.item_manage_transcation, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setImageResource(R.id.ic_coin, getImage(item));
    }

    public int getImage(String type) {
        switch (type) {
            case "0":
                return R.mipmap.ic_type_interest;
            case "1":
                return R.mipmap.ic_type_into;
            case "2":
                return R.mipmap.ic_type_out;
            case "3":
                return R.mipmap.ic_type_overdue;
            default:
                return R.mipmap.ic_type_push;
        }

    }
}
