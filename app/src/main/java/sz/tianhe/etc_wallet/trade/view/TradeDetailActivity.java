package sz.tianhe.etc_wallet.trade.view;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;

import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityTradeBinding;
import sz.tianhe.etc_wallet.databinding.ActivityTradeDetailBinding;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

/**
 * 交易结果页面
 */
public class TradeDetailActivity extends BaseActivity {

    @Override
    public int layoutId() {
        return R.layout.activity_trade_detail;
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

    ActivityTradeDetailBinding binding;

    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }
}
