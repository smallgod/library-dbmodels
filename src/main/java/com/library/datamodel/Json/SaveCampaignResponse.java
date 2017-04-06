package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaveCampaignResponse {

    /*
    
        {
            "success": true,
            "data": {
                "campaign_id":"11233",
                "campaign_status":"DRAFT",
                "description":"Advert draft has been saved"
        }
}
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    private SaveCampaignResponse(boolean success) {
        this.success = success;
    }

    public SaveCampaignResponse() {
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

    }
}
