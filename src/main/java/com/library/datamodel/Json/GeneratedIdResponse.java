package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GeneratedIdResponse {

    /*
    
    {
        "id": "FILE_ID",
        "generated_ids": [2481434800, 2481434800, 2481434800, 2481434800],
    }
    
     */
    @SerializedName(value = "id")
    private String id;

    @SerializedName(value = "generated_ids")
    private List<String> generatedIdList;

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGeneratedIdList() {
        return generatedIdList;
    }

    public void setGeneratedIdList(List<String> generatedIdList) {
        this.generatedIdList = generatedIdList;
    }

}
