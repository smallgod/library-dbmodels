package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdPaymentStatus;
import com.library.datamodel.Constants.AdvertStatus;
import com.library.datamodel.Constants.AdvertStep;
import com.library.datamodel.Constants.ProgDisplayLayout;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.LocalDate;

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

    @Column(name = "program_id") //this is the ID we internally generate for every program
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
    @Enumerated(EnumType.STRING)
    private AdvertStatus adStatus;//the status of the advert whether successful, Rejected or ....

    @Column(name = "processing_step")
    @Enumerated(EnumType.STRING)
    private AdvertStep adStep;//at which processing level this advert is at

    //whether this advert has been paid for or not - if an advert is rejected after payment, 
    //payment should be reversed and this value should read 'REVERSED'
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private AdPaymentStatus paymentStatus;

    //@ManyToMany(mappedBy = "ad_screen_list")
    @SerializedName(value = "program_screens")
    @ManyToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "list_program_screens",
            joinColumns = {
                @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
            }
    )
    //@Cascade(CascadeType.SAVE_UPDATE)
    private Set<AdScreen> adScreenList = new HashSet<>(0);//all the screens on which this ad needs to display

    @Column(name = "schedules_to_play")
    private int totalSchedulesToPlay; //number of schedules paid for, to be played

    @Column(name = "schedules_played")
    private int totalSchedulesPlayed; //number of schedules played so far

    @SerializedName(value = "start_date")
    @Column(name = "start_date")
    @Type(type = "jodalocaldate")
    private LocalDate startAdDate;

    @SerializedName(value = "end_date")
    @Column(name = "end_date")
    @Type(type = "jodalocaldate")
    private LocalDate endAdDate;
    
    @SerializedName(value = "dsm_updated")
    @Column(name = "dsm_updated")
    private boolean isDSMUpdated;
    
    @SerializedName(value = "number_of_files")
    @Column(name = "number_of_files")
    private int numOfFileResources;

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

    public Set<AdScreen> getAdScreenList() {
        return adScreenList;
    }

    public void setAdScreenList(Set<AdScreen> adScreenList) {
        this.adScreenList = adScreenList;
    }

    public LocalDate getStartAdDate() {
        return startAdDate;
    }

    public void setStartAdDate(LocalDate startAdDate) {
        this.startAdDate = startAdDate;
    }

    public LocalDate getEndAdDate() {
        return endAdDate;
    }

    public void setEndAdDate(LocalDate endAdDate) {
        this.endAdDate = endAdDate;
    }

    public boolean isIsDSMUpdated() {
        return isDSMUpdated;
    }

    public void setIsDSMUpdated(boolean isDSMUpdated) {
        this.isDSMUpdated = isDSMUpdated;
    }

    public int getNumOfFileResources() {
        return numOfFileResources;
    }

    public void setNumOfFileResources(int numOfFileResources) {
        this.numOfFileResources = numOfFileResources;
    }

}
