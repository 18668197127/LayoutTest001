package com.example.testretrofit.retrofit;

import com.example.testretrofit.gsonData1.Result;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZhailuData1 {
    //test Path parameter
    @GET("api/v1/{id}")
    Call<ResponseBody> getZhailuData(@Path("id") String index);

    //test  no parameter
    @GET("api/v1/Index")
    Call<Result> getZhailuData();

}
