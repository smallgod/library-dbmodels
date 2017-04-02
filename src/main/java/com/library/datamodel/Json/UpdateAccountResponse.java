package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateAccountResponse {

    /*
    
        {
            "success": true,
            "data": {
              "user_id": "774983602", //generated from the "primary_phone"
              "account_status": "ACTIVE",
              "description": "Account details successfuly updated"
            }
        }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    private UpdateAccountResponse(boolean success) {
        this.success = success;
    }

    public UpdateAccountResponse() {
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
    }
}
