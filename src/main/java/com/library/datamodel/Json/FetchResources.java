package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class FetchResources implements JsonDataModel {

    /*{
    "method":"FETCH_RESOURCES",
    "params":{
        "parameter_name":"",
        "parameter_value":"",
        "named_query":""
    }
}*/
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

        @SerializedName(value = "named_query")
        private String namedQuery;

        @SerializedName(value = "parameter_name")
        private String parameterName;

        @SerializedName(value = "parameter_value")
        private Object parameterValue;

        public String getParameterName() {
            return parameterName;
        }

        public void setParameterName(String parameterName) {
            this.parameterName = parameterName;
        }

        public String getNamedQuery() {
            return namedQuery;
        }

        public void setNamedQuery(String namedQuery) {
            this.namedQuery = namedQuery;
        }

        public Object getParameterValue() {
            return parameterValue;
        }

        public void setParameterValue(Object parameterValue) {
            this.parameterValue = parameterValue;
        }
    }
}
