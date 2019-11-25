package com.example.retrofitexample3.network;


import com.example.retrofitexample3.model.BaseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

//    @GET("checkMyMembership")
//    Call<BaseRespModel<SendDeviceRespModel>> checkMyMembership(@Query("macAddress") String macAddress,
//                                                               @Query("name") String name);

    @GET("launches")
    Call<List<BaseModel>> getBaseModel();
}
