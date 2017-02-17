package com.library.datamodel.model.v1_0;

/**
 * Works but inserts duplicate entries in all tables involved
 * 
 * AdText adText1 = new AdText();
        adText1.setIsUploadedToDSM(Boolean.FALSE);
        adText1.setScreenRegion(AdScreenRegion.CENTER);
        adText1.setTextContent("This is scroll text right here...");
        adText1.setTextType(TextType.SCROLL_TEXT);
        adText1.setTextId(new Random().nextInt());

        AdText adText2 = new AdText();
        adText2.setIsUploadedToDSM(Boolean.FALSE);
        adText2.setScreenRegion(AdScreenRegion.CENTER);
        adText2.setTextContent("This is Header Text.");
        adText2.setTextType(TextType.HEADER_TEXT);
        adText2.setTextId(new Random().nextInt());

        AdProgram program1 = new AdProgram();
        program1.setAdCampaignName("Test Campaign - No. 1");
        program1.setAdLength(10);
        program1.setAdStatus(AdvertStatus.PROCESSING);
        program1.setProgJoinId(new Random().nextInt());
        program1.setDisplayLayout(ProgDisplayLayout.THREE_SPLIT);
        program1.setIsDSMUpdated(Boolean.FALSE);
        program1.setStartAdDate(new LocalDate(2017, 2, 15));
        program1.setEndAdDate(new LocalDate(2017, 2, 17));
        program1.setIsToBeNotified(Boolean.TRUE);
        program1.setNumOfFileResources(3);
        program1.setPaymentStatus(AdPaymentStatus.NOT_PAID);
        program1.setTotalSchedulesPlayed(9);
        program1.setTotalSchedulesToPlay(900);

        AdProgram program2 = new AdProgram();
        program2.setAdCampaignName("Test Campaign - No. 2");
        program2.setAdLength(15);
        program2.setAdStatus(AdvertStatus.PROCESSING);
        program2.setProgJoinId(new Random().nextInt());
        program2.setDisplayLayout(ProgDisplayLayout.THREE_SPLIT);
        program2.setIsDSMUpdated(Boolean.FALSE);
        program2.setStartAdDate(new LocalDate(2017, 2, 15));
        program2.setEndAdDate(new LocalDate(2017, 2, 18));
        program2.setIsToBeNotified(Boolean.TRUE);
        program2.setNumOfFileResources(3);
        program2.setPaymentStatus(AdPaymentStatus.NOT_PAID);
        program2.setTotalSchedulesPlayed(10);
        program2.setTotalSchedulesToPlay(999);

        
        
        //Add programs to each of the adText sets
        adText1.getAdPrograms().add(program1);
        adText1.getAdPrograms().add(program2);
        adText2.getAdPrograms().add(program1);
        adText2.getAdPrograms().add(program2);
        
        //Add Text to each of the Program sets
        program1.getAdTextList().add(adText1);
        program1.getAdTextList().add(adText2);
        program2.getAdTextList().add(adText1);
        program2.getAdTextList().add(adText2);
        
        

        databaseAdapter.saveOrUpdateEntity(program1, Boolean.TRUE);

        Thread.sleep(delay);

        databaseAdapter.saveOrUpdateEntity(program2, Boolean.TRUE);

        Thread.sleep(delay);
 */

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdPaymentStatus;
import com.library.datamodel.Constants.AdvertStatus;
import com.library.datamodel.Constants.AdvertStep;
import com.library.datamodel.Constants.ProgDisplayLayout;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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

public class AdProgram2 extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @SerializedName(value = "program_id")
    @Column(name = "program_id") //this is the ID we internally generate for every program, by default, let it be zero(0) since we dont have it till later after generation
    private int advertProgramId = 0;

    @SerializedName(value = "program_join_id")
    @Column(name = "program_join_id") //this is the ID we internally generate for every program, later when we figure out, we can use the BaseEntity id
    private int progJoinId;

    @SerializedName(value = "campaign_name")
    @Column(name = "campaign_name")
    private String adCampaignName;

    @SerializedName(value = "ad_length")
    @Column(name = "ad_length")
    private long adLength;

    @SerializedName(value = "notify_client")
    @Column(name = "notfiy")
    private boolean isToBeNotified; //send SMS notification concerning this ad

    @SerializedName(value = "display_layout")
    @Column(name = "display_layout")
    @Enumerated(EnumType.STRING)
    private ProgDisplayLayout displayLayout;

    @SerializedName(value = "ad_status")
    @Column(name = "ad_status")
    @Enumerated(EnumType.STRING)
    private AdvertStatus adStatus;//the status of the advert whether successful, Rejected or ....

    @SerializedName(value = "processing_step")
    @Column(name = "processing_step")
    @Enumerated(EnumType.STRING)
    private AdvertStep adStep;//at which processing level this advert is at

    //whether this advert has been paid for or not - if an advert is rejected after payment, 
    //payment should be reversed and this value should read 'REVERSED'
    @SerializedName(value = "payment_status")
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private AdPaymentStatus paymentStatus;

    @SerializedName(value = "schedules_to_play")
    @Column(name = "schedules_to_play")
    private int totalSchedulesToPlay; //number of schedules paid for, to be played

    @SerializedName(value = "schedules_played")
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

    @SerializedName(value = "program_texts")
    @ManyToMany(
            fetch = FetchType.EAGER, 
            mappedBy = "adPrograms",
            cascade = {
                //javax.persistence.CascadeType.PERSIST, 
                javax.persistence.CascadeType.ALL
            }
    ) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "ad_program_text",
//            joinColumns = {
//                @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "text_id", referencedColumnName = "text_id", nullable = false, insertable = false, updatable = false)
//            }
//    )
    //@Cascade(CascadeType.ALL)
    private Set<AdText> adTextList = new HashSet<AdText>();//all the screens on which this ad needs to display

//  private Set<AdResource> adResourceList = new HashSet<AdResource>();//all the screens on which this ad needs to display
    public AdProgram2() {
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
    public Set<AdText> getAdTextList() {
        return adTextList;
    }

    public void setAdTextList(Set<AdText> adTextList) {
        this.adTextList = adTextList;
    }

    public int getProgJoinId() {
        return progJoinId;
    }

    public void setProgJoinId(int progJoinId) {
        this.progJoinId = progJoinId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
