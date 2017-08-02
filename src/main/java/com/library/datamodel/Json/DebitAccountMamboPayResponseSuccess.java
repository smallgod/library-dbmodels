package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;

public class DebitAccountMamboPayResponseSuccess {

    /*
    

    JSON Request sample:

    SUCCESS
    {
    
        "reference":745115924,
        "transaction_id":"33322345",
        "status_code":"01",
        "status_description":"Transaction Queued for processing"
    }
    
    FAIL
    { 
    "statusCode": 401, 
    "message": "Access denied due to missing subscription key. Make sure to include subscription key when making requests to an API." 
    }
     */
    @SerializedName(value = "reference")
    private String reference;

    @SerializedName(value = "transaction_id")
    private String transactionId;

    @SerializedName(value = "status_code")
    private String statusCode;

    @SerializedName(value = "status_message") // also use status_description
    private String statusDescription;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

}
