package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;

public class CreateAccountRequest implements JsonDataModel {

    /*
        {
            "method":"CREATE_ACCOUNT",
            "credentials":{
               "app_id":"ADER6864g25644777", //subscription_id
               "api_password":"sLA84009rw2",
               "token_id": "" //25-xter optional field, if user not yet logged in, not mandatory
            },
            "params":{
               "personal_info":{
                  "first_name":"Davies",
                  "primary_phone":"256774983602",
                  "preferred_password":"eyru474894833y3994ir94309323943"
               },
               "addition_info": {
                 "agreed_to_terms":true
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

        @SerializedName(value = "personal_info")
        private PersonalInfo personalInfo;

        @SerializedName(value = "additional_info")
        private AdditionalInfo additionalInfo;

        public Params() {
        }

        public PersonalInfo getPersonalInfo() {
            return personalInfo;
        }

        public void setPersonalInfo(PersonalInfo personalInfo) {
            this.personalInfo = personalInfo;
        }

        public AdditionalInfo getAdditionalInfo() {
            return additionalInfo;
        }

        public void setAdditionalInfo(AdditionalInfo additionalInfo) {
            this.additionalInfo = additionalInfo;
        }

        public class PersonalInfo {

            @SerializedName(value = "first_name")
            private String firstName;

            @SerializedName(value = "primary_phone")
            private String primaryPhone;

            @SerializedName(value = "preferred_password")
            private String preferredPassword;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getPrimaryPhone() {
                return primaryPhone;
            }

            public void setPrimaryPhone(String primaryPhone) {
                this.primaryPhone = primaryPhone;
            }

            public String getPreferredPassword() {
                return preferredPassword;
            }

            public void setPreferredPassword(String preferredPassword) {
                this.preferredPassword = preferredPassword;
            }
        }

        public class AdditionalInfo {

            @SerializedName(value = "agreed_to_terms")
            private boolean isAgreedToTerms;
            
            @SerializedName(value = "user_type")
            private String userType;

            public boolean isIsAgreedToTerms() {
                return isAgreedToTerms;
            }

            public void setIsAgreedToTerms(boolean isAgreedToTerms) {
                this.isAgreedToTerms = isAgreedToTerms;
            }

            public String getUserType() {
                return userType;
            }

            public void setUserType(String userType) {
                this.userType = userType;
            }

        }
    }

}
