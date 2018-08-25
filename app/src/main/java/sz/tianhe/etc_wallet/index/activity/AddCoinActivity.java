package sz.tianhe.etc_wallet.index.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.baselib.navagation.AdapterNavagation;
import sz.tianhe.baselib.navagation.IBaseNavagation;
import sz.tianhe.baselib.view.activity.BaseActivity;
import sz.tianhe.baselib.weight.ProgrossDialog;
import sz.tianhe.etc_wallet.MyApplication;
import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.ActivityAddCoinBinding;
import sz.tianhe.etc_wallet.index.adapter.AddCoinAdapter;
import sz.tianhe.etc_wallet.index.animation.HeightEvaluator;
import sz.tianhe.etc_wallet.index.bean.ETHCoinVo;
import sz.tianhe.etc_wallet.index.bean.SelectCoinVo;
import sz.tianhe.etc_wallet.requst.api.WalletApi;
import sz.tianhe.etc_wallet.utils.SoftUtils;

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
        AdapterNavagation adapterNavagation = new AdapterNavagation(this)
                .setNavagationBackgroudColor(R.color.fragment_index_color)
                .setBack()
                .setTitle("添加币种", 16, R.color.white)
                .setRightImage(R.mipmap.search, v -> {
                    show();
                });
        return adapterNavagation;
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
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) binding.constraintLayout2.getLayoutParams();
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
        addCoinAdapter = new AddCoinAdapter(this.ethCoinVos);
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
        MyApplication.tranferClient.create(WalletApi.class).searchItem(binding.numbers.getText().toString())
                .subscribeOn(Schedulers.newThread())
                .flatMap((Function<List<ETHCoinVo>, ObservableSource<List<ETHCoinVo>>>) ethCoinVos -> {
                    List<String> datas = new ArrayList<>();
                    for (ETHCoinVo item : ethCoinVos) {
                        datas.add(item.getContractAddress());
                    }
                    //获取数据
                    List<SelectCoinVo> serverEthCoins = MyApplication.retrofitClient.
                            create(WalletApi.class).querySelector(MyApplication.user.getId(), new Gson().toJson(datas))
                            .execute().body().getData();

                    for (ETHCoinVo item : ethCoinVos) {
                        for (SelectCoinVo selectCoinVo : serverEthCoins) {
                            if (item.getContractAddress().equals(selectCoinVo.getContractAddr())) {
                                item.setAdd(selectCoinVo.isStatus());
                            }
                        }
                    }

                    return Observable.create(emitter -> {
                        emitter.onNext(ethCoinVos);
                        emitter.onComplete();
                    });
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ETHCoinVo>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (dialog == null) {
                            dialog = new ProgrossDialog(AddCoinActivity.this);
                        }
                        dialog.show();
                    }

                    @Override
                    public void onNext(List<ETHCoinVo> ethCoinVos) {
                        dialog.dismiss();
                        AddCoinActivity.this.ethCoinVos.clear();
                        AddCoinActivity.this.ethCoinVos.addAll(ethCoinVos);
                        AddCoinActivity.this.addCoinAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        dialog.dismiss();
                        ToastUtils.showShort("请求错误");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    @Override
    protected View bindViews() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this), layoutId(), null, false);
        return binding.getRoot();
    }


}
