package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author smallGod
 */
public class TimeSlotsAudienceCount {

    @SerializedName("slot")
    @Expose
    private String slot;

    @SerializedName("days")
    @Expose
    private DaysAudienceCount days;

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public DaysAudienceCount getDays() {
        return days;
    }

    public void setDays(DaysAudienceCount days) {
        this.days = days;
    }
}