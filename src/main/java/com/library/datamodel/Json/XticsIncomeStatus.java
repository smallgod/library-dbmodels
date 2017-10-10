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
public class XticsIncomeStatus {

    @SerializedName("ultra_low")
    @Expose
    private int ultraLow;

    @SerializedName("low")
    @Expose
    private int low;

    @SerializedName("average")
    @Expose
    private int average;

    @SerializedName("high")
    @Expose
    private int high;

    @SerializedName("ultra_high")
    @Expose
    private int ultraHigh;

    public int getUltraLow() {
        return ultraLow;
    }

    public void setUltraLow(int ultraLow) {
        this.ultraLow = ultraLow;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getUltraHigh() {
        return ultraHigh;
    }

    public void setUltraHigh(int ultraHigh) {
        this.ultraHigh = ultraHigh;
    }

    
}
