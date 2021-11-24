package com.example.rxjavalearning.my_retrofit.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.rxjavalearning.R;
import com.example.rxjavalearning.my_retrofit.model.MarsPhoto;
import com.example.rxjavalearning.my_retrofit.network.MarsApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MarsPhotoGalleryFragment extends Fragment {

    private RecyclerView photoRecyclerView;
    private MarsPhotoAdapter photoAdapter;

    List<MarsPhoto> photos = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getRequest();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mars_photo_gallery, container, false);

        photoRecyclerView = (RecyclerView) view.findViewById(R.id.photo_recycler_view);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        photoRecyclerView.setLayoutManager(gridLayoutManager);

        return view;
    }

    private void updateUI(){
        photoAdapter = new MarsPhotoAdapter(photos);
        photoRecyclerView.setAdapter(photoAdapter);
    }


    private void getRequest(){
        MarsApiService.getInstance()
                .getJSONApi()
                .getPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<MarsPhoto>>() {
                    @Override
                    public void onSuccess(List<MarsPhoto> value) {
                        List<MarsPhoto> loadedPhotos = value.stream()
                                .limit(15)
                                .collect(Collectors.toList());
                        photos.addAll(loadedPhotos);
                        updateUI();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

}