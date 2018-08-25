package sz.tianhe.etc_wallet.index.adapter;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.requst.vo.ETHList;
import sz.tianhe.etc_wallet.requst.vo.TanscationBean;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/18 11:39
 */
public class TanscationAdaper extends BaseQuickAdapter<ETHList.ResultBean,BaseViewHolder>{

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 我的交易地址
     */
    private String meAddress = "";
    public TanscationAdaper(@Nullable List<ETHList.ResultBean> data) {
        super(R.layout.item_transcation,data);
    }

    public void setMeAddress(String meAddress) {
        this.meAddress = meAddress;
    }

    @Override
    protected void convert(BaseViewHolder helper, ETHList.ResultBean item) {
        helper.setText(R.id.address,item.getHash().substring(0,6)+"..."+item.getHash().substring(item.getHash().length()-6,item.getHash().length()))
                .setText(R.id.time,simpleDateFormat.format(new Date(item.getTimeStamp()*1000)))
                .setText(R.id.money,(meAddress.equalsIgnoreCase(item.getFrom())?
                        "-":"+")+
                        (item.getValue().divide(new BigDecimal("100000000000000000"),6,BigDecimal.ROUND_DOWN)).toString());
        helper.setTextColor(R.id.money,meAddress.equalsIgnoreCase(item.getFrom())?mContext.getResources().getColor(R.color.color286cff)
                :mContext.getResources().getColor(R.color.color262626));
    }
}
