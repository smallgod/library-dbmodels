package com.library.datamodel.model.v1_0;

import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_terminal", uniqueConstraints = @UniqueConstraint(columnNames = {"terminal_id", "task_id"}))

public class AdTerminal extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Column(name = "terminal_id")
    private long terminalId;

    @Column(name = "task_id")
    private int taskId;

    @Column(name = "latitude", precision = 9, scale = 7)
    private double latitude;

    @Column(name = "longitude", precision = 9, scale = 7)
    private double longitude;

    //private int displayWidth; //terminal resolution ??
    //private int displayHeight;
    public AdTerminal() {
    }

    public long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(long terminalId) {
        this.terminalId = terminalId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

}
