package sz.tianhe.etc_wallet.requst.api;

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
import sz.tianhe.etc_wallet.assets.bean.QutaiorBean;

public class QutaiorApi {
    /**
     * @param urlAll  :请求接口
     * @param charset :字符编码
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
     *
     * @param markets
     * @return
     */
    public static Observable<List<QutaiorBean>> getQutations(List<String> markets) {
        return Observable.create((ObservableOnSubscribe<List<QutaiorBean>>) emitter -> {
            List<QutaiorBean> callbacks = new ArrayList<>();
            for (String maket : markets) {
                if(maket.split("_").length<2){
                    continue;
                }
                // 请求地址
                String url = "https://data.gateio.io/api2/1/ticker/" + markets.get(0).toLowerCase();
                // 请求测试
                String callback = get(url, "UTF-8");
                QutaiorBean qutaiorBean = new Gson().fromJson(callback, QutaiorBean.class);
                qutaiorBean.setCoinName(maket);
                callbacks.add(qutaiorBean);
            }
            emitter.onNext(callbacks);
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    public static Observable<Map<String, List<String>>> getMarkets() {
        return Observable.create((ObservableOnSubscribe<List<String>>) emitter -> {
            String url = "https://data.gateio.io/api2/1/pairs";
            String callback = get(url, "UTF-8");
            List<String> makerts = new Gson().fromJson(callback, new TypeToken<List<String>>() {
            }.getType());
            emitter.onNext(makerts);
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).flatMap((Function<List<String>, ObservableSource<Map<String, List<String>>>>) strings -> Observable.create(emitter -> {
            //转换
            emitter.onNext(converMakets(strings));
            emitter.onComplete();
        })).flatMap((Function<Map<String, List<String>>, ObservableSource<Map<String, List<String>>>>) stringListMap -> Observable.create(emitter -> {
            //过滤
            Set<String> sets = stringListMap.keySet();
            Iterator<String> iterator = sets.iterator();
            Map<String, List<String>> coinVos = new HashMap<>();
            while (iterator.hasNext()) {
                String key = iterator.next();
                if (key.equals("ETH")
                        || key.equals("BTC")
                        || key.equals("BTS")
                        || key.equals("EOS")
                        ) {
                    coinVos.put(key, stringListMap.get(key));
                }
            }
            emitter.onNext(coinVos);
            emitter.onComplete();
        })).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 转换
     *
     * @param input
     * @return
     */
    private static Map<String, List<String>> converMakets(List<String> input) {
        Map<String, List<String>> coinVos = new HashMap<>();
        for (String item : input) {
            String strZeroInKey = item.split("_")[0];
            if(item.split("_").length < 2){
                continue;
            }
            if (coinVos.containsKey(strZeroInKey)) {
                coinVos.get(strZeroInKey).add(strZeroInKey);
            } else {
                List<String> markertNames = new ArrayList<>();
                markertNames.add(item);
                coinVos.put(strZeroInKey, markertNames);
            }
        }
        return coinVos;
    }

}
