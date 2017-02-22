package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.APIMethodName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.List;
import java.util.Set;

public class DbFetchRequest implements JsonDataModel {

    /*
    {
    "method":"FETCH_ENTITY",
    "params":{
        "entity_name":"AD_SCREEN",
        "columns_to_fetch":["ALL"],
        "order_by":"name", // others can include | "audience_count", "id", "screen_count"
        "order":"ASC",
        "limit":0 //0 means no limit
    },
    "properties":[
        {
            "name":"screenArea.areaCode",
            "values":[1]
        },
        {
            "name":"locationType.location_type_code",
            "values":[3, 7]
        }
    ]
}
     */
    public DbFetchRequest() {
        //this.method = APIMethodName.FETCH_ENTITY.getValue();
    }

    @SerializedName(value = "method")
    private String method;

    @SerializedName(value = "params")
    private Params params;

    @SerializedName(value = "properties")
    private Set<Property> property;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public Set<Property> getProperty() {
        return property;
    }

    public void setProperty(Set<Property> property) {
        this.property = property;
    }

    public class Params {

        @SerializedName(value = "entity_name")
        private String entityName;

        @SerializedName(value = "columns_to_fetch")
        private Set<String> columnsToFetch;

        @SerializedName(value = "order_by")
        private String orderBy;

        @SerializedName(value = "order")
        private String order;

        @SerializedName(value = "limit")
        private int limit;

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

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public String getEntityName() {
            return entityName;
        }

        public void setEntityName(String entityName) {
            this.entityName = entityName;
        }

        public Set<String> getColumnsToFetch() {
            return columnsToFetch;
        }

        public void setColumnsToFetch(Set<String> columnsToFetch) {
            this.columnsToFetch = columnsToFetch;
        }
    }

    public class Property {

        @SerializedName(value = "name")
        private String name;

        @SerializedName(value = "values")
        private Set<Object> values;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<Object> getValues() {
            return values;
        }

        public void setValues(Set<Object> values) {
            this.values = values;
        }

    }

}
