package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class GetUserAdsRequest implements JsonDataModel {

    /*
    {
        "method": "GET_USER_ADVERTS",
        "params": {
          "user_id": "774983602",
          "limit": 10, //default is "" meaning  no limit
          "order_first": "OLDEST", //default is "" meaning "NEWEST"
          "status": "PENDING_PAYMENT", //default is "" meaning "ALL"
        }
    }
     */
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

        @SerializedName(value = "user_id")
        private String userId;
        
        @SerializedName(value = "order_first")
        private String orderFirst = "";

        @SerializedName(value = "transaction_limit")
        private int transactionLimit = -1;

        @SerializedName(value = "status")
        private String status = "ALL";

        private Params(String orderFirst, int transactionLimit, String status) {
            this.orderFirst = orderFirst;
            this.transactionLimit = transactionLimit;
            this.status = status;
        }

        public Params() {
            this("NEWEST", -1, "ALL");
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOrderFirst() {
            return orderFirst;
        }

        public void setOrderFirst(String orderFirst) {
            this.orderFirst = orderFirst;
        }

        public int getTransactionLimit() {
            return transactionLimit;
        }

        public void setTransactionLimit(int transactionLimit) {
            this.transactionLimit = transactionLimit;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

}
