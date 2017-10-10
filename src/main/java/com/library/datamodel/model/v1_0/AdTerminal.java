package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
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
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.jadira.usertype.dateandtime.joda.PersistentLocalTime;

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
@Table(name = "ad_terminal", uniqueConstraints = @UniqueConstraint(columnNames = {"terminal_id"}))

@NamedQueries({
    @NamedQuery(name = AdTerminal.FETCH_TERMINAL, query = AdTerminal.FETCH_TERMINAL_QUERY)
})
public class AdTerminal extends BaseEntity implements Auditable, Serializable {

    public static final String FETCH_TERMINAL_QUERY = "SELECT supportTerminal FROM AdTerminal supportTerminal WHERE supportTerminal.terminalId=:terminalId";
    public static final String FETCH_TERMINAL = "FETCH_TERMINAL";

    private static final long serialVersionUID = -7420964819128665745L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @Column(name = "terminal_id")
    @SerializedName(value = "terminal_id")
    private String terminalId;

    @Column(name = "terminal_name")
    @SerializedName(value = "terminal_name")
    private String terminalName;

    @Column(name = "terminal_description")
    @SerializedName(value = "terminal_description")
    private String terminalDescription;

    @Column(name = "task_idx")
    @SerializedName(value = "task_idx")
    private int taskIdX;

    @Column(name = "task_idy")
    @SerializedName(value = "task_idy")
    private int taskIdY;

    @Column(name = "task_idz")
    @SerializedName(value = "task_idz")
    private int taskIdZ;

    @Column(name = "latitude", precision = 9, scale = 7)
    @SerializedName(value = "latitude")
    private double latitude;

    @Column(name = "longitude", precision = 9, scale = 7)
    @SerializedName(value = "longitude")
    private double longitude;

    public AdTerminal() {
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
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

    public int getTaskIdX() {
        return taskIdX;
    }

    public void setTaskIdX(int taskIdX) {
        this.taskIdX = taskIdX;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getTerminalDescription() {
        return terminalDescription;
    }

    public void setTerminalDescription(String terminalDescription) {
        this.terminalDescription = terminalDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTaskIdY() {
        return taskIdY;
    }

    public void setTaskIdY(int taskIdY) {
        this.taskIdY = taskIdY;
    }

    public int getTaskIdZ() {
        return taskIdZ;
    }

    public void setTaskIdZ(int taskIdZ) {
        this.taskIdZ = taskIdZ;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + Objects.hashCode(this.terminalId);
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
        final AdTerminal other = (AdTerminal) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.terminalId, other.getTerminalId());
    }

}
