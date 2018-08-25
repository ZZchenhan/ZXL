package sz.tianhe.baselib.http;

import android.content.Context;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 15:46
 */
public abstract class IResultListener<T> {
    public abstract void onListener(T t);
    public void onFailListener(Context context,String erro){
        Toast.makeText(context, erro, Toast.LENGTH_SHORT).show();
    }
}

