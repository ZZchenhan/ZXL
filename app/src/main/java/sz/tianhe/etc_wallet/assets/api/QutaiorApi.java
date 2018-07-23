package sz.tianhe.etc_wallet.assets.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import sz.tianhe.etc_wallet.assets.bean.CoinVo;
import sz.tianhe.etc_wallet.assets.bean.Makert;

public class QutaiorApi {
    /**
     *
     * @param urlAll
     *            :请求接口
     * @param charset
     *            :字符编码
     * @return 返回json结果
     */
    public static String get(String urlAll, String charset) throws IOException {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";// 模拟浏览器

            URL url = new URL(urlAll);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(30000);
            connection.setConnectTimeout(30000);
            connection.setRequestProperty("User-agent", userAgent);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, charset));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
            }
            reader.close();
            result = sbf.toString();
            return result;
    }

    /**
     * 获取市场行情
     * @param markets
     * @return
     */
    public  static Observable<String> getQutations(List<String> markets){
        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
            List<String> callbacks= new ArrayList<>();

            // 请求地址
            String url = "http://api.zb.cn/data/v1/ticker?market=" + markets.get(0);
            // 请求测试
            String callback = get(url, "UTF-8");
            callbacks.add(callback);
            emitter.onNext(callback);
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()) .observeOn(AndroidSchedulers.mainThread());
    }


    public  static Observable<Map<String,List<String>>> getMarkets(){
        return Observable.create((ObservableOnSubscribe<Map<String,Makert>>) emitter -> {
            String url = "http://api.zb.cn/data/v1/markets" ;
            String callback = get(url, "UTF-8");
            Map<String,Makert> makerts = new HashMap<>();
            emitter.onNext( new Gson().fromJson(callback,new TypeToken<Map<String,Makert>>(){}.getType()));
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).flatMap((Function<Map<String, Makert>, ObservableSource< Map<String,List<String>>>>) input -> {
            Set<String> sets = input.keySet();
            Iterator<String> iterator = sets.iterator();
            Map<String,List<String>>  coinVos= new HashMap<>();
            while (iterator.hasNext()){
                String key = iterator.next();
                String strZeroInKey = key.split("_")[0];
                if(coinVos.containsKey(strZeroInKey)){
                    coinVos.get(strZeroInKey).add(key);
                }else{
                    List<String> markertNames = new ArrayList<>();
                    markertNames.add(key);
                    coinVos.put(strZeroInKey,markertNames);
                }
            }
            return Observable.create(emitter -> {
                emitter.onNext(coinVos);
                emitter.onComplete();
            });
        }) .flatMap((Function<Map<String, List<String>>, ObservableSource<Map<String, List<String>>>>) input -> {
            //过滤
            Set<String> sets = input.keySet();
            Iterator<String> iterator = sets.iterator();
            Map<String,List<String>>  coinVos= new HashMap<>();
            while (iterator.hasNext()){
                String key = iterator.next();
                if(key.equals("eth")
                        || key.equals("btc")
                        ||key.equals("etc")
                        ||key.equals("bts")
                        ){
                    coinVos.put(key,input.get(key));
                }
            }
            return  Observable.create(emitter -> {
                emitter.onNext(coinVos);
                emitter.onComplete();
            });
        }).observeOn(AndroidSchedulers.mainThread());
    }

    //截取市场名

}
