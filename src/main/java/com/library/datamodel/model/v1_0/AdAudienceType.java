package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

//@Entity(name = "recon_entity1")
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_audience_type")
public class AdAudienceType extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    // MEN | WOMEN | KIDS | MEN_WOMEN | CORPORATES | ALL | BODA-RIDERS
    @Column(name = "audience_code")
    private int audienceCode;

    @Column(name = "audience_name", length = 1000) //might want to change this - what if the data is too long
    private String audienceName;

    public AdAudienceType() {
    }

    public int getAudienceCode() {
        return audienceCode;
    }

    public void setAudienceCode(int audienceCode) {
        this.audienceCode = audienceCode;
    }

    public String getAudienceName() {
        return audienceName;
    }

    public void setAudienceName(String audienceName) {
        this.audienceName = audienceName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

}
