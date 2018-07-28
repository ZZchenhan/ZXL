package sz.tianhe.etc_wallet.requst.api;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import sz.tianhe.etc_wallet.assets.bean.MarketKLine;
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
                if (maket.split("_").length < 2) {
                    continue;
                }
                try {
                    // 请求地址
                    String url = "http://api.zb.cn/data/v1/kline?type=3min&size=481&market=" + maket.toLowerCase();
                    // 请求测试
                    String callback = get(url, "UTF-8");
                    Log.i("请求地址",url);
                    Log.i("请求返回",callback);
                    QutaiorBean qutaiorBean = new QutaiorBean();
                    qutaiorBean.setCoinName(maket.toUpperCase());

                    //解析并且开始
                    MarketKLine kLine = new Gson().fromJson(callback, MarketKLine.class);
                    if(kLine.getData().size() <481){
                        continue;
                    }
                    //设zbK线12小时
                    List<String> last = kLine.getData().get(0);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    simpleDateFormat.format(new Date(Long.parseLong(last.get(0))));
                    List<String> current = kLine.getData().get(480);
                    Log.e("Load",String.format("%s开%s高%s低%s收%s量%s",simpleDateFormat.format(new Date(Long.parseLong(last.get(0)))),last.get(1),last.get(2),last.get(3),last.get(4),last.get(5)));
                    Log.e("Load",String.format("%s开%s高%s低%s收%s量%s",simpleDateFormat.format(new Date(Long.parseLong(current.get(0)))),current.get(1),current.get(2),current.get(3),current.get(4),current.get(5)));
                    getHLV(kLine.getData(),qutaiorBean);
                    //时间0 开1高2低3收4量5

                    BigDecimal percent = new BigDecimal(current.get(4)).
                            subtract(new BigDecimal(last.get(4))).
                            multiply(new BigDecimal(100).
                            divide(new BigDecimal(last.get(4)),BigDecimal.ROUND_HALF_EVEN,6));
                    qutaiorBean.setPercentChange(percent.toString());
                    callbacks.add(qutaiorBean);
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            emitter.onNext(callbacks);
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获得最高价 最低价 总量
     */
    private static void getHLV(List<List<String>> datas, QutaiorBean qutaiorBean){
        //时间0 开1高2低3收4量5
        String low = datas.get(1).get(4);
        String high = datas.get(1).get(4);
        BigDecimal total = new BigDecimal(0);
        for(int i = 1;i<datas.size();i++){
            List<String> item = datas.get(i);
            if(low.compareTo(item.get(4))>0){
                low = item.get(4);
            }
            if(high.compareTo(item.get(4))<0){
                high = item.get(4);
            }
            total = total.add(new BigDecimal(item.get(5)));
        }
        qutaiorBean.setLow24hr(low);
        qutaiorBean.setHigh24hr(high);
        qutaiorBean.setBaseVolume(total.toString());
    }


    @SuppressLint("CheckResult")
    public static Observable<List<String>> getMarkets() {
        return Observable.create((ObservableOnSubscribe<Map<String, Makert>>) emitter -> {
            Log.i("Load", "开始请求时间" + System.currentTimeMillis());
            String url = "http://api.zb.cn/data/v1/markets";
            String callback = get(url, "UTF-8");
            Log.i("Load", "请求结束时间" + System.currentTimeMillis());
            Map<String, Makert> makerts = new Gson().fromJson(callback, new TypeToken<Map<String, Makert>>() {
            }.getType());
            emitter.onNext(makerts);
            emitter.onComplete();
        }).flatMap((Function<Map<String, Makert>, ObservableSource<List<String>>>) stringMakertMap -> Observable.create(emitter -> {
            List<String> markets = new ArrayList<>();
            //只显示bts_usdt
            //eos_usdt
            //btc_usdt
            //eth_usdt
            Iterator<Map.Entry<String, Makert>> iterator = stringMakertMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Makert> entry = iterator.next();
                if (entry.getKey().split("_")[0].equals("eos")
                        || entry.getKey().split("_")[0].equals("bts") ||
                        entry.getKey().split("_")[0].equals("btc") ||
                        entry.getKey().split("_")[0].equals("eth")
                        ) {
                    if(entry.getKey().split("_")[1].equals("qc")) {
                        markets.add(entry.getKey());
                    }
                }
            }
            emitter.onNext(markets);
            emitter.onComplete();
        })).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.newThread());
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
            if (item.split("_").length < 2) {
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
