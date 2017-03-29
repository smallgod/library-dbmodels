package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Set;

public class AdDetail {

    /*
        ISIAH 45:11 - LIVING BIBLE / KJV
    
        {
        "method": "PLACE_AD",
        "params": {
            "basic_info": {
                "phone_contact": "774983602", //for logged in users, this is the user id otherwise the primary contact
                "campaign_name": "Jgifts new Campaign",
                "advert_length": 10,
                "notifications": true,
                "layout_type": "3SPLIT"
            },
            "targeting": {
                "target_screen_codes": "",
                "areas": [
                    8,
                    7,
                    6,
                    4,
                    5,
                    3
                ],
                "location_types": [
                    7,
                    9,
                    3,
                    5,
                    2
                ],
                "audience_types": [
                    2,
                    4,
                    5,
                    9
                ]
            },

            "schedule_info": {
                "start_date": "2017-01-20",
                "end_date": "2017-01-22",
                "schedule": [
                        {
                            "time": {
                                "slot": "EARLY_BIRD",
                                "preferred": 7, //should be -1 incase not set by user, Hour preferred to play program
                                "frequency":3 //number of times we can play this ad within this time slot
                            },
                            "days": [
                                1, //1 for first days of week - Monday
                                4,
                                7,
                                6
                            ]
                        },
                        {
                            "time": {
                                "slot": "PRIME",
                                "preferred": 21,
                                "frequency":3 //number of times we can play this ad within this time slot
                            },
                            "days": [
                                5,
                                6,
                                7
                            ]
                        }
                    ]
                },

                "payment_info": {
                    "payment_method": "MTNMOMO_UG",
                    "account_number": "07888788878"
                },
                "resources": [
                    {
                        "upload_id": "1486059288818_97354630323904.jpg",
                        "region": "RIGHT",
                        "sequence": 2
                    },
                    {
                        "upload_id": "1486059288839_97354630322880.mp4",
                        "region": "RIGHT",
                        "sequence": 1
                    },
                    {
                        "upload_id": "1486115397494_97354630325888.vob",
                        "region": "MIDDLE",
                        "sequence": 1
                    }
                ],
                "text": [
                    {
                        "text": "This is scrolling text here..",
                        "type": "SCROLL_TEXT"
                    },
                    {
                        "text": "This is Header text",
                        "type": "HEADER_TEXT"
                    }
                ]
            }
        }
    
     */
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

    public class Params {

        @SerializedName("basic_info")
        @Expose
        private BasicInfo basicInfo;

        @SerializedName("targeting")
        @Expose
        private Targeting targeting;

        @SerializedName("schedule_info")
        @Expose
        private ScheduleInfo scheduleInfo;

        @SerializedName("payment_info")
        @Expose
        private PaymentInfo paymentInfo;

        @SerializedName("resources")
        @Expose
        private Set<Resource> resources = null;

        @SerializedName("text")
        @Expose
        private Set<Text> text = null;

        public BasicInfo getBasicInfo() {
            return basicInfo;
        }

        public void setBasicInfo(BasicInfo basicInfo) {
            this.basicInfo = basicInfo;
        }

        public Targeting getTargeting() {
            return targeting;
        }

        public void setTargeting(Targeting targeting) {
            this.targeting = targeting;
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

        public Set<Resource> getResources() {
            return resources;
        }

        public void setResources(Set<Resource> resources) {
            this.resources = resources;
        }

        public Set<Text> getText() {
            return text;
        }

        public void setText(Set<Text> text) {
            this.text = text;
        }

        public class BasicInfo {

            ////for logged in users, this is the user id otherwise the primary contact
            @SerializedName("phone_contact")
            @Expose
            private String phoneContact;

            @SerializedName("campaign_name")
            @Expose
            private String campaignName;

            @SerializedName("advert_length")
            @Expose
            private Integer advertLength;

            @SerializedName("notifications")
            @Expose
            private Boolean notifications;

            @SerializedName("layout_type")
            @Expose
            private String layoutType;

            public String getPhoneContact() {
                return phoneContact;
            }

            public void setPhoneContact(String phoneContact) {
                this.phoneContact = phoneContact;
            }

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

        }

        public class Targeting {

            @SerializedName("target_screen_codes")
            @Expose
            private Set<String> targetScreenCodes = null;

            @SerializedName("areas")
            @Expose
            private Set<Integer> areas = null;

            @SerializedName("location_types")
            @Expose
            private Set<Integer> locationTypes = null;

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

            public Set<Integer> getLocationTypes() {
                return locationTypes;
            }

            public void setLocationTypes(Set<Integer> locationTypes) {
                this.locationTypes = locationTypes;
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
            @SerializedName("schedule")
            @Expose
            private Set<Schedule> schedule;

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

            public Set<Schedule> getSchedule() {
                return schedule;
            }

            public void setSchedule(Set<Schedule> schedule) {
                this.schedule = schedule;
            }

            public class Schedule {

                @SerializedName("time")
                @Expose
                private Time time;
                @SerializedName("days")
                @Expose
                private Set<Integer> days;

                public Time getTime() {
                    return time;
                }

                public void setTime(Time time) {
                    this.time = time;
                }

                /**
                 * Get all the days to advertise on e.g [1,3,6,7] means [Monday,
                 * Wednesday, Saturday & Saturday]
                 *
                 * @return
                 */
                public Set<Integer> getDays() {
                    return days;
                }

                public void setDays(Set<Integer> days) {
                    this.days = days;
                }

                public class Time {

                    @SerializedName("slot")
                    @Expose
                    private String slot;

                    @SerializedName("preferred")
                    @Expose
                    private Integer preferred;

                    @SerializedName("frequency")
                    @Expose
                    private Integer frequency = 1;//number of times we can play this ad within this time slot

                    public String getSlot() {
                        return slot;
                    }

                    public void setSlot(String slot) {
                        this.slot = slot;
                    }

                    public Integer getPreferred() {
                        return preferred;
                    }

                    public void setPreferred(Integer preferred) {
                        this.preferred = preferred;
                    }

                    public Integer getFrequency() {
                        return frequency;
                    }

                    public void setFrequency(Integer frequency) {
                        this.frequency = frequency;
                    }

                }

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

        public class Resource {

            @SerializedName("upload_id")
            @Expose
            private String uploadId;
            @SerializedName("region")
            @Expose
            private String region;
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

        public class Text {

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
