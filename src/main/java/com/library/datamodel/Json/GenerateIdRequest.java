package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;

public class GenerateIdRequest implements JsonDataModel {

    /*
   
    JSON Request sample:
    
    {
    "method": "GENERATE_ID",
    "params": [
        {
            "num_ids": 4, //I think we remove this, so that the bridge service tells us how many ids it has generated depending on what exist and doesn't
            "id_type": "LONG", //INTEGER
            "id": "FILE_ID",
            "existing_ids": [
                36382726,
                958329744
            ]
        },
        {
            "num_ids": 3, //I think we remove this, so that the bridge service tells us how many ids it has generated depending on what exist and doesn't
            "id_type": "LONG", //INTEGER
            "id": "PROGRAM_ID",
            "existing_ids": []
        }
    ]
}
    
     */
    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "params")
    private List<Params> params;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Params> getParams() {
        return params;
    }

    public void setParams(List<Params> params) {
        this.params = params;
    }

    public class Params {

        @SerializedName(value = "num_ids")
        private int numOfIds;

        @SerializedName(value = "id_type")
        private String idTypeToGenerate;

        @SerializedName(value = "id")
        private String id;
        
        @SerializedName(value = "existing_ids")
        private List<String> existingIdList;

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

        public List<String> getExistingIdList() {
            return existingIdList;
        }

        public void setExistingIdList(List<String> existingIdList) {
            this.existingIdList = existingIdList;
        }

    }
}
