package sz.tianhe.etc_wallet.recive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 *  金额变动接收器,
 *  @author ch
 *  @date 2018年9月3日
 */
public class AmountChangeBroadCastRecive extends BroadcastReceiver {

    /**
     * action名称
     */
    public static final String  ACTION_AMOUNT_CHANGE = "ACTION_AMOUNT_CHANGE";

    /**
     * 金额变动回调放法
     */
    private AmountChangeListener mAmountChangeListener;

    public AmountChangeBroadCastRecive() {
    }

    public AmountChangeBroadCastRecive(AmountChangeListener listener){
        this.mAmountChangeListener = listener;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        //接受到广播时候
        if(ACTION_AMOUNT_CHANGE.equals(intent.getAction())){
            if (null != this.mAmountChangeListener){
                this.mAmountChangeListener.onAcmountChanged();
            }
        }
    }


    /**
     * 金额变动回调放珐
     */
    public interface AmountChangeListener{
        void onAcmountChanged();
    }
}
