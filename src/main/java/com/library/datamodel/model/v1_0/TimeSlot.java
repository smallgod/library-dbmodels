package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.jaxb.config.v1_0.Amounttype;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
@Table(name = "time_slot", uniqueConstraints = @UniqueConstraint(columnNames = {"time_slot_id"}))

public class TimeSlot extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -4958704682470297016L;

    @SerializedName(value = "slot_id")
    @Column(name = "slot_id")
    private long timeSlotId;

    @SerializedName(value = "slot_name")
    
    @Column(name = "slot_name")
    private String timeSlotName;

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

    public TimeSlot() {
    }

    public long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

}
