package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenSize;
import com.library.datamodel.Constants.AdScreenType;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_screen", uniqueConstraints = @UniqueConstraint(columnNames = {"screen_id"}))

@NamedQueries({
    @NamedQuery(name = AdScreen.GET_SCREENS, query = AdScreen.GET_SCREENS_QUERY),
    @NamedQuery(name = AdScreen.GET_SCREENS_BY_ID, query = AdScreen.GET_SCREENS_BY_ID_QUERY),

    @NamedQuery(name = AdScreen.FETCH_SCREENS_BY_SCREEN_ID, query = AdScreen.FETCH_SCREENS_BY_SCREEN_ID_QUERY),
    @NamedQuery(name = AdScreen.FETCH_SCREENS, query = AdScreen.FETCH_SCREENS_QUERY),

    @NamedQuery(name = AdScreen.FETCH_SCREENS_BY_PROGRAM_ID, query = AdScreen.FETCH_SCREENS_BY_PROGRAM_ID_QUERY),
    @NamedQuery(name = AdScreen.FETCH_SCREENCODES_BY_PROGRAM_ID, query = AdScreen.FETCH_SCREENCODES_BY_PROG_ID_QUERY),

    @NamedQuery(name = AdScreen.AREA_AUDIENCE_COUNT, query = AdScreen.AREA_AUDIENCE_COUNT_QUERY),
    @NamedQuery(name = AdScreen.AREA_SCREEN_COUNT, query = AdScreen.AREA_SCREEN_COUNT_QUERY),

    @NamedQuery(name = AdScreen.BUSINESSTYPE_AUDIENCE_COUNT, query = AdScreen.BUSINESSTYPE_AUDIENCE_COUNT_QUERY),
    @NamedQuery(name = AdScreen.BUSINESSTYPE_SCREEN_COUNT, query = AdScreen.BUSINESSTYPE_SCREEN_COUNT_QUERY),

    @NamedQuery(name = AdScreen.AUDIENCETYPE_AUDIENCE_COUNT, query = AdScreen.AUDIENCETYPE_AUDIENCE_COUNT_QUERY),
    @NamedQuery(name = AdScreen.AUDIENCETYPE_SCREEN_COUNT, query = AdScreen.AUDIENCETYPE_SCREEN_COUNT_QUERY),

    @NamedQuery(name = AdScreen.FETCH_TARGETED_AREAS, query = AdScreen.FETCH_TARGETED_AREAS_QUERY),
    @NamedQuery(name = AdScreen.FETCH_TARGETED_BUSINESS_TYPES, query = AdScreen.FETCH_TARGETED_BUSINESS_TYPES_QUERY),
    @NamedQuery(name = AdScreen.FETCH_TARGETED_AUDIENCE_TYPES, query = AdScreen.FETCH_TARGETED_AUDIENCE_TYPES_QUERY),

    @NamedQuery(name = AdScreen.FETCH_AREAS, query = AdScreen.FETCH_AREAS_QUERY),
    @NamedQuery(name = AdScreen.FETCH_BUSINESS_TYPES, query = AdScreen.FETCH_BUSINESS_TYPES_QUERY),
    @NamedQuery(name = AdScreen.FETCH_AUDIENCE_TYPES, query = AdScreen.FETCH_AUDIENCE_TYPES_QUERY)

})

public class AdScreen extends BaseEntity implements Auditable, Serializable {

    public static final String GET_SCREENS_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.screenArea area INNER JOIN screen.businessType biztype INNER JOIN screen.screenOwnerBusiness business";
    public static final String GET_SCREENS = "GET_SCREENS";

    public static final String GET_SCREENS_BY_ID_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.screenArea area INNER JOIN screen.businessType biztype INNER JOIN screen.screenOwnerBusiness business WHERE screen.screenId IN (:screenId)";
    public static final String GET_SCREENS_BY_ID = "GET_SCREENS_BY_ID";

    public static final String FETCH_SCREENS_BY_SCREEN_ID_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.screenArea area where screen.screenId IN (:screenIds)";
    public static final String FETCH_SCREENS_BY_SCREEN_ID = "FETCH_SCREENS_BY_SCREEN_ID";

    public static final String FETCH_SCREENS_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.screenArea area";
    public static final String FETCH_SCREENS = "FETCH_SCREENS";

