package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdSlotsReserve;
import com.library.datamodel.Constants.CampaignStatus;
import com.library.datamodel.Constants.ScreenSplit;
import com.library.datamodel.Constants.ScheduleType;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

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
@Table(name = "ad_program", uniqueConstraints = @UniqueConstraint(columnNames = {"campaign_id"}))

@NamedQueries({
    @NamedQuery(name = AdProgram.FETCH_CAMPAIGNS_BY_PAYMENT_ID, query = AdProgram.FETCH_CAMPAIGNS_BY_PAYMENT_ID_QUERY),
    @NamedQuery(name = AdProgram.FETCH_ALL_USER_CAMPAIGNS, query = AdProgram.FETCH_ALL_USER_CAMPAIGNS_QUERY),
    @NamedQuery(name = AdProgram.FETCH_USER_CAMPAIGNS_BY_ID, query = AdProgram.FETCH_USER_CAMPAIGNS_BY_ID_QUERY),
    @NamedQuery(name = AdProgram.FETCH_SCREENCODES_BY_CAMPAIGN_ID, query = AdProgram.FETCH_SCREENCODES_BY_CAMPAIGN_ID_QUERY),
    @NamedQuery(name = AdProgram.FETCH_ALL_CAMPAIGNS_BY_CAMPAIGN_ID, query = AdProgram.FETCH_ALL_CAMPAIGNS_BY_ID_QUERY),
    @NamedQuery(name = AdProgram.FETCH_ALL_CAMPAIGNS, query = AdProgram.FETCH_ALL_CAMPAIGNS_QUERY),
    @NamedQuery(name = AdProgram.FETCH_CAMPAIGNS_BY_STATUS, query = AdProgram.FETCH_CAMPAIGNS_BY_STATUS_QUERY)

})

public class AdProgram extends BaseEntity implements Auditable, Serializable {

    public static final String FETCH_CAMPAIGNS_BY_STATUS_QUERY =       "SELECT DISTINCT prog FROM AdProgram prog INNER JOIN prog.adCampaignStats stats INNER JOIN prog.client cl INNER JOIN prog.adPaymentDetails pd INNER JOIN cl.adUser user where prog.adCampaignStatus IN (:campaignStatuses)";
    public static final String FETCH_CAMPAIGNS_BY_PAYMENT_ID_QUERY =   "SELECT DISTINCT prog FROM AdProgram prog INNER JOIN prog.adCampaignStats stats INNER JOIN prog.client cl INNER JOIN prog.adPaymentDetails pd INNER JOIN cl.adUser user where pd.internalPaymentID=:internalPaymentID";
    public static final String FETCH_ALL_USER_CAMPAIGNS_QUERY =        "SELECT DISTINCT prog FROM AdProgram prog INNER JOIN prog.adCampaignStats stats INNER JOIN prog.client cl INNER JOIN prog.adPaymentDetails pd INNER JOIN cl.adUser user where user.userId=:userId";
    public static final String FETCH_USER_CAMPAIGNS_BY_ID_QUERY =      "SELECT DISTINCT prog FROM AdProgram prog INNER JOIN prog.adCampaignStats stats INNER JOIN prog.client cl INNER JOIN prog.adPaymentDetails pd INNER JOIN cl.adUser user where user.userId IN (:userId) AND prog.campaignId IN (:campaignIds)";
    //fetch all specified campaigns regardless whether they belong to a single user or not
    public static final String FETCH_ALL_CAMPAIGNS_QUERY =             "SELECT DISTINCT prog FROM AdProgram prog INNER JOIN prog.adCampaignStats stats INNER JOIN prog.client cl INNER JOIN prog.adPaymentDetails pd INNER JOIN cl.adUser user ORDER BY prog.id DESC";
    public static final String FETCH_ALL_CAMPAIGNS_BY_ID_QUERY =       "SELECT DISTINCT prog FROM AdProgram prog INNER JOIN prog.adCampaignStats stats INNER JOIN prog.client cl INNER JOIN prog.adPaymentDetails pd INNER JOIN cl.adUser user where prog.campaignId IN (:campaignIds) ORDER BY prog.id DESC";
    public static final String FETCH_SCREENCODES_BY_CAMPAIGN_ID_QUERY ="SELECT DISTINCT program.campaignScreenCodes FROM AdProgram program WHERE program.campaignId=:campaignId";
    public static final String FETCH_SCREENCODES_BY_CAMPAIGN_ID = "FETCH_SCREENCODES_BY_CAMPAIGN_ID";
    public static final String FETCH_ALL_CAMPAIGNS_BY_CAMPAIGN_ID = "FETCH_ALL_CAMPAIGNS_BY_ID";
    public static final String FETCH_ALL_USER_CAMPAIGNS = "FETCH_ALL_USER_CAMPAIGNS";
    public static final String FETCH_USER_CAMPAIGNS_BY_ID = "FETCH_USER_CAMPAIGNS_BY_ID";
    public static final String FETCH_ALL_CAMPAIGNS = "FETCH_ALL_CAMPAIGNS";
    public static final String FETCH_CAMPAIGNS_BY_PAYMENT_ID = "FETCH_CAMPAIGNS_BY_PAYMENT_ID";
    public static final String FETCH_CAMPAIGNS_BY_STATUS = "FETCH_CAMPAIGNS_BY_STATUS";
    
