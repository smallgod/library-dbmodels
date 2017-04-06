package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class GeneralGetRequest implements JsonDataModel {

    /*
        {
            "method": "GET_SCREEN_AREAS", | GET_BUSINESS_TYPES | 
            "credentials": {
              "app_id": "ADER6864g25644777",
              "api_password": "sLA84009dfewwrw2",
              "token_id": "84938urj9338203u349393"
            },
            "params": {
              "ordering_info": {
                "order_by": "name", // others are 'audience_count', "id", "screen_count"
                "order": "ASC"
              },
              "paging_info": {
                "current_page": 1,
                "page_size": 20,
                "total_pages": 1,
                "total_rows": 3
              }
            }
        }
             
     */
    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "credentials")
    private Credentials credentials;

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

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public class Params {

        @SerializedName(value = "ordering_info")
        private OrderingInfo orderingInfo;

        @SerializedName(value = "paging_info")
        private PagingInfo pagingInfo;

        public Params() {
        }

        public OrderingInfo getOrderingInfo() {
            return orderingInfo;
        }

        public void setOrderingInfo(OrderingInfo orderingInfo) {
            this.orderingInfo = orderingInfo;
        }

        public PagingInfo getPagingInfo() {
            return pagingInfo;
        }

        public void setPagingInfo(PagingInfo pagingInfo) {
            this.pagingInfo = pagingInfo;
        }

        public class OrderingInfo {

            @SerializedName(value = "order_by")
            private String orderBy; // 'audience_count', "id", "screen_count"

            @SerializedName(value = "order")
            private String order; // ASC | DESC

            public String getOrderBy() {
                return orderBy;
            }

            public void setOrderBy(String orderBy) {
                this.orderBy = orderBy;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

        }

        public class PagingInfo {

        }
    }

}
