package sz.tianhe.etc_wallet.trade.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.FragmentTradeBinding;

/**
 * 主页-交易部分
 */
public class TradeFragment extends Fragment {

    FragmentTradeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == binding) {
            binding = DataBindingUtil.inflate(inflater, R.layout.fragment_trade, null, false);
            initView();
        }
        return binding.getRoot();
    }


    private void initView() {
        binding.buy.setOnClickListener(v -> buy());
        binding.sell.setOnClickListener(v -> sell());
        initFragment();
    }

    HallFragment selleFragment;
    HallFragment buyFragment;
    private void initFragment() {
        selleFragment = new HallFragment();
        Bundle selleBundle = new Bundle();
        selleBundle.putInt(HallFragment.EXTRA_TYPE, HallFragment.TYPE_SELL);
        selleFragment.setArguments(selleBundle);


         buyFragment = new HallFragment();
        Bundle buyeBundle = new Bundle();
        buyeBundle.putInt(HallFragment.EXTRA_TYPE, HallFragment.TYPE_BUY);
        buyFragment.setArguments(buyeBundle);

        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        fragmentManager.beginTransaction().
                add(R.id.trade_contain, selleFragment,"sell")
                .add(R.id.trade_contain, buyFragment,"buy").commit();
        buy();
    }

    private void buy() {
        binding.view1.setVisibility(View.VISIBLE);
        binding.view2.setVisibility(View.GONE);
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        fragmentManager.beginTransaction().hide(selleFragment)
                .show(buyFragment).commit();
        buyFragment.refresh();
    }

    private void sell() {
        binding.view1.setVisibility(View.GONE);
        binding.view2.setVisibility(View.VISIBLE);
        FragmentManager fragmentManager = getFragmentManager();
        assert fragmentManager != null;
        fragmentManager.beginTransaction().hide(buyFragment)
                .show(selleFragment).commit();
        selleFragment.refresh();
    }
}
