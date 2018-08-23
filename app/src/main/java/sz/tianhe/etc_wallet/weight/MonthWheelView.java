package sz.tianhe.etc_wallet.weight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 币种选择题
 */
public class MonthWheelView extends WheelPicker<String> {

    private List<String> mDatas = new ArrayList<>();



    public MonthWheelView(Context context) {
        this(context,null);
    }

    public MonthWheelView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MonthWheelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setItemMaximumWidthText("000000");

        loadData();
    }


    public String getCurrentItme() {
        return mDatas.get(getCurrentPosition());
    }



    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
    /**
     * 加载最近6个月
     */
    private void loadData(){
        this.mDatas.clear();
        Calendar calendar = Calendar.getInstance();
        this.mDatas.add(simpleDateFormat.format(calendar.getTime())+"-01");
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
        this.mDatas.add(simpleDateFormat.format(calendar.getTime())+"-01");
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
        this.mDatas.add(simpleDateFormat.format(calendar.getTime())+"-01");
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
        this.mDatas.add(simpleDateFormat.format(calendar.getTime())+"-01");
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
        this.mDatas.add(simpleDateFormat.format(calendar.getTime())+"-01");
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)-1);
        this.mDatas.add(simpleDateFormat.format(calendar.getTime())+"-01");
        setDataList(mDatas);
    }
}
