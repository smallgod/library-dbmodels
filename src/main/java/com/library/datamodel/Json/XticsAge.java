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
public class XticsAge {

    @Expose
    @SerializedName(value = "under_12")
    private int ageUnder12;

    @Expose
    @SerializedName(value = "13_to_17")
    private int age13to17;

    @Expose
    @SerializedName(value = "18_to_24")
    private int age18to24;

    @Expose
    @SerializedName(value = "25_to_39")
    private int age25to39;

    @Expose
    @SerializedName(value = "40_to_55")
    private int age40to55;

    @Expose
    @SerializedName(value = "above_56")
    private int ageAbove56;

    public int getAgeUnder12() {
        return ageUnder12;
    }

    public void setAgeUnder12(int ageUnder12) {
        this.ageUnder12 = ageUnder12;
    }

    public int getAge13to17() {
        return age13to17;
    }

    public void setAge13to17(int age13to17) {
        this.age13to17 = age13to17;
    }

    public int getAge18to24() {
        return age18to24;
    }

    public void setAge18to24(int age18to24) {
        this.age18to24 = age18to24;
    }

    public int getAge25to39() {
        return age25to39;
    }

    public void setAge25to39(int age25to39) {
        this.age25to39 = age25to39;
    }

    public int getAge40to55() {
        return age40to55;
    }

    public void setAge40to55(int age40to55) {
        this.age40to55 = age40to55;
    }

    public int getAgeAbove56() {
        return ageAbove56;
    }

    public void setAgeAbove56(int ageAbove56) {
        this.ageAbove56 = ageAbove56;
    }

}
