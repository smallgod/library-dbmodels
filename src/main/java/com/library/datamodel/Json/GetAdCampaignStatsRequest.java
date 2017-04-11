package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GetAdCampaignStatsRequest {

    /*
        ISIAH 45:11 - LIVING BIBLE / KJV
    
        // Get ad length amount
        //we start with amount - 0 & audience reach - 0
        //this request is sent both at adding a parameter or at its removal
        {
          "method": "GET_CAMPAIGN_STATS",
          "credentials":{
            "app_id":"ADER6864g25644777", //subscription_id
            "api_password":"sLA84009rw2",
            "token_id": "y0lhfdety90jfdsa223sxbrj9" //25-xter optional field, if user not yet logged in, not mandatory
          },
          "params": {
            "ad_length":60, //default is: 0 seconds
            "layout_type": "3SPLIT",//default is: TEXT_ONLY
            "target_screen_codes": ["SC093302", "SD345632"], //default is: []
            "areas": [8, 7, 6], //default is []
             "business_types": [7, 9, 3], //default is []
             "audience_types": [2, 4], //default is []
             "start_date": "2017-03-06", //default is today, 2017-03-05
             "end_date": "2017-03-11", //default is today, 2017-03-05
             "time_slots":[                // default is [], I will use freebie
                {
                  "name":"PRIME",
                  "preferred_hour":-1
                  "frequency":2, //default is 1
                  "days":[1,2,5] //default is all days i.e. [1,2,3,4,5,6,7]

                },
                {
                  "name":"RUSHHOUR",
                  "preferred_hour":-1
                  "frequency":1,
                  "days":[4]

                }
             ]
          }
        }
    
     */
    @SerializedName("method")
    @Expose
    private String method;
    
    @SerializedName("credentials")
    @Expose
    private Credentials credentials;
    
    @SerializedName("params")
    @Expose
    private Params params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

        @SerializedName("ad_length")
        @Expose
        private int adLength;

        @SerializedName("layout_type")
        @Expose
        private String layoutType;

        @SerializedName("target_screen_codes")
        @Expose
        private Set<String> targetScreenCodes = new HashSet<>();

        @SerializedName("areas")
        @Expose
        private Set<String> areas = new HashSet<>();

        @SerializedName("business_types")
        @Expose
        private Set<String> businessTypes = new HashSet<>();

        @SerializedName("audience_types")
        @Expose
        private Set<String> audienceTypes = new HashSet<>();

        @SerializedName("start_date")
        @Expose
        private String startDate;
        @SerializedName("end_date")
        @Expose
        private String endDate;

        @SerializedName("slots") //rename back to 'time_slots'
        @Expose
        private Set<TimeSlot> timeSlots = new HashSet<>();

        public int getAdLength() {
            return adLength;
        }

        public void setAdLength(int adLength) {
            this.adLength = adLength;
        }

        public String getLayoutType() {
            return layoutType;
        }

        public void setLayoutType(String layoutType) {
            this.layoutType = layoutType;
        }

        public Set<String> getTargetScreenCodes() {
            return targetScreenCodes;
        }

        public void setTargetScreenCodes(Set<String> targetScreenCodes) {
            this.targetScreenCodes = targetScreenCodes;
        }

        public Set<String> getAreas() {
            return areas;
        }

        public void setAreas(Set<String> areas) {
            this.areas = areas;
        }

        public Set<String> getBusinessTypes() {
            return businessTypes;
        }

        public void setBusinessTypes(Set<String> businessTypes) {
            this.businessTypes = businessTypes;
        }

        public Set<String> getAudienceTypes() {
            return audienceTypes;
        }

        public void setAudienceTypes(Set<String> audienceTypes) {
            this.audienceTypes = audienceTypes;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public Set<TimeSlot> getTimeSlots() {
            return timeSlots;
        }

        public void setTimeSlots(Set<TimeSlot> timeSlots) {
            this.timeSlots = timeSlots;
        }

    }

    
}
