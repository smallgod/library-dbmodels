package com.library.datamodel.model.v1_0;

import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

//@Entity(name = "recon_entity1")
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_terminal")

//id int auto_increment primary key, subject varchar(30),description varchar(100), targetArea varchar(40),startTime varchar(20),endTime varchar(20),imageUrl varchar(100),contactDetails varchar(50),category varchar (30),paymentMethod varchar(30),advertType varchar(20),advertiserType varchar(30), terminalDeviceId varchar (10000),DateSent currentTimestamp)")
public class AdTerminal extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Column(name = "terminal_dev_id", nullable = false, unique = true)
    private String terminalDeviceId;

    @Column(name = "audience_count", nullable = true, unique = false)
    private int audienceCount;

    @OneToOne(fetch = FetchType.LAZY)
    //@JoinColumns({ //see TbFile.java class for details using this relation
    //			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
//			@JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID", nullable = false, insertable = false, updatable = false) 
//        })
    @Column(name = "area")
    private Area area;

    @Column(name = "audience_type")
    @ManyToOne
    private AudienceType audienceType;

    @Column(name = "latitude")
    private long latitude;

    @Column(name = "longitude")
    private long longitude;
    

    public AdTerminal(String advertiserId) {
        this.terminalDeviceId = advertiserId;
    }

    public AdTerminal() {
        this(""); //initialise fields
    }

    public String getTerminalDeviceId() {
        return terminalDeviceId;
    }

    public void setTerminalDeviceId(String terminalDeviceId) {
        this.terminalDeviceId = terminalDeviceId;
    }

   

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public void setAudienceCount(int audienceCount) {
        this.audienceCount = audienceCount;
    }


    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public AudienceType getAudienceType() {
        return audienceType;
    }

    public void setAudienceType(AudienceType audienceType) {
        this.audienceType = audienceType;
    }

    

}
