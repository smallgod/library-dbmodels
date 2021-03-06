package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.model.v1_0.AdTerminal;
import com.library.sgsharedinterface.JsonDataModel;

public class AdvertRequest implements JsonDataModel {

    //{"method":"ADVERT","params":{"ad_id":"4567K","ad_owner":"yoyoyooyyo" }}
    @SerializedName(value = "identifier")
    private String identifier;

    @SerializedName(value = "params")
    private AdTerminal advertParams;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public AdTerminal getAdvertParams() {
        return advertParams;
    }

    public void setAdvertParams(AdTerminal advertParams) {
        this.advertParams = advertParams;
    }

}
