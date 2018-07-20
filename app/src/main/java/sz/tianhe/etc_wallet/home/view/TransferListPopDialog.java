package sz.tianhe.etc_wallet.home.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import sz.tianhe.etc_wallet.R;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/16 13:52
 */
public class TransferListPopDialog extends PopupWindow implements View.OnClickListener{

    private TextView tvAll;
    private TextView tvOneMonth;
    private TextView tvTwoMonth;
    private TextView tvThreeMonth;
    public TransferListPopDialog(Context context){
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pop_window_transfer,null,false);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setContentView(view);

        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);

        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        /**
         * 设置背景只有设置了这个才可以点击外边和BACK消失
         */
        setBackgroundDrawable(new ColorDrawable());
        tvAll = view.findViewById(R.id.all);
        tvOneMonth = view.findViewById(R.id.current_month);
        tvTwoMonth = view.findViewById(R.id.last_month);
        tvThreeMonth = view.findViewById(R.id.three_month);
        tvAll.setOnClickListener(this);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月");
        tvOneMonth.setText(simpleDateFormat.format(calendar.getTime()));
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
        tvTwoMonth.setText(simpleDateFormat.format(calendar.getTime()));
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
        tvThreeMonth.setText(simpleDateFormat.format(calendar.getTime()));

        tvOneMonth.setOnClickListener(this);
        tvTwoMonth.setOnClickListener(this);
        tvThreeMonth.setOnClickListener(this);
        /**
         * 设置可以获取集点
         */
        setFocusable(true);

        /**
         * 设置点击外边可以消失
         */
        setOutsideTouchable(true);

        /**
         *设置可以触摸
         */
        setTouchable(true);


        /**
         * 设置点击外部可以消失
         */

        setTouchInterceptor((v, event) -> {

            /**
             * 判断是不是点击了外部
             */
            if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
                return true;
            }
            //不是点击外部
            return false;
        });
    }

    public void setmOnSelectedListener(OnSelectedListener mOnSelectedListener) {
        this.mOnSelectedListener = mOnSelectedListener;
    }

    OnSelectedListener mOnSelectedListener;

    @Override
    public void onClick(View view) {
        TextView textView = (TextView) view;
        if(mOnSelectedListener!=null){
            mOnSelectedListener.selected(textView.getText().toString());
        }
    }

    public interface  OnSelectedListener{
        void selected(String string);
    }
}
