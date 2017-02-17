package com.library.datamodel.model.v1_0;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_monitor", uniqueConstraints = @UniqueConstraint(columnNames = {"monitor_id"}))

public class AdMonitor extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -3896516545777190361L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @Column(name = "monitor_id")
    private String monitorId;

    
////    private AdProgram adProgram;

    @Column(name = "sched_screen_count")
    private int scheduledScreenCount; //number of screens to reach for this schedule

    @Column(name = "screens_reached")
    private int screensReached; // number of screens actually reached

    public AdMonitor() {
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public String getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(String monitorId) {
        this.monitorId = monitorId;
    }

//    public AdProgram getAdProgram() {
//        return adProgram;
//    }
//
//    public void setAdProgram(AdProgram adProgram) {
//        this.adProgram = adProgram;
//    }

    public int getScheduledScreenCount() {
        return scheduledScreenCount;
    }

    public void setScheduledScreenCount(int scheduledScreenCount) {
        this.scheduledScreenCount = scheduledScreenCount;
    }

    public int getScreensReached() {
        return screensReached;
    }

    public void setScreensReached(int screensReached) {
        this.screensReached = screensReached;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}


//@OneToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//        @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false)
//    })
