package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Set;

public class PlaceAdvertRequest {

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
              "areas": [1],
              "business_types": [1],
              "audience_types": [1]
            },
            "schedule_info": {
              "start_date": "2017-03-21",
              "end_date": "2017-03-21",
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
        private Targeting targetInfo;

        @SerializedName("schedule_info")
        @Expose
        private ScheduleInfo scheduleInfo;

        @SerializedName("payment_info")
        @Expose
        private PaymentInfo paymentInfo;

        @SerializedName("resources_info")
        @Expose
        private Set<ResourcesInfo> resourcesInfo = null;

        @SerializedName("text_info")
        @Expose
        private Set<TextInfo> textInfo = null;

        public BasicInfo getBasicInfo() {
            return basicInfo;
        }

        public void setBasicInfo(BasicInfo basicInfo) {
            this.basicInfo = basicInfo;
        }

        public Targeting getTargetInfo() {
            return targetInfo;
        }

        public void setTargetInfo(Targeting targetInfo) {
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

        public class BasicInfo {

            @SerializedName("notifications")
            @Expose
            private Boolean notifications;

            @SerializedName("campaign_id")
            @Expose
            private int campaignId = 0; //new campaigns are 0 by default, edited campaigns have an ID

            @SerializedName("campaign_name")
            @Expose
            private String campaignName;

            @SerializedName("layout_type")
            @Expose
            private String layoutType;

            @SerializedName("advert_length")
            @Expose
            private Integer advertLength;

            public String getCampaignName() {
                return campaignName;
            }

            public void setCampaignName(String campaignName) {
                this.campaignName = campaignName;
            }

            public Integer getAdvertLength() {
                return advertLength;
            }

            public void setAdvertLength(Integer advertLength) {
                this.advertLength = advertLength;
            }

            public Boolean getNotifications() {
                return notifications;
            }

            public void setNotifications(Boolean notifications) {
                this.notifications = notifications;
            }

            public String getLayoutType() {
                return layoutType;
            }

            public void setLayoutType(String layoutType) {
                this.layoutType = layoutType;
            }

            public int getCampaignId() {
                return campaignId;
            }

            public void setCampaignId(int campaignId) {
                this.campaignId = campaignId;
            }

        }

        public class Targeting {

            @SerializedName("target_screen_codes")
            @Expose
            private Set<String> targetScreenCodes = null;

            @SerializedName("areas")
            @Expose
            private Set<Integer> areas = null;

            @SerializedName("business_types")
            @Expose
            private Set<Integer> businessTypes = null;

            @SerializedName("audience_types")
            @Expose
            private Set<Integer> audienceTypes = null;

            public Set<String> getTargetScreenCodes() {
                return targetScreenCodes;
            }

            public void setTargetScreenCodes(Set<String> targetScreenCodes) {
                this.targetScreenCodes = targetScreenCodes;
            }

            public Set<Integer> getAreas() {
                return areas;
            }

            public void setAreas(Set<Integer> areas) {
                this.areas = areas;
            }

            public Set<Integer> getBusinessTypes() {
                return businessTypes;
            }

            public void setBusinessTypes(Set<Integer> businessTypes) {
                this.businessTypes = businessTypes;
            }

            public Set<Integer> getAudienceTypes() {
                return audienceTypes;
            }

            public void setAudienceTypes(Set<Integer> audienceTypes) {
                this.audienceTypes = audienceTypes;
            }

        }

        public class ScheduleInfo {

            @SerializedName("start_date")
            @Expose
            private String startDate;
            @SerializedName("end_date")
            @Expose
            private String endDate;

            @SerializedName("time_slots")
            @Expose
            private Set<TimeSlot> timeSlots;

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

        public class PaymentInfo {

            @SerializedName("payment_method")
            @Expose
            private String paymentMethod;
            @SerializedName("account_number")
            @Expose
            private String accountNumber;

            public String getPaymentMethod() {
                return paymentMethod;
            }

            public void setPaymentMethod(String paymentMethod) {
                this.paymentMethod = paymentMethod;
            }

            public String getAccountNumber() {
                return accountNumber;
            }

            public void setAccountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
            }

        }

        public class ResourcesInfo {

            @SerializedName("region")
            @Expose
            private String region;

            @SerializedName("upload_id")
            @Expose
            private String uploadId;

            @SerializedName("sequence")
            @Expose
            private Integer sequence;

            public String getUploadId() {
                return uploadId;
            }

            public void setUploadId(String uploadId) {
                this.uploadId = uploadId;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public Integer getSequence() {
                return sequence;
            }

            public void setSequence(Integer sequence) {
                this.sequence = sequence;
            }

        }

        public class TextInfo {

            @SerializedName("text")
            @Expose
            private String text;
            @SerializedName("type")
            @Expose
            private String type;

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

        }
    }
}
