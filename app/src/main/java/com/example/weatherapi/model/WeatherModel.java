package com.example.weatherapi.model;

import android.content.Context;
import android.util.Log;

import com.example.weatherapi.NetworkService;
import com.example.weatherapi.contact.WeatherContactModel;
import com.example.weatherapi.pojo.location.Location;
import com.google.android.gms.location.LocationRequest;
import com.patloew.rxlocation.RxLocation;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class WeatherModel implements WeatherContactModel {

    private Context weatherContext;
    private double latitude;
    private double longitude;
    private static final String API = "wyKrkqqNe19YsqnZCZBLviT8307SYN2O";
    private String q;
    private static final String LANGUAGE = "ru-ru";
    private String cityKey;

    public void setWeatherContext(Context weatherContext) {
        this.weatherContext = weatherContext;
    }

    public void location(){
        RxLocation rxLocation = new RxLocation(weatherContext);

        LocationRequest locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//                .setInterval(20000);

        rxLocation.location().updates(locationRequest)
                .subscribe(location ->{
                    latitude = location.getLatitude();
                    longitude = location.getLongitude();
                    q = latitude + ", " + longitude;
                        });
    }

    public Single<Location> getCityKey(){
       return NetworkService.getInstance().getJsonApi().getCityKeyWithApi(API, q, LANGUAGE);
//        locationSingle
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(location -> {
//                    cityKey = location.getKey();
//                    Log.d("TAG", cityKey);
//                });
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getKey(){
        return cityKey;
    }
}
