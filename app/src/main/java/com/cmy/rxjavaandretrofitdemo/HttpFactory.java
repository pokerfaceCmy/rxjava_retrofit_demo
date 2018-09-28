package com.cmy.rxjavaandretrofitdemo;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 文 件 名: HttpFactory<p>
 * 创 建 人: cmy<p>
 * 创建日期: 2018/9/28 15:25<p>
 * 邮   箱: mengyuan.cheng.mier@gmail.com<p>
 * 文件说明:初始化okhttp+retrofit<p>
 */
public class HttpFactory {
    //基础url
    private static final String BASE_URL = "https://www.apiopen.top/";
    //默认的超时时间
    private static final int DEFAULT_MILLISECONDS = 60000;
    //APP版本号
    private static final String APP_VERSION = "1";


    private HttpFactory() {

    }

    private static class HttpFactoryInstance {//单例模式
        private final static HttpFactory HttpFactory = new HttpFactory();
    }

    public static HttpFactory getInstance() {//单例模式
        return HttpFactoryInstance.HttpFactory;
    }

    private Retrofit createRetrofit(String baseUrl) {
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient().newBuilder()
                .readTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_MILLISECONDS, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public <T> T getRetrofitService(Class<T> cls) {
        return createRetrofit(BASE_URL).create(cls);
    }

}
