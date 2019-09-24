
package com.example.weatherapi.pojo.weather;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WindGust_ implements Serializable
{

    @SerializedName("Speed")
    @Expose
    private Speed___ speed;
    @SerializedName("Direction")
    @Expose
    private Direction___ direction;
    private final static long serialVersionUID = 7686672810831943432L;

    public Speed___ getSpeed() {
        return speed;
    }

    public void setSpeed(Speed___ speed) {
        this.speed = speed;
    }

    public Direction___ getDirection() {
        return direction;
    }

    public void setDirection(Direction___ direction) {
        this.direction = direction;
    }

}
