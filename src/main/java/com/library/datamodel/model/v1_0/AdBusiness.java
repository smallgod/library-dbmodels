package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.LocationType;
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
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
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
@Table(name = "ad_business", uniqueConstraints = @UniqueConstraint(columnNames = {"business_id"}))

@NamedQueries({
    @NamedQuery(name = AdBusiness.FETCH_BUSINESS_BY_ID, query = AdBusiness.FETCH_BUSINESS_BY_ID_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_BUSINESS_SERVICES, query = AdBusiness.FETCH_BUSINESS_SERVICES_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_BUSINESS_SERVICES_BY_ID, query = AdBusiness.FETCH_BUSINESS_SERVICES_BY_ID_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_BUSINESS_BY_AUDIENCETYPE, query = AdBusiness.FETCH_BUSINESS_BY_AUDIENCETYPE_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_BUSINESS_BY_SERVICE_ID, query = AdBusiness.FETCH_BUSINESS_BY_SERVICE_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_AUDIENCE_TYPES_BY_BIZ_ID, query = AdBusiness.FETCH_AUDIENCE_TYPES_BY_BIZ_ID_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_AUDIENCE_TYPES, query = AdBusiness.FETCH_AUDIENCE_TYPES_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_AREAS, query = AdBusiness.FETCH_AREAS_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_BUSINESS_TYPES, query = AdBusiness.FETCH_BUSINESS_TYPES_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_AUDIENCETYPE_BY_ID, query = AdBusiness.FETCH_AUDIENCETYPE_BY_ID_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_AUDIENCE_TYPE_IDS, query = AdBusiness.FETCH_AUDIENCE_TYPE_IDS_QUERY),
    @NamedQuery(name = AdBusiness.FETCH_BUSINESS_TYPE_IDS, query = AdBusiness.FETCH_BUSINESS_TYPE_IDS_QUERY)
    
    
    

})
//can be used for both screens and normal areas in the database
/**
 * When sending back locations for search by location, we can use AdArea and
 * depending on the number of screens available in a certain area we can mixup
 * what we send back to UI e.g. if there are 20 screens in wandegeya market and
 * 5 screens in Karamoja, we can return an array of wandegeya - 20 screens &
 * Karamoja - 5 screens -> so the JSON object "name" should not be restricted to
 * only "area_name" object
 */
public class AdBusiness extends BaseEntity implements Auditable, Serializable {

    public static final String FETCH_BUSINESS_BY_ID_QUERY = "SELECT business FROM AdBusiness business WHERE business.businessId=:businessId";
    public static final String FETCH_BUSINESS_BY_ID = "FETCH_BUSINESS_BY_ID";

    public static final String FETCH_BUSINESS_SERVICES_QUERY = "SELECT DISTINCT businessServices FROM AdBusiness business INNER JOIN business.businessServices businessServices";
    public static final String FETCH_BUSINESS_SERVICES = "FETCH_BUSINESS_SERVICES";

    public static final String FETCH_BUSINESS_SERVICES_BY_ID_QUERY = "SELECT DISTINCT businessServices FROM AdBusiness business INNER JOIN business.businessServices businessServices WHERE businessServices.id IN (:ids)";
    public static final String FETCH_BUSINESS_SERVICES_BY_ID = "FETCH_BUSINESS_SERVICES_BY_ID";

    public static final String FETCH_AUDIENCETYPE_BY_ID_QUERY = "SELECT DISTINCT audienceTypes FROM AdBusiness business INNER JOIN business.audienceTypes audienceTypes WHERE audienceTypes.id IN (:ids)";
    public static final String FETCH_AUDIENCETYPE_BY_ID = "FETCH_AUDIENCETYPE_BY_ID";

    public static final String FETCH_BUSINESS_BY_AUDIENCETYPE_QUERY = "SELECT DISTINCT business FROM AdBusiness business INNER JOIN business.audienceTypes audience WHERE audience.id=:id";
    public static final String FETCH_BUSINESS_BY_AUDIENCETYPE = "FETCH_BUSINESS_BY_AUDIENCETYPE";

    public static final String FETCH_BUSINESS_BY_SERVICE_QUERY = "SELECT DISTINCT business FROM AdBusiness business INNER JOIN business.businessServices businessServices WHERE businessServices.id=:id";
    public static final String FETCH_BUSINESS_BY_SERVICE_ID = "FETCH_BUSINESS_BY_SERVICE_ID";

