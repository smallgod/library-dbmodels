package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;

public class ResourceDetail implements JsonDataModel {

    /*
    
    {
    "method": "RESOURCE_DETAIL",
    "data": [
        {
            "display_date": "2017-01-10",
            "resources": [
                {
                    "resource_id": 5480212808,
                    "resource_detail": "restaurant_front.mp4",
                    "resource_type": "VIDEO",
                    "status": "OLD"
                },
                {
                    "resource_id": 2481434800,
                    "resource_detail": "This is Header text [DEL] This is scrolling text here..",
                    "resource_type": "TEXT",
                    "status": "NEW"
                },
                {
                    "resource_id": 2481434800,
                    "resource_detail": "swimming pool.jpg",
                    "resource_type": "IMAGE",
                    "status": "NEW"
                }
            ]
        }
    ]
}
     */
    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "data")
    private List<Data> data;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public class Data {

        @SerializedName(value = "display_date")
        private String displayDate;

        @SerializedName(value = "resources")
        private List<Resources> resources;

        public String getDisplayDate() {
            return displayDate;
        }

        public void setDisplayDate(String displayDate) {
            this.displayDate = displayDate;
        }

        public List<Resources> getResources() {
            return resources;
        }

        public void setResources(List<Resources> resources) {
            this.resources = resources;
        }

        public class Resources {

            @SerializedName(value = "resource_id")
            private String resourceId;

            @SerializedName(value = "resource_detail")
            private String resourceDetail;

            @SerializedName(value = "resource_type")
            private String resourceType;

            @SerializedName(value = "status")
            private String status;

            public String getResourceId() {
                return resourceId;
            }

            public void setResourceId(String resourceId) {
                this.resourceId = resourceId;
            }

            public String getResourceDetail() {
                return resourceDetail;
            }

            public void setResourceDetail(String resourceDetail) {
                this.resourceDetail = resourceDetail;
            }

            public String getResourceType() {
                return resourceType;
            }

            public void setResourceType(String resourceType) {
                this.resourceType = resourceType;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

        }
    }

}
