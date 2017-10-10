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
 * @author smallGod
 */
public class Days {

    @SerializedName(value = "monday")
    private String monday;

    @Expose
    @SerializedName(value = "tuesday")
    private String tuesday;

    @Expose
    @SerializedName(value = "wednesday")
    private String wednesday;

    @Expose
    @SerializedName(value = "thursday")
    private String thursday;

    @Expose
    @SerializedName(value = "friday")
    private String friday;

    @Expose
    @SerializedName(value = "saturday")
    private String saturday;

    @Expose
    @SerializedName(value = "sunday")
    private String sunday;

    @Expose
    @SerializedName(value = "holiday")
    private String holiday; //if closed - 0000

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }

}