    public static final String FETCH_AUDIENCE_TYPES_BY_BIZ_ID_QUERY = "SELECT DISTINCT audienceTypes FROM AdBusiness business INNER JOIN business.audienceTypes audienceTypes WHERE business.id IN (:ids)";
    public static final String FETCH_AUDIENCE_TYPES_BY_BIZ_ID = "FETCH_AUDIENCE_TYPES_BY_BIZ_ID";

    public static final String FETCH_AUDIENCE_TYPES_QUERY = "SELECT DISTINCT audienceTypes FROM AdBusiness business INNER JOIN business.audienceTypes audienceTypes";
    public static final String FETCH_AUDIENCE_TYPES = "FETCH_AUDIENCE_TYPES";
    
    public static final String FETCH_AUDIENCE_TYPE_IDS_QUERY = "SELECT DISTINCT audienceTypes.id FROM AdBusiness business INNER JOIN business.audienceTypes audienceTypes";
    public static final String FETCH_AUDIENCE_TYPE_IDS = "FETCH_AUDIENCE_TYPE_IDS";

    public static final String FETCH_AREAS_QUERY = "SELECT DISTINCT business.area FROM AdBusiness business";
    public static final String FETCH_AREAS = "FETCH_AREAS";

    public static final String FETCH_BUSINESS_TYPES_QUERY = "SELECT DISTINCT businessServices FROM AdBusiness business INNER JOIN business.businessServices businessServices";
    public static final String FETCH_BUSINESS_TYPES = "FETCH_BUSINESS_TYPES";
    
    public static final String FETCH_BUSINESS_TYPE_IDS_QUERY = "SELECT DISTINCT businessServices.id FROM AdBusiness business INNER JOIN business.businessServices businessServices";
    public static final String FETCH_BUSINESS_TYPE_IDS = "FETCH_BUSINESS_TYPE_IDS";

    private static final long serialVersionUID = -9145189073667975787L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Expose
    @SerializedName(value = "is_default")
    @Column(name = "is_default")
    private boolean isDefault; //default business a user is advertising from if no business is explicitly selected OR a default business for the screen owner

    @Expose
    @SerializedName(value = "business_id")
    @Column(name = "business_id", nullable = false)
    private String businessId; // a combination of 4 letters representing the business name (must be unique)

    @SerializedName(value = "is_open_today")
    @Column(name = "is_open_today")
    private boolean isOpenToday; //whether business is open today - especially for advertising locations
    /**
     * total screens available at location - don't have to be signed up
     */
    @SerializedName(value = "total_screens")
    @Column(name = "total_screens")
    private int numberOfScreens = 0;

    @SerializedName(value = "business_name")
    @Column(name = "business_name")
    private String businessName; //commonly used business name

    @SerializedName(value = "registered_name")
    @Column(name = "registered_name")
    private String registeredName; //official business name

    @SerializedName(value = "phone_contact")
    @Column(name = "phone_contact", nullable = false)
    private String phoneContact;

    @SerializedName(value = "secondary_contact")
    @Column(name = "secondary_contact")
    private String secondaryContact;

    @SerializedName(value = "plot_num")
    @Column(name = "plot_num")
    private String plotNumber;

    @SerializedName(value = "building_name")
    @Column(name = "building_name")
    private String buildingName;

    @SerializedName(value = "street_name")
    @Column(name = "street_name")
    private String streetName;

    @SerializedName(value = "sub_area_2")
    @Column(name = "sub_area_2")
    private String subArea2;

    @SerializedName(value = "sub_area_1")
    @Column(name = "sub_area_1")
    private String subArea1; //a sub area below the area-name

    @SerializedName(value = "area")
    @Column(name = "area", length = 1000) //might want to change this - what if the data is too long
    private String area; //e.g. Parish like -> kyanja or City center -> areaName can be concantenated to the other params below with a '-' delimeter

    @SerializedName(value = "division")
    @Column(name = "division")
    private String division;

    @SerializedName(value = "district")
    @Column(name = "district")
    private String district;

    @SerializedName(value = "state_province")
    @Column(name = "state_province")
    private String state;

