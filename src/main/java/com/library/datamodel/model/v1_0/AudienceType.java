package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdPaymentStatus;
import com.library.datamodel.Constants.AdvertStatus;
import com.library.datamodel.Constants.AdvertStep;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

//@Entity(name = "recon_entity1")
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "area")

//id int auto_increment primary key, subject varchar(30),description varchar(100), targetArea varchar(40),startTime varchar(20),endTime varchar(20),imageUrl varchar(100),contactDetails varchar(50),category varchar (30),paymentMethod varchar(30),advertType varchar(20),advertiserType varchar(30), audienceCode varchar (10000),DateSent currentTimestamp)")
public class AudienceType extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Column(name = "audience_code", nullable = false, unique = true)
    private String audienceCode;

    @Column(name = "audience_name", length = 1000) //might want to change this - what if the data is too long
    private String audienceName;

    public AudienceType(String audienceCode, String audienceName) {
        this.audienceCode = audienceCode;
        this.audienceName = audienceName;
    }

    public AudienceType() {
        this("", ""); //initialise fields
    }

    public String getAudienceCode() {
        return audienceCode;
    }

    public void setAudienceCode(String audienceCode) {
        this.audienceCode = audienceCode;
    }

    public String getAudienceName() {
        return audienceName;
    }

    public void setAudienceName(String audienceName) {
        this.audienceName = audienceName;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

}
