package com.zxl.goodapp.base;

import com.google.gson.Gson;
import com.zxl.baselib.bean.response.BaseResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author crazyZhangxl on 2018/11/1.
 * Describe:
 */
public class ApiRetrofit extends MyBaseApiRetrofit{
    public MyApi mApi;
    private ApiRetrofit(){
        //在构造方法中完成对Retrofit接口的初始化
        mApi = new Retrofit.Builder()
                .baseUrl(MyApi.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MyApi.class);
    }

    private static class  ApiRetrofitHolder{
        private static final ApiRetrofit M_INSTANCE =  new ApiRetrofit();
    }

    public static ApiRetrofit getInstance(){
        return ApiRetrofitHolder.M_INSTANCE;
    }

    public Observable<Object> queryPondMainInfo(){
        return mApi.queryPondMainInfo();
    }

    public Observable<BaseResponse<LoginResponse>> requestLogin(LoginRequest loginRequest){
        return mApi.requestLogin(getRequestBody(loginRequest));
    }

    /**
     * bean 转body
     * @param obj
     * @return
     */
    private RequestBody getRequestBody(Object obj) {
        String route = new Gson().toJson(obj);
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),route);
    }
}
