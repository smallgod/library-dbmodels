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
public class TargetReach {

    @SerializedName("amount")
    @Expose
    private int amount;

    @SerializedName("audience_count")
    @Expose
    private int audienceCount;

    @SerializedName("screen_count")
    @Expose
    private int screenCount;

    @SerializedName("estimated_views")
    @Expose
    private int estimatedViews;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public void setAudienceCount(int audienceCount) {
        this.audienceCount = audienceCount;
    }

    public int getScreenCount() {
        return screenCount;
    }

    public void setScreenCount(int screenCount) {
        this.screenCount = screenCount;
    }

    public int getEstimatedViews() {
        return estimatedViews;
    }

    public void setEstimatedViews(int estimatedViews) {
        this.estimatedViews = estimatedViews;
    }

}
