
package com.example.weatherapi.pojo.weather;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather implements Serializable
{

    @SerializedName("Headline")
    @Expose
    private Headline headline;
    @SerializedName("DailyForecasts")
    @Expose
    private List<DailyForecast> dailyForecasts = null;
    private final static long serialVersionUID = -2908447562881286677L;

    public Headline getHeadline() {
        return headline;
    }

    public void setHeadline(Headline headline) {
        this.headline = headline;
    }

    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

}
