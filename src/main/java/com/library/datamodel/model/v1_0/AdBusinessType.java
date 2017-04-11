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
    private String businessTypeCode;

    @SerializedName(value = "busines_type_name")
    @Column(name = "busines_type_name", length = 1000)
    private String businessTypeName;

    /**
     * will be used for giving more description to GET_SCREENS response
     */
    @SerializedName(value = "busines_type_short_name")
    @Column(name = "busines_type_short_name", length = 1000)
    private String businessTypeshortName;

    public AdBusinessType() {
    }

    public String getBusinessTypeName() {
        return businessTypeName;
    }

    public void setBusinessTypeName(String businessTypeName) {
        this.businessTypeName = businessTypeName;
    }

    public String getBusinessTypeCode() {
        return businessTypeCode;
    }

    public void setBusinessTypeCode(String businessTypeCode) {
        this.businessTypeCode = businessTypeCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessTypeshortName() {
        return businessTypeshortName;
    }

    public void setBusinessTypeshortName(String businessTypeshortName) {
        this.businessTypeshortName = businessTypeshortName;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 37 * hash + Objects.hashCode(this.businessTypeCode);
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
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.businessTypeCode, other.getBusinessTypeCode());
    }

}
