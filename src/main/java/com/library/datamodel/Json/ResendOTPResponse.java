package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResendOTPResponse {

    /*
    
        {
            "success": true,
            "data": {
              "otp": 7892,
              "user_id": "774983602", 
              "account_status": "PENDING_VERIFICATION", 
              "description": "OTP has been sent to user."
            }
          }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    private ResendOTPResponse(boolean success) {
        this.success = success;
    }

    public ResendOTPResponse() {
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

        @SerializedName("otp")
        @Expose
        private int otp;

        @SerializedName("user_id")
        @Expose
        private String userId;

        @SerializedName("account_status")
        @Expose
        private String accountStatus;

        @SerializedName("description")
        @Expose
        private String description;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

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

        public int getOtp() {
            return otp;
        }

        public void setOtp(int otp) {
            this.otp = otp;
        }

    }
}
