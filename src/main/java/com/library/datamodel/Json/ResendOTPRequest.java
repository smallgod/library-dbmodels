package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class ResendOTPRequest implements JsonDataModel {

    /*
        {
            "method": "VERIFY_ACCOUNT",
            "credentials": {
              "app_id": "ADER6864g25644777",
              "api_password": "sLA84009rw2",
              "token_id": "y0lhfdety90jfdsa223sxbrj9" //this is like a session id
            },
            "params": {
              "primary_phone": 739234567
            }
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

        @SerializedName(value = "primary_phone")
        private String primaryPhone;

        public Params() {
        }

        public String getPrimaryPhone() {
            return primaryPhone;
        }

        public void setPrimaryPhone(String primaryPhone) {
            this.primaryPhone = primaryPhone;
        }

    }

}
