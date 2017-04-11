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
    private Set<Data> data = new HashSet<>();

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

    public Set<Data> getData() {
        return data;
    }

    public void setData(Set<Data> data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("id")
        @Expose
        private int id;

        @SerializedName("screen_code")
        @Expose
        private String screenCode;

        @SerializedName("business_name")
        @Expose
        private String businessName;

        @SerializedName("sub_area")
        @Expose
        private String subArea;

        @SerializedName("area_name")
        @Expose
        private String areaName;

        @SerializedName("extra_1")
        @Expose
        private String extra1;

        @SerializedName("extra_2")
        @Expose
        private String extra2;

        @SerializedName("extra_3")
        @Expose
        private String extra3;

        @SerializedName("extra_4")
        @Expose
        private String extra4;

        @SerializedName("alias")
        @Expose
        private String alias;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getScreenCode() {
            return screenCode;
        }

        public void setScreenCode(String screenCode) {
            this.screenCode = screenCode;
        }

        public String getSubArea() {
            return subArea;
        }

        public void setSubArea(String subArea) {
            this.subArea = subArea;
        }

        public String getAreaName() {
            return areaName;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getExtra1() {
            return extra1;
        }

        public void setExtra1(String extra1) {
            this.extra1 = extra1;
        }

        public String getExtra2() {
            return extra2;
        }

        public void setExtra2(String extra2) {
            this.extra2 = extra2;
        }

        public String getExtra3() {
            return extra3;
        }

        public void setExtra3(String extra3) {
            this.extra3 = extra3;
        }

        public String getExtra4() {
            return extra4;
        }

        public void setExtra4(String extra4) {
            this.extra4 = extra4;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

    }
}
