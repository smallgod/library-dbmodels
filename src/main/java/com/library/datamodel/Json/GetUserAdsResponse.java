package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GetUserAdsResponse {

    /*
    
        {
            "success": true,
            "data": [

                {
                  "id":1, //For sorting and numbering purposes
                  "campaign_id":345543,
                  "campaign_name":"Plumber Samuel #1",
                  "cost":34554,
                  "screens_reached":253,
                  "audience_reached":9909,
                  "status":"ACTIVE", // PENDING_PAYMENT| IN_REVIEW | ACTIVE or PLAYING | PROCESSED | REJECTED | FLAGGED | REVERSED
                  "start_date": "2017-03-23",
                  "end_date": "2017-03-29",
                  "display_count":160 //number of times ad will be shown
                },

                 {
                  "id":2, //For sorting and numbering purposes
                  "campaign_id":3455843,
                  "campaign_name":"Motorcycle Repairs #1",
                  "cost":34554,
                  "screens_reached":253,
                  "audience_reached":9909,
                  "status":"ACTIVE", // PENDING_PAYMENT| IN_REVIEW | ACTIVE or PLAYING | PROCESSED | REJECTED | FLAGGED | REVERSED
                  "start_date": "2017-03-23",
                  "end_date": "2017-03-29",
                  "display_count":88 //number of times ad will be shown
                }
            ]
        }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Set<Data> data = new HashSet<>();

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Set<Data> getData() {
        return data;
    }

    public void setData(Set<Data> data) {
        this.data = data;
    }

    public class Data {

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

        @SerializedName("audience_reached")
        @Expose
        private int audienceReached;

        @SerializedName("screens_reached")
        @Expose
        private int screensReached;

        @SerializedName("status")
        @Expose
        private String status;

        @SerializedName("start_date")
        @Expose
        private String startDate;

        @SerializedName("end_date")
        @Expose
        private String endDate;

        @SerializedName("screen_count")
        @Expose
        private int display_count;

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

        public int getAudienceReached() {
            return audienceReached;
        }

        public void setAudienceReached(int audienceReached) {
            this.audienceReached = audienceReached;
        }

        public int getScreensReached() {
            return screensReached;
        }

        public void setScreensReached(int screensReached) {
            this.screensReached = screensReached;
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

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        public int getDisplay_count() {
            return display_count;
        }

        public void setDisplay_count(int display_count) {
            this.display_count = display_count;
        }

    }
}
