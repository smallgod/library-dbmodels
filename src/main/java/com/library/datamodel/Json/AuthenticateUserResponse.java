package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class AuthenticateUserResponse {

    /*
    
        {
            "success": true,
            "data": {
              "login_info": {
                "token_id": "84938urj9338203u349393",
                "user_id": "774983602",
                "account_status": "PENDING_OTP"
              },
              "personal_info": {
                "first_name": "Davies"
              },
              "campaign_info": [
                {
                  "id": 1, //For sorting and numbering purposes
                  "campaign_id": 345543,
                  "campaign_name": "Plumber Samuel #1",
                  "cost": 34554,
                  "screen_reach": 253,
                  "audience_reach": 9909,
                  "campaign_status": "ACTIVE",
                  "start_date": "2017-03-23",
                  "end_date": "2017-03-29",
                  "displayCount": 160 //number of times ad will be shown
                },
                {
                  "id": 2,
                  "campaign_id": 3455843,
                  "campaign_name": "Motorcycle Repairs #1",
                  "cost": 34554,
                  "screens_reached": 253,
                  "audience_reached": 9909,
                  "campaign_status": "ACTIVE",
                  "start_date": "2017-03-23",
                  "end_date": "2017-03-29",
                  "displayCount": 88
                }
              ]
            }
          }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    private AuthenticateUserResponse(boolean success) {
        this.success = success;
    }

    public AuthenticateUserResponse() {
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

        @SerializedName(value = "login_info")
        private LoginInfo loginInfo;

        @SerializedName(value = "personal_info")
        private PersonalInfo personalInfo;

        @SerializedName(value = "campaign_info")
        private Set<CampaignInfo> campaignInfoList = new HashSet<>();

        public Data() {
        }

        public PersonalInfo getPersonalInfo() {
            return personalInfo;
        }

        public void setPersonalInfo(PersonalInfo personalInfo) {
            this.personalInfo = personalInfo;
        }

        public LoginInfo getLoginInfo() {
            return loginInfo;
        }

        public void setLoginInfo(LoginInfo loginInfo) {
            this.loginInfo = loginInfo;
        }

        public Set<CampaignInfo> getCampaignInfoList() {
            return campaignInfoList;
        }

        public void setCampaignInfoList(Set<CampaignInfo> campaignInfoList) {
            this.campaignInfoList = campaignInfoList;
        }

        public class LoginInfo {

            @SerializedName(value = "token_id")
            private String tokenId;

            @SerializedName(value = "user_id")
            private String userId;

            @SerializedName(value = "account_status")
            private String accountStatus;

            public String getTokenId() {
                return tokenId;
            }

            public void setTokenId(String tokenId) {
                this.tokenId = tokenId;
            }

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

        }

        public class PersonalInfo {

            @SerializedName(value = "first_name")
            private String firstName;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

        }

    }
}
