package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class CampaignRequest {

    /*
        ISIAH 45:11 - LIVING BIBLE / KJV
    
        {
          "method": "PLACE_ADVERT",
          "credentials": {
            "app_id": "ADER6864g25644777",
            "api_password": "sLA84009dfewwrw2",
            "token_id": "84938urj9338203u349393"
          },
          "params": {
            "basic_info": {
              "notifications": true,
              "campaign_id": 3455843,
              "campaign_name": "Plumber Samuel #1",
              "layout_type": "3SPLIT",
              "advert_length": 60
            },
            "target_info": {
              "target_screen_codes": [],
              "areas": ["namuwongo", "Kisasi"],
              "business_types": [1],
              "audience_types": [1],
    
    
                ///just added///
    
                "audience_xtics":{
                  "gender":[],
                  "age":[]
                }
    
                /// added up-to here ///
    
    
            },
            "schedule_info": {
              "start_date": "2017-03-21",
              "end_date": "2017-03-21",
              "schedule_type":"LATER",
              "time_slots": [
                {
                  "name": "EARLYBIRD",
                  "preferred_hour": -1,
                  "frequency": -1,
                  "days": [4, 5]
                },
                {
                  "name": "RUSHHOUR",
                  "preferred_hour": 19,
                  "frequency": 2,
                  "days": [3, 5]
                }
              ]
            },
            "payment_info": {
              "payment_method": "MTNMOMO_UG",
              "account_number": "0771111119"
            },
            "resources_info": [
              {
                "region": "RIGHT",
                "upload_id": "1490118191421_RestaurantV (9).jpg",
                "sequence": 1
              }
            ],
            "text_info": [
              {
                "textInfo": "Plumber Samuel 0732 888 888",
                "type": "SCROLL_TEXT"
              },
              {
                "textInfo": "We fix your pipes properly - Satisfaction guaranteed, or your money back.  Phone Samuel.",
                "type": "HEADER_TEXT"
              }
            ]
          }
        }
    
     */
    @SerializedName("credentials")
    @Expose
    private Credentials credentials;

    @SerializedName("method")
    @Expose
    private String method;

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

        @SerializedName("basic_info")
        @Expose
        private BasicInfo basicInfo;

        @SerializedName("target_info")
        @Expose
        private TargetInfo targetInfo;

        @SerializedName("schedule_info")
        @Expose
        private ScheduleInfo scheduleInfo;

        @SerializedName("payment_info")
        @Expose
        private PaymentInfo paymentInfo;

        @SerializedName("resources_info")
        @Expose
        private Set<ResourcesInfo> resourcesInfo = new HashSet<>();

        @SerializedName("text_info")
        @Expose
        private Set<TextInfo> textInfo = null;

        public BasicInfo getBasicInfo() {
            return basicInfo;
        }

        public void setBasicInfo(BasicInfo basicInfo) {
            this.basicInfo = basicInfo;
        }

        public TargetInfo getTargetInfo() {
            return targetInfo;
        }

        public void setTargetInfo(TargetInfo targetInfo) {
            this.targetInfo = targetInfo;
        }

        public ScheduleInfo getScheduleInfo() {
            return scheduleInfo;
        }

        public void setScheduleInfo(ScheduleInfo scheduleInfo) {
            this.scheduleInfo = scheduleInfo;
        }

        public PaymentInfo getPaymentInfo() {
            return paymentInfo;
        }

        public void setPaymentInfo(PaymentInfo paymentInfo) {
            this.paymentInfo = paymentInfo;
        }

        public Set<ResourcesInfo> getResourcesInfo() {
            return resourcesInfo;
        }

        public void setResourcesInfo(Set<ResourcesInfo> resourcesInfo) {
            this.resourcesInfo = resourcesInfo;
        }

        public Set<TextInfo> getTextInfo() {
            return textInfo;
        }

        public void setTextInfo(Set<TextInfo> textInfo) {
            this.textInfo = textInfo;
        }

        public class TargetInfo {

            @SerializedName("target_screen_codes")
            @Expose
            private Set<String> targetScreenCodes = null;

            @SerializedName("areas")
            @Expose
            private Set<String> areas = null;

            @SerializedName("business_types")
            @Expose
            private Set<String> businessTypes = null;

            @SerializedName("audience_types")
            @Expose
            private Set<String> audienceTypes = null;

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

        }

    }
}
