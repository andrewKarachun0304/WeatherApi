
package com.example.weatherapi.pojo.weather;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AirAndPollen implements Serializable
{

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Value")
    @Expose
    private String value;
    @SerializedName("Category")
    @Expose
    private String category;
    @SerializedName("CategoryValue")
    @Expose
    private Integer categoryValue;
    @SerializedName("Type")
    @Expose
    private String type;
    private final static long serialVersionUID = 1763997679315361021L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(Integer categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
