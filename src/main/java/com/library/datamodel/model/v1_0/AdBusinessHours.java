package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalTime;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.LocalTime;

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
    ),
    @TypeDef(name = "jodalocaltime", typeClass = PersistentLocalTime.class,
            parameters = {
                @Parameter(value = "UTC", name = "databaseZone"),
                @Parameter(value = "UTC", name = "javaZone")
            }
    )
})
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_business_hours")

public class AdBusinessHours extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = 7763590605747655539L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @SerializedName(value = "open_monday")
    @Column(name = "open_monday")
    @Type(type = "jodalocaltime")
    private LocalTime openMonday;

    @SerializedName(value = "open_tuesday")
    @Column(name = "open_tuesday")
    @Type(type = "jodalocaltime")
    private LocalTime openTuesday;

    @SerializedName(value = "open_wednesday")
    @Column(name = "open_wednesday")
    @Type(type = "jodalocaltime")
    private LocalTime openWednesday;

    @SerializedName(value = "open_thursday")
    @Column(name = "open_thursday")
    @Type(type = "jodalocaltime")
    private LocalTime openThursday;

    @SerializedName(value = "open_friday")
    @Column(name = "open_friday")
    @Type(type = "jodalocaltime")
    private LocalTime openFriday;

    @SerializedName(value = "open_saturday")
    @Column(name = "open_saturdayy")
    @Type(type = "jodalocaltime")
    private LocalTime openSaturday;

    @SerializedName(value = "open_sunday")
    @Column(name = "open_sunday")
    @Type(type = "jodalocaltime")
    private LocalTime openSunday;

    @SerializedName(value = "open_holiday")
    @Column(name = "open_holiday")
    @Type(type = "jodalocaltime")
    private LocalTime openHoliday; //if closed - 0000

    @SerializedName(value = "close_monday")
    @Column(name = "close_monday")
    @Type(type = "jodalocaltime")
    private LocalTime closeMonday;

    @SerializedName(value = "close_tuesday")
    @Column(name = "close_tuesday")
    @Type(type = "jodalocaltime")
    private LocalTime closeTuesday;

    @SerializedName(value = "close_wednesday")
    @Column(name = "close_wednesday")
    @Type(type = "jodalocaltime")
    private LocalTime closeWednesday;

    @SerializedName(value = "close_thursday")
    @Column(name = "close_thursday")
    @Type(type = "jodalocaltime")
    private LocalTime closeThursday;

    @SerializedName(value = "close_friday")
    @Column(name = "close_friday")
    @Type(type = "jodalocaltime")
    private LocalTime closeFriday;

    @SerializedName(value = "close_saturday")
    @Column(name = "close_saturday")
    @Type(type = "jodalocaltime")
    private LocalTime closeSaturday;

    @SerializedName(value = "close_sunday")
    @Column(name = "close_sunday")
    @Type(type = "jodalocaltime")
    private LocalTime closeSunday;

    @SerializedName(value = "close_holiday")
    @Column(name = "close_holiday")
    @Type(type = "jodalocaltime")
    private LocalTime closeHoliday;//if closed - 0000

    public AdBusinessHours() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public LocalTime getOpenMonday() {
        return openMonday;
    }

    public void setOpenMonday(LocalTime openMonday) {
        this.openMonday = openMonday;
    }

    public LocalTime getOpenTuesday() {
        return openTuesday;
    }

    public void setOpenTuesday(LocalTime openTuesday) {
        this.openTuesday = openTuesday;
    }

    public LocalTime getOpenWednesday() {
        return openWednesday;
    }

    public void setOpenWednesday(LocalTime openWednesday) {
        this.openWednesday = openWednesday;
    }

    public LocalTime getOpenThursday() {
        return openThursday;
    }

    public void setOpenThursday(LocalTime openThursday) {
        this.openThursday = openThursday;
    }

    public LocalTime getOpenFriday() {
        return openFriday;
    }

    public void setOpenFriday(LocalTime openFriday) {
        this.openFriday = openFriday;
    }

    public LocalTime getOpenSaturday() {
        return openSaturday;
    }

    public void setOpenSaturday(LocalTime openSaturday) {
        this.openSaturday = openSaturday;
    }

    public LocalTime getOpenSunday() {
        return openSunday;
    }

    public void setOpenSunday(LocalTime openSunday) {
        this.openSunday = openSunday;
    }

    public LocalTime getOpenHoliday() {
        return openHoliday;
    }

    public void setOpenHoliday(LocalTime openHoliday) {
        this.openHoliday = openHoliday;
    }

    public LocalTime getCloseMonday() {
        return closeMonday;
    }

    public void setCloseMonday(LocalTime closeMonday) {
        this.closeMonday = closeMonday;
    }

    public LocalTime getCloseTuesday() {
        return closeTuesday;
    }

    public void setCloseTuesday(LocalTime closeTuesday) {
        this.closeTuesday = closeTuesday;
    }

    public LocalTime getCloseWednesday() {
        return closeWednesday;
    }

    public void setCloseWednesday(LocalTime closeWednesday) {
        this.closeWednesday = closeWednesday;
    }

    public LocalTime getCloseThursday() {
        return closeThursday;
    }

    public void setCloseThursday(LocalTime closeThursday) {
        this.closeThursday = closeThursday;
    }

    public LocalTime getCloseFriday() {
        return closeFriday;
    }

    public void setCloseFriday(LocalTime closeFriday) {
        this.closeFriday = closeFriday;
    }

    public LocalTime getCloseSaturday() {
        return closeSaturday;
    }

    public void setCloseSaturday(LocalTime closeSaturday) {
        this.closeSaturday = closeSaturday;
    }

    public LocalTime getCloseSunday() {
        return closeSunday;
    }

    public void setCloseSunday(LocalTime closeSunday) {
        this.closeSunday = closeSunday;
    }

    public LocalTime getCloseHoliday() {
        return closeHoliday;
    }

    public void setCloseHoliday(LocalTime closeHoliday) {
        this.closeHoliday = closeHoliday;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final AdBusinessHours other = (AdBusinessHours) obj;
        return this.id == other.getId();
    }
    
    

}
