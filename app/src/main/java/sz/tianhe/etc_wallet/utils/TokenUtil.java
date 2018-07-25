package sz.tianhe.etc_wallet.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenUtil {

    public static void saveToken(Context context, String token) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("token", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("token", token);
        editor.commit();
    }

    public static void cleanToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("token", 0);
        sharedPreferences.edit().clear().commit();
    }

    public static String getToken(Context context) {
        return context.getSharedPreferences("token", 0).getString("token", null);
    }
}
