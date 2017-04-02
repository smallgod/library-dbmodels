package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GuestLoginResponse {

    /*
    {
        "success": true,
        "data": {
          "user_id": "774983602", 
          "otp":5634, // OTP sent to client, used to verify account (so no need to call server again if user enters)
          "first_name":"Davies",
          "token_id": "y0lhfdety90jfdsa223sxbrj9",
          "account_status": "PENDING_VERIFICATION", // |   REGISTERED
          "description": "New client accont created, pending OTP verification"
        }
      }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

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

        private Data(String accountStatus, String description) {
            this.accountStatus = accountStatus;
            this.description = description;
        }

        public Data() {

            this("GUEST", "You are using a guest account, to upgrade, create new account or login");
        }

        @SerializedName("token_id")
        @Expose
        private String tokenId;

        @SerializedName("account_status")
        @Expose
        private String accountStatus;

        @SerializedName("description")
        @Expose
        private String description;

        public String getAccountStatus() {
            return accountStatus;
        }

        public void setAccountStatus(String accountStatus) {
            this.accountStatus = accountStatus;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTokenId() {
            return tokenId;
        }

        public void setTokenId(String tokenId) {
            this.tokenId = tokenId;
        }

    }
}
