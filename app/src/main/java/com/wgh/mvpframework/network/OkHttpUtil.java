package com.wgh.mvpframework.network;

import com.wgh.mvpframework.network.api.TestApi;
import com.wgh.mvpframework.net.interceptor.RequestInterceptor;
import com.wgh.mvpframework.net.interceptor.ResponseInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @version V0.1.0
 * @author: wgh
 * @date: 2018/4/10
 * @description
 */
public class OkHttpUtil {

    private static OkHttpUtil mInstance;
    private OkHttpClient okHttpClient;
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create();
    private static TestApi testApi;

    private OkHttpUtil(){
        okHttpClient = new OkHttpClient.Builder()
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new RequestInterceptor())
                .addInterceptor(new ResponseInterceptor())
                .build();
    }

    public static OkHttpUtil getInstance(){
        if (mInstance == null){
            synchronized (OkHttpUtil.class){
                if (mInstance == null){
                    mInstance = new OkHttpUtil();
                }
            }
        }
        return mInstance;
    }

    public TestApi getTestApi(){
        if (testApi == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://httpbin.org/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJava2CallAdapterFactory)
                    .build();
            testApi = retrofit.create(TestApi.class);
        }
        return testApi;
    }

}
