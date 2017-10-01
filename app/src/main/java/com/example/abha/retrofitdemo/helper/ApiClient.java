package com.example.abha.retrofitdemo.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ABHA on 01-10-2017.
 */
// class returns an instance of retrofit

public class ApiClient {

    public static final String BASE_URL = "https://learnwebcode.github.io/json-example/";
    public static Retrofit retrofit = null;

//    method that returns an instance of retrofit
    public static Retrofit getApiClient(){
        // if instance is null then create a new instance
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
