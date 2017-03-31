package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.HashSet;
import java.util.Set;

public class GetUserCampaignsRequest implements JsonDataModel {

    /*
    {
        "method": "GET_USER_ADVERTS",
        "credentials": {
          "app_id": "ADER6864g25644777",
          "api_password": "sLA84009rw2",
          "token_id": "84938urj9338203u349393"
        },
        "params": {
          "campaign_id": [583746] //default is [] meaning return all campaign ids
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
        private Set<Integer> campaignIds = new HashSet<>();

        public Set<Integer> getCampaignIds() {
            return campaignIds;
        }

        public void setCampaignIds(Set<Integer> campaignIds) {
            this.campaignIds = campaignIds;
        }

    }

}
