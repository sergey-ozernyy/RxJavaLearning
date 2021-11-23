package com.example.rxjavalearning;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rxjavalearning.R;



public class StartFragment extends Fragment {

    Button goToRetrofitButton;
    Button goToRxJavaButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        goToRetrofitButton = view.findViewById(R.id.go_to_retrofit_fragment_button);
        goToRxJavaButton = view.findViewById(R.id.go_to_rx_fragment_button);

        goToRetrofitButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_marsPhotosFragment));
        goToRxJavaButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_rxButtonClickFragment));

        return view;
    }
}