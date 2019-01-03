package com.example.logintest.retrofitTest;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//retrofit2的一个接口
public interface GetCodePost {


        //test1
        @FormUrlEncoded
        @POST("getcode")
        Call<ResponseBody> postData(@Field("telephone") String telephone);

        //test2
        @FormUrlEncoded
        @POST("getcode")
        Call<ResponseBody> postData2(@Body String telephone);

}
