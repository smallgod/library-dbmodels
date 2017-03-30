package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class AuthenticateUserRequest implements JsonDataModel {

    /*
        {
            "method": "AUTHENTICATE_USER",
            "credentials": {
              "app_id": "ADER6864g25644777", 
              "api_password": "sLA84009rw2",
              "token_id": ""
            },
            "params": {
              "user_id": "774983602",
              "password": "eioi45609oifgoi6567978uty",
              "user_type": "CLIENT" || SCREEN_OWNER -> This is different from user_role which can be admin, reports, etc
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

        @SerializedName(value = "user_id")
        private String userId;

        @SerializedName(value = "password")
        private String password;
        
        @SerializedName(value = "user_type")
        private String userType;

        public Params() {
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

    }

}
