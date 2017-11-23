package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.jaxb.config.v1_0.Amounttype;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
import org.jadira.usertype.dateandtime.joda.PersistentLocalTime;
import org.joda.time.Duration;
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
    ),
    @TypeDef(name = "jodalocaltime", typeClass = PersistentLocalTime.class,
            parameters = {
                @Parameter(value = "UTC", name = "databaseZone"),
                @Parameter(value = "UTC", name = "javaZone")
            }
    ),
    @TypeDef(name = "jodaduration", typeClass = Duration.class,
            parameters = {
                @Parameter(value = "UTC", name = "databaseZone"),
                @Parameter(value = "UTC", name = "javaZone")
            }
    )

})
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_time_slot", uniqueConstraints = @UniqueConstraint(columnNames = {"slot_code"}))

@NamedQueries({
    @NamedQuery(name = AdTimeSlot.FETCH_NON_FREE_SLOTS, query = AdTimeSlot.FETCH_NON_FREE_SLOTS_QUERY),
    @NamedQuery(name = AdTimeSlot.FETCH_TIME_SLOT, query = AdTimeSlot.FETCH_TIME_SLOT_QUERY)
})
public class AdTimeSlot extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = 5331811399461672332L;
    
    public static final String FETCH_TIME_SLOT_QUERY = "SELECT DISTINCT slot FROM AdTimeSlot slot WHERE slot.timeSlotCode=:slotCode";
    public static final String FETCH_TIME_SLOT = "FETCH_TIME_SLOT";

    public static final String FETCH_NON_FREE_SLOTS_QUERY = "SELECT DISTINCT slot FROM AdTimeSlot slot WHERE slot.timeSlotCode NOT IN (:freebie)";
    public static final String FETCH_NON_FREE_SLOTS = "FETCH_NON_FREE_SLOTS";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @SerializedName(value = "slot_code")
    @Column(name = "slot_code", length = 30)
    private String timeSlotCode; // "EARLYBIRD"

    @SerializedName(value = "slot_name")
    @Column(name = "slot_name")
    private String timeSlotName; //"Early Bird"

    @SerializedName(value = "slot_description")
    @Column(name = "slot_description")
    private String timeSlotDescription;

    @SerializedName(value = "slot_start_time")
    @Type(type = "jodalocaltime")
    @Column(name = "slot_start_time")
    private LocalTime startTime; //e.g. 9 // on a scale of 0 - 23 i think we need to include decimals e.g. 9.5 to mean 09hr30

    @SerializedName(value = "slot_end_time")
    @Type(type = "jodalocaltime")
    @Column(name = "slot_end_time")
    private LocalTime endTime;

    @Embedded
    @Column(name = "slot_adprice")
    @SerializedName(value = "slot_adprice")
    private Amounttype slotAdPrice;

    @Expose
    @Column(name = "slot_discount")
    @SerializedName(value = "slot_discount")
    private float slotDiscount; //slots discounted for promotional purpose

    @Expose
    @Column(name = "instant_slot")
    @SerializedName(value = "instant_slot")
    private boolean isInstant;

    @Expose
    @SerializedName(value = "approval_delay")
    @Column(name = "approval_delay")
    private long approvalDelay; // in millis

    public AdTimeSlot() {
    }

    public String getTimeSlotCode() {
        return timeSlotCode;
    }

    public void setTimeSlotCode(String timeSlotCode) {
        this.timeSlotCode = timeSlotCode;
    }

    public String getTimeSlotName() {
        return timeSlotName;
    }

    public void setTimeSlotName(String timeSlotName) {
        this.timeSlotName = timeSlotName;
    }

    public String getTimeSlotDescription() {
        return timeSlotDescription;
    }

    public void setTimeSlotDescription(String timeSlotDescription) {
        this.timeSlotDescription = timeSlotDescription;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Amounttype getSlotAdPrice() {
        return slotAdPrice;
    }

    public void setSlotAdPrice(Amounttype slotAdPrice) {
        this.slotAdPrice = slotAdPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getSlotDiscount() {
        return slotDiscount;
    }

    public void setSlotDiscount(float slotDiscount) {
        this.slotDiscount = slotDiscount;
    }

    public boolean isIsInstant() {
        return isInstant;
    }

    public void setIsInstant(boolean isInstant) {
        this.isInstant = isInstant;
    }

    public long getApprovalDelay() {
        return approvalDelay;
    }

    public void setApprovalDelay(long approvalDelay) {
        this.approvalDelay = approvalDelay;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.timeSlotCode);
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
        final AdTimeSlot other = (AdTimeSlot) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.timeSlotCode, other.getTimeSlotCode());
    }

}
