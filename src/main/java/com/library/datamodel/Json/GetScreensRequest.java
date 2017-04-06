package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.Set;

public class GetScreensRequest implements JsonDataModel {

    /*
    {
        "method": "GET_SCREENS",
        "credentials": {
          "app_id": "ADER6864g25644777",
          "api_password": "sLA84009rw2",
          "token_id": "84938urj9338203u349393"
        },
        "params": {
          "screen_codes": ['CHURCH-K2'] //default is [] meaning return all campaign ids
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

        @SerializedName(value = "screen_codes")
        private Set<String> screenCodes;

        public Set<String> getScreenCodes() {
            return screenCodes;
        }

        public void setScreenCodes(Set<String> screenCodes) {
            this.screenCodes = screenCodes;
        }

       
    }
}
