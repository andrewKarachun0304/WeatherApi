
package com.example.weatherapi.pojo.weather;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DegreeDaySummary implements Serializable
{

    @SerializedName("Heating")
    @Expose
    private Heating heating;
    @SerializedName("Cooling")
    @Expose
    private Cooling cooling;
    private final static long serialVersionUID = -4149622137678344891L;

    public Heating getHeating() {
        return heating;
    }

    public void setHeating(Heating heating) {
        this.heating = heating;
    }

    public Cooling getCooling() {
        return cooling;
    }

    public void setCooling(Cooling cooling) {
        this.cooling = cooling;
    }

}
