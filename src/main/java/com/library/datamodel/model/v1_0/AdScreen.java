package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenType;
import com.library.datamodel.Constants.ScreenPopularity;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.Objects;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_screen", uniqueConstraints = @UniqueConstraint(columnNames = {"screen_id"}))

@NamedQueries({
    @NamedQuery(name = AdScreen.FETCH_SCREEN_BY_BUSINESS_ID, query = AdScreen.FETCH_SCREEN_BY_BUSINESS_ID_QUERY),
    @NamedQuery(name = AdScreen.FETCH_SCREENS_BY_SCREEN_CODE, query = AdScreen.FETCH_SCREENS_BY_SCREEN_CODE_QUERY),
    @NamedQuery(name = AdScreen.FETCH_SCREEN_BUSINESSES, query = AdScreen.FETCH_SCREEN_BUSINESSES_QUERY),
    @NamedQuery(name = AdScreen.FETCH_ALL_SCREENS, query = AdScreen.FETCH_ALL_SCREENS_QUERY),
    @NamedQuery(name = AdScreen.FETCH_SCREENS_BY_AUDIENCE_ID, query = AdScreen.FETCH_SCREENS_BY_AUDIENCE_QUERY)

})

public class AdScreen extends BaseEntity implements Auditable, Serializable {

    public static final String FETCH_SCREENS_BY_SCREEN_CODE_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.screenSize screenSize INNER JOIN screen.supportTerminal supportTerminal INNER JOIN screen.adBusiness adBusiness WHERE screen.screenId IN (:screenId)";
    public static final String FETCH_SCREENS_BY_SCREEN_CODE = "FETCH_SCREENS_BY_SCREEN_ID";

    public static final String FETCH_ALL_SCREENS_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.screenSize screenSize INNER JOIN screen.supportTerminal supportTerminal INNER JOIN screen.adBusiness adBusiness";
    public static final String FETCH_ALL_SCREENS = "FETCH_SCREENS";

    public static final String FETCH_SCREEN_BUSINESSES_QUERY = "SELECT DISTINCT adBusiness FROM AdScreen screen INNER JOIN screen.adBusiness WHERE screen.screenId IN (:screenId)";
    public static final String FETCH_SCREEN_BUSINESSES = "FETCH_SCREEN_BUSINESSES";

    public static final String FETCH_SCREEN_BY_BUSINESS_ID_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.adBusiness business WHERE business.businessId IN (:businessId)";
    public static final String FETCH_SCREEN_BY_BUSINESS_ID = "FETCH_SCREEN_BY_BUSINESS_ID";

    public static final String FETCH_SCREENS_BY_AREA_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.adBusiness business WHERE business.area IN (:areas) AND screen.isPublishScreen='true'";
    public static final String FETCH_SCREENS_BY_AREA = "FETCH_SCREENS_BY_AREA";

    public static final String FETCH_SCREENS_BY_AUDIENCE_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.adBusiness business WHERE business.area IN (:areas)";
    public static final String FETCH_SCREENS_BY_AUDIENCE_ID = "FETCH_SCREENS_BY_AUDIENCE_ID";

    private static final long serialVersionUID = 2301296823801925900L;

