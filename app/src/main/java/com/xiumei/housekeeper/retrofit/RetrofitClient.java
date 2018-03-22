package com.xiumei.housekeeper.retrofit;

import com.xiumei.housekeeper.config.AppConfig;
import com.xiumei.housekeeper.util.LogUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @des Retrofit相关设置
 * Created by zjj on 2018/3/22 14:29.
 */

public class RetrofitClient {
    private static final int READ_TIME_OUT = 10;
    private static final int WRITE_TIME_OUT = 10;
    private static final int CONNECT_TIME_OUT = 10;

    private static Retrofit retrofit;

    private static Retrofit newInstance() {
        if (retrofit == null) {
            synchronized (RetrofitClient.class) {
                if (retrofit == null) {
                    OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
                    if (AppConfig.isDebug) {
                        HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {
                            @Override
                            public void log(String message) {
                                LogUtils.e("NetRequestData>>>", message + "");
                            }
                        };
                        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger);
                        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                        httpBuilder.addInterceptor(loggingInterceptor);
                    }
                    OkHttpClient httpClient = httpBuilder
                            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                            .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                            .build();
                    Retrofit.Builder builder = new Retrofit.Builder();
                    retrofit = builder.baseUrl(AppConfig.baseUrl)
                            .client(httpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .baseUrl(AppConfig.baseUrl)
                            .build();
                }
            }
        }
        return retrofit;
    }

    public static ApiService getApiService() {
        return newInstance().create(ApiService.class);
    }
}
