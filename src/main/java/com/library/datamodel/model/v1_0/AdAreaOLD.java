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
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_area")


public class AdAreaOLD extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "country")
    private String Country;

    @Column(name = "region")
    private String region; //Central / Western / 

    @Column(name = "district")
    private String District;

    @Column(name = "area_name", length = 1000) //might want to change this - what if the data is too long
    private String areaName; //e.g. Bugolobi -> areaName can be concantenated to the other params below with a '-' delimeter

    @Column(name = "sub_area")
    private String subArea1; //a sub area below the area-name

    @Column(name = "sub_area_2")
    private String subArea2;

    public AdAreaOLD() {
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubArea1() {
        return subArea1;
    }

    public void setSubArea1(String subArea1) {
        this.subArea1 = subArea1;
    }

    public String getSubArea2() {
        return subArea2;
    }

    public void setSubArea2(String subArea2) {
        this.subArea2 = subArea2;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.areaCode);
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
        final AdAreaOLD other = (AdAreaOLD) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.areaCode, other.getAreaCode());
    }

}

//    @SerializedName(value = "area_screens")
//    @OneToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "area_screens",
//            joinColumns = {
//                @JoinColumn(name = "area_code", referencedColumnName = "area_code", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
//            }
//    )
