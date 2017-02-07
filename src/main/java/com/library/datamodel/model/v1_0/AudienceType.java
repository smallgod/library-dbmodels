package com.library.datamodel.model.v1_0;

import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

//@Entity(name = "recon_entity1")
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
//@Table(name = "audience_type", uniqueConstraints = @UniqueConstraint(columnNames = {"audience_code"}))
@Table(name = "audience_type")

public class AudienceType extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    // MEN | WOMEN | KIDS | MEN_WOMEN | CORPORATES | ALL | BODA-RIDERS
    @Column(name = "audience_code")
    private int audienceCode;

    @Column(name = "audience_name", length = 1000) //might want to change this - what if the data is too long
    private String audienceName;
    
    //@ManyToMany(mappedBy = "audienceTypes")
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "audienceTypes")
    private Set<AdScreen> adScreens = new HashSet<>(0);

    public AudienceType() {
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

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public Set<AdScreen> getAdScreens() {
        return adScreens;
    }

    public void setAdScreens(Set<AdScreen> adScreens) {
        this.adScreens = adScreens;
    }

}
