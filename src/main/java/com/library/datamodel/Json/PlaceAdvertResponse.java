package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaceAdvertResponse {

    /*
        ISIAH 45:11 - LIVING BIBLE / KJV
    
        {
           "success":true,
           "data":{
              "campaign_id":"4511233",
              "campaign_status":"PENDING_PAYMENT",
              "description":"Campaign has been logged, pending payment confirmation",
              "display_count":88,
              "start_date":"2017-03-23",
              "end_date":"2017-03-29",
              "target_reach":{
                 "amount":500,
                 "audience_count":4,
                 "screen_count":1
              },
              "potential_reach":{
                 "amount":500000,
                 "audience_count":50000,
                 "screen_count":9100
              }
           }
        }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    public PlaceAdvertResponse(boolean success) {
        this.success = success;
    }

    public PlaceAdvertResponse() {
        this(Boolean.TRUE);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("campaign_id")
        @Expose
        private int campaignId;

        @SerializedName("campaign_status")
        @Expose
        private String campaignStatus;

        @SerializedName("description")
        @Expose
        private String description;

        @SerializedName("display_count")
        @Expose
        private int numOfTimesAdIsToPlay;

        @SerializedName("start_date")
        @Expose
        private String startDate;

        @SerializedName("end_date")
        @Expose
        private String endDate;

        @SerializedName("target_reach")
        @Expose
        private TargetReach targetReach;

        @SerializedName("potential_reach")
        @Expose
        private PotentialReach potentialReach;

        public TargetReach getTargetReach() {
            return targetReach;
        }

        public void setTargetReach(TargetReach targetReach) {
            this.targetReach = targetReach;
        }

        public PotentialReach getPotentialReach() {
            return potentialReach;
        }

        public void setPotentialReach(PotentialReach potentialReach) {
            this.potentialReach = potentialReach;

        }

        public int getNumOfTimesAdIsToPlay() {
            return numOfTimesAdIsToPlay;
        }

        public void setNumOfTimesAdIsToPlay(int numOfTimesAdIsToPlay) {
            this.numOfTimesAdIsToPlay = numOfTimesAdIsToPlay;
        }

        public int getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(int campaignId) {
            this.campaignId = campaignId;
        }

        public String getCampaignStatus() {
            return campaignStatus;
        }

        public void setCampaignStatus(String campaignStatus) {
            this.campaignStatus = campaignStatus;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        }

        public class PotentialReach {

            @SerializedName("amount")
            @Expose
            private int amount;

            @SerializedName("audience_count")
            @Expose
            private int audienceCount;

            @SerializedName("screen_count")
            @Expose
            private int screenCount;

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

        }
    }
}
