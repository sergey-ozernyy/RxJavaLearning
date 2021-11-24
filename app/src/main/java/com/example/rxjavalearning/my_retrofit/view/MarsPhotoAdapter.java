package com.example.rxjavalearning.my_retrofit.view;

import static com.example.rxjavalearning.my_retrofit.model.ImageLoader.imageDownload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavalearning.MainActivity;
import com.example.rxjavalearning.R;
import com.example.rxjavalearning.my_retrofit.model.MarsPhoto;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.HashMap;
import java.util.List;

public class MarsPhotoAdapter extends RecyclerView.Adapter<MarsPhotoAdapter.MarsPhotoHolder> {
    private List<MarsPhoto> photos;


    private final static String key = "KEY";

    public MarsPhotoAdapter(List<MarsPhoto> photos){
        this.photos = photos;
    }

    static class MarsPhotoHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private MarsPhoto photo;

        public MarsPhotoHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.recyclerview_item_for_mars_photos, parent, false));
            imageView = (ImageView) itemView.findViewById(R.id.mars_photo_image);
        }

        public void bind(MarsPhoto photo){
            this.photo = photo;
            imageDownload(imageView, photo.getImg_src(), false);

        }

    }


    @NonNull
    @Override
    public MarsPhotoAdapter.MarsPhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MarsPhotoAdapter.MarsPhotoHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MarsPhotoHolder holder, int position) {
        MarsPhoto photo = photos.get(position);
        holder.bind(photo);

        Bundle bundle = new Bundle();
        bundle.putSerializable(key, photo);
        //Положить в Bundle изображение, по которому кликнули и его id (тк нет названия)

        holder.itemView.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_marsPhotoGalleryFragment_to_marsPhotoFragment, bundle));


    }


    @Override
    public int getItemCount() {
        return this.photos.size();
    }



}
