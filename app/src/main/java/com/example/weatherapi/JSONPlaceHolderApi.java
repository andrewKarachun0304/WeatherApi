package com.example.weatherapi;

import com.example.weatherapi.pojo.location.LocationCord;
import com.example.weatherapi.pojo.weather.Weather;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/locations/v1/cities/geoposition/search")
    Single<LocationCord> getCityKeyWithApi(@Query("apikey") String apiKey, @Query("q") String q, @Query("language") String language);

    @GET("forecasts/v1/daily/5day/{city_key}")
    Single<Weather> getWeatherWithApi(@Path("city_key") String cityKey, @Query("apikey") String apiKey, @Query("language") String language,
                                      @Query("details") boolean details, @Query("metric") boolean metric);

}