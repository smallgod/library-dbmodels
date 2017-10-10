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

    @SerializedName("secondary_contact")
    @Expose
    private String secondaryContact;

    @SerializedName("business_name")
    @Expose
    private String businessName;

    @SerializedName("registered_name")
    @Expose
    private String registeredName;

    @SerializedName("total_screens")
    @Expose
    private int numOfScreens;

    @SerializedName("plot_num")
    @Expose
    private String plotNum;

    @SerializedName("building_name")
    @Expose
    private String buildingName;

    @SerializedName("street_name")
    @Expose
    private String streetName;

    @SerializedName(value = "sub_area_2")
    private String subArea2;

    @SerializedName(value = "sub_area_1")
    private String subArea1; //a sub area below the area-name

    @SerializedName(value = "area")
    private String area; //e.g. Parish like -> kyanja or City center -> areaName can be concantenated to the other params below with a '-' delimeter

    @SerializedName("division")
    @Expose
    private String division;

    @SerializedName("district")
    @Expose
    private String district;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("country")
    @Expose
    private String country;

    public String getSecondaryContact() {
        return secondaryContact;
    }

    public void setSecondaryContact(String secondaryContact) {
        this.secondaryContact = secondaryContact;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getPlotNum() {
        return plotNum;
    }

    public void setPlotNum(String plotNum) {
        this.plotNum = plotNum;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSubArea2() {
        return subArea2;
    }

    public void setSubArea2(String subArea2) {
        this.subArea2 = subArea2;
    }

    public String getSubArea1() {
        return subArea1;
    }

    public void setSubArea1(String subArea1) {
        this.subArea1 = subArea1;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

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
