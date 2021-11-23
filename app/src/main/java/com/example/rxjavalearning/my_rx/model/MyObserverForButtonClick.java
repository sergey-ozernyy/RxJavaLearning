package com.example.rxjavalearning.my_rx.model;

import android.view.View;

import com.example.rxjavalearning.my_rx.view.RxButtonClickFragment;

import java.time.Instant;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MyObserverForButtonClick {
    public static Observer<View> observerClickEvent = new Observer<View>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onNext(@NonNull View view) {
            //Генерируем строку
            Instant nowInInstant = Instant.now();
            long nowInSecond = nowInInstant.getEpochSecond();
            String result = nowInInstant.toString() + " or " + nowInSecond + " seconds in Unix timestamp";

            //Добавляем строку в массив
            RxButtonClickFragment.listValues.add(result);

            //Обновляем адаптер
            RxButtonClickFragment.adapter.notifyDataSetChanged();
        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

}
