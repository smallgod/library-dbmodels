package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class AdScheduleRequest implements JsonDataModel {

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

        @SerializedName(value = "ad_text")
        private String adText;

        @SerializedName(value = "ad_target")
        private String adTarget;
        
        @SerializedName(value = "payment_channel")
        private String paymentChannel;
        
        @SerializedName(value = "ad_owner")
        private String adOwnerId;
        
        @SerializedName(value = "ad_schedule")
        private String adSchedule;

        public String getAdText() {
            return adText;
        }

        public void setAdText(String adText) {
            this.adText = adText;
        }

        public String getAdTarget() {
            return adTarget;
        }

        public void setAdTarget(String adTarget) {
            this.adTarget = adTarget;
        }

        public String getPaymentChannel() {
            return paymentChannel;
        }

        public void setPaymentChannel(String paymentChannel) {
            this.paymentChannel = paymentChannel;
        }

        public String getAdOwnerId() {
            return adOwnerId;
        }

        public void setAdOwnerId(String adOwnerId) {
            this.adOwnerId = adOwnerId;
        }

        public String getAdSchedule() {
            return adSchedule;
        }

        public void setAdSchedule(String adSchedule) {
            this.adSchedule = adSchedule;
        }
        
    }
}
