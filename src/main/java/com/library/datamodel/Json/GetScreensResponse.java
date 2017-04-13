package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GetScreensResponse {

    /*
        {
            "success": true,
            "data": [
              {
                "id": 2, //remove this guy
                "screen_code":"KOKO2",
                "business_name": "Le Village wines", //Get business name from AdBusiness in AdScreen
                "sub_area":"Kamwokya", //get area_name from AdArea, AdArea also has sub_area & sub_area_2 -> area4.setAreaName("Kabalagala");
                "area_name":"Kampala", //get area_name from AdArea i.e. -> area4.setDistrict("Kampala"); //perhaps we ignore this field in what we return
                "extra_1":"Village Mall", //get extra_1 from AdScreen i.e. -> screen1.setExtra1("Village Mall");
                "extra_2":"Front lounge", //get extra_2 from AdScreen i.e. -> screen2.setExtra1("front lounge");
                "extra_3":"Shop", //get from AdBusinessType -> getAdBusinessTypeShortName();
                "extra_4":"",
                "concatenated_name":"KOKO2 - Kamwokya - Kampala"
              },
              {
                "id": 2,
                "screen_code":"KPC4",
                "business_name": "Liquid Silk",
                "sub_area":"Ntinda",
                "area_name":"Kampala",
                "extra_1":"Central",
                "extra_2":"Watoto",
                "extra_3":"",
                "extra_4":"",
                "concatenated_name":"KPC4 - Ntinda - Kampala"
              }
            ]
        }
     */
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Set<ScreenData> data = new HashSet<>();

    private GetScreensResponse(boolean success) {
        this.success = success;
    }

    public GetScreensResponse() {
        this(Boolean.TRUE);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Set<ScreenData> getData() {
        return data;
    }

    public void setData(Set<ScreenData> data) {
        this.data = data;
    }

}
