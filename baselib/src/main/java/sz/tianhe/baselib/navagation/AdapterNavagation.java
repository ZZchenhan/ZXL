package sz.tianhe.baselib.navagation;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import sz.tianhe.baselib.R;
import sz.tianhe.baselib.utils.DeviceUtils;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 12:42
 */
public class AdapterNavagation extends RelativeLayout implements IBaseNavagation {

    private LinearLayout leftPane;

    private LinearLayout rightPane;

    public AdapterNavagation(@NonNull Context context) {
        super(context);
        this.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                DeviceUtils.dip2px(getContext(), 50)));
    }

    public AdapterNavagation setLeftImage(int drawableId) {
        setLeftImage(drawableId, null);
        return this;
    }

    public AdapterNavagation setBack() {
       setLeftImage(R.drawable.icon_back,v->{  ((Activity)getContext()).finish();});
        return this;
    }

    public AdapterNavagation setBack(String string,int color){
        int padding = DeviceUtils.dip2px(getContext(), 8);
        if (leftPane == null) {
            leftPane = new LinearLayout(getContext());
            LayoutParams layoutParams = new LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                    LayoutParams.MATCH_PARENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
            layoutParams.leftMargin = padding;
            leftPane.setLayoutParams(layoutParams);
            this.addView(leftPane);
        }
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        textView.setPadding(padding,0,0,0);
        textView.setLayoutParams(params);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(color));

        textView.setOnClickListener(view -> {
            ((Activity)getContext()).finish();
        });

        Drawable lIcon = getContext().getDrawable(R.drawable.icon_back);
        lIcon.setBounds(0,0,lIcon.getMinimumWidth(),lIcon.getMinimumHeight());
        textView.setCompoundDrawablePadding(20);
        textView.setCompoundDrawables(lIcon,null,null,null);
        textView.setText(string == null?"返回":string);
        leftPane.addView(textView);
        return this;
    }


    public AdapterNavagation setLeftText(String title, int textSize, int color,OnClickListener onClickListener) {
        int padding = DeviceUtils.dip2px(getContext(), 4);
        if (leftPane == null) {
            leftPane = new LinearLayout(getContext());
            LayoutParams layoutParams = new LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                    LayoutParams.MATCH_PARENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
            layoutParams.leftMargin = padding;
            leftPane.setLayoutParams(layoutParams);
            this.addView(leftPane);
        }
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(params);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(color));
        if(onClickListener != null){
            textView.setOnClickListener(onClickListener);
        }
        textView.setText(title);
        leftPane.addView(textView);
        return this;
    }

    public AdapterNavagation setTitle(String title, int textSize, int color) {
        TextView textView = new TextView(getContext());
        RelativeLayout.LayoutParams params = new  RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        textView.setLayoutParams(params);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(color));
        textView.setText(title);
        addView(textView,params);
        return this;
    }

    public AdapterNavagation setLeftImage(int drawableId, OnClickListener onClickListener) {
        int padding = DeviceUtils.dip2px(getContext(), 8);
        if (leftPane == null) {
            leftPane = new LinearLayout(getContext());
            LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.MATCH_PARENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
            layoutParams.leftMargin = padding;
            leftPane.setLayoutParams(layoutParams);
            this.addView(leftPane);
        }
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        params.gravity = Gravity.CENTER;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(padding, 0, padding, 0);
        imageView.setImageDrawable(getResources().getDrawable(drawableId));
        if (onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        }
        leftPane.addView(imageView);
        return this;
    }


    @Override
    public View getNavagation() {
        return this;
    }

    @Override
    public AdapterNavagation setNavagationBackgroudColor(int color) {
        setBackgroundColor(this.getResources().getColor(color));
        return this;
    }




    public AdapterNavagation setRightImage(int drawableId, OnClickListener onClickListener) {
        int padding = DeviceUtils.dip2px(getContext(), 8);
        if (rightPane == null) {
            rightPane = new LinearLayout(getContext());
            LayoutParams layoutParams = new LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                    LayoutParams.MATCH_PARENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
            layoutParams.rightMargin = padding;
            rightPane.setLayoutParams(layoutParams);
            this.addView(rightPane);
        }
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        params.gravity = Gravity.CENTER;
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setPadding(padding, 20, padding, 20);
        imageView.setImageDrawable(getResources().getDrawable(drawableId));
        if (onClickListener != null) {
            imageView.setOnClickListener(onClickListener);
        }
        rightPane.addView(imageView);
        return this;
    }

    public AdapterNavagation setLineColor(int color){
        View view = new View(getContext());
        view.setBackgroundColor(getResources().getColor(color));
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                DeviceUtils.dip2px(getContext(), DeviceUtils.dip2px(getContext(), (float) 0.3)));
        layoutParams.addRule(ALIGN_PARENT_BOTTOM,TRUE);
        view.setLayoutParams(layoutParams);
        addView(view);
        return this;
    }

    public AdapterNavagation setRightText(String title, int textSize, int color,OnClickListener onClickListener) {
        int padding = DeviceUtils.dip2px(getContext(), 4);
        if (rightPane == null) {
            rightPane = new LinearLayout(getContext());
            LayoutParams layoutParams = new LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                    LayoutParams.MATCH_PARENT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
            layoutParams.rightMargin = padding;
            rightPane.setLayoutParams(layoutParams);
            this.addView(rightPane);
        }
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        textView.setLayoutParams(params);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(color));
        textView.setPadding(padding, 0, padding, 0);
        textView.setText(title);
        if(onClickListener!=null){
            textView.setOnClickListener(onClickListener);
        }
        rightPane.addView(textView);
        return this;
    }

}
