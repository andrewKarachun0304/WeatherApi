
package com.example.weatherapi.pojo.weather;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealFeelTemperature implements Serializable
{

    @SerializedName("Minimum")
    @Expose
    private Minimum_ minimum;
    @SerializedName("Maximum")
    @Expose
    private Maximum_ maximum;
    private final static long serialVersionUID = -5324778194365778131L;

    public Minimum_ getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum_ minimum) {
        this.minimum = minimum;
    }

    public Maximum_ getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum_ maximum) {
        this.maximum = maximum;
    }

}
