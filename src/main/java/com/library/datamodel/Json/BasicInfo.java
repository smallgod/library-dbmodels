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
public class BasicInfo {

    @SerializedName("notifications")
    @Expose
    private Boolean notifications;

    @SerializedName("campaign_id")
    @Expose
    private int campaignId = 0; //new campaigns are 0 by default, edited campaigns have an ID

    @SerializedName("campaign_name")
    @Expose
    private String campaignName;

    @SerializedName("layout_type")
    @Expose
    private String layoutType;

    @SerializedName("advert_length")
    @Expose
    private Integer advertLength;

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public Integer getAdvertLength() {
        return advertLength;
    }

    public void setAdvertLength(Integer advertLength) {
        this.advertLength = advertLength;
    }

    public Boolean getNotifications() {
        return notifications;
    }

    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }

    public String getLayoutType() {
        return layoutType;
    }

    public void setLayoutType(String layoutType) {
        this.layoutType = layoutType;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

}
