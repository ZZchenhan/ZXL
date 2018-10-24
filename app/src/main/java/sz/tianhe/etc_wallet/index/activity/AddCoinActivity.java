package sz.tianhe.etc_wallet.index.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.baselib.weight.ProgrossDialog;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityAddCoinBinding;
import sz.tianhe.etc_wallet.index.adapter.AddCoinAdapter;
import sz.tianhe.etc_wallet.index.animation.HeightEvaluator;
import sz.tianhe.etc_wallet.index.bean.ETHCoinVo;
import sz.tianhe.etc_wallet.utils.SoftUtils;
import sz.tianhe.etc_wallet.utils.StatusBarUtils;

/**
 * 添加币种
 */
public class AddCoinActivity extends BaseActivity {
    ActivityAddCoinBinding binding;
    protected ProgrossDialog dialog;

    List<ETHCoinVo> ethCoinVos = new ArrayList<>();
    AddCoinAdapter addCoinAdapter;

    @Override
    public int layoutId() {
        return R.layout.activity_add_coin;
    }

    @Override
    public IBaseNavagation navagation() {
        return null;
    }

    boolean isCanclik = true;

    private void show() {
        if (!isCanclik) {
            return;
        }
        ValueAnimator set = ValueAnimator.ofObject(new HeightEvaluator(), 0, 125);
        if (binding.constraintLayout2.getHeight() != 0) {
            set = ValueAnimator.ofObject(new HeightEvaluator(), 125, 0);
        }
        set.addUpdateListener(animation -> {
            float heigh = (float) animation.getAnimatedValue();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) binding.constraintLayout2.getLayoutParams();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, heigh, getResources().getDisplayMetrics());
            binding.constraintLayout2.setLayoutParams(layoutParams);
        });
        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation, boolean isReverse) {
                isCanclik = false;
            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                isCanclik = true;
                if (binding.constraintLayout2.getHeight() == 0) {
                    SoftUtils.hidenSoftInputFromWindow(binding.numbers);
                } else {
                    SoftUtils.showSoftInputFromWindow(binding.numbers);
                }
            }
        });
        set.setDuration(500);
        set.start();
    }

    @Override
    public void initView() {
        StatusBarUtils.hideStatus(this);
        addCoinAdapter = new AddCoinAdapter(this.ethCoinVos);
        binding.search.setOnClickListener(v -> show());
        binding.toolbar.setNavigationOnClickListener(v -> finish());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(addCoinAdapter);
        binding.recyclerView.postDelayed(() -> show(), 200);
    }

    @Override
    public void findViews() {
        binding.numbers.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                SoftUtils.hidenSoftInputFromWindow(binding.numbers);
                show();
                search();
                binding.numbers.setText("");
                return true;
            }
            return false;
        });
    }


    private void search() {
        if (binding.numbers.getText().toString().equals("")) {
            ToastUtils.showShort("请输入正确的币种名称");
            return;
        }
        ethCoinVos.add(new ETHCoinVo());
        ethCoinVos.add(new ETHCoinVo());
        ethCoinVos.add(new ETHCoinVo());
        ethCoinVos.add(new ETHCoinVo());
        ethCoinVos.add(new ETHCoinVo());
        addCoinAdapter.notifyDataSetChanged();
    }


    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }

}
