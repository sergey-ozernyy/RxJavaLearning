package com.example.rxjavalearning.my_retrofit.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.rxjavalearning.R;
import com.example.rxjavalearning.my_retrofit.model.MarsPhoto;
import com.example.rxjavalearning.my_retrofit.network.MarsApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MarsPhotosFragment extends Fragment {

    final static String TAG = "MarsPhotosFragment";

    ListView listView;
    Button button;
    public static List<String> listValues = new ArrayList<>();
    public static ArrayAdapter<String> adapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i(TAG,"onCreateView");
        View view = inflater.inflate(R.layout.fragment_mars_photos, container, false);
        listView = view.findViewById(R.id.MarsPhotoListView);
        button = view.findViewById(R.id.MarsPhotoListButton);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listValues);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRequest();
            }
        });

        return view;
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
                        List<String> photos = value.stream()
                                .limit(15)
                                .map( marsPhoto -> marsPhoto.getImg_src())
                                .collect(Collectors.toList());
                        listValues.addAll(photos);
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }




}