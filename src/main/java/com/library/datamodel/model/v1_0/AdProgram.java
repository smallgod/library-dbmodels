package com.library.datamodel.model.v1_0;

import com.library.datamodel.Constants.AdPaymentStatus;
import com.library.datamodel.Constants.AdvertStatus;
import com.library.datamodel.Constants.AdvertStep;
import com.library.datamodel.Constants.ProgDisplayLayout;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "ad_program", uniqueConstraints = @UniqueConstraint(columnNames = {"program_id"}))

public class AdProgram extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Column(name = "program_id", nullable = false)
    private int advertProgramId;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    })
    private AdClient adClient;

    @Column(name = "campaign_name")
    private String adCampaignName;

    @Column(name = "ad_length")
    private int adLength;

    @Column(name = "notfiy")
    private boolean isToBeNotified; //send SMS notification concerning this ad

    @Column(name = "display_layout")
    @Enumerated(EnumType.STRING)
    private ProgDisplayLayout displayLayout;

    @Column(name = "ad_status")
    private AdvertStatus adStatus;//the status of the advert whether successful, Rejected or ....

    @Column(name = "processing_step")
    private AdvertStep adStep;//at which processing level this advert is at

    //whether this advert has been paid for or not - if an advert is rejected after payment, 
    //payment should be reversed and this value should read 'REVERSED'
    @Column(name = "payment_status")
    private AdPaymentStatus paymentStatus;

    //@ManyToMany(mappedBy = "ad_screen_list")
    @ManyToMany
    @JoinColumns({
        @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false),
        @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    })
    @Column(name = "screen_list")
    private List<AdScreen> adScreenList;//all the screens on which this ad needs to display

    @Column(name = "schedules_to_play")
    private int totalSchedulesToPlay; //number of schedules paid for, to be played

    @Column(name = "schedules_played")
    private int totalSchedulesPlayed; //number of schedules played so far

    public AdProgram() {
    }

    public AdvertStatus getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(AdvertStatus adStatus) {
        this.adStatus = adStatus;
    }

    public AdvertStep getAdStep() {
        return adStep;
    }

    public void setAdStep(AdvertStep adStep) {
        this.adStep = adStep;
    }

    public AdPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(AdPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getAdvertProgramId() {
        return advertProgramId;
    }

    public void setAdvertProgramId(int advertProgramId) {
        this.advertProgramId = advertProgramId;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public AdClient getAdClient() {
        return adClient;
    }

    public void setAdClient(AdClient adClient) {
        this.adClient = adClient;
    }

    public List<AdScreen> getAdScreenList() {
        return adScreenList;
    }

    public void setAdScreenList(List<AdScreen> adScreenList) {
        this.adScreenList = adScreenList;
    }

    public String getAdCampaignName() {
        return adCampaignName;
    }

    public void setAdCampaignName(String adCampaignName) {
        this.adCampaignName = adCampaignName;
    }

    public int getAdLength() {
        return adLength;
    }

    public void setAdLength(int adLength) {
        this.adLength = adLength;
    }

    public boolean isIsToBeNotified() {
        return isToBeNotified;
    }

    public void setIsToBeNotified(boolean isToBeNotified) {
        this.isToBeNotified = isToBeNotified;
    }

    public ProgDisplayLayout getDisplayLayout() {
        return displayLayout;
    }

    public void setDisplayLayout(ProgDisplayLayout displayLayout) {
        this.displayLayout = displayLayout;
    }

    public int getTotalSchedulesToPlay() {
        return totalSchedulesToPlay;
    }

    public void setTotalSchedulesToPlay(int totalSchedulesToPlay) {
        this.totalSchedulesToPlay = totalSchedulesToPlay;
    }

    public int getTotalSchedulesPlayed() {
        return totalSchedulesPlayed;
    }

    public void setTotalSchedulesPlayed(int totalSchedulesPlayed) {
        this.totalSchedulesPlayed = totalSchedulesPlayed;
    }
}
