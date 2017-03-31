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
              "screen_count": 1
            },
            "potential_reach": {
              "amount": 500000,
              "audience_count": 50000,
              "screen_count": 9100
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("display_count")
        @Expose
        private int numOfTimesAdIsToPlay;

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
