package com.example.rxjavalearning.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rxjavalearning.R;
import com.example.rxjavalearning.model.MarsPhoto;
import com.example.rxjavalearning.network.MarsApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MarsPhotosFragment extends Fragment {

    ListView listView;
    public static final ArrayList<String> listValues = new ArrayList<>();
    public static ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mars_photos, container, false);
        listView = view.findViewById(R.id.MarsPhotoListView);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listValues);
        listView.setAdapter(adapter);

        MarsApiService.getInstance()
                .getJSONApi()
                .getPhotos()
                .enqueue(new Callback<MarsPhoto>() {
                    @Override
                    public void onResponse(Call<MarsPhoto> call, Response<MarsPhoto> response) {
                        MarsPhoto marsPhoto = response.body();
                        listValues.add(marsPhoto.toString());
                        adapter.notifyDataSetChanged();
                        //
                    }

                    @Override
                    public void onFailure(Call<MarsPhoto> call, Throwable t) {
                        t.printStackTrace();
                    }
                });




        return view;
    }

}