package com.example.rxjavalearning.network;

import com.example.rxjavalearning.model.MarsPhoto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarsApi {
    @GET("photos")
    Call<MarsPhoto> getPhotos();
}
