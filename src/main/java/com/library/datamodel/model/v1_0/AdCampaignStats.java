package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;

@TypeDefs({
    @TypeDef(name = "jodalocaldatetime", typeClass = PersistentLocalDateTime.class,
            parameters = {
                @Parameter(value = "UTC", name = "databaseZone"),
                @Parameter(value = "UTC", name = "javaZone")
            }
    ),
    @TypeDef(name = "jodalocaldate", typeClass = PersistentLocalDate.class,
            parameters = {
                @Parameter(value = "UTC", name = "databaseZone"),
                @Parameter(value = "UTC", name = "javaZone")
            }
    )
})
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_campaign_stats")

public class AdCampaignStats extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -4676011471815960734L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

   

    @Expose
    @SerializedName(value = "campaign_cost")
    @Column(name = "campaign_cost")
    private int campaignCost;

    @Expose
    @SerializedName(value = "display_count")
    @Column(name = "times_ad_should_play")
    private int numOfTimesAdIsToPlay;
    
    
     @Expose
    @SerializedName(value = "times_ad_has_played")
    @Column(name = "times_ad_has_played")
    private int numOfTimesAdHasPlayed;

    @Expose
    @SerializedName(value = "target_screen_reach")
    @Column(name = "target_screen_reach")
    private int targetScreenReach;

    @Expose
    @SerializedName(value = "target_audience_reach")
    @Column(name = "target_audience_reach")
    private int targetAudienceReach;

    @Expose
    @SerializedName(value = "potential_screen_reach")
    @Column(name = "potential_screen_reach")
    private int potentialScreenReach;

    @Expose
    @SerializedName(value = "potential_audience_reach")
    @Column(name = "potential_audience_reach")
    private int potentialAudienceReach;


    public AdCampaignStats() {
    }


    public int getNumOfTimesAdHasPlayed() {
        return numOfTimesAdHasPlayed;
    }

    public void setNumOfTimesAdHasPlayed(int numOfTimesAdHasPlayed) {
        this.numOfTimesAdHasPlayed = numOfTimesAdHasPlayed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCampaignCost() {
        return campaignCost;
    }

    public void setCampaignCost(int campaignCost) {
        this.campaignCost = campaignCost;
    }

    public int getNumOfTimesAdIsToPlay() {
        return numOfTimesAdIsToPlay;
    }

    public void setNumOfTimesAdIsToPlay(int numOfTimesAdIsToPlay) {
        this.numOfTimesAdIsToPlay = numOfTimesAdIsToPlay;
    }

    public int getTargetScreenReach() {
        return targetScreenReach;
    }

    public void setTargetScreenReach(int targetScreenReach) {
        this.targetScreenReach = targetScreenReach;
    }

    public int getTargetAudienceReach() {
        return targetAudienceReach;
    }

    public void setTargetAudienceReach(int targetAudienceReach) {
        this.targetAudienceReach = targetAudienceReach;
    }

    public int getPotentialScreenReach() {
        return potentialScreenReach;
    }

    public void setPotentialScreenReach(int potentialScreenReach) {
        this.potentialScreenReach = potentialScreenReach;
    }

    public int getPotentialAudienceReach() {
        return potentialAudienceReach;
    }

    public void setPotentialAudienceReach(int potentialAudienceReach) {
        this.potentialAudienceReach = potentialAudienceReach;
    }
    
    
    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AdCampaignStats other = (AdCampaignStats) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return true;
    }

   

}
