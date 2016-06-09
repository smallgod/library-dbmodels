package com.library.datamodel.Json;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.JsonDataModel;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AdFetchResponse implements JsonDataModel {

    @SerializedName(value = "device_id")
    private String device_id;

    @SerializedName(value = "numberof_ads")
    private String numberOfAds;

    @SerializedName(value = "narration")
    private String narration;

    @SerializedName(value = "ad_details")
    private List<Map<String, Object>> adDetails;//each merchant has a set of questions the payer must (has to) answer - sow we have merchant handle -> merchantqueries

    /**
     * Gets the value of the adDetails property.
     *
     * @return possible object is {@link String }
     *
     */
    public List<Map<String, Object>> getAdDetails() {
        return Collections.unmodifiableList(adDetails);
    }

    /**
     * Sets the value of the adDetails property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setAdDetails(List<Map<String, Object>> value) {
        this.adDetails = value;
    }

    public boolean isSetVersion() {
        return (this.adDetails != null);
    }

    public String getNumberOfAds() {
        return numberOfAds;
    }

    public void setNumberOfAds(String numberOfAds) {
        this.numberOfAds = numberOfAds;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }
}
