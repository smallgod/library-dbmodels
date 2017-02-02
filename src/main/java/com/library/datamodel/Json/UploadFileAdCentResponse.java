package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;

public class UploadFileAdCentResponse implements JsonDataModel {

    /*
    {
        "success":true,
        "Data":[
            {
                "upload_name":"swimming pool.jpg",
                "upload_id": "swimming pool-646437382763.jpg", 
                "preview_url":"http://192.168.1.111:9008/adcentral/resources/swimming pool-646437382763.jpg"
            },
            {
                "upload_name":"restaurant_front2.mp4",
                "upload_id": "restaurant_front2-35729173636.mp4", 
                "preview_url":"http://192.168.1.111:9008/adcentral/resources/restaurant_front2-35729173636.mp4"
            }
        ]
    }*/
    @SerializedName(value = "success")
    private boolean isSuccessful;

    @SerializedName(value = "data")
    private List<Data> data;

    public boolean getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public class Data {

        @SerializedName(value = "upload_name")
        private String uploadName;

        @SerializedName(value = "upload_id")
        private String uploadId;

        @SerializedName(value = "preview_url")
        private String previewUrl;

        public String getUploadName() {
            return uploadName;
        }

        public void setUploadName(String uploadName) {
            this.uploadName = uploadName;
        }

        public String getUploadId() {
            return uploadId;
        }

        public void setUploadId(String uploadId) {
            this.uploadId = uploadId;
        }

        public String getPreviewUrl() {
            return previewUrl;
        }

        public void setPreviewUrl(String previewUrl) {
            this.previewUrl = previewUrl;
        }
    }
}
