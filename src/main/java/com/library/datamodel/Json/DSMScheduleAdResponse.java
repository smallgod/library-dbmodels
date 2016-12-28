package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;

public class DSMScheduleAdResponse {

    /*
    
    {
        ​"task_id"     : "74983602",
        ​"status"      : "LOGGED",
        ​"description" : "under processing"
    }
    
     */
    @SerializedName(value = "task_id")
    private int taskId;

    @SerializedName(value = "status")
    private String status;

    @SerializedName(value = "description")
    private String statusDescription;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

}
