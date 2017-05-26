package com.soarsky.car.data.remote.server1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soarsky.car.App;
import com.soarsky.car.Constants;
import com.soarsky.car.uitl.LogUtil;
import com.soarsky.car.uitl.NetWorkUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 车主APP
 * 作者： 孙向锦
 * 时间： 8/18/2016
 * 公司：长沙硕铠电子科技有限公司
 * Email：sunxiangjin@soarsky-e.com
 * 公司网址：http://www.soarsky-e.com
 * 公司地址（Add）  ：湖南省长沙市岳麓区麓谷信息港A座8楼
 * 版本：1.0.0.0
 * 邮编：410000
 * 程序功能：
 * 请求后台服务器封装，对后台所有请求的管理
 */
public class Api {

    public Retrofit retrofit;
    public ApiService service;

    /**
     * 拦截器1
     * 如果后台服务器需要用到token，则每次请求自动对token的添加验证
     * 自动添加请求数据的格式，所有请求URL连接输出
     */
    Interceptor mInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            LogUtil.i("url=="+chain.request().url());
            return chain.proceed(chain.request().newBuilder()
//                    .addHeader("Token", "Token")
                    .addHeader("Content-Type", "application/json")
                    .build());
        }



    };

    private Api() {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        /**
         * 网络请求缓存
         */
//        File cacheFile = new File(App.getApp().getCacheDir(), "cache");
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        /**
         * 使用OKhttp 来请求，设置超时时间，连接时间，添加过滤器
         */
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(7676, TimeUnit.MILLISECONDS)
                .connectTimeout(7676, TimeUnit.MILLISECONDS)
                .addInterceptor(mInterceptor)
//                .addInterceptor(interceptor)
                .addNetworkInterceptor(new HttpCacheInterceptor())
//                .cache(cache)
                .build();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").serializeNulls().create();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build();
        service = retrofit.create(ApiService.class);

     
    }

    /**
     *     在访问HttpMethods时创建单例
     */
    private static class SingletonHolder {
        private static final Api INSTANCE = new Api();
    }

    /**
     *     获取单例
     */
    public static Api getInstance() {
        return SingletonHolder.INSTANCE;
    }


    /**
     * 网络缓存
     */
    class HttpCacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();


            if (!NetWorkUtil.isNetConnected(App.getApp())) {
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }

            Response originalResponse = chain.proceed(request);
            if (NetWorkUtil.isNetConnected(App.getApp())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }
}
