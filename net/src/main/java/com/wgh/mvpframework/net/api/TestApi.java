package com.wgh.mvpframework.net.api;

import com.wgh.mvpframework.net.model.TestBean;
import com.wgh.mvpframework.net.model.TestModel;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @version V0.1.0
 * @author: wgh
 * @date: 2018/4/10
 * @description
 */
public interface TestApi {

    @GET("get")
    Observable<TestBean> testGet();

    @GET("data/{page}")
    Observable<TestBean> testGet(@Path("page") int page);

    @GET("get")
    Observable<TestBean> testGet(@Query("username") String username, @Query("pwd") String pwd);

    @FormUrlEncoded
    @POST("post")
    Observable<TestBean> testPost(@Field("username") String username, @Field("pwd") String pwd);

    @POST("post")
    Observable<TestBean> testPost(@Body TestModel body);


}
