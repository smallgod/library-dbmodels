package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.jaxb.config.v1_0.Amounttype;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.jadira.usertype.dateandtime.joda.PersistentLocalTime;
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
    )
})
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "time_slot", uniqueConstraints = @UniqueConstraint(columnNames = {"slot_code"}))

public class TimeSlot extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -4958704682470297016L;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;
    
    
    @SerializedName(value = "slot_code")
    @Column(name = "slot_code", length = 30)
    private String timeSlotCode; // "EARLY_BIRD"

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

    public TimeSlot() {
    }

    public String getTimeSlotCode() {
        return timeSlotCode;
    }

    public void setTimeSlotCode(String timeSlotCode) {
        this.timeSlotCode = timeSlotCode;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
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

}
