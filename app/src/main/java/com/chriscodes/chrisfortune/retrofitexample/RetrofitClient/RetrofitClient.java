package com.chriscodes.chrisfortune.retrofitexample.RetrofitClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String URL = "https://jsonplaceholder.typicode.com/comments/";

    public static Retrofit getRetrofit(){

        if(retrofit == null){

            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