    //public static final String FETCH_TARGET_SCREENS_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.adBusiness business screen.screenArea area INNER JOIN screen.businessType busType INNER JOIN screen.audienceTypes audType WHERE area.areaCode IN (:areaCodes) AND busType.businessTypeCode IN (:businessCodes) AND audType.audienceCode IN (:audienceCodes)";
    //public static final String FETCH_TARGET_SCREENS  = "FETCH_TARGET_SCREENS";
    //we have program screencodes - i think we need to do away with this query and use those instead
    //public static final String FETCH_SCREENS_BY_PROGRAM_ID_QUERY = "SELECT DISTINCT screen FROM AdScreen screen INNER JOIN screen.businessTypes businessTypes INNER JOIN screen.screenArea area INNER JOIN screen.adPrograms prog INNER JOIN prog.client cl INNER JOIN cl.adUser user where user.userId IN (:userId) AND prog.campaignId IN (:campaignIds)";
    //public static final String FETCH_SCREENS_BY_PROGRAM_ID = "FETCH_SCREENS_BY_PROGRAM_ID";
    //public static final String FETCH_SCREENCODES_BY_PROG_ID_QUERY = "SELECT DISTINCT screen.screenId FROM AdScreen screen INNER JOIN screen.adPrograms prog WHERE prog.campaignId=:campaignId";
    //public static final String FETCH_SCREENCODES_BY_PROGRAM_ID = "FETCH_SCREENCODES_BY_PROGRAM_ID";
    //---> was commented --> public static final String FETCH_TARGETED_AREAS_QUERY = "SELECT DISTINCT area FROM AdScreen screen, screen.screenArea area WHERE screen.screenId=:screenId";
    //---> was commented --> public static final String FETCH_TARGETED_AREAS_QUERY = "SELECT DISTINCT area FROM AdScreen screen INNER JOIN screen.screenArea area WHERE screen.screenId=:screenId";
    //---> was commented --> SQL works -> SELECT DISTINCT area.area_code FROM adexpo_main.ad_screen screen, adexpo_main.ad_screen_area area WHERE screen.screen_id='KOKO2';
    //public static final String FETCH_TARGETED_AREAS_QUERY = "SELECT DISTINCT area FROM AdScreen screen INNER JOIN screen.screenArea area INNER JOIN screen.adPrograms prog WHERE prog.campaignId=:campaignId";
    //public static final String FETCH_TARGETED_AREAS = "FETCH_TARGETED_AREAS";    
    //public static final String FETCH_TARGETED_BUSINESS_TYPES_QUERY = "SELECT DISTINCT business FROM AdScreen screen INNER JOIN screen.businessTypes business INNER JOIN screen.adPrograms prog WHERE prog.campaignId=:campaignId";
    //public static final String FETCH_TARGETED_BUSINESS_TYPES = "FETCH_TARGETED_BUSINESS_TYPES";
    //public static final String FETCH_TARGETED_AUDIENCE_TYPES_QUERY = "SELECT DISTINCT audience FROM AdScreen screen INNER JOIN screen.audienceTypes audience INNER JOIN screen.adPrograms prog WHERE prog.campaignId=:campaignId";
    //public static final String FETCH_TARGETED_AUDIENCE_TYPES = "FETCH_TARGETED_AUDIENCE_TYPES";
    //@Expose
    //@SerializedName(value = "screen_value") //different screens will fall in diff categories depending on location, audience_count, audience_type, size, etc
    //@Column(name = "screen_value")
    //private float screenValue; //a percentage value e.g 1.2 or 0.75
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
    @SerializedName(value = "screen_size_code")
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "screen_size_code", referencedColumnName = "screen_size_code")
    })
    @Cascade(CascadeType.ALL)
    private AdScreenSize screenSize;

//    @Expose
//    @SerializedName(value = "audience_count")
//    @Column(name = "audience_count")
//    private int audienceCount;
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
    @SerializedName(value = "business")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "business_id", referencedColumnName = "business_id") //get business name from here for GET_SCREENS
    })
    @Cascade(CascadeType.ALL)
    private AdBusiness adBusiness;// owner of this screen is a business -  what about the business object on screenOwner object ??? we need to get rid of one or the other

    @Column(name = "screen_popularity")
    @Enumerated(EnumType.STRING)
    private ScreenPopularity screenPopularity;//in comparison to other screens in same area if more than one 

    @Column(name = "publish")
    private boolean isPublishScreen; //show screen on user UI or not

    @Column(name = "allow_volume")
    private boolean isAllowVolume;

    @Column(name = "screen_placement")
    private String screenPlacement; // e.g. front lounge area

    @Column(name = "extra_1")
    private String extra1; //any other info (descriptive info) to identify this screen e.g. front lounge area

    @Column(name = "extra_2")
    private String extra2;

    public boolean isIsPublishScreen() {
        return isPublishScreen;
    }

    public void setIsPublishScreen(boolean isPublishScreen) {
        this.isPublishScreen = isPublishScreen;
    }

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

    public AdBusiness getAdBusiness() {
        return adBusiness;
    }

    public void setAdBusiness(AdBusiness adBusiness) {
        this.adBusiness = adBusiness;
    }

    public AdScreenSize getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(AdScreenSize screenSize) {
        this.screenSize = screenSize;
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

    public String getScreenPlacement() {
        return screenPlacement;
    }

    public void setScreenPlacement(String screenPlacement) {
        this.screenPlacement = screenPlacement;
    }

    public ScreenPopularity getScreenPopularity() {
        return screenPopularity;
    }

    public void setScreenPopularity(ScreenPopularity screenPopularity) {
        this.screenPopularity = screenPopularity;
    }

    public boolean isIsAllowVolume() {
        return isAllowVolume;
    }

    public void setIsAllowVolume(boolean isAllowVolume) {
        this.isAllowVolume = isAllowVolume;
    }

    /**
     * Different screens will fall in different categories depending on
     * location, audience_count, audience_type, size, etc
     *
     * @return
     */
//    public float getSScreenValue() {
//        return screenValue;
//    }
//
//    public void setSScreenValue(float screenValue) {
//        this.screenValue = screenValue;
//    }
    /* @Expose
    @SerializedName(value = "screen_area")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "screen_area_code", referencedColumnName = "area_code") // we can leave this Join-Column out, if we leave it out, Hibernate will use the entity Id
    })
    @Cascade({CascadeType.ALL})
    private AdArea screenArea;*/
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
