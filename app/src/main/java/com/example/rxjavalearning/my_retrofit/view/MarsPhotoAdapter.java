package com.example.rxjavalearning.my_retrofit.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavalearning.R;
import com.example.rxjavalearning.my_retrofit.model.MarsPhoto;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MarsPhotoAdapter extends RecyclerView.Adapter<MarsPhotoAdapter.MarsPhotoHolder> {
    private List<MarsPhoto> photos;

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
            imageDownload(imageView, photo.getImg_src());
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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Просмотр изображения во весь экран или еще что-то
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.photos.size();
    }

    public static void imageDownload(ImageView imageView, String url){
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_loading_mars_photo)
                .error(R.drawable.ic_error_loading_mars_photo)
                .fit()
                .centerCrop()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });

    }

}
