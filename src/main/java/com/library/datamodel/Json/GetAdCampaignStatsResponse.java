package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAdCampaignStatsResponse {

    /*
        ISIAH 45:11 - LIVING BIBLE / KJV
    
        // Get ad length amount
        //we start with amount - 0 & audience reach - 0
        //this request is sent both at adding a parameter or at its removal
    
    
        {
          "success": true,
          "data": {
            "display_count":59, //number of times advert is going to be displayed
            "target_reach": {
              "amount": 500,
              "audience_count": 4,
              "screen_count": 1,
              "estimated_views":1000
            },
            "potential_reach": {
              "amount": 500000,
              "audience_count": 50000,
              "screen_count": 9100,
              "estimated_views":1000
            }
          }
        }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private CampaignStats data;

    public GetAdCampaignStatsResponse(boolean success) {
        this.success = success;
    }

    public GetAdCampaignStatsResponse() {
        this(Boolean.TRUE);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public CampaignStats getData() {
        return data;
    }

    public void setData(CampaignStats data) {
        this.data = data;
    }
}
