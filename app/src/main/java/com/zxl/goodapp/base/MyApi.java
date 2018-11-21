package com.zxl.goodapp.base;

import com.zxl.baselib.bean.response.BaseResponse;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * @author crazyZhangxl on 2018/11/1.
 * Describe:
 */
public interface MyApi {
    String BASE_URL = "http://223.2.197.240:8062/";


    @GET("pound/")
    Observable<Object> queryPondMainInfo();

    @POST("auth")
    Observable<BaseResponse<LoginResponse>> requestLogin(@Body RequestBody body);
}
