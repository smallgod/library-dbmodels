package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
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

        @SerializedName(value = "location_info")
        private LocationInfo locationInfo;

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

        @SerializedName("audience_types")
        @Expose
        private Set<Integer> audienceTypes = null;

        @SerializedName("location_services")
        @Expose
        private Set<Integer> locationServices = null;

        public Params() {
        }

    }

}
