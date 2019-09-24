
package com.example.weatherapi.pojo.weather;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindGust implements Serializable
{

    @SerializedName("Speed")
    @Expose
    private Speed_ speed;
    @SerializedName("Direction")
    @Expose
    private Direction_ direction;
    private final static long serialVersionUID = 316930525555125806L;

    public Speed_ getSpeed() {
        return speed;
    }

    public void setSpeed(Speed_ speed) {
        this.speed = speed;
    }

    public Direction_ getDirection() {
        return direction;
    }

    public void setDirection(Direction_ direction) {
        this.direction = direction;
    }

}
