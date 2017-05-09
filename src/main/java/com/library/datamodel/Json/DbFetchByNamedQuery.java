package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.APIMethodName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.Set;

public class DbFetchByNamedQuery implements JsonDataModel {

    /*
    {
        "method":"FETCH_ENTITY_BY_NAMED_QUERY",
        "params":{
            "named_query":"",
            "entity_name":"AD_SCREEN",
            "properties":[
                {
                    "name":"",
                    "values":[]
                },
                {
                    "name":"",
                    "values":[]
                }
            ]

        }
    }
     */
    @SerializedName(value = "method")
    private String methodName;

    @SerializedName(value = "params")
    private Params params;

    private DbFetchByNamedQuery(String methodName) {
        this.methodName = methodName;
    }

    public DbFetchByNamedQuery() {
        this(APIMethodName.FETCH_ENTITY_BY_NAMED_QUERY.getValue());
    }

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

    public class Params {

        @SerializedName(value = "named_query")
        private String namedQuery;

        @SerializedName(value = "entity_name")
        private String entityName;

        @SerializedName(value = "properties")
        private Set<Properties> properties;

        public String getNamedQuery() {
            return namedQuery;
        }

        public void setNamedQuery(String namedQuery) {
            this.namedQuery = namedQuery;
        }

        public Set<Properties> getProperties() {
            return properties;
        }

        public void setProperties(Set<Properties> properties) {
            this.properties = properties;
        }

        public String getEntityName() {
            return entityName;
        }

        public void setEntityName(String entityName) {
            this.entityName = entityName;
        }

        public class Properties {

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
}