    private static final long serialVersionUID = 7580435289074737150L;
    

    
    //Select i from Inventory i,Category c INNER JOIN i.product ip INNER JOIN c.products cp where ip = cp and c.id=?
    
   // select e from Employee e inner join e.team;
            
   //select p from Products p INNER JOIN p.productlanguages pl where pl.languages.shortname ='eng';
    
//    SELECT supplierOrderDetails.productID as product, supplierOrderDetails.orderQty as orderedQty,sum(supplierOrderReceiveDetail.qtyArrived) as qtyArrived 
//    FROM SupplierOrder as so, SupplierOrderDetails as supplierOrderDetails,  SupplierOrderReceiveDetail as supplierOrderReceiveDetail, SupplierOrderReceive as supplierOrderReceive
//    INNER JOIN supplierOrderDetails.supplierOrderID
//    INNER JOIN supplierOrderReceive.supplierOrder
//    INNER JOIN supplierOrderReceiveDetail.supplierOrderReceive
//    GROUP BY supplierOrderDetails.productID, supplierOrderDetails.orderQty
   

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
    @SerializedName(value = "campaign_id")
    @Column(name = "campaign_id", nullable = false) //this is the ID we internally generate for every program, later when we figure out, we can use the BaseEntity id
    private int campaignId;

    @SerializedName(value = "campaign_name")
    @Column(name = "campaign_name")
    private String adCampaignName;

    @Expose
    @SerializedName(value = "ad_length")
    @Column(name = "ad_length")
    private long adLength;
    
     @Expose
    @SerializedName(value = "campaign_days_period")
    @Column(name = "campaign_days_period", nullable = false)
    private int CampaignDaysPeriod = 0; //in days
     
     //add actualCampaignDays // days on which the campaign is set to run

    @Expose
    @SerializedName(value = "notify_client")
    @Column(name = "notfiy")
    private boolean isToBeNotified; //send SMS notification concerning this ad
    
    
    @Expose
    @SerializedName(value = "is_selected_codes")
    @Column(name = "is_selected_codes", nullable = false)
    private boolean isSelectedScreenCodes = Boolean.FALSE; //if the user just selected target screen codes or selected areas/audience/business_type

