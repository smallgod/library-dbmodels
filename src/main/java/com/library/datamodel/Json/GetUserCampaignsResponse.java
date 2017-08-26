package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GetUserCampaignsResponse {

    /*
    
        {
            "success": true,
            "data": [
              {
                "id": 1, //For sorting and numbering purposes
                "campaign_id": 345543,
                "campaign_name": "Plumber Samuel #1",
                "cost": 34554,
                "screen_reach": 253,
                "audience_reach": 9909,
                "campaign_status": "IN_REVIEW",
                "creation_date_time": "2017-03-23 23:23",
                "start_date": "2017-03-23",
                "end_date": "2017-03-29",
                "display_count": 160, //number of times ad will be shown
                "description": "Awaiting admin moderation of the advert before scheduling for display"
              },
              {
                "id": 2,
                "campaign_id": 3455843,
                "campaign_name": "Motorcycle Repairs #1",
                "cost": 34554,
                "screen_reach": 253,
                "audience_reach": 9909,
                "campaign_status": "ACTIVE",
                "creation_date_time": "2017-03-23 23:23",
                "start_date": "2017-03-23",
                "end_date": "2017-03-29",
                "display_count": 88,
                "description": "Ad has been scheduled for display on 120 out of 120 screens"
              }
            ]

              
                I think i should add this pagination stuff below
               ,"page": {
                  "current_page": 1,
                  "page_size": 20,
                  "total_pages": 1,
                  "total_rows": 3}
          }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Set<CampaignInfo> data = new HashSet<>();

    private GetUserCampaignsResponse(boolean success) {
        this.success = success;
    }

    public GetUserCampaignsResponse() {
        this(Boolean.TRUE);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Set<CampaignInfo> getData() {
        return data;
    }

    public void setData(Set<CampaignInfo> data) {
        this.data = data;

    }

}
