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

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_business_type")

public class AdBusinessType extends BaseEntity implements Auditable, Serializable {

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

    public AdBusinessType() {
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
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
    
    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + this.businessTypeCode;
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
        final AdBusinessType other = (AdBusinessType) obj;
        return this.businessTypeCode == other.getBusinessTypeCode();
    }


}
