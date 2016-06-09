package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class WakeupResponse implements JsonDataModel {

    @SerializedName(value = "device_id")
    private String deviceID;
    
    @SerializedName(value = "unit_status")
    private String unitStatus;

    public String getDeviceID() {
        return deviceID;
    }
    

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(String unitStatus) {
        this.unitStatus = unitStatus;
    }

}
