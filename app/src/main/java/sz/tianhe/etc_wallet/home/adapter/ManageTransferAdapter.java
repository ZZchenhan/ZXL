package sz.tianhe.etc_wallet.home.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
 * 创建时间:2018/7/19 18:14
 */
public class ManageTransferAdapter extends BaseQuickAdapter<ETHList.ResultBean, BaseViewHolder> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private String meAddrss = "";
    public ManageTransferAdapter(@Nullable List<ETHList.ResultBean> data) {
        super(R.layout.item_manage_transcation, data);
    }

    public void setMeAddrss(String meAddrss) {
        this.meAddrss = meAddrss;
    }

    @Override
    protected void convert(BaseViewHolder helper, ETHList.ResultBean item) {
//        helper.setImageResource(R.id.ic_coin, getImage(item));
//        helper.setText(R.id.address,item.getHash().substring(0,6)+"..."+item.getHash().substring(item.getHash().length()-6,item.getHash().length()));
//        helper.setText(R.id.time,simpleDateFormat.format(item.getTimeStamp()*1000));
//        helper.setText(R.id.money,(meAddrss.equalsIgnoreCase(item.getFrom())?
//                        "-":"+")+
//                        (item.getValue().divide(new BigDecimal("100000000000000000"),6,BigDecimal.ROUND_DOWN)).toString());
//        if(!meAddrss.equalsIgnoreCase(item.getFrom())){
//            helper.setTextColor(R.id.money, Color.parseColor("#286CFF"));
//        }else{
//            helper.setTextColor(R.id.money,Color.BLACK);
//        }
    }

    public int getImage(ETHList.ResultBean type) {
        if (type.getFrom() == null) {
            return R.mipmap.ic_type_out;
        }else{
            return R.mipmap.ic_type_into;
        }
    }
}
