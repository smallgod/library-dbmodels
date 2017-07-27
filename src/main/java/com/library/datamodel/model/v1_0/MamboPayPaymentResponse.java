/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.model.v1_0;

/**
 *
 * @author smallgod
 */
public class MamboPayPaymentResponse {

    private String status;
    private String statusDescription;
    private String mamboPayReference;

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the statusDescription
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getMamboPayReference() {
        return mamboPayReference;
    }

    public void setMamboPayReference(String mamboPayReference) {
        this.mamboPayReference = mamboPayReference;
    }

}
