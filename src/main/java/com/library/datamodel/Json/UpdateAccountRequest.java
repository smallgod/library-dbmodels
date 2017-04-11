package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.Set;

public class UpdateAccountRequest implements JsonDataModel {

    /*
        {
            "method": "UPDATE_ACCOUNT",
            "credentials": {
              "app_id": "ADER6864g25644777", 
              "api_password": "sLA84009rw2",
              "token_id": "84938urj9338203u349393"
            },

            "params": {

              "personal_info": {
                "first_name": "Davies",
                "second_name": "Mugume", 
                "other_phone": "256790790491", 
                "email_address": "smallg@gmail.com"
              },

              "business_info": {
                "business_type": "Plumbing", //multi-select i.e can add multiple businesses // Chapati seller | Plumbing | Telecom
                "business_name": "Sam's Plumbing",
                "business_location": "Ntinda", //multi-select
                "target_audience": [1] // Boda-Boda Riders | Kids | Cooporates | 
              },

              "account_info": {
                "account_number": "256774983602",
                "value_store": "MTNMOMO_UG" // others can be | STANBIC_UG | AIRTELMOMO_UG
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
        
        @SerializedName(value = "business_info")
        private BusinessInfo businessInfo;
        
        @SerializedName(value = "account_info")
        private AccountInfo accountInfo;

        public Params() {
        }

        

        public PersonalInfo getPersonalInfo() {
            return personalInfo;
        }

        public void setPersonalInfo(PersonalInfo personalInfo) {
            this.personalInfo = personalInfo;
        }

        public BusinessInfo getBusinessInfo() {
            return businessInfo;
        }

        public void setBusinessInfo(BusinessInfo businessInfo) {
            this.businessInfo = businessInfo;
        }

        public AccountInfo getAccountInfo() {
            return accountInfo;
        }

        public void setAccountInfo(AccountInfo accountInfo) {
            this.accountInfo = accountInfo;
        }

        

        public class PersonalInfo {

            @SerializedName(value = "first_name")
            private String firstName;

            @SerializedName(value = "last_name")
            private String lastName;

            @SerializedName(value = "other_phone")
            private String otherPhone;

            @SerializedName(value = "email_address")
            private String emailAddress;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getOtherPhone() {
                return otherPhone;
            }

            public void setOtherPhone(String otherPhone) {
                this.otherPhone = otherPhone;
            }

            public String getEmailAddress() {
                return emailAddress;
            }

            public void setEmailAddress(String emailAddress) {
                this.emailAddress = emailAddress;
            }

        }
    
        public class BusinessInfo {

            @SerializedName(value = "business_type")
            private String businessType;

            @SerializedName(value = "business_name")
            private String businessName;

            @SerializedName(value = "business_location")
            private String businessLocation;

            //@SerializedName(value = "target_audience")
            //private Set<Integer> targetAudience;
            
            @SerializedName(value = "target_audience")
            private String targetAudience; //After Mr. B corrects change back to array
            
            

            public String getBusinessType() {
                return businessType;
            }

            public void setBusinessType(String businessType) {
                this.businessType = businessType;
            }

            public String getBusinessName() {
                return businessName;
            }

            public void setBusinessName(String businessName) {
                this.businessName = businessName;
            }

            public String getBusinessLocation() {
                return businessLocation;
            }

            public void setBusinessLocation(String businessLocation) {
                this.businessLocation = businessLocation;
            }

            public String getTargetAudience() {
                return targetAudience;
            }

            public void setTargetAudience(String targetAudience) {
                this.targetAudience = targetAudience;
            }

           

        }
    
        public class AccountInfo {

            @SerializedName("value_store")
            @Expose
            private String valueStore;
            
            @SerializedName("account_number")
            @Expose
            private String accountNumber;

            public String getValueStore() {
                return valueStore;
            }

            public void setValueStore(String valueStore) {
                this.valueStore = valueStore;
            }

            public String getAccountNumber() {
                return accountNumber;
            }

            public void setAccountNumber(String accountNumber) {
                this.accountNumber = accountNumber;
            }

        }
    }

}
