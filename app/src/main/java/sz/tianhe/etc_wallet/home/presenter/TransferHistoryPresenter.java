package sz.tianhe.etc_wallet.home.presenter;

import android.content.Context;

import sz.tianhe.baselib.presenter.AbstarctPresenter;
import sz.tianhe.etc_wallet.requst.vo.ETHList;
import sz.tianhe.etc_wallet.requst.vo.TanscationTotalBean;

public class TransferHistoryPresenter extends AbstarctPresenter {
    ITransfer mITransfer;
    public TransferHistoryPresenter(Context context,ITransfer mITransfer) {
        super(context);
        this.mITransfer = mITransfer;
    }

    @Override
    public void init() {

    }

    public void getTotal(String startTime){

    }

    /**
     *
     * @param address
     */
    public void getList(String address,int page){


    }

    public interface ITransfer{
        void total(TanscationTotalBean total);
        void list(ETHList page);
    }
}
