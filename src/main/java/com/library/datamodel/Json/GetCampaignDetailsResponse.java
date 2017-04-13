package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GetCampaignDetailsResponse {

    /*
        ISIAH 45:11 - LIVING BIBLE / KJV
    
        {
            "success": true,
            "data": {
              "basic_info": {
                "notifications": true,
                "campaign_name": "MamboPay launch",
                "layout_type": "3SPLIT",
                "advert_length": 60
              },
              "target_info": {
                "target_screen_codes": [],
                "areas": [
                  {
                    "id": 3,
                    "name": "Namuwongo",
                    "audience_count": 8976,
                    "screen_count": 124
                  }
                ],
                "business_types": [
                  {
                    "id": 4,
                    "name": "Sports Houses",
                    "audience_count": 14570,
                    "screen_count": 99
                  }
                ],
                "audience_types": [ // for audience type - ALL, You will get ->  [{"id":1, "name":"ALL", "audience_count":747333374833, "screen_count":2345432341}]
                  {
                    "id": 4,
                    "name": "Boda-boda Riders",
                    "audience_count": 594330,
                    "screen_count": 609
                  }
                ]
              },
              "schedule_info": {
                "start_date": "2017-03-16",
                "end_date": "2017-03-30",
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
                  },
                  {
                    "name": "FREEBIE",
                    "preferred_hour": -1,
                    "frequency": -1,
                    "days": [3, 5]
                  }
                ]
              },
              "payment_info": {
                "value_store": "MTNMOMO_UG",
                "account_number": "0787399351"
              },
              "resources_info": [
                {
                  "region": "RIGHT",
                  "upload_id": "213231",
                  "sequence": 1,
                  "preview_url": "http://67.205.155.195/seyeya/p.jpg",
                  "upload_name": "my image",
                  "type": "IMAGE"
                },
                {
                  "region": "RIGHT",
                  "upload_id": "214231",
                  "sequence": 2,
                  "preview_url": "http://67.205.155.195/seyeya/c.jpg",
                  "upload_name": "intro tvc",
                  "type": "VIDEO"
                }
              ],
              "text_info": [
                {
                  "text": "JGifts",
                  "type": "HEADER_TEXT"
                },
                {
                  "text": "Order for a personalised gift. Call 0787399351",
                  "type": "SCROLL_TEXT"
                }
              ],
              "campaign_stats": {
                "display_count": 999,
                "target_reach": {
                  "amount": 509000,
                  "audience_count": 49099,
                  "screen_count": 1898
                },
                "potential_reach": {
                  "amount": 1500000,
                  "audience_count": 50000,
                  "screen_count": 9100
                }
              }
            }
        }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    public GetCampaignDetailsResponse(boolean success) {
        this.success = success;
    }

    public GetCampaignDetailsResponse() {
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
        private Set<TextInfo> textInfo = new HashSet<>();

        @SerializedName("campaign_stats")
        @Expose
        private CampaignStats campaignStats;

        @SerializedName("campaign_status")
        @Expose
        private CampaignStatus campaignStatus;

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

        public CampaignStats getCampaignStats() {
            return campaignStats;
        }

        public void setCampaignStats(CampaignStats campaignStats) {
            this.campaignStats = campaignStats;
        }

        public CampaignStatus getCampaignStatus() {
            return campaignStatus;
        }

        public void setCampaignStatus(CampaignStatus campaignStatus) {
            this.campaignStatus = campaignStatus;
        }

        public class TargetInfo {

            @SerializedName("target_screen_codes")
            @Expose
            private Set<ScreenData> targetScreenCodes = new HashSet<>();

            @SerializedName("areas")
            @Expose
            private Set<MyTypes> areas = new HashSet<>();

            @SerializedName("business_types")
            @Expose
            private Set<MyTypes> businessTypes = new HashSet<>();

            @SerializedName("audience_types")
            @Expose
            private Set<MyTypes> audienceTypes = new HashSet<>();

            public Set<ScreenData> getTargetScreenCodes() {
                return targetScreenCodes;
            }

            public void setTargetScreenCodes(Set<ScreenData> targetScreenCodes) {
                this.targetScreenCodes = targetScreenCodes;
            }

            public Set<MyTypes> getAreas() {
                return areas;
            }

            public void setAreas(Set<MyTypes> areas) {
                this.areas = areas;
            }

            public Set<MyTypes> getBusinessTypes() {
                return businessTypes;
            }

            public void setBusinessTypes(Set<MyTypes> businessTypes) {
                this.businessTypes = businessTypes;
            }

            public Set<MyTypes> getAudienceTypes() {
                return audienceTypes;
            }

            public void setAudienceTypes(Set<MyTypes> audienceTypes) {
                this.audienceTypes = audienceTypes;
            }

        }

        public class CampaignStatus {

            @SerializedName("status")
            @Expose
            private String status;

            @SerializedName("description")
            @Expose
            private String description;

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

        }

    }
}
