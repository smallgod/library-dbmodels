package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GetTemplateCampaignsResponse {

    /*
    
        {
            "success": true,
            "data": [
              {
                "id": 1, 
                "campaign_id": 345543,
                "campaign_name": "3-Screen split ad #1",
                "campaign_status": "DRAFT",
                "layout_type": "3SPLIT",
                "layout_cost": 1000,
                "description": "This layout will show your ad..."
              },
              {
                "id": 2,
                "campaign_id": 345003,
                "campaign_name": "Full Screen ad #1",
                "campaign_status": "DRAFT",
                "layout_type": "FULLSCREEN",
                "layout_cost": 1500,
                "description": "This layout will show your ad in full screen views..."
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

    private GetTemplateCampaignsResponse(boolean success) {
        this.success = success;
    }

    public GetTemplateCampaignsResponse() {
        this(Boolean.TRUE);
    }

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

        @SerializedName("campaign_status")
        @Expose
        private String campaignStatus;

        @SerializedName("layout_type")
        @Expose
        private String layoutType;

        @SerializedName("layout_cost")
        @Expose
        private int layoutCost;

        @SerializedName("description")
        @Expose
        private String description;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(int campaignId) {
            this.campaignId = campaignId;
        }

        public String getCampaignName() {
            return campaignName;
        }

        public void setCampaignName(String campaignName) {
            this.campaignName = campaignName;
        }

        public String getCampaignStatus() {
            return campaignStatus;
        }

        public void setCampaignStatus(String campaignStatus) {
            this.campaignStatus = campaignStatus;
        }

        public String getLayoutType() {
            return layoutType;
        }

        public void setLayoutType(String layoutType) {
            this.layoutType = layoutType;
        }

        public int getLayoutCost() {
            return layoutCost;
        }

        public void setLayoutCost(int layoutCost) {
            this.layoutCost = layoutCost;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

}
