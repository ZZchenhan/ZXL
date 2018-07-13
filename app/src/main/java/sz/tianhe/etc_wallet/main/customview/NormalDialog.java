package sz.tianhe.etc_wallet.main.customview;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import sz.tianhe.etc_wallet.R;
import sz.tianhe.etc_wallet.databinding.DialogNomalBinding;

/**
 * 项目名称:etc_wallet
 * 类描述 更新Dialer
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/13 15:09
 */
public class NormalDialog extends Dialog {

    protected NormalDialog(Context context) {
        super(context);
    }

    public NormalDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {

        private Dialog alertDialog;
        /**
         * 上下文内容
         */
        private Context context;

        /**
         * 标题
         */
        private String title;

        /**
         * 标题颜色
         */
        private int titleColor;

        /**
         * 标题字体大小
         */
        private int titleSize;


        /**
         * 居中内容窗格
         */
        private View contextView;

        /**
         * 左边文字
         */
        private String leftString;

        /**
         * 左边文字颜色
         */
        private int leftColor;

        /**
         * 左边文字大小
         */
        private int leftSize;

        /**
         * 右边文字
         */
        private String rightString;

        /**
         * 右边文字大小
         */
        private int rightSize;

        /**
         * 右边颜色
         */
        private int rightColor;

        /**
         * 左边点击事件
         */
        private View.OnClickListener leftOnclickListener;

        /**
         * 右边点击时间
         */
        private View.OnClickListener rightOnclickListener;


        public Builder(@NonNull Context context) {
            this.context = context;

            //初始化各种属性
            this.titleColor = context.getResources().getColor(R.color.black);
            this.titleSize = 16;
            this.title = "标题";

            this.leftColor = context.getResources().getColor(R.color.colorPrimary);
            this.leftSize = 15;
            this.leftString = "拒绝";
            this.leftOnclickListener = view -> alertDialog.dismiss();

            this.rightColor = context.getResources().getColor(R.color.colorPrimary);
            this.rightString = "接受";
            this.rightSize = 15;
            this.rightOnclickListener = view -> alertDialog.dismiss();
        }

        public Builder setTitle(@NonNull String title) {
            this.title = title;
            return this;
        }

        public Builder setTitleColor(@ColorInt int color) {
            this.titleColor = color;
            return this;
        }

        public Builder setTileeSize(int size) {
            this.titleSize = size;
            return this;
        }

        public Builder setLeftString(@NonNull String leftString) {
            this.leftString = leftString;
            return this;
        }

        public Builder setLeftColor(@ColorInt int color) {
            this.leftColor = color;
            return this;
        }

        public Builder setLeftSize(int size) {
            this.leftSize = size;
            return this;
        }


        public Builder setRightString(@NonNull String rightString) {
            this.rightString = rightString;
            return this;
        }

        public Builder setRightColor(@ColorInt int color) {
            this.rightColor = color;
            return this;
        }

        public Builder setRightSize(int size) {
            this.rightSize = size;
            return this;
        }

        public Builder setConentView(View view) {
            this.contextView = view;
            return this;
        }

        public Builder setLeftOnclickListener(View.OnClickListener onclickListener){
            this.leftOnclickListener = onclickListener;
            return this;
        }

        public Builder setRightOnclickListner(View.OnClickListener onclickListner){
            this.rightOnclickListener = onclickListner;
            return this;
        }

        public Dialog create() {
            this.alertDialog = new NormalDialog(this.context,R.style.DatePickerBottomDialog);
            DialogNomalBinding binding = DataBindingUtil.inflate(LayoutInflater.from(this.context),
                    R.layout.dialog_nomal, null, false);
            //设置用户属性
            binding.title.setText(this.title);
            binding.title.setTextColor(this.titleColor);
            binding.title.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.titleSize);

            binding.rightString.setText(this.rightString);
            binding.rightString.setTextColor(this.rightColor);
            binding.rightString.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.rightSize);
            binding.rightString.setOnClickListener(this.rightOnclickListener);

            binding.leftString.setText(this.leftString);
            binding.leftString.setTextColor(this.leftColor);
            binding.leftString.setTextSize(TypedValue.COMPLEX_UNIT_SP, this.leftSize);
            binding.leftString.setOnClickListener(this.leftOnclickListener);

            if (null != this.contextView)
                binding.content.addView(this.contextView);

            //开始创建属性及对象
            this.alertDialog.setContentView(binding.getRoot());
            Window window =  this.alertDialog.getWindow();
            window.setGravity(Gravity.CENTER);

            WindowManager m = window.getWindowManager();
            Display d = m.getDefaultDisplay(); //为获取屏幕宽、高
            WindowManager.LayoutParams p = this.alertDialog.getWindow().getAttributes(); //获取对话框当前的参数值
            p.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,260,context.getResources().getDisplayMetrics());
            p.gravity = Gravity.CENTER;
            this.alertDialog.getWindow().setAttributes(p); //设置生效
            this.alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            return this.alertDialog;
        }
    }
}
