package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class WakeupRequest implements JsonDataModel {

    //{"method":"WAKEUP_REQUEST","params":{"device_id":"4567K"}}
    @SerializedName(value = "method")
    private String methodName;

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

    public class Params {

        @SerializedName(value = "device_id")
        private String deviceID;

        public String getDeviceID() {
            return deviceID;
        }

        public void setDeviceID(String deviceID) {
            this.deviceID = deviceID;
        }
    }
}
