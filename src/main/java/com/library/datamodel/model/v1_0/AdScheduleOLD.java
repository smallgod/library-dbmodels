package com.library.datamodel.model.v1_0;

import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "ad_schedule_old", uniqueConstraints = @UniqueConstraint(columnNames = {"audience_code"}))

public class AdScheduleOLD extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -3186734784130219196L;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
    //@JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID", nullable = false, insertable = false, updatable = false) 
    })
    private AdProgram adProgram;

    @Column(name = "detail", length = 10000)
    private String scheduleDetail; //e.g. {"schedule":[{"time":{"slot":"EARLY_BIRD","preferred":7},"day":["MON","WED","SAT","SUN"]},{"time":{"slot":"PRIME","preferred":9},"day":["FRI","SAT","SUN"]}]}

    @Column(name = "start_date")
    @Type(type = "jodalocaldate")
    private LocalDate startDate;

    @Column(name = "end_date")
    @Type(type = "jodalocaldate")
    private LocalDate endDate;

    public AdScheduleOLD() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public AdProgram getAdProgram() {
        return adProgram;
    }

    public void setAdProgram(AdProgram adProgram) {
        this.adProgram = adProgram;
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
}
