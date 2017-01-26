package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GeneratedIdResponse {

    /*
    
    GENERATE_ID RESPONSE: [
    {
        "id": "FILE_ID",
        "num_ids": 4,
        "generated_ids": [2481434800, 2481434800, 2481434800, 958329744
        ],
        "exising_id_check": [
            {
                "id": 36382726,
                "exists": true
            },
            {
                "id": 958329744,
                "exists": false
            }
        ]  
    },
    {
        "id": "PROGRAM_ID",
        "num_ids": 4,
        "generated_ids": [2481434800, 2481434800, 2481434800, 958329744
        ],
        "exising_id_check": [
            {
                "id": 36382726,
                "exists": true
            },
            {
                "id": 958329744,
                "exists": false
            }
        ]  
    }
]

    
     */
    private List<Response> response;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public class Response {

        @SerializedName(value = "id")
        private String id;

        @SerializedName(value = "num_ids")
        private int numOfIds;

        @SerializedName(value = "generated_ids")
        private List<String> generatedIdList;

        @SerializedName(value = "generated_ids")
        private List<ExistingIDCheck> existingIdCheck;

        public String getId() {

            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGeneratedIdList() {
            return generatedIdList;
        }

        public void setGeneratedIdList(List<String> generatedIdList) {
            this.generatedIdList = generatedIdList;
        }

        public int getNumOfIds() {
            return numOfIds;
        }

        public void setNumOfIds(int numOfIds) {
            this.numOfIds = numOfIds;
        }

        public List<ExistingIDCheck> getExistingIdCheck() {
            return existingIdCheck;
        }

        public void setExistingIdCheck(List<ExistingIDCheck> existingIdCheck) {
            this.existingIdCheck = existingIdCheck;
        }

        public class ExistingIDCheck {

            @SerializedName(value = "id")
            private String id;

            @SerializedName(value = "exists")
            private boolean exists;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public boolean isExists() {
                return exists;
            }

            public void setExists(boolean exists) {
                this.exists = exists;
            }

        }
    }

}
