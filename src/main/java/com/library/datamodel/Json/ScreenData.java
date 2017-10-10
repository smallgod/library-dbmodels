package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author smallgod
 */
public class ScreenData {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("screen_code")
    @Expose
    private String screenCode;

    @SerializedName("business_name")
    @Expose
    private String businessName;

    @SerializedName("sub_area")
    @Expose
    private String subArea;

    @SerializedName("area_name")
    @Expose
    private String areaName;

    @SerializedName("alias")
    @Expose
    private String alias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreenCode() {
        return screenCode;
    }

    public void setScreenCode(String screenCode) {
        this.screenCode = screenCode;
    }

    public String getSubArea() {
        return subArea;
    }

    public void setSubArea(String subArea) {
        this.subArea = subArea;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
