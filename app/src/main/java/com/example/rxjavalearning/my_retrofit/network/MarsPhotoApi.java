package com.example.rxjavalearning.my_retrofit.network;

import com.example.rxjavalearning.my_retrofit.model.MarsPhoto;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MarsPhotoApi {
    @GET("photos")
    Single<List<MarsPhoto>> getPhotos();
}
