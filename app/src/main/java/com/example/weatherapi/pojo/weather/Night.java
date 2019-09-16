
package com.example.weatherapi.pojo.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Night {

    @SerializedName("Icon")
    @Expose
    private int icon;
    @SerializedName("IconPhrase")
    @Expose
    private String iconPhrase;
    @SerializedName("HasPrecipitation")
    @Expose
    private boolean hasPrecipitation;
    @SerializedName("ShortPhrase")
    @Expose
    private String shortPhrase;
    @SerializedName("LongPhrase")
    @Expose
    private String longPhrase;
    @SerializedName("PrecipitationProbability")
    @Expose
    private int precipitationProbability;
    @SerializedName("ThunderstormProbability")
    @Expose
    private int thunderstormProbability;
    @SerializedName("RainProbability")
    @Expose
    private int rainProbability;
    @SerializedName("SnowProbability")
    @Expose
    private int snowProbability;
    @SerializedName("IceProbability")
    @Expose
    private int iceProbability;
    @SerializedName("Wind")
    @Expose
    private Wind_ wind;
    @SerializedName("WindGust")
    @Expose
    private WindGust_ windGust;
    @SerializedName("TotalLiquid")
    @Expose
    private TotalLiquid_ totalLiquid;
    @SerializedName("Rain")
    @Expose
    private Rain_ rain;
    @SerializedName("Snow")
    @Expose
    private Snow_ snow;
    @SerializedName("Ice")
    @Expose
    private Ice_ ice;
    @SerializedName("HoursOfPrecipitation")
    @Expose
    private float hoursOfPrecipitation;
    @SerializedName("HoursOfRain")
    @Expose
    private float hoursOfRain;
    @SerializedName("HoursOfSnow")
    @Expose
    private float hoursOfSnow;
    @SerializedName("HoursOfIce")
    @Expose
    private float hoursOfIce;
    @SerializedName("CloudCover")
    @Expose
    private int cloudCover;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public boolean isHasPrecipitation() {
        return hasPrecipitation;
    }

    public void setHasPrecipitation(boolean hasPrecipitation) {
        this.hasPrecipitation = hasPrecipitation;
    }

    public String getShortPhrase() {
        return shortPhrase;
    }

    public void setShortPhrase(String shortPhrase) {
        this.shortPhrase = shortPhrase;
    }

    public String getLongPhrase() {
        return longPhrase;
    }

    public void setLongPhrase(String longPhrase) {
        this.longPhrase = longPhrase;
    }

    public int getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(int precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }

    public int getThunderstormProbability() {
        return thunderstormProbability;
    }

    public void setThunderstormProbability(int thunderstormProbability) {
        this.thunderstormProbability = thunderstormProbability;
    }

    public int getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(int rainProbability) {
        this.rainProbability = rainProbability;
    }

    public int getSnowProbability() {
        return snowProbability;
    }

    public void setSnowProbability(int snowProbability) {
        this.snowProbability = snowProbability;
    }

    public int getIceProbability() {
        return iceProbability;
    }

    public void setIceProbability(int iceProbability) {
        this.iceProbability = iceProbability;
    }

    public Wind_ getWind() {
        return wind;
    }

    public void setWind(Wind_ wind) {
        this.wind = wind;
    }

    public WindGust_ getWindGust() {
        return windGust;
    }

    public void setWindGust(WindGust_ windGust) {
        this.windGust = windGust;
    }

    public TotalLiquid_ getTotalLiquid() {
        return totalLiquid;
    }

    public void setTotalLiquid(TotalLiquid_ totalLiquid) {
        this.totalLiquid = totalLiquid;
    }

    public Rain_ getRain() {
        return rain;
    }

    public void setRain(Rain_ rain) {
        this.rain = rain;
    }

    public Snow_ getSnow() {
        return snow;
    }

    public void setSnow(Snow_ snow) {
        this.snow = snow;
    }

    public Ice_ getIce() {
        return ice;
    }

    public void setIce(Ice_ ice) {
        this.ice = ice;
    }

    public float getHoursOfPrecipitation() {
        return hoursOfPrecipitation;
    }

    public void setHoursOfPrecipitation(float hoursOfPrecipitation) {
        this.hoursOfPrecipitation = hoursOfPrecipitation;
    }

    public float getHoursOfRain() {
        return hoursOfRain;
    }

    public void setHoursOfRain(float hoursOfRain) {
        this.hoursOfRain = hoursOfRain;
    }

    public float getHoursOfSnow() {
        return hoursOfSnow;
    }

    public void setHoursOfSnow(float hoursOfSnow) {
        this.hoursOfSnow = hoursOfSnow;
    }

    public float getHoursOfIce() {
        return hoursOfIce;
    }

    public void setHoursOfIce(float hoursOfIce) {
        this.hoursOfIce = hoursOfIce;
    }

    public int getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(int cloudCover) {
        this.cloudCover = cloudCover;
    }

}
