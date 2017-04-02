package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class GuestLoginRequest implements JsonDataModel {

    /*
        {
            "method": "GUEST_LOGIN",
            "credentials": {
              "app_id": "ADER6864g25644777", 
              "api_password": "sLA84009rw2",
              "token_id": ""
            },
            "params": {

              "user_type":"CLIENT", //I think I should add this field
              "agreed_to_terms":true //terms & conditions need be for both guest users and upgraded users

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

        @SerializedName(value = "user_type")
        private String userType;

        @SerializedName(value = "agreed_to_terms")
        private boolean isAgreedToTerms;

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public boolean isIsAgreedToTerms() {
            return isAgreedToTerms;
        }

        public void setIsAgreedToTerms(boolean isAgreedToTerms) {
            this.isAgreedToTerms = isAgreedToTerms;
        }

    }

}
