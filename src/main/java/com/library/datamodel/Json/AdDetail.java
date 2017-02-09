package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdDetail {

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
        private List<Resource> resources = null;

        @SerializedName("text")
        @Expose
        private List<Text> text = null;

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

        public List<Resource> getResources() {
            return resources;
        }

        public void setResources(List<Resource> resources) {
            this.resources = resources;
        }

        public List<Text> getText() {
            return text;
        }

        public void setText(List<Text> text) {
            this.text = text;
        }

        public class BasicInfo {

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

            @SerializedName("target_screen_code")
            @Expose
            private String targetScreenCode;

            @SerializedName("areas")
            @Expose
            private List<Integer> areas = null;

            @SerializedName("location_types")
            @Expose
            private List<Integer> locationTypes = null;

            @SerializedName("audience_types")
            @Expose
            private List<Integer> audienceTypes = null;

            public String getTargetScreenCode() {
                return targetScreenCode;
            }

            public void setTargetScreenCode(String targetScreenCode) {
                this.targetScreenCode = targetScreenCode;
            }

            public List<Integer> getAreas() {
                return areas;
            }

            public void setAreas(List<Integer> areas) {
                this.areas = areas;
            }

            public List<Integer> getLocationTypes() {
                return locationTypes;
            }

            public void setLocationTypes(List<Integer> locationTypes) {
                this.locationTypes = locationTypes;
            }

            public List<Integer> getAudienceTypes() {
                return audienceTypes;
            }

            public void setAudienceTypes(List<Integer> audienceTypes) {
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
            private List<Schedule> schedule;

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

            public List<Schedule> getSchedule() {
                return schedule;
            }

            public void setSchedule(List<Schedule> schedule) {
                this.schedule = schedule;
            }

            public class Schedule {

                @SerializedName("time")
                @Expose
                private Time time;
                @SerializedName("day")
                @Expose
                private List<Integer> day;

                public Time getTime() {
                    return time;
                }

                public void setTime(Time time) {
                    this.time = time;
                }

                public List<Integer> getDay() {
                    return day;
                }

                public void setDay(List<Integer> day) {
                    this.day = day;
                }

                public class Time {

                    @SerializedName("slot")
                    @Expose
                    private String slot;
                    @SerializedName("preferred")
                    @Expose
                    private Integer preferred;

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
