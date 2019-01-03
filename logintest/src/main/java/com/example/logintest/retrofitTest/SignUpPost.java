package com.example.logintest.retrofitTest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

//retrofit2的一个post接口
public interface SignUpPost {
        //test1
        @FormUrlEncoded
        @POST("register")
        Call<ResponseBody> postData(@Field("telephone") String telephone,@Field("code") String code,@Field("password") String password);

        @POST("register")
        Call<ResponseBody> postData2(@Body RegisterData registerData);
}

