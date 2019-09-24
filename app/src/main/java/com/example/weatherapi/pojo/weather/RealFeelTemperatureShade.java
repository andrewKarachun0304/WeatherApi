
package com.example.weatherapi.pojo.weather;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RealFeelTemperatureShade implements Serializable
{

    @SerializedName("Minimum")
    @Expose
    private Minimum__ minimum;
    @SerializedName("Maximum")
    @Expose
    private Maximum__ maximum;
    private final static long serialVersionUID = 1862931189686588440L;

    public Minimum__ getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum__ minimum) {
        this.minimum = minimum;
    }

    public Maximum__ getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum__ maximum) {
        this.maximum = maximum;
    }

}