    //we have program screencodes - i think we need to do away with this query and use those instead
    public static final String FETCH_SCREENS_BY_PROGRAM_ID_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.businessType businessType INNER JOIN screen.screenArea area INNER JOIN screen.adPrograms prog INNER JOIN prog.client cl INNER JOIN cl.adUser user where user.userId IN (:userId) AND prog.campaignId IN (:campaignIds)";
    public static final String FETCH_SCREENS_BY_PROGRAM_ID = "FETCH_SCREENS_BY_PROGRAM_ID";

    public static final String FETCH_SCREENCODES_BY_PROG_ID_QUERY = "SELECT DISTINCT screen.screenId FROM AdScreen screen INNER JOIN screen.adPrograms prog WHERE prog.campaignId=:campaignId";
    public static final String FETCH_SCREENCODES_BY_PROGRAM_ID = "FETCH_SCREENCODES_BY_PROGRAM_ID";

    public static final String AREA_AUDIENCE_COUNT_QUERY = "SELECT DISTINCT SUM(screen.audienceCount) FROM AdScreen screen INNER JOIN screen.screenArea area WHERE area.areaCode=:code";
    public static final String AREA_AUDIENCE_COUNT = "AREA_AUDIENCE_COUNT";

    public static final String AREA_SCREEN_COUNT_QUERY = "SELECT DISTINCT COUNT(screen.screenId) FROM AdScreen screen INNER JOIN screen.screenArea area WHERE area.areaCode=:code";
    public static final String AREA_SCREEN_COUNT = "AREA_SCREEN_COUNT";

    public static final String BUSINESSTYPE_AUDIENCE_COUNT_QUERY = "SELECT DISTINCT SUM(screen.audienceCount) FROM AdScreen screen INNER JOIN screen.businessType business WHERE business.businessTypeCode=:code";
    ;
    public static final String BUSINESSTYPE_AUDIENCE_COUNT = "BUSINESSTYPE_AUDIENCE_COUNT";

    public static final String BUSINESSTYPE_SCREEN_COUNT_QUERY = "SELECT DISTINCT COUNT(screen.screenId) FROM AdScreen screen INNER JOIN screen.businessType business WHERE business.businessTypeCode=:code";
    public static final String BUSINESSTYPE_SCREEN_COUNT = "BUSINESSTYPE_SCREEN_COUNT";

    public static final String AUDIENCETYPE_AUDIENCE_COUNT_QUERY = "SELECT DISTINCT SUM(screen.audienceCount) FROM AdScreen screen INNER JOIN screen.audienceTypes audience WHERE audience.audienceCode=:code";
    public static final String AUDIENCETYPE_AUDIENCE_COUNT = "AUDIENCETYPE_AUDIENCE_COUNT";

    public static final String AUDIENCETYPE_SCREEN_COUNT_QUERY = "SELECT DISTINCT COUNT(screen.screenId) FROM AdScreen screen INNER JOIN screen.audienceTypes audience WHERE audience.audienceCode=:code";
    public static final String AUDIENCETYPE_SCREEN_COUNT = "AUDIENCETYPE_SCREEN_COUNT";

    public static final String FETCH_TARGETED_AREAS_QUERY = "SELECT DISTINCT area FROM AdScreen screen INNER JOIN screen.screenArea area INNER JOIN screen.adPrograms prog WHERE prog.campaignId=:campaignId";
    //public static final String FETCH_TARGETED_AREAS_QUERY = "SELECT DISTINCT area FROM AdScreen screen, screen.screenArea area WHERE screen.screenId=:screenId";
    //public static final String FETCH_TARGETED_AREAS_QUERY = "SELECT DISTINCT area FROM AdScreen screen INNER JOIN screen.screenArea area WHERE screen.screenId=:screenId";
    //SQL works -> SELECT DISTINCT area.area_code FROM adexpo_main.ad_screen screen, adexpo_main.ad_screen_area area WHERE screen.screen_id='KOKO2';
    public static final String FETCH_TARGETED_AREAS = "FETCH_TARGETED_AREAS";

    public static final String FETCH_TARGETED_BUSINESS_TYPES_QUERY = "SELECT DISTINCT business FROM AdScreen screen INNER JOIN screen.businessType business INNER JOIN screen.adPrograms prog WHERE prog.campaignId=:campaignId";
    public static final String FETCH_TARGETED_BUSINESS_TYPES = "FETCH_TARGETED_BUSINESS_TYPES";

