package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class ErrorResponse {

    /*
    
        {
            "success": true,
            "data": {
              "user_id": "774983602", 
              "otp":5634, // OTP sent to client, used to verify account (so no need to call server again if user enters)
              "account_status": "PENDING_OTP", // |   REGISTERED
              "description": "New client accont created, pending OTP verification"
            }
        }
    
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Data data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private ErrorResponse(boolean success) {
        this.success = success;
    }

    public ErrorResponse() { //init success to False for all error responses
        this(Boolean.FALSE);
    }

    public class Data {

        @SerializedName("request_id")
        @Expose
        private String requestId;

        @SerializedName("errors")
        @Expose
        private Set<Error> errors = new HashSet<>();

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public Set<Error> getErrors() {
            return errors;
        }

        public void setErrors(Set<Error> errors) {
            this.errors = errors;
        }

        public class Error {

            @SerializedName("error_code")
            @Expose
            private String errorCode;

            @SerializedName("description")
            @Expose
            private String description;

            @SerializedName("additional_details")
            @Expose
            private String additionalDetails;

            public String getErrorCode() {
                return errorCode;
            }

            public void setErrorCode(String errorCode) {
                this.errorCode = errorCode;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getAdditionalDetails() {
                return additionalDetails;
            }

            public void setAdditionalDetails(String additionalDetails) {
                this.additionalDetails = additionalDetails;
            }

        }
    }
}
