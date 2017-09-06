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
public class CampaignInfo implements DataList {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("campaign_id")
    @Expose
    private int campaignId;

    @SerializedName("campaign_name")
    @Expose
    private String campaignName;

    @SerializedName("cost")
    @Expose
    private int cost;

    @SerializedName("audience_reach")
    @Expose
    private int audienceReach;

    @SerializedName("estimated_views")
    @Expose
    private int estimatedViews;

    @SerializedName("screen_reach")
    @Expose
    private int screenReach;

    @SerializedName("campaign_status")
    @Expose
    private String campaignStatus;
    
    @SerializedName("readable_status")
    @Expose
    private String readableStatus;

    @SerializedName("creation_date_time")
    @Expose
    private String creationDateTime;

    @SerializedName("start_date")
    @Expose
    private String startDate;

    @SerializedName("end_date")
    @Expose
    private String endDate;

    @SerializedName("display_count")
    @Expose
    private int displayCount;

    @SerializedName("description")
    @Expose
    private String description;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public int getAudienceReach() {
        return audienceReach;
    }

    public void setAudienceReach(int audienceReach) {
        this.audienceReach = audienceReach;
    }

    public int getScreenReach() {
        return screenReach;
    }

    public void setScreenReach(int screenReach) {
        this.screenReach = screenReach;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCampaignStatus() {
        return campaignStatus;
    }

    public void setCampaignStatus(String campaignStatus) {
        this.campaignStatus = campaignStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getDisplayCount() {
        return displayCount;
    }

    public void setDisplayCount(int displayCount) {
        this.displayCount = displayCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(String creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public int getEstimatedViews() {
        return estimatedViews;
    }

    public void setEstimatedViews(int estimatedViews) {
        this.estimatedViews = estimatedViews;
    }

    public String getReadableStatus() {
        return readableStatus;
    }

    public void setReadableStatus(String readableStatus) {
        this.readableStatus = readableStatus;
    }

}
