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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
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

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    //@EmbeddedId private AdSchedCompositeId key;
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
    private boolean isToUpdate; //True - If we need to fetch this schedule and update DSM and the row as well

    @Expose
    @SerializedName(value = "schedule_screen")
    @ManyToOne(fetch = FetchType.EAGER) //Many schedules can have the same adScreen
    @JoinColumns({
        @JoinColumn(name = "screen_id", referencedColumnName = "screen_id")
    })
    @Cascade(CascadeType.ALL)
    private AdScreen adScreen;

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

    public long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AdScreen getAdScreen() {
        return adScreen;
    }

    public void setAdScreen(AdScreen adScreen) {
        this.adScreen = adScreen;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + (int) (this.scheduleId ^ (this.scheduleId >>> 32));
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
        final AdSchedule other = (AdSchedule) obj;
        if (this.id != other.getScheduleId()) {
            return false;
        }
        return this.scheduleId == other.getScheduleId();
    }

    /**
     * AdSchedCompositeId generated by hbm2java
     */
    /*@Embeddable
    private class AdSchedCompositeId implements Serializable {

        private int cstmId;
        private int userId;

        public AdSchedCompositeId() {
        }

        public AdSchedCompositeId(int cstmId, int userId) {
            this.cstmId = cstmId;
            this.userId = userId;
        }

        @Column(name = "CSTM_ID", nullable = false)
        public int getCstmId() {
            return this.cstmId;
        }

        public void setCstmId(int cstmId) {
            this.cstmId = cstmId;
        }

        @Column(name = "USER_ID", nullable = false)
        public int getUserId() {
            return this.userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public boolean equals(Object other) {
            if ((this == other)) {
                return true;
            }
            if ((other == null)) {
                return false;
            }
            if (!(other instanceof AdSchedCompositeId)) {
                return false;
            }
            AdSchedCompositeId castOther = (AdSchedCompositeId) other;

            return (this.getCstmId() == castOther.getCstmId()) && (this.getUserId() == castOther.getUserId());
        }

        public int hashCode() {
            int result = 17;

            result = 37 * result + this.getCstmId();
            result = 37 * result + this.getUserId();
            return result;
        }

    }*/
}
