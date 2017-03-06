package com.library.datamodel.Json;

/**
 *
 * @author smallgod
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.HashSet;
import java.util.Set;

public class GetParametersResponse {

    /**
     * "{\"success\":true,\"data\":[{\"id\":2,\"name\":\"Kibuli\",\"audience_count\":34000,\"screen_count\":459},{\"id\":1,\"name\":\"Kyengera\",\"c\":4570,\"screen_count\":99},{\"id\":3,\"name\":\"Namuwongo\",\"audience_count\":8976,\"screen_count\":124},{\"id\":4,\"name\":\"Ntinda\",\"audience_count\":54330,\"screen_count\":600}]}"
     */
    
    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("data")
    @Expose
    private Set<Data> data = new HashSet<>();

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

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("audience_count")
        @Expose
        private int audience_count;

        @SerializedName("screen_count")
        @Expose
        private int screen_count;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAudience_count() {
            return audience_count;
        }

        public void setAudience_count(int audience_count) {
            this.audience_count = audience_count;
        }

        public int getScreen_count() {
            return screen_count;
        }

        public void setScreen_count(int screen_count) {
            this.screen_count = screen_count;
        }

    }
}