    public static final String FETCH_TARGETED_AUDIENCE_TYPES_QUERY = "SELECT DISTINCT audience FROM AdScreen screen INNER JOIN screen.audienceTypes audience INNER JOIN screen.adPrograms prog WHERE prog.campaignId=:campaignId";
    public static final String FETCH_TARGETED_AUDIENCE_TYPES = "FETCH_TARGETED_AUDIENCE_TYPES";

    public static final String FETCH_AREAS_QUERY = "SELECT DISTINCT area FROM AdScreen screen INNER JOIN screen.screenArea area";
    public static final String FETCH_AREAS = "FETCH_AREAS";

    public static final String FETCH_BUSINESS_TYPES_QUERY = "SELECT DISTINCT bizTypes FROM AdScreen screen INNER JOIN screen.businessType bizTypes";
    public static final String FETCH_BUSINESS_TYPES = "FETCH_BUSINESS_TYPES";

    public static final String FETCH_AUDIENCE_TYPES_QUERY = "SELECT DISTINCT audience FROM AdScreen screen INNER JOIN screen.audienceTypes audience";
    public static final String FETCH_AUDIENCE_TYPES = "FETCH_AUDIENCE_TYPES";

    private static final long serialVersionUID = 2301296823801925900L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @Expose
    @SerializedName(value = "screen_id")
    @Column(name = "screen_id")
    private String screenId;

    @Expose
    @SerializedName(value = "vendor_name")
    @Column(name = "vendor_name")
    private String vendorName;

    @Expose
    @SerializedName(value = "screen_type")
    @Column(name = "screen_type")
    @Enumerated(EnumType.STRING)
    private AdScreenType screenType;

    @Expose
    @SerializedName(value = "screen_size")
    @Column(name = "screen_size")
    @Enumerated(EnumType.STRING)
    private AdScreenSize screenSize; //  e.g. 32 inch TV

    @Expose
    @SerializedName(value = "audience_count")
    @Column(name = "audience_count")
    private int audienceCount;

    @Expose
    @SerializedName(value = "screen_value") //different screens will fall in diff categories depending on location, audience_count, audience_type, size, etc
    @Column(name = "screen_value")
    private float screenValue; //a percentage value e.g 1.2 or 0.75

    @Expose
    @SerializedName(value = "display_width")
    @Column(name = "display_width")
    private int displayWidth;

    @Expose
    @SerializedName(value = "display_height")
    @Column(name = "display_height")
    private int displayHeight;

    @Expose
    @SerializedName(value = "terminal_id")
    @ManyToOne(fetch = FetchType.EAGER) //To-DO I think it is better to have this relationship owned by the terminal one terminal - > one screen for now, later we can have multiple screens on a terminal
    @JoinColumns({
        @JoinColumn(name = "terminal_id", referencedColumnName = "terminal_id")
    })
    @Cascade(CascadeType.ALL)
    private AdTerminal supportTerminal;

    @Expose
    @SerializedName(value = "business_type_code")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "business_type_code", referencedColumnName = "business_type_code") // we can leave this Join-Column out, if we leave it out, Hibernate will use the entity Id
    })
    @Cascade(CascadeType.ALL)
    private AdBusinessType businessType;

    @Expose
    @SerializedName(value = "screen_owner")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "business_id", referencedColumnName = "business_id") //get business name from here for GET_SCREENS
    })
    @Cascade(CascadeType.ALL)
    private AdBusiness screenOwnerBusiness;// owner of this screen is a business

    @Expose
    @SerializedName(value = "screen_area")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "screen_area_code", referencedColumnName = "area_code") // we can leave this Join-Column out, if we leave it out, Hibernate will use the entity Id
    })
    @Cascade({CascadeType.ALL})
    private AdArea screenArea;

    @SerializedName(value = "screen_audience")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "screen_audience",
            joinColumns = {
                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "audience_code", referencedColumnName = "audience_code")
            }
    )
    @Cascade({CascadeType.ALL})
    private Set<AdAudienceType> audienceTypes = new HashSet<>(0);

    //I really want to move this relationship to AdProgram but the way I schedule stuff need be considered before doing so..
    //Let's instead use the field called 'campaignScreenCodes' inside AdProgram it is a long comma-separated varchar
    //Together with AdSchedule or another table we can create with Screens and a list of programs these 2 can mimick this join-table
