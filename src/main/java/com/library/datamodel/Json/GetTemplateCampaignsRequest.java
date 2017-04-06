package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class GetTemplateCampaignsRequest implements JsonDataModel {

    /*
        {
            "method": "GET_TEMPLATE_ADVERTS",
            "credentials": {
              "app_id": "ADER6864g25644777",
              "api_password": "sLA84009dfewwrw2",
              "token_id": "84938urj9338203u349393"
            },
            "params": {} //We shall have params, for now leave them out
        }
             
     */
    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "credentials")
    private Credentials credentials;

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

    }

}
