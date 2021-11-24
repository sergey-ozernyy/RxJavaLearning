package com.example.rxjavalearning.my_retrofit.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rxjavalearning.R;
import com.example.rxjavalearning.my_retrofit.model.ImageLoader;
import com.example.rxjavalearning.my_retrofit.model.MarsPhoto;



public class MarsPhotoFragment extends Fragment {

    private ImageView imageView;
    private ScaleGestureDetector mScaleGestureDetector;
    private float mScaleFactor = 1.0f;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mars_photo, container, false);
        imageView = view.findViewById(R.id.big_mars_photo_image);
        mScaleGestureDetector = new ScaleGestureDetector(getActivity(), new ScaleListener());
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mScaleGestureDetector.onTouchEvent(motionEvent);
                return true;
            }
        });

        MarsPhoto photo = (MarsPhoto) getArguments().getSerializable("KEY");
        ImageLoader.imageDownload(imageView, photo.getImg_src(), true);

        return view;
    }


    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector){
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);
            return true;
        }
    }


}