//    @Expose
//    @SerializedName(value = "screen_programs")
//    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "ad_screen_programs",
//            joinColumns = {
//                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id")
//
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id")
//            }
//    )
//    @Cascade({CascadeType.ALL})
//    private Set<AdProgram> adPrograms = new HashSet<>(0);

    @Column(name = "extra_1")
    private String extra1; //any other info (descriptive info) to identify this screen e.g. front lounge area

    @Column(name = "extra_2")
    private String extra2;

    @Column(name = "extra_3")
    private String extra3;

    @Column(name = "extra_4")
    private String extra4;

    public AdScreen() {
    }

    //@Override
    public long getId() {
        return id;
    }

    //@Override
    public void setId(long id) {
        this.id = id;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public AdScreenSize getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(AdScreenSize screenSize) {
        this.screenSize = screenSize;
    }

    public AdScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(AdScreenType screenType) {
        this.screenType = screenType;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public void setAudienceCount(int audienceCount) {
        this.audienceCount = audienceCount;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayWidth(int displayWidth) {
        this.displayWidth = displayWidth;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public void setDisplayHeight(int displayHeight) {
        this.displayHeight = displayHeight;
    }

    public AdTerminal getSupportTerminal() {
        return supportTerminal;
    }

    public void setSupportTerminal(AdTerminal supportTerminal) {
        this.supportTerminal = supportTerminal;
    }

    public AdBusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(AdBusinessType businessType) {
        this.businessType = businessType;
    }

    public AdArea getScreenArea() {
        return screenArea;
    }

    public void setScreenArea(AdArea screenArea) {
        this.screenArea = screenArea;
    }

    /**
     * Different screens will fall in different categories depending on
     * location, audience_count, audience_type, size, etc
     *
     * @return
     */
    public float getScreenValue() {
        return screenValue;
    }

    public void setScreenValue(float screenValue) {
        this.screenValue = screenValue;
    }

    public Set<AdAudienceType> getAudienceTypes() {
        return audienceTypes;
    }

    public void setAudienceTypes(Set<AdAudienceType> audienceTypes) {
        this.audienceTypes = audienceTypes;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra3() {
        return extra3;
    }

    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }

    public String getExtra4() {
        return extra4;
    }

    public void setExtra4(String extra4) {
        this.extra4 = extra4;
    }

    public AdBusiness getScreenOwnerBusiness() {
        return screenOwnerBusiness;
    }

    public void setScreenOwnerBusiness(AdBusiness screenOwnerBusiness) {
        this.screenOwnerBusiness = screenOwnerBusiness;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.screenId);
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

        final AdScreen other = (AdScreen) obj;

        if (this.id != other.getId()) {
            return false;
        }

        return Objects.equals(this.screenId, other.getScreenId());
    }

    //
//    public AdTerminal getSupportTerminal() {
//        return supportTerminal;
//    }
//
//    public void setSupportTerminal(AdTerminal supportTerminal) {
//        this.supportTerminal = supportTerminal;
//    }
//    public Set<AdProgram> getAdPrograms() {
//        return adPrograms;
//    }
//
//    public void setAdPrograms(Set<AdProgram> adPrograms) {
//        this.adPrograms = adPrograms;
//    }
    //    @SerializedName(value = "audience_list")
//    @ManyToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "list_screen_audience_types",
//            joinColumns = {
//                @JoinColumn(name = "audience_screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "audience_code", referencedColumnName = "audience_code", nullable = false, insertable = false, updatable = false)
//            }
//    )
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumns({
//        @JoinColumn(name = "audience_screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
//    })
//    //@Cascade(CascadeType.SAVE_UPDATE)
    //
    //
    //
//    @SerializedName(value = "entity_id")
//    @Id
//    @GeneratedValue(generator = "myGenerator")
//    @GenericGenerator(
//            name = "myGenerator",
//            strategy = "foreign",
//            parameters = @Parameter(
//                    value = "supportTerminal",
//                    name = "property"
//            )
//    )
//    private long id;
}
