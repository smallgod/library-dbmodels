package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenSize;
import com.library.datamodel.Constants.AdScreenType;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_screen", uniqueConstraints = @UniqueConstraint(columnNames = {"screen_id"}))
//@Table(name = "ad_screen")
public class AdScreen extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = 2301296823801925900L;

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
    private AdScreenSize screenSize; // in inches e.g. 32 inch TV

//  private Set<AudienceType> audienceTypes = new HashSet<>(0);// e.g. ALL, MEN, WOMEN, CORPORATES, STUDENTS
//    @OneToOne
//    @JoinColumns({
//        @JoinColumn(name = "location_type_code", referencedColumnName = "location_type_code")
//    })
//    @SerializedName(value = "location_type_code")
//    private LocationType locationType; //BAR, SALON, SPORTS_HOUSE, HOTEL
    @Expose
    @SerializedName(value = "audience_count")
    @Column(name = "audience_count")
    private int audienceCount;

    @Expose
    @SerializedName(value = "display_width")
    @Column(name = "display_width")
    private int displayWidth;

    @Expose
    @SerializedName(value = "display_height")
    @Column(name = "display_height")
    private int displayHeight;

//    @SerializedName(value = "terminal")
//    @OneToOne //To-DO I think it is better to have this relationship owned by the terminal one terminal - > one screen for now, later we can have multiple screens on a terminal
//    @JoinColumns({
//        @JoinColumn(name = "terminal_id", referencedColumnName = "terminal_id")
//    })
//    private AdTerminal supportTerminal;
//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adScreenList")//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    private Set<AdProgram> adPrograms = new HashSet<>(0);

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "owner_id", referencedColumnName = "owner_id") // we can leave this Join-Column out, if we leave it out, Hibernate will use the entity Id
    })
    @SerializedName(value = "screen_owner")
    @Cascade(CascadeType.SAVE_UPDATE)
    private AdScreenOwner screenOwner;

    public AdScreen() {
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

//    public Set<AudienceType> getAudienceTypes() {
//        return audienceTypes;
//    }
//
//    public void setAudienceTypes(Set<AudienceType> audienceTypes) {
//        this.audienceTypes = audienceTypes;
//    }
//    public LocationType getLocationType() {
//        return locationType;
//    }
//
//    public void setLocationType(LocationType locationType) {
//        this.locationType = locationType;
//    }
    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
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
    public AdScreenOwner getScreenOwner() {
        return screenOwner;
    }

    public void setScreenOwner(AdScreenOwner screenOwner) {
        this.screenOwner = screenOwner;
    }
}
