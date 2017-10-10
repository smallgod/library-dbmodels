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
public class XticsBusinessHours {

    @Expose
    @SerializedName(value = "opens")
    private Days opens;

    @Expose
    @SerializedName(value = "closes")
    private Days closes;

    public Days getOpens() {
        return opens;
    }

    public void setOpens(Days opens) {
        this.opens = opens;
    }

    public Days getCloses() {
        return closes;
    }

    public void setCloses(Days closes) {
        this.closes = closes;
    }

}
