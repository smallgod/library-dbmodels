package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GetAdPriceRequest {

    /*
        ISIAH 45:11 - LIVING BIBLE / KJV
    
        // Get ad length amount
        //we start with amount - 0 & audience reach - 0
        //this request is sent both at adding a parameter or at its removal
        {
          "method": "GET_PRICE",
          "params": {
            "ad_length":60, //default is: 0 seconds
            "layout_type": "3SPLIT",//default is: TEXT_ONLY
            "target_screen_codes": ["SC093302", "SD345632"], //default is: []
            "areas": [8, 7, 6], //default is []
             "location_types": [7, 9, 3], //default is []
             "audience_types": [2, 4], //default is []
             "start_date": "2017-03-06", //default is today, 2017-03-05
             "end_date": "2017-03-11", //default is today, 2017-03-05
             "slots":[                // default is [], I will use freebie
                {
                  "name":"PRIME",
                  "frequency":2, //default is 1
                  "days":[1,2,5] //default is all days i.e. [1,2,3,4,5,6,7]

                },
                {
                  "name":"RUSHHOUR",
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
        private Set<Integer> areas = new HashSet<>();

        @SerializedName("location_types")
        @Expose
        private Set<Integer> locationTypes = new HashSet<>();

        @SerializedName("audience_types")
        @Expose
        private Set<Integer> audienceTypes = new HashSet<>();

        @SerializedName("start_date")
        @Expose
        private String startDate;
        @SerializedName("end_date")
        @Expose
        private String endDate;

        @SerializedName("slots")
        @Expose
        private Set<Slot> slots = new HashSet<>();

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

        public Set<Slot> getSlots() {
            return slots;
        }

        public void setSlots(Set<Slot> slots) {
            this.slots = slots;
        }

        public class Slot {

            @SerializedName("name")
            @Expose
            private String name;

            @SerializedName("frequency")
            @Expose
            private Integer frequency = 1;//number of times we can play this ad within this time name

            @SerializedName("days")
            @Expose
            private Set<Integer> days;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getFrequency() {
                return frequency;
            }

            public void setFrequency(Integer frequency) {
                this.frequency = frequency;
            }

            public Set<Integer> getDays() {
                return days;
            }

            public void setDays(Set<Integer> days) {
                this.days = days;
            }

        }
    }
}
