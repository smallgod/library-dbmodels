package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalTime;
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
@Table(name = "ad_audience_count", uniqueConstraints = @UniqueConstraint(columnNames = {"code"}))

@NamedQueries({
    @NamedQuery(name = AdAudienceCount.COUNT_AUDIENCE_BY_SCREEN_CODE, query = AdAudienceCount.COUNT_AUDIENCE_BY_SCREEN_CODE_QUERY)
})

public class AdAudienceCount extends BaseEntity implements Auditable, Serializable {

    public static final String COUNT_AUDIENCE_BY_SCREEN_CODE_QUERY = "SELECT DISTINCT audienceCount FROM AdAudienceCount audienceCount INNER JOIN audienceCount.adTimeSlot timeSlot INNER JOIN audienceCount.adScreen screen WHERE screen.screenId IN (:screenId)";
    public static final String COUNT_AUDIENCE_BY_SCREEN_CODE = "COUNT_AUDIENCE_BY_SCREEN_CODE";

    private static final long serialVersionUID = 5475033620308432546L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @SerializedName(value = "code")
    @Column(name = "code", nullable = false)
    private long code;

    @SerializedName(value = "monday")
    @Column(name = "monday")
    private int monday;

    @SerializedName(value = "tuesday")
    @Column(name = "tuesday")
    private int tuesday;

    @SerializedName(value = "wednesday")
    @Column(name = "wednesday")
    private int wednesday;

    @SerializedName(value = "thursday")
    @Column(name = "thursday")
    private int thursday;

    @SerializedName(value = "friday")
    @Column(name = "friday")
    private int friday;

    @SerializedName(value = "saturday")
    @Column(name = "saturday")
    private int saturday;

    @SerializedName(value = "sunday")
    @Column(name = "sunday")
    private int sunday;

    @SerializedName(value = "holiday")
    @Column(name = "holiday")
    private int holiday;

    @SerializedName(value = "today")
    @Column(name = "today")
    private int today; //audience count can have a bump on a given day due to perhaps an event at a location

    @Expose
    @SerializedName(value = "slot_code")
    @OneToOne(fetch = FetchType.EAGER) //// ?????? one2one ??//
    @JoinColumns({
        @JoinColumn(name = "slot_code", referencedColumnName = "slot_code")
    })
    @Cascade(CascadeType.ALL)
    private AdTimeSlot adTimeSlot;

    @Expose
    @SerializedName(value = "screen_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "screen_id", referencedColumnName = "screen_id")
    })
    @Cascade(CascadeType.ALL)
    private AdScreen adScreen;

    public AdAudienceCount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    public int getSaturday() {
        return saturday;
    }

    public void setSaturday(int saturday) {
        this.saturday = saturday;
    }

    public int getSunday() {
        return sunday;
    }

    public void setSunday(int sunday) {
        this.sunday = sunday;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public int getToday() {
        return today;
    }

    public void setToday(int today) {
        this.today = today;
    }

    public AdTimeSlot getAdTimeSlot() {
        return adTimeSlot;
    }

    public void setAdTimeSlot(AdTimeSlot adTimeSlot) {
        this.adTimeSlot = adTimeSlot;
    }

    public AdScreen getAdScreen() {
        return adScreen;
    }

    public void setAdScreen(AdScreen adScreen) {
        this.adScreen = adScreen;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + (int) (this.code ^ (this.code >>> 32));
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
        final AdAudienceCount other = (AdAudienceCount) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return this.code == other.getCode();
    }
}
