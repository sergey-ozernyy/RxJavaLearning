package com.example.rxjavalearning.my_retrofit.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rxjavalearning.R;
import com.example.rxjavalearning.my_retrofit.model.MarsPhoto;

import java.util.List;


public class MarsPhotoGalleryFragment extends Fragment {

    private RecyclerView photoRecyclerView;
    private MarsPhotoAdapter photoAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mars_photo_gallery, container, false);

        photoRecyclerView = (RecyclerView) view.findViewById(R.id.photo_recycler_view);
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        photoRecyclerView.setLayoutManager(gridLayoutManager);

        updateUI();

        return view;
    }

    private void updateUI(){
        List<MarsPhoto> photos = null;//!!!!!
        photoAdapter = new MarsPhotoAdapter(photos);
        photoRecyclerView.setAdapter(photoAdapter);
    }
}