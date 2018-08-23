package sz.tianhe.etc_wallet.main.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.EditText;

public class MyPassInputTextView extends EditText {

    /**
     * 默认得输入字符串长度
     */
    public static final int DEFAULT_TEXT_LENTH = 6;

    /**
     * 默认得间距
     */
    public static final int DEFAULT_SPAN = 6;


    /**
     * 默认得背景颜色
     */
    public static final int DEFAULT_BG_COLOR = 0xFFF7F7F7;


    private int textLength =DEFAULT_TEXT_LENTH;
    private int span = DEFAULT_SPAN;
    private int bgColor = DEFAULT_BG_COLOR;
    private int riadius = 4;

    public MyPassInputTextView(Context context) {
        this(context,null);
    }

    public MyPassInputTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyPassInputTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        span = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,DEFAULT_SPAN,context.getResources().getDisplayMetrics());
        riadius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,4,context.getResources().getDisplayMetrics());
        setFocusable(true);
        setEnabled(true);
        requestFocus();
        setFocusableInTouchMode(true);
        requestFocusFromTouch();
    }

    private int height;
    /**
     * 计算宽度和高度
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthLenth = MeasureSpec.getSize(widthMeasureSpec);//获取计算宽度
        height = (widthLenth - 5 * span)/textLength;
        setMeasuredDimension(widthLenth,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        drawBg(canvas);
    }

    /**
     * 开始绘制背景
     */
    public void drawBg(Canvas canvas){
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(bgColor);
        for(int i=0;i<textLength;i++){
            RectF rect = new RectF();
            rect.left = (span+height)*i;
            rect.top =0;
            rect.right = (span+height)*i +height;
            rect.bottom = height;
            canvas.drawRoundRect(rect,riadius,riadius,paint);
        }
    }

}
