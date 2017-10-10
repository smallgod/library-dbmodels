package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.HashSet;
import java.util.Set;

public class CreateLocationRequest implements JsonDataModel {

    /*
    
    method: APP_CONFIGS.CREATE_NEW_LOCATION,
      credentials: (new UtilityService).getCredentials(),
      params: {
        location_info: {
          phone_contact: <string>(mainFormValue.locationInfo.phoneContact),
          business_name: <string>(mainFormValue.locationInfo.businessName),
          screens: (<number>(mainFormValue.locationInfo.screens)).valueOf()
        },
        audience_types: checkedAudienceIds,
        location_services: checkedLocationIds
      }
    
    
    {
        "method": "CREATE_NEW_LOCATION",
        "credentials": {
          "app_id": "ADER6864g25644777",
          "api_password": "sLA84009rw2",
          "token_id": "84938urj9338203u349393"
        },
        "params": {
          "action":"create", //update
          "location_info": {
              "phone_contact": "0774983602",
              "secondary_contact": "0774999999",
              "business_name": "Super Bet", //known Business name
              "registered_name": "0774983602", //official Business registered name
              "total_screens": 3,
              "plot_num": "KV 16",
              "building_name": "Telecom House",
              "street_name": "Kaciru road",
              "sub_area_2": "",
              "sub_area_1": "",
              "area": "Kyanja",
              "division": "Nakawa",
              "district": "Kampala",
              "state": "Uganda",
              "country": "Uganda"
          },
          "income_status": {

              "ultra_low": 0,
              "low": 1,
              "average": 1,
              "high": 3,
              "ultra_high": 5
          }, 

          "gender": {

              "male": 8,
              "female": 2
          }, 

          "audience_types": [5,6],

          "location_services": [2,8,3], 

          "audience_language": { //out of 10 - but these can 0verlap i.e. 10 out of 10 might speak all the languages listed

              "english": 10,
              "luganda": 10,
              "swahili": 5
          },

          "age": {

              "under_12": 0,
              "13_to_17": 1,
              "18_to_24": 2,
              "25_to_39": 1,
              "40_to_55": 3,
              "above_56": 3

          },
          "business_hours": {

              "opens": {

                  "monday": "0830",
                  "tuesday": "1300",
                  "wednesday": "1200",
                  "thursday": "1200",
                  "friday": "1045",
                  "saturday": "0800",
                  "sunday": "0800",
                  "holidays":"1400",
                  "today":"closed" //incase place is locked on given day for some reason - otherwise "open" - at end of day, automate to change this value to "open". You can have "closed" running for 7 days straight incase place is closed for those 7 days
              },
              "closes": {

                  "monday": "0830",
                  "tuesday": "1300",
                  "wednesday": "1200",
                  "thursday": "1200",
                  "friday": "1045",
                  "saturday": "0800",
                  "sunday": "0800",
                  "holidays":"2330",
                  "today":"closed"
              }
          }
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
        @SerializedName(value = "action")
        private String action; // CREATE | UPDATE

        @Expose
        @SerializedName(value = "location_info")
        private LocationInfo locationInfo;

        @SerializedName("audience_types")
        @Expose
        private Set<Integer> audienceTypes = new HashSet<>();

        @SerializedName("location_services")
        @Expose
        private Set<Integer> locationServices = new HashSet<>();

        @Expose
        @SerializedName(value = "income_status")
        private XticsIncomeStatus incomeStatus;

        @Expose
        @SerializedName(value = "gender")
        private XticsGender gender;

        @Expose
        @SerializedName(value = "audience_language")
        private XticsLanguage language;

        @Expose
        @SerializedName(value = "age")
        private XticsAge age;

        @Expose
        @SerializedName(value = "business_hours")
        private XticsBusinessHours businessHours;

        public LocationInfo getLocationInfo() {
            return locationInfo;
        }

        public void setLocationInfo(LocationInfo locationInfo) {
            this.locationInfo = locationInfo;
        }

        public Set<Integer> getAudienceTypes() {
            return audienceTypes;
        }

        public void setAudienceTypes(Set<Integer> audienceTypes) {
            this.audienceTypes = audienceTypes;
        }

        public Set<Integer> getLocationServices() {
            return locationServices;
        }

        public void setLocationServices(Set<Integer> locationServices) {
            this.locationServices = locationServices;
        }

        public XticsIncomeStatus getIncomeStatus() {
            return incomeStatus;
        }

        public void setIncomeStatus(XticsIncomeStatus incomeStatus) {
            this.incomeStatus = incomeStatus;
        }

        public XticsGender getGender() {
            return gender;
        }

        public void setGender(XticsGender gender) {
            this.gender = gender;
        }

        public XticsLanguage getLanguage() {
            return language;
        }

        public void setLanguage(XticsLanguage language) {
            this.language = language;
        }

        public XticsAge getAge() {
            return age;
        }

        public void setAge(XticsAge age) {
            this.age = age;
        }

        public XticsBusinessHours getBusinessHours() {
            return businessHours;
        }

        public void setBusinessHours(XticsBusinessHours businessHours) {
            this.businessHours = businessHours;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }
    }
}
