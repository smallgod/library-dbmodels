package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class AdSetupRequestWrapper implements JsonDataModel {

    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "player_detail")
    private PlayerDetail playerDetail;

    @SerializedName(value = "program_detail")
    private ProgramDetail programDetail;

    @SerializedName(value = "resource_detail")
    private ResourceDetail resourceDetail;

    public PlayerDetail getPlayerDetail() {
        return playerDetail;
    }

    public void setPlayerDetail(PlayerDetail playerDetail) {
        this.playerDetail = playerDetail;
    }

    public ProgramDetail getProgramDetail() {
        return programDetail;
    }

    public void setProgramDetail(ProgramDetail programDetail) {
        this.programDetail = programDetail;
    }

    public ResourceDetail getResourceDetail() {
        return resourceDetail;
    }

    public void setResourceDetail(ResourceDetail resourceDetail) {
        this.resourceDetail = resourceDetail;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
