package com.zxl.goodapp.base;



import android.annotation.SuppressLint;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zxl.baselib.BuildConfig;
import com.zxl.baselib.bean.response.BaseResponse;
import com.zxl.baselib.util.formatter.JsonUtils;

import java.io.IOException;
import java.util.Objects;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 张先磊 on 2018/4/10.
 *
 * 用于 普通请求的retrofit
 */

public class MyBaseApiRetrofit {
    private final OkHttpClient mClient;
    // 这里的token是从数据库中获得的-------------
    private String token = "Bearer default";

    public OkHttpClient getClient() {
        return mClient;
    }

    public MyBaseApiRetrofit(){
        //OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // -------- 在这里获得 token,通过数据库缓存 ********-----------
        if (BuildConfig.DEBUG) {
            // Log信息拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置 Debug Log 模式
            builder.addInterceptor(loggingInterceptor);
        }

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder request = chain.request().newBuilder();
                //添加Token请求头 这里的token应当是从本地数据库中读取的 **********
                request.addHeader("Authorization", token);
                Response proceed = chain.proceed(request.build());
                //如果token过期 再去重新请求token 然后设置token的请求头 重新发起请求 用户无感
                if (isTokenExpired(proceed)){
                    String newHeaderToken = getNewToken();
                    //使用新的Token，创建新的请求
                    Request newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", newHeaderToken)
                            .build();
                    return chain.proceed(newRequest);
                }
                return proceed;
            }
        });
        mClient = builder.build();
    }

    /**
     * 根据Response，判断Token是否失效
     * 401表示token过期
     * @param response
     * @return
     */
    private boolean isTokenExpired(Response response) {
        Log.e("状态码",response.code()+"---------------------");
        if (response.code() == 401) {
            return true;
        }
        return false;
    }

    /**
     * 这里可以考虑让后台提供一个接口,通过用户名直接返回一个token-----------------
     * @return
     * @throws IOException
     */
    @SuppressLint("CheckResult")
    private String getNewToken() throws IOException {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("apple2");
        loginRequest.setPassword("123abc");
        OkHttpClient okHttpClient = new OkHttpClient();
        Gson gson = new Gson();
        String json = gson.toJson(loginRequest);
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , json);
        Request request = new Request.Builder().url(MyApi.BASE_URL+"auth").post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        String string = Objects.requireNonNull(call.execute().body()).string();
        MyLoginResponse loginResponse = JsonUtils.jsonToBean(string, MyLoginResponse.class);
        token = "Bearer "+loginResponse.getData().getToken();
        Log.e("token刷新结果",token);
        return token;
    }
}
