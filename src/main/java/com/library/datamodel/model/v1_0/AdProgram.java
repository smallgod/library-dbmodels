package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdPaymentStatus;
import com.library.datamodel.Constants.AdvertStatus;
import com.library.datamodel.Constants.AdvertStep;
import com.library.datamodel.Constants.ProgDisplayLayout;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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
@Table(name = "ad_program")

public class AdProgram extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Expose
    @SerializedName(value = "program_id")
    @Column(name = "program_id") //this is the ID we internally generate for every program, by default, let it be zero(0) since we dont have it till later after generation
    private int advertProgramId = 0;

    @Expose
    @SerializedName(value = "program_join_id")
    @Column(name = "program_join_id") //this is the ID we internally generate for every program, later when we figure out, we can use the BaseEntity id
    private int progJoinId;

    @SerializedName(value = "campaign_name")
    @Column(name = "campaign_name")
    private String adCampaignName;

    @Expose
    @SerializedName(value = "ad_length")
    @Column(name = "ad_length")
    private long adLength;

    @Expose
    @SerializedName(value = "notify_client")
    @Column(name = "notfiy")
    private boolean isToBeNotified; //send SMS notification concerning this ad

    @Expose
    @SerializedName(value = "display_layout")
    @Column(name = "display_layout")
    @Enumerated(EnumType.STRING)
    private ProgDisplayLayout displayLayout;

    @Expose
    @SerializedName(value = "ad_status")
    @Column(name = "ad_status")
    @Enumerated(EnumType.STRING)
    private AdvertStatus adStatus;//the status of the advert whether successful, Rejected or ....

    @Expose
    @SerializedName(value = "processing_step")
    @Column(name = "processing_step")
    @Enumerated(EnumType.STRING)
    private AdvertStep adStep;//at which processing level this advert is at

    //whether this advert has been paid for or not - if an advert is rejected after payment, 
    //payment should be reversed and this value should read 'REVERSED'
    @Expose
    @SerializedName(value = "payment_status")
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private AdPaymentStatus paymentStatus;

    @Expose
    @SerializedName(value = "schedules_to_play")
    @Column(name = "schedules_to_play")
    private int totalSchedulesToPlay; //number of schedules paid for, to be played

    @Expose
    @SerializedName(value = "schedules_played")
    @Column(name = "schedules_played")
    private int totalSchedulesPlayed; //number of schedules played so far

    @Expose
    @SerializedName(value = "start_date")
    @Column(name = "start_date")
    @Type(type = "jodalocaldate")
    private LocalDate startAdDate;

    @Expose
    @SerializedName(value = "end_date")
    @Column(name = "end_date")
    @Type(type = "jodalocaldate")
    private LocalDate endAdDate;

    @Expose
    @SerializedName(value = "dsm_updated")
    @Column(name = "dsm_updated")
    private boolean isDSMUpdated;

    @Expose
    @SerializedName(value = "number_of_files")
    @Column(name = "number_of_files")
    private int numOfFileResources;

    @Expose
    @SerializedName(value = "program_client")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "client_id") // we can leave this Join-Column out, if we leave it out, Hibernate will use the entity Id
    })
    @Cascade({CascadeType.ALL})
    private AdClient client;

//    @ManyToMany(
//        fetch = FetchType.EAGER, 
//        mappedBy = "adPrograms"
//    )
//    private Set<AdText> adTextList = new HashSet<AdText>();
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

    public String getAdCampaignName() {
        return adCampaignName;
    }

    public void setAdCampaignName(String adCampaignName) {
        this.adCampaignName = adCampaignName;
    }

    public long getAdLength() {
        return adLength;
    }

    public void setAdLength(long adLength) {
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

//    public Set<AdScreen> getAdScreenList() {
//        return adScreenList;
//    }
//
//    public void setAdScreenList(Set<AdScreen> adScreenList) {
//        this.adScreenList = adScreenList;
//    }
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

//    public Set<AdResource> getAdResourceList() {
//        return adResourceList;
//    }
//
//    public void setAdResourceList(Set<AdResource> adResourceList) {
//        this.adResourceList = adResourceList;
//    }
//
    public int getProgJoinId() {
        return progJoinId;
    }

    public void setProgJoinId(int progJoinId) {
        this.progJoinId = progJoinId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.progJoinId;
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

        final AdProgram other = (AdProgram) obj;

        if (this.getId() == other.getId()) {
            return true;
        }

        return this.progJoinId == other.getProgJoinId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AdClient getClient() {
        return client;
    }

    public void setClient(AdClient client) {
        this.client = client;
    }

}

//    @SerializedName(value = "program_screens")
//    @ManyToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "list_program_screens",
//            joinColumns = {
//                @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
//            }
//    )
//for now comment the Many-to-Many out but ideally we should be able tö use resources across multiple programs i.e. Many-to-Many
//    @SerializedName(value = "program_resources") // for now we comment this guy Many-to-Many guy out
//    @ManyToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "list_program_resources",
//            joinColumns = {
//                @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "upload_id", referencedColumnName = "upload_id", nullable = false, insertable = false, updatable = false)
//            }
//    )
//    @SerializedName(value = "program_resources")
//    @OneToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "program_resources",
//            joinColumns = {
//                @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                //@JoinColumn(name = "resource_id",   referencedColumnName = "resource_id", nullable = false, insertable = false, updatable = false),
//                @JoinColumn(name = "resource_size", referencedColumnName = "resource_size", nullable = false, insertable = false, updatable = false)
//                //@JoinColumn(name = "resource_name", referencedColumnName = "resource_name", nullable = false, insertable = false, updatable = false)
//            }
//    )
//    //@Cascade(CascadeType.SAVE_UPDATE)
//    private Set<AdResource> adResources = new HashSet<>(0)
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumns({
//        @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//    })
//    //@Cascade(CascadeType.SAVE_UPDATE)
//    private Set<AdScreen> adScreenList = new HashSet<>();//all the screens on which this ad needs to display
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumns({
//        @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//    })
//    //@Cascade(CascadeType.SAVE_UPDATE)
//    
//
//  @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumns({
//        @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//    })
//    //@Cascade(CascadeType.SAVE_UPDATE)
