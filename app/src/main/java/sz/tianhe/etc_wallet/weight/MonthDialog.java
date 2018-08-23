package sz.tianhe.etc_wallet.weight;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import sz.tianhe.etc_wallet.R;


public class MonthDialog extends Dialog {

    private MonthDialog(@NonNull Context context) {
        this(context, R.style.BottomDialog);
    }

    public MonthDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    /**
     * 构建者
     */
    public static class Builder{
        private Context mContext;

        private String phone;
        private Dialog dialog;

        private OnComfirmListener onComfirmListener;
        MonthWheelView coinWheelView;
        public Builder(Context context){
            this.mContext = context;
        }

        public Builder onConfirmListenr(OnComfirmListener onComfirmListener){
            this.onComfirmListener = onComfirmListener;
            return this;
        }

        public Builder phone(String phone){
            this.phone = phone;
            return this;
        }


        public Dialog Builder(){
            View rootView = LayoutInflater.from(this.mContext).inflate(R.layout.dialog_month,null,false);
            TextView cancel = rootView.findViewById(R.id.cancel);
             coinWheelView = rootView.findViewById(R.id.coin_wheel_view);

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            TextView confim = rootView.findViewById(R.id.confirm);
            confim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onComfirmListener.onCofirmListenr(coinWheelView.getCurrentItme());
                    dialog.dismiss();
                }
            });


            dialog = new MonthDialog(mContext);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(rootView);
            dialog.setCanceledOnTouchOutside(true); // 外部点击取消
            Window window = dialog.getWindow();
            if (window != null) {

                WindowManager.LayoutParams lp = window.getAttributes();
                lp.gravity = Gravity.BOTTOM;
                lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT; // 宽度持平
                lp.dimAmount = 0.35f;
                window.setAttributes(lp);
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            }

            return dialog;
        }


        public interface OnComfirmListener{
            void onCofirmListenr(String coinBean);
        }



    }
}
