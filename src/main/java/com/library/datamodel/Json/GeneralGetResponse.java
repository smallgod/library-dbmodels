package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GeneralGetResponse {

    /*
    {
        "success": true,
        "data": [
          {
            "id": 2,
            "name": "Kibuli",
            "audience_count": 34000,
            "screen_count": 459
          },
          {
            "id": 1,
            "name": "Kyengera",
            "audience_count": 4570,
            "screen_count": 99
          },
          {
            "id": 3,
            "name": "Namuwongo",
            "audience_count": 8976,
            "screen_count": 124
          },
          {
            "id": 4,
            "name": "Ntinda",
            "audience_count": 54330,
            "screen_count": 600
          }
        ]
    }
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Set<MyTypes> data = new HashSet<>();

    private GeneralGetResponse(boolean success) {
        this.success = success;
    }

    public GeneralGetResponse() {
        this(Boolean.TRUE);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Set<MyTypes> getData() {
        return data;
    }

    public void setData(Set<MyTypes> data) {
        this.data = data;
    }

}