    @SerializedName(value = "country")
    @Column(name = "country")
    private String country;

    @SerializedName(value = "type")
    @Column(name = "type")//Business can be belong to either an advertising client or a screen owner
    @Enumerated(EnumType.STRING)
    private LocationType type; //ADVERT_LOCATION | CLIENT_LOCATION | BOTH

    @Expose
    @SerializedName(value = "business_owner_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "business_owner_id", referencedColumnName = "user_id")
    })
    @Cascade(CascadeType.ALL)
    private AdUser adUser;

    @Expose
    @SerializedName(value = "audience_xtics_id")
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "audience_xtics_id", referencedColumnName = "id")
    })
    @Cascade(CascadeType.ALL)
    private AdAudienceXtics audienceXtics;

    @Expose
    @SerializedName(value = "business_hours_id")
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "business_hours_id", referencedColumnName = "id")
    })
    @Cascade(CascadeType.ALL)
    private AdBusinessHours businessHours;

    @SerializedName(value = "location_audience_types")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "location_audience_types",
            joinColumns = {
                @JoinColumn(name = "business_id", referencedColumnName = "business_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "audience_type_id", referencedColumnName = "id")
            }
    )
    @Cascade({CascadeType.ALL})
    private Set<AdAudienceType> audienceTypes = new HashSet<>(0);

    @SerializedName(value = "location_business_services")
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "location_business_services",
            joinColumns = {
                @JoinColumn(name = "business_id", referencedColumnName = "business_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "business_service_id", referencedColumnName = "id") // we can leave this Join-Column out, if we leave it out, Hibernate will use the entity Id
            }
    )
    @Cascade({CascadeType.ALL})
    private Set<AdBusinessService> businessServices = new HashSet<>(0);

    public AdBusiness() {
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public int getNumberOfScreens() {
        return numberOfScreens;
    }

    public void setNumberOfScreens(int numberOfScreens) {
        this.numberOfScreens = numberOfScreens;
    }

    public String getRegisteredName() {
        return registeredName;
    }

    public void setRegisteredName(String registeredName) {
        this.registeredName = registeredName;
    }

    public String getSecondaryContact() {
        return secondaryContact;
    }

    public void setSecondaryContact(String secondaryContact) {
        this.secondaryContact = secondaryContact;
    }

    public String getPlotNumber() {
        return plotNumber;
    }

    public void setPlotNumber(String plotNumber) {
        this.plotNumber = plotNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getSubArea2() {
        return subArea2;
    }

    public void setSubArea2(String subArea2) {
        this.subArea2 = subArea2;
    }

    public String getSubArea1() {
        return subArea1;
    }

    public void setSubArea1(String subArea1) {
        this.subArea1 = subArea1;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public AdUser getAdUser() {
        return adUser;
    }

    public void setAdUser(AdUser adUser) {
        this.adUser = adUser;
    }

    public AdAudienceXtics getAudienceXtics() {
        return audienceXtics;
    }

    public void setAudienceXtics(AdAudienceXtics audienceXtics) {
        this.audienceXtics = audienceXtics;
    }

    public boolean isIsOpenToday() {
        return isOpenToday;
    }

    public void setIsOpenToday(boolean isOpenToday) {
        this.isOpenToday = isOpenToday;
    }

    public AdBusinessHours getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(AdBusinessHours businessHours) {
        this.businessHours = businessHours;
    }

    public Set<AdAudienceType> getAudienceTypes() {
        return audienceTypes;
    }

    public void setAudienceTypes(Set<AdAudienceType> audienceTypes) {
        this.audienceTypes = audienceTypes;
    }

    public Set<AdBusinessService> getBusinessServices() {
        return businessServices;
    }

    public void setBusinessServices(Set<AdBusinessService> businessServices) {
        this.businessServices = businessServices;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.businessId);
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
        final AdBusiness other = (AdBusiness) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.businessId, other.getBusinessId());
    }
}

//@SerializedName(value = "client_programs")
//    @OneToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "client_programs",
//            joinColumns = {
//                @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "client_program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false),
//                @JoinColumn(name = "campaign_name", referencedColumnName = "campaign_name", nullable = false, insertable = false, updatable = false)
//            }
//    )
//    //@Cascade(CascadeType.SAVE_UPDATE)
