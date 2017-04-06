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
 * @author smallgod
 */
public class PaymentInfo {

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