    @Expose
    @SerializedName(value = "display_layout")
    @Column(name = "display_layout")
    @Enumerated(EnumType.STRING)
    private ScreenSplit displayLayout;

    
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
        @JoinColumn(name = "client_id", referencedColumnName = "user_id") // we can leave this Join-Column out, if we leave it out, Hibernate will use the entity Id
    })
    //@Cascade({CascadeType.ALL}) //commented out for causing a duplicate object error when saving with client
    //org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session : [com.library.datamodel.model.v1_0.AdClient#122]
    private AdClient client;
    
    @Expose
    @SerializedName(value = "campaign_status")
    @Column(name = "campaign_status")
    @Enumerated(EnumType.STRING)
    private CampaignStatus adCampaignStatus;
    
    
   /**
     * Number of times this campaign program has been picked 
     * with the same status
     */
    @Expose
    @SerializedName(value = "same_status_picks")
    @Column(name = "same_status_picks", nullable = false)
    private int sameStatusPick = 0;
    
        /**
     * Time status was last changed for this campaign
     */
    @Expose
    @SerializedName(value = "status_change_time")
    @Type(type = "jodalocaldatetime")
    @Column(name = "status_change_time")
    private LocalDateTime statusChangeTime;
    
     
    @Expose
    @SerializedName(value = "campaign_stats_id")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "campaign_stats_id")
    })
    @Cascade(CascadeType.ALL)
    private AdCampaignStats adCampaignStats;
    
    @Expose
    @SerializedName(value = "payment_details_id")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        //@JoinColumn(name = "payment_details_id", referencedColumnName = "internal_payment_id")
        @JoinColumn(name = "payment_details_id")
    })
    @Cascade(CascadeType.ALL)
    private AdPaymentDetails adPaymentDetails;
     
    //use later when we upgrade to newer design
    
