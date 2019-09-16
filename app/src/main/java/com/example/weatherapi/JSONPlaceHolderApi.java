package com.example.weatherapi;

import com.example.weatherapi.pojo.location.Location;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/locations/v1/cities/geoposition/search")
    Single<Location> getCityKeyWithApi(@Query("apikey") String apiKey, @Query("q") String q, @Query("language") String language);

}
