package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class createTerminalRequest implements JsonDataModel {

    /*
    
        {
            "method": "CREATE_NEW_TERMINAL",
            "credentials": {
              "app_id": "ADER6864g25644777",
              "api_password": "sLA84009rw2",
              "token_id": "84938urj9338203u349393"
            },
            "params": {

              "terminal_id":233097221599994,
              "terminal_name":"Second Terminal",
              "terminal_description":"This is my test terminal, original - chill out!!",
              "task_idx":2345674567,
              "task_idy":2345674568,
              "task_idz":2345674569,
              "longitude":34567999989,
              "latitude":23456776543
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

        @SerializedName(value = "terminal_id")
        private String terminalId;

        @SerializedName(value = "terminal_name")
        private String terminalName;

        @SerializedName(value = "terminal_description")
        private String terminalDescription;

        @SerializedName(value = "task_idx")
        private int taskIdX;

        @SerializedName(value = "task_idy")
        private int taskIdY;

        @SerializedName(value = "task_idz")
        private int taskIdZ;

        @SerializedName(value = "latitude")
        private double latitude;

        @SerializedName(value = "longitude")
        private double longitude;

        public String getTerminalId() {
            return terminalId;
        }

        public void setTerminalId(String terminalId) {
            this.terminalId = terminalId;
        }

        public String getTerminalName() {
            return terminalName;
        }

        public void setTerminalName(String terminalName) {
            this.terminalName = terminalName;
        }

        public String getTerminalDescription() {
            return terminalDescription;
        }

        public void setTerminalDescription(String terminalDescription) {
            this.terminalDescription = terminalDescription;
        }

        public int getTaskIdX() {
            return taskIdX;
        }

        public void setTaskIdX(int taskIdX) {
            this.taskIdX = taskIdX;
        }

        public int getTaskIdY() {
            return taskIdY;
        }

        public void setTaskIdY(int taskIdY) {
            this.taskIdY = taskIdY;
        }

        public int getTaskIdZ() {
            return taskIdZ;
        }

        public void setTaskIdZ(int taskIdZ) {
            this.taskIdZ = taskIdZ;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }
    }
}
