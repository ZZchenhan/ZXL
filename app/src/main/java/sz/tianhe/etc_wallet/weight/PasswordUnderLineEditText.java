package sz.tianhe.etc_wallet.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/17 15:28
 */
public class PasswordUnderLineEditText extends EditText{

    private int count = 6;

    private float width = 0;

    private Paint bgPaint = null;

    private Paint textPaint = null;

    private float corrio;

    public PasswordUnderLineEditText(Context context) {
        this(context, null);
    }

    public PasswordUnderLineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bgPaint.setColor(Color.parseColor("#FFF7F7F7"));

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,20,context.getResources().getDisplayMetrics()));
        textPaint.setColor(Color.parseColor("#FF252525"));

        width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,40,context.getResources().getDisplayMetrics());
        corrio = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,5,context.getResources().getDisplayMetrics());
        setMaxEms(6);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    float space = 0;
    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        space = (getMeasuredWidth()-6*width)/5;
        drwabg(canvas);
        drawTextString(canvas,getText().toString());
    }

    private void drwabg(Canvas canvas){
        for (int i=0;i<6;i++){
            canvas.drawRoundRect((width+space)*i,0,(width+space)*i+width,width,corrio,corrio,bgPaint);
        }
    }

    private void drawTextString(Canvas canvas,String string){
        for (int i=0;i<string.length();i++){
            textPaint.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
            int baseLineY = (int) (width/2 - fontMetrics.top/2 - fontMetrics.bottom/2);//基线中间点的y轴计算公式
            canvas.drawText("*",(width+space)*i+(width)/2,
                    baseLineY,textPaint);
        }
    }

}
