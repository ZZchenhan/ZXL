package sz.tianhe.etc_wallet.home.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/19 18:14
 */
public class ManageTransferAdapter extends BaseQuickAdapter<TanscationBean, BaseViewHolder> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public ManageTransferAdapter(@Nullable List<TanscationBean> data) {
        super(R.layout.item_manage_transcation, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TanscationBean item) {
        helper.setImageResource(R.id.ic_coin, getImage(item));
        helper.setText(R.id.address,item.getHash().substring(0,6)+"..."+item.getHash().substring(item.getHash().length()-6,item.getHash().length()));
        helper.setText(R.id.time,simpleDateFormat.format(item.getCreateTime()));
        helper.setText(R.id.money,item.getAmount().setScale(4).toString());
        if(item.getAmount().compareTo(new BigDecimal(0))>0){
            helper.setTextColor(R.id.money, Color.parseColor("#286CFF"));
        }else{
            helper.setTextColor(R.id.money,Color.BLACK);
        }
    }

    public int getImage(TanscationBean type) {
        switch (type.getTxType()) {
            case 1:
                return R.mipmap.ic_type_interest;
            case 2:
                return R.mipmap.ic_type_into;
            case 3:
                return R.mipmap.ic_type_out;
            case 4:
                return R.mipmap.ic_type_overdue;
            default:
                return R.mipmap.ic_type_push;
        }

    }
}
