package sz.tianhe.etc_wallet.index.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

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
 * 创建时间:2018/7/18 11:39
 */
public class TanscationAdaper extends BaseQuickAdapter<TanscationBean,BaseViewHolder>{

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public TanscationAdaper(@Nullable List<TanscationBean> data) {
        super(R.layout.item_transcation,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TanscationBean item) {
        helper.setText(R.id.address,item.getHash().substring(0,6)+"..."+item.getHash().substring(item.getHash().length()-6,item.getHash().length()))
                .setText(R.id.time,simpleDateFormat.format(item.getCreateTime()))
                .setText(R.id.money,(item.getTxType() == 1?"+":"-")+item.getAmount().setScale(4).toString());


        helper.setTextColor(R.id.money,item.getTxType() == 1?mContext.getResources().getColor(R.color.color286cff)
                :mContext.getResources().getColor(R.color.color262626));
    }
}
