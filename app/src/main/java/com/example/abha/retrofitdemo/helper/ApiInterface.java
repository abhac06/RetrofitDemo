package com.example.abha.retrofitdemo.helper;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ABHA on 01-10-2017.
 */

public interface ApiInterface {

    // annotations - http method and endpoint of the base url
//    @POST("animals-1.json")
    @GET("animals-1.json")
    Call<List<Animals>> getAnimals();

}
