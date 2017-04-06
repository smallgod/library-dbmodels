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
public class CampaignStats {

    @SerializedName("display_count")
    @Expose
    private int numOfTimesAdIsToPlay;

    @SerializedName("target_reach")
    @Expose
    private TargetReach targetReach;

    @SerializedName("potential_reach")
    @Expose
    private PotentialReach potentialReach;

    public TargetReach getTargetReach() {
        return targetReach;
    }

    public void setTargetReach(TargetReach targetReach) {
        this.targetReach = targetReach;
    }

    public PotentialReach getPotentialReach() {
        return potentialReach;
    }

    public void setPotentialReach(PotentialReach potentialReach) {
        this.potentialReach = potentialReach;

    }

    public int getNumOfTimesAdIsToPlay() {
        return numOfTimesAdIsToPlay;
    }

    public void setNumOfTimesAdIsToPlay(int numOfTimesAdIsToPlay) {
        this.numOfTimesAdIsToPlay = numOfTimesAdIsToPlay;
    }

}
