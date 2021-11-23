package com.example.rxjavalearning.my_rx.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.rxjavalearning.R;
import com.example.rxjavalearning.my_rx.model.MyObserverForButtonClick;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class RxButtonClickFragment extends Fragment {

    Button button;
    ListView listView;

    public static final ArrayList<String> listValues = new ArrayList<>();
    public static ArrayAdapter<String> adapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_rx_button_click, container, false);

        listView = view.findViewById(R.id.TimeLogListView);
        button = view.findViewById(R.id.AddTimeLogButton);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, listValues);
        listView.setAdapter(adapter);

        Observable<View> clickEventObservable = Observable.create(subscriber -> {
                    button.setOnClickListener(viewClick -> subscriber.onNext(viewClick));
                }
        );

        clickEventObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(MyObserverForButtonClick.observerClickEvent);


        return view;
    }
}