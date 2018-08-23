package sz.tianhe.baselib.utils;

/**
 * Created by 86936 on 2018/7/4.
 *
 * @QQ 869360026
 */

public class PhoneUtils {
    public static boolean isMobile0(String str){
        if(str == null || "".equals(str)){
            return false;
        }
        return str.matches("^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$");
    }
}
