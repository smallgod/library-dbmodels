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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_terminal", uniqueConstraints = @UniqueConstraint(columnNames = {"terminal_id", "task_id"}))

public class AdTerminal extends BaseEntity implements Auditable, Serializable {

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

    @Column(name = "task_id")
    @SerializedName(value = "task_id")
    private int taskId;

    @Column(name = "latitude", precision = 9, scale = 7)
    @SerializedName(value = "latitude")
    private double latitude;

    @Column(name = "longitude", precision = 9, scale = 7)
    @SerializedName(value = "longitude")
    private double longitude;

//    @SerializedName(value = "terminal_screens")
//    @OneToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "terminal_screens",
//            joinColumns = {
//                @JoinColumn(name = "terminal_id", referencedColumnName = "terminal_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
//            }
//    )
//    @Cascade(CascadeType.SAVE_UPDATE)
//    private Set<AdScreen> terminalScreens = new HashSet<>(0);
//    @SerializedName(value = "terminal_screen")
//    @OneToOne //For now, let's have only one screen (max) for every terminal
//    @JoinColumns({
//        @JoinColumn(name = "screen_id", referencedColumnName = "screen_id")
//    })
//    @Cascade(CascadeType.SAVE_UPDATE)
//    private AdScreen terminalScreen;
    //private int displayWidth; //terminal resolution ??
    //private int displayHeight;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.terminalId);
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
