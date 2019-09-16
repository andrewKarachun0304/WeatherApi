package com.example.weatherapi.presenter;

import android.os.Handler;
import android.util.Log;

import com.example.weatherapi.contact.WeatherContactPresenter;
import com.example.weatherapi.model.WeatherModel;
import com.example.weatherapi.pojo.location.Location;
import com.example.weatherapi.view.WeatherActivity;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class WeatherPresenter implements WeatherContactPresenter {

    private WeatherActivity view;
    private WeatherModel model;

    public void setView(WeatherActivity view) {
        this.view = view;
        model = new WeatherModel();
        model.setWeatherContext(view.getApplicationContext());
    }

    public void getLocation(){
        model.location();
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(model.getLatitude() == 0.0 && model.getLongitude() == 0.0){
                    handler.postDelayed(this, 1000);
                } else {
                    Single<Location> locationSingle = model.getCityKey();
                    locationSingle
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .flatMap(location -> Single.just(location.getKey()))
                            .subscribe(s -> view.initTextView(s));
                }
            }
        });
    }
}
//Log.d("TAG", "Presenter");
//        model.getCityKey();
//        if(model.getKey().equals(null)){
//        handler.postDelayed(this, 1000);
//        } else view.initTextView(model.getKey());