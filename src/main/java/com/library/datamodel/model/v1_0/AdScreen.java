package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenSize;
import com.library.datamodel.Constants.AdScreenType;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
//@Table(name = "ad_screen", uniqueConstraints = @UniqueConstraint(columnNames = {"screen_id"}))
@Table(name = "ad_screen")
public class AdScreen extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = 2301296823801925900L;

    @SerializedName(value = "screen_id")
    @Column(name = "screen_id")
    private String screenId;

    @SerializedName(value = "screen_owner")
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "owner_id", referencedColumnName = "owner_id")
    })
    private AdScreenOwner screenOwner;

    @SerializedName(value = "vendor_name")
    @Column(name = "vendor_name")
    private String vendorName;

    @SerializedName(value = "screen_type")
    @Column(name = "screen_type")
    @Enumerated(EnumType.STRING)
    private AdScreenType screenType;

    @SerializedName(value = "screen_size")
    @Column(name = "screen_size")
    @Enumerated(EnumType.STRING)
    private AdScreenSize screenSize; // in inches e.g. 32 inch TV

//    @SerializedName(value = "audience")
//    @Column(name = "audience_list")
//    @ManyToMany
//    @Cascade(CascadeType.SAVE_UPDATE)//cascade on save and update but not delete (so we didnt use .ALL
//    private Set<AudienceType> audienceTypes = new HashSet<AudienceType>(0);// e.g. ALL, MEN, WOMEN, CORPORATES, STUDENTS
    @SerializedName(value = "audience_list")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "list_screen_audience_types",
            joinColumns = {
                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "audience_code", referencedColumnName = "audience_code", nullable = false, updatable = false)
            }
    )
    //@Cascade(CascadeType.SAVE_UPDATE)
    private Set<AudienceType> audienceTypes = new HashSet<>(0);// e.g. ALL, MEN, WOMEN, CORPORATES, STUDENTS

    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "location_type_code", referencedColumnName = "location_type_code")
    })
    @SerializedName(value = "location_type_code")
    private LocationType locationType; //BAR, SALON, SPORTS_HOUSE, HOTEL

    @SerializedName(value = "audience_count")
    @Column(name = "audience_count")
    private int audienceCount;

    @SerializedName(value = "screen_area")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "area_code", referencedColumnName = "area_code")
    })
    private AdScreenArea screenArea; //where the screen is located

    @SerializedName(value = "display_width")
    @Column(name = "display_width")
    private int displayWidth;

    @SerializedName(value = "display_height")
    @Column(name = "display_height")
    private int displayHeight;

    @SerializedName(value = "terminal")
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "terminal_id", referencedColumnName = "terminal_id")
    })
    private AdTerminal supportTerminal;

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

    public AdScreenOwner getScreenOwner() {
        return screenOwner;
    }

    public void setScreenOwner(AdScreenOwner screenOwner) {
        this.screenOwner = screenOwner;
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

    public Set<AudienceType> getAudienceTypes() {
        return audienceTypes;
    }

    public void setAudienceTypes(Set<AudienceType> audienceTypes) {
        this.audienceTypes = audienceTypes;
    }

    public AdScreenArea getScreenArea() {
        return screenArea;
    }

    public void setScreenArea(AdScreenArea screenArea) {
        this.screenArea = screenArea;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

}
