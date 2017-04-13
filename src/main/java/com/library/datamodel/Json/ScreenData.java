/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    @SerializedName("extra_1")
    @Expose
    private String extra1;

    @SerializedName("extra_2")
    @Expose
    private String extra2;

    @SerializedName("extra_3")
    @Expose
    private String extra3;

    @SerializedName("extra_4")
    @Expose
    private String extra4;

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

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra3() {
        return extra3;
    }

    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }

    public String getExtra4() {
        return extra4;
    }

    public void setExtra4(String extra4) {
        this.extra4 = extra4;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

}
