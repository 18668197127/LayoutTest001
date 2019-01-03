package com.example.threadtest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//retrofit2的一个接口
public interface TokenVfPost {


        //test1
        @FormUrlEncoded
        @POST("tokenCheck")
        Call<ResponseBody> postData(@Field("token") String token);


}
