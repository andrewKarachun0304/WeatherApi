
package com.example.weatherapi.pojo.weather;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind_ implements Serializable
{

    @SerializedName("Speed")
    @Expose
    private Speed__ speed;
    @SerializedName("Direction")
    @Expose
    private Direction__ direction;
    private final static long serialVersionUID = 5870070056754580869L;

    public Speed__ getSpeed() {
        return speed;
    }

    public void setSpeed(Speed__ speed) {
        this.speed = speed;
    }

    public Direction__ getDirection() {
        return direction;
    }

    public void setDirection(Direction__ direction) {
        this.direction = direction;
    }

}
