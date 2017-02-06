/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author smallgod
 */
public class DBSaveResponse {
    
    /*
    
    {
        "success": true,
        "detail": {
            "entity_id": [987654,3453222]
        },
        "error": {
            "message": "",
            "description": ""
        }
        }
    */

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("detail")
    @Expose
    private Detail detail;
    @SerializedName("error")
    @Expose
    private Error error;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public class Detail {

        @SerializedName("entity_id")
        @Expose
        private List<Long> entityId = null;

        public List<Long> getEntityId() {
            return entityId;
        }

        public void setEntityId(List<Long> entityId) {
            this.entityId = entityId;
        }

    }

    public class Error {

        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("description")
        @Expose
        private String description;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }

}
