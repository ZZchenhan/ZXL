package sz.tianhe.etc_wallet.index.animation;

import android.animation.TypeEvaluator;

public class HeightEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int start = (int) startValue;
        int end = (int)endValue;
        float y = start + fraction * (end - start);
        return y;
    }
}
