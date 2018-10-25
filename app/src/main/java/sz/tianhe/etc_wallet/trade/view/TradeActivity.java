package sz.tianhe.etc_wallet.trade.view;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTradeBinding;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

/**
 * 交易详情
 */
public class TradeActivity extends BaseActivity {


    @Override
    public int layoutId() {
        return R.layout.activity_trade;
    }


    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
    }

    @Override
    public void findViews() {

    }

    ActivityTradeBinding binding;

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }
}
