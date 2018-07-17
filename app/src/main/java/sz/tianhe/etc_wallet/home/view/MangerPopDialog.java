package sz.tianhe.etc_wallet.home.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import sz.tianhe.etc_wallet.R;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/16 13:52
 */
public class MangerPopDialog extends PopupWindow{

    private TextView tvCreate;
    private TextView tvImport;
    public MangerPopDialog(Context context){
        super(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pop_window_manager,null,false);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setContentView(view);

        setWidth(WindowManager.LayoutParams.WRAP_CONTENT);

        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        /**
         * 设置背景只有设置了这个才可以点击外边和BACK消失
         */
        setBackgroundDrawable(new ColorDrawable());
        tvCreate = view.findViewById(R.id.create_wallet);
        tvImport = view.findViewById(R.id.import_wallet);
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

    public void setCreatListener(View.OnClickListener onClickListener){
        tvCreate.setOnClickListener(onClickListener);
    }

    public void setImportListener(View.OnClickListener onClickListener){
        tvImport.setOnClickListener(onClickListener);
    }
}
