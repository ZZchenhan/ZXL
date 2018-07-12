package sz.tianhe.baselib.http;

/**
 * 项目名称:etc_wallet
 * 类描述
 *
 * @author ch
 * @email 869360026@qq.com
 * 创建时间:2018/7/12 15:46
 */
public interface IResultListener<T> {
    void onListener(T t);
}
