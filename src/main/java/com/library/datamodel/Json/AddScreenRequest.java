package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;

public class AddScreenRequest implements JsonDataModel {

    /*
    
        {
    "method": "ADD_SCREEN",
    "credentials": {
        "app_id": "ADER6864g25644777",
        "api_password": "sLA84009rw2",
        "token_id": "84938urj9338203u349393"
    },
    
    "params": {
        
        "business_id":"TOPB", //BUSINESS/LOC under which this screen is registered
        "screen_info":{

            "vendor_name": "Samsung",
            "screen_height": 1080,
            "screen_width": 1920,
            "placement":"hotel room", //dorm room | main reception | serving tills | 
            "popularity":"most popular", // hardly watched | most popular | not so popular -> popularity in comparison to the rest of screens in this location
            "allow_volume":true,
            "split_screen":"Full Screen", // 2-split | 3-split | full screen | All -> if 3-split/or 2-split is chosen, either/or is by default - if Full Screen is chosen, rest are by default
            "screen_size": "THIRTYTWO",
            "screen_type":"FLAT_LED_TV",//KABUTO_TV | FLAT_LCD_TV | FLAT_LED_TV | KABUTO_MONITOR | FLAT_LCD_MONITOR
            //"business_code":"CKA0091" //will be used to get audTypes, bizTypes, areaCode, businessId, street_name etc
            "is_publish":true,
            "terminal_id":"23456789987654345",
            "extra_1": "",
            "extra_2": ""

        },
        "audience_count": {

            "time_slots":[

                {
                    "slot":"freebie",
                    "days":{
                        "monday":300,
                        "tuesday":50,
                        "wednesday":450,
                        "thursday":890,
                        "friday":844,
                        "saturday":908,
                        "sunday":1098,
                        "holiday":10
                    }
                },
                {
                    "slot":"early_bird",
                    "days":{
                        "monday":300,
                        "tuesday":50,
                        "wednesday":450,
                        "thursday":890,
                        "friday":844,
                        "saturday":908,
                        "sunday":1098,
                        "holiday":10
                    }
                },
                {
                    "slot":"lunch_hour",
                    "days":{
                        "monday":300,
                        "tuesday":50,
                        "wednesday":450,
                        "thursday":890,
                        "friday":844,
                        "saturday":908,
                        "sunday":1098,
                        "holiday":10
                    }
                },
                {
                    "slot":"rush_hour",
                    "days":{
                        "monday":300,
                        "tuesday":50,
                        "wednesday":450,
                        "thursday":890,
                        "friday":844,
                        "saturday":908,
                        "sunday":1098,
                        "holiday":10
                    }
                },
                {
                    "slot":"prime",
                    "days":{
                        "monday":300,
                        "tuesday":50,
                        "wednesday":450,
                        "thursday":890,
                        "friday":844,
                        "saturday":908,
                        "sunday":1098,
                        "holiday":10
                    }
                },
                {
                    "slot":"late_nite",
                    "days":{
                        "monday":300,
                        "tuesday":50,
                        "wednesday":450,
                        "thursday":890,
                        "friday":844,
                        "saturday":908,
                        "sunday":1098,
                        "holiday":10
                    }
                }
            ]
    }
}
    
    
     */
    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "credentials")
    private Credentials credentials;

    @SerializedName(value = "params")
    private Params params;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
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

        @Expose
        @SerializedName(value = "business_id")
        private String businessId;

        @Expose
        @SerializedName(value = "screen_info")
        private ScreenInfo screenInfo;

        @Expose
        @SerializedName(value = "audience_count")
        private AudienceCount audienceCount;

        public ScreenInfo getScreenInfo() {
            return screenInfo;
        }

        public void setScreenInfo(ScreenInfo screenInfo) {
            this.screenInfo = screenInfo;
        }

        public AudienceCount getAudienceCount() {
            return audienceCount;
        }

        public void setAudienceCount(AudienceCount audienceCount) {
            this.audienceCount = audienceCount;
        }

        public String getBusinessId() {
            return businessId;
        }

        public void setBusinessId(String businessId) {
            this.businessId = businessId;
        }

    }

    public class AudienceCount {

        @SerializedName(value = "time_slots")
        private List<TimeSlotsAudienceCount> timeSlots;

        public List<TimeSlotsAudienceCount> getTimeSlots() {
            return timeSlots;
        }

        public void setTimeSlots(List<TimeSlotsAudienceCount> timeSlots) {
            this.timeSlots = timeSlots;
        }

    }
}
