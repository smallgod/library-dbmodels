/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author smallGod
 */
public class LocationInfo {

    @SerializedName("phone_contact")
    @Expose
    private String phoneContact;

    @SerializedName("business_name")
    @Expose
    private String businessName;

    @SerializedName("screens")
    @Expose
    private int numOfScreens;

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getNumOfScreens() {
        return numOfScreens;
    }

    public void setNumOfScreens(int numOfScreens) {
        this.numOfScreens = numOfScreens;
    }

}
