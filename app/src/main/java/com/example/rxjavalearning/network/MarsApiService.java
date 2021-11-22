package com.example.rxjavalearning.network;


import com.example.rxjavalearning.model.MarsPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import com.google.gson.*;

public class MarsApiService {

    private static MarsApiService instance;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/";


    private MarsApiService(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public static MarsApiService getInstance() {
        if(instance == null){
            instance = new MarsApiService();
        }
        return instance;
    }




    public MarsApi getJSONApi(){
        return retrofit.create(MarsApi.class);
    }


}


