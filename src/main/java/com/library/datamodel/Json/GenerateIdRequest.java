package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class GenerateIdRequest implements JsonDataModel {

    /*
   
    JSON Request sample:
    
    {
        "method": "GENERATE_ID",
        "params": {
            "num_ids": "5",
            "id_type": "LONG", //INTEGER
            "id": "FILE_ID"
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

        @SerializedName(value = "num_ids")
        private int numOfIds;

        @SerializedName(value = "id_type")
        private String idTypeToGenerate;

        @SerializedName(value = "id")
        private String id;

        public int getNumOfIds() {
            return numOfIds;
        }

        public void setNumOfIds(int numOfIds) {
            this.numOfIds = numOfIds;
        }

        public String getIdTypeToGenerate() {
            return idTypeToGenerate;
        }

        public void setIdTypeToGenerate(String idTypeToGenerate) {
            this.idTypeToGenerate = idTypeToGenerate;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }
}
