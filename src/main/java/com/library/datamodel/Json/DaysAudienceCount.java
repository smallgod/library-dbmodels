package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author smallGod
 */
public class DaysAudienceCount {

    @Expose
    @SerializedName(value = "monday")
    private int monday;

    @Expose
    @SerializedName(value = "tuesday")
    private int tuesday;

    @Expose
    @SerializedName(value = "wednesday")
    private int wednesday;

    @Expose
    @SerializedName(value = "thursday")
    private int thursday;

    @Expose
    @SerializedName(value = "friday")
    private int friday;

    @Expose
    @SerializedName(value = "saturday")
    private int saturday;

    @Expose
    @SerializedName(value = "sunday")
    private int sunday;

    @Expose
    @SerializedName(value = "holiday")
    private int holiday;

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    public int getSaturday() {
        return saturday;
    }

    public void setSaturday(int saturday) {
        this.saturday = saturday;
    }

    public int getSunday() {
        return sunday;
    }

    public void setSunday(int sunday) {
        this.sunday = sunday;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }
}
