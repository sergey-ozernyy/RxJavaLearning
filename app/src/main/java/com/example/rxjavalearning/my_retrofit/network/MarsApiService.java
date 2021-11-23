package com.example.rxjavalearning.my_retrofit.network;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarsApiService {

    private static MarsApiService instance;
    private Retrofit retrofit;
    private static final String BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/";


    private MarsApiService(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public static MarsApiService getInstance() {
        if(instance == null){
            instance = new MarsApiService();
        }
        return instance;
    }




    public MarsPhotoApi getJSONApi(){
        return retrofit.create(MarsPhotoApi.class);
    }


}


