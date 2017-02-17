package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

//@Entity(name = "recon_entity1")
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "audience_type", uniqueConstraints = @UniqueConstraint(columnNames = {"audience_code"}))
//@Table(name = "audience_type")

public class AudienceType extends BaseEntity implements Auditable, Serializable {

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

    @SerializedName(value = "audience_type_screens")
    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "audience_type_screens",
            joinColumns = {
                @JoinColumn(name = "audience_code", referencedColumnName = "audience_code")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id")
            }
    )
    @Cascade({CascadeType.ALL})
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

//    public Set<AdScreen> getAdAudienceScreens() {
//        return adAudienceScreens;
//    }
//
//    public void setAdAudienceScreens(Set<AdScreen> adAudienceScreens) {
//        this.adAudienceScreens = adAudienceScreens;
//    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<AdScreen> getAdScreens() {
        return adScreens;
    }

    public void setAdScreens(Set<AdScreen> adScreens) {
        this.adScreens = adScreens;
    }

}
