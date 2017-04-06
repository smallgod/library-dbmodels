package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class GetCampaignDetailsRequest implements JsonDataModel {

    /*
    
    {
        "method": "GET_CAMPAIGN_DETAILS",
        "credentials": {
          "app_id": "ADER6864g25644777", 
          "api_password": "sLA84009rw2",
          "token_id": "84938urj9338203u349393"
        },
        "params": {
          "campaign_id": 3455843
        }
    }
    
     */
    @SerializedName(value = "credentials")
    private Credentials credentials;

    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "params")
    private Params params;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public class Params {

        @SerializedName(value = "campaign_id")
        private int campaignId;

        public int getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(int campaignId) {
            this.campaignId = campaignId;
        }
    }
}
