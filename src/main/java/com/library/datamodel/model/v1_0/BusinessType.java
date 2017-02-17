package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
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
@Table(name = "business_type", uniqueConstraints = @UniqueConstraint(columnNames = {"business_type_code"}))

public class BusinessType extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -1139458573433634348L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    //BAR | SALON | SPORTS_HOUSE | HOTEL | HOSTELS | SCHOOLS | UNIVERSITIES | AIRPORT | BIBANDA | RESTAURANT | SUPERMARKET | SHOP
    @SerializedName(value = "business_type_code")
    @Column(name = "business_type_code")
    private int businessTypeCode;

    @SerializedName(value = "busines_type_name")
    @Column(name = "busines_type_name", length = 1000)
    private String businessTypeName;

    @Expose
    @SerializedName(value = "screens")
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "businessType")
    @Cascade(CascadeType.ALL)
    private Set<AdScreen> screens = new HashSet<>(0);

    public BusinessType() {
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public int getBusinessTypeCode() {
        return businessTypeCode;
    }

    public void setBusinessTypeCode(int businessTypeCode) {
        this.businessTypeCode = businessTypeCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<AdScreen> getScreens() {
        return screens;
    }

    public void setScreens(Set<AdScreen> screens) {
        this.screens = screens;
    }

}