//    @SerializedName(value = "advertising_business")
//    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "advertising_business",
//            joinColumns = {
//                @JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id")
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "business_id", referencedColumnName = "business_id")
//            }
//    )
//    @Cascade({CascadeType.ALL})//A user can advertise/campaign from/for 0 or more businesses and multiple campaigns/programs can be for the same business
//    @OrderBy("id")
//    private Set<AdBusiness> advertisingBusinesses = new HashSet<>(0);
     
    /**
     * Use this nigger for storing screen codes separated by ","s
     */
    @SerializedName(value = "campaign_screen_codes")
    @Column(name = "campaign_screen_codes", length = 15000)
    private String campaignScreenCodes;
    
    
    @SerializedName(value = "campaign_service_ids")
    @Column(name = "campaign_service_ids", length = 10000)
    private String campaignBusinessServiceIds;
    
    
    @SerializedName(value = "campaign_area_ids")
    @Column(name = "campaign_area_ids", length = 10000)
    private String campaignAreaIds;
    
    
    @SerializedName(value = "campaign_audiencetype_ids")
    @Column(name = "campaign_audiencetype_ids", length = 10000)
    private String campaignAudienceTypeIds;
    
    @Expose
    @SerializedName(value = "schedule_type")
    @Column(name = "schedule_type")
    @Enumerated(EnumType.STRING)
    private ScheduleType scheduleType;
    
    @Expose
    @SerializedName(value = "ad_slot_reserve")
    @Column(name = "ad_slot_reserve")
    @Enumerated(EnumType.STRING)
    private AdSlotsReserve adSlotReserve;
    
    @Expose
    @SerializedName(value = "to_review")
    @Column(name = "to_review", nullable = false)
    private boolean isToBeReviewed = Boolean.TRUE; //whether or not campaign is to be reviewed
    
    @Expose
    @SerializedName(value = "is_reviewed")
    @Column(name = "is_reviewed", nullable = false)
    private boolean isReviewed = Boolean.FALSE; //whether or not campaign has been reviewed
    
    
    
    @Transient
    private transient boolean isCampaignExist;
     

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }
    
    public AdProgram() {
    }
    
    public CampaignStatus getAdCampaignStatus() {
        return adCampaignStatus;
    }

    public void setAdCampaignStatus(CampaignStatus adCampaignStatus) {
        this.adCampaignStatus = adCampaignStatus;
    }


    public int getAdvertProgramId() {
        return advertProgramId;
    }

    public void setAdvertProgramId(int advertProgramId) {
        this.advertProgramId = advertProgramId;
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

    public ScreenSplit getDisplayLayout() {
        return displayLayout;
    }

    public void setDisplayLayout(ScreenSplit displayLayout) {
        this.displayLayout = displayLayout;
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

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
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

    public AdCampaignStats getAdCampaignStats() {
        return adCampaignStats;
    }

    public void setAdCampaignStats(AdCampaignStats adCampaignStats) {
        this.adCampaignStats = adCampaignStats;
    }


    public String getCampaignScreenCodes() {
        return campaignScreenCodes;
    }

    public void setCampaignScreenCodes(String campaignScreenCodes) {
        this.campaignScreenCodes = campaignScreenCodes;
    }
    
    

    public int getCampaignDaysPeriod() {
        return CampaignDaysPeriod;
    }

    public void setCampaignDaysPeriod(int CampaignDaysPeriod) {
        this.CampaignDaysPeriod = CampaignDaysPeriod;
    }

    public boolean isIsCampaignExist() {
        return isCampaignExist;
    }

    public void setIsCampaignExist(boolean isCampaignExist) {
        this.isCampaignExist = isCampaignExist;
    }

    public boolean isIsSelectedScreenCodes() {
        return isSelectedScreenCodes;
    }

    public void setIsSelectedScreenCodes(boolean isSelectedScreenCodes) {
        this.isSelectedScreenCodes = isSelectedScreenCodes;
    }
    
    
    
     @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + this.campaignId;
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
        if (this.id != other.getId()) {
            return false;
        }
        
        return this.campaignId == other.getCampaignId();
    }

    public AdPaymentDetails getAdPaymentDetails() {
        return adPaymentDetails;
    }

    public void setAdPaymentDetails(AdPaymentDetails adPaymentDetails) {
        this.adPaymentDetails = adPaymentDetails;
    }

    public int getSameStatusPick() {
        return sameStatusPick;
    }

    public void setSameStatusPick(int sameStatusPick) {
        this.sameStatusPick = sameStatusPick;
    }

    public LocalDateTime getStatusChangeTime() {
        return statusChangeTime;
    }

    public void setStatusChangeTime(LocalDateTime statusChangeTime) {
        this.statusChangeTime = statusChangeTime;
    }

    public boolean isIsToBeReviewed() {
        return isToBeReviewed;
    }

    public void setIsToBeReviewed(boolean isToBeReviewed) {
        this.isToBeReviewed = isToBeReviewed;
    }

    public boolean isIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(boolean isReviewed) {
        this.isReviewed = isReviewed;
    }

    public AdSlotsReserve getAdSlotReserve() {
        return adSlotReserve;
    }

    public void setAdSlotReserve(AdSlotsReserve adSlotReserve) {
        this.adSlotReserve = adSlotReserve;
    }

    public String getCampaignBusinessServiceIds() {
        return campaignBusinessServiceIds;
    }

    public void setCampaignBusinessServiceIds(String campaignBusinessServiceIds) {
        this.campaignBusinessServiceIds = campaignBusinessServiceIds;
    }

    public String getCampaignAreaIds() {
        return campaignAreaIds;
    }

    public void setCampaignAreaIds(String campaignAreaIds) {
        this.campaignAreaIds = campaignAreaIds;
    }

    public String getCampaignAudienceTypeIds() {
        return campaignAudienceTypeIds;
    }

    public void setCampaignAudienceTypeIds(String campaignAudienceTypeIds) {
        this.campaignAudienceTypeIds = campaignAudienceTypeIds;
    }

    
    
}


/*@Expose
    @SerializedName(value = "resource_list")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adResourcePrograms")
    @Cascade({CascadeType.ALL})
    private Set<AdResource> adResourceList = new HashSet<>(0);

    @Expose
    @SerializedName(value = "text_list")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adTextPrograms")
    @Cascade({CascadeType.ALL})
    private Set<AdText> adTextList = new HashSet<>(0);*/
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
