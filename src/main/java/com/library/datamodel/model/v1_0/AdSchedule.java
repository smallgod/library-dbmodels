package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
import org.joda.time.LocalDate;

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
@Table(name = "ad_schedule", uniqueConstraints = @UniqueConstraint(columnNames = {"schedule_id"}))

public class AdSchedule extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -3186734784130219196L;

    @SerializedName(value = "schedule_id")
    @Column(name = "schedule_id")
    private long scheduleId;

    @SerializedName(value = "schedule")
    @Column(name = "schedule", length = 10000)
    private String scheduleDetail; //e.g. "prog_id:time;prog_id:time" i.e. 764:4563;905:2355; //e.g. {"schedule":[{"time":{"slot":"EARLY_BIRD","preferred":7},"day":["MON","WED","SAT","SUN"]},{"time":{"slot":"PRIME","preferred":9},"day":["FRI","SAT","SUN"]}]}

    @SerializedName(value = "display_date")
    @Column(name = "display_date")
    @Type(type = "jodalocaldate")
    private LocalDate displayDate;

    @Column(name = "to_update")
    private boolean isToUpdate;

    @SerializedName(value = "screen_schedule")
    @ManyToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "list_sreen_schedules",
            joinColumns = {
                @JoinColumn(name = "schedule_id", referencedColumnName = "schedule_id", nullable = false, insertable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
            }
    )
    //@Cascade(CascadeType.SAVE_UPDATE)
    private Set<AdScreen> screenScheduleList = new HashSet<>(0);

    public boolean isIsToUpdate() {
        return isToUpdate;
    }

    public void setIsToUpdate(boolean isToUpdate) {
        this.isToUpdate = isToUpdate;
    }

    public AdSchedule() {
    }

    public LocalDate getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(LocalDate displayDate) {
        this.displayDate = displayDate;
    }

    public String getScheduleDetail() {
        return scheduleDetail;
    }

    public void setScheduleDetail(String scheduleDetail) {
        this.scheduleDetail = scheduleDetail;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Set<AdScreen> getScreenScheduleList() {
        return screenScheduleList;
    }

    public void setScreenScheduleList(Set<AdScreen> screenScheduleList) {
        this.screenScheduleList = screenScheduleList;
    }
}
