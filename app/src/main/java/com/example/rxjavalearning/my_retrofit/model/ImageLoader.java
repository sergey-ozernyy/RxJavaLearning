package com.example.rxjavalearning.my_retrofit.model;

import android.widget.ImageView;

import com.example.rxjavalearning.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ImageLoader {
    public static void imageDownload(ImageView imageView, String url, Boolean isBigImage){
        if(isBigImage){
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_loading_mars_photo)
                    .error(R.drawable.ic_error_loading_mars_photo)
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();
                        }
                    });
        } else {
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
}
