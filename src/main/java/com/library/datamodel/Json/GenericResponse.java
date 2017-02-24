package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class GenericResponse implements JsonDataModel {

    /*
    {
        "success": true,
        "description": "Advert has been scheduled"
    }
     */
    public GenericResponse() {
    }

    @SerializedName(value = "success")
    private boolean success;

    @SerializedName(value = "description")
    private String description;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
