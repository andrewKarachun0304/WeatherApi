package com.example.weatherapi;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;

public class MyLocation {

    private Context weatherContext;

    private LocationListener listener;
    private LocationManager manager;

    private double latitude;
    private double longitude;

    public static final String PERMISSION_STRING
            = android.Manifest.permission.ACCESS_FINE_LOCATION;

    public void setWeatherContext(Context weatherContext) {
        this.weatherContext = weatherContext;
    }

    public void onCreate(){
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        manager = (LocationManager) weatherContext.getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(weatherContext, PERMISSION_STRING)
                == PackageManager.PERMISSION_GRANTED){
            String provider = manager.getBestProvider(new Criteria(), true);
            if (provider != null)
                manager.requestLocationUpdates(provider, 1000, 1, listener);
        }
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void onDestroy(){
        if(manager != null && listener != null){
            if(ContextCompat.checkSelfPermission(weatherContext, PERMISSION_STRING)
                    == PackageManager.PERMISSION_GRANTED)
                manager.removeUpdates(listener);
        }
        listener = null;
        manager = null;
    }
}
