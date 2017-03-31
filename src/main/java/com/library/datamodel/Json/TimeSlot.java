/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Set;

/**
 *
 * @author smallgod
 */
public class TimeSlot {

    @SerializedName(value = "name")
    @Expose
    private String name;

    @SerializedName(value = "preferred_hour")
    @Expose
    private Integer preferredHour = -1;

    @SerializedName(value = "frequency")
    @Expose
    private Integer frequency = 1; //number of times we can play this ad within this time name

    @SerializedName(value = "days")
    @Expose
    private Set<Integer> days;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    /**
     * Get all the days to advertise on e.g [1,3,6,7] means [Monday, Wednesday,
     * Saturday & Saturday]
     *
     * @return
     */
    public Set<Integer> getDays() {
        return days;
    }

    public void setDays(Set<Integer> days) {
        this.days = days;
    }

    public Integer getPreferredHour() {
        return preferredHour;
    }

    public void setPreferredHour(Integer preferredHour) {
        this.preferredHour = preferredHour;
    }
}
