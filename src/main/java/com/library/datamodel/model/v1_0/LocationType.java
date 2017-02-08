package com.library.datamodel.model.v1_0;

import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "location_type", uniqueConstraints = @UniqueConstraint(columnNames = {"location_type_code"}))

public class LocationType extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -1139458573433634348L;

    @Column(name = "location_type_code")
    private int locationTypeCode;

    @Column(name = "location_type_name", length = 1000)
    private String locationTypeName; //BAR, SALON, SPORTS_HOUSE, HOTEL, HOSTELS, SCHOOLS, UNIVERSITIES, AIRPORT, BIBANDA, RESTAURANT, SUPERMARKET, SHOP, etc

    public LocationType() {
    }

    public String getLocationTypeName() {
        return locationTypeName;
    }

    public void setLocationTypeName(String locationTypeName) {
        this.locationTypeName = locationTypeName;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public int getLocationTypeCode() {
        return locationTypeCode;
    }

    public void setLocationTypeCode(int locationTypeCode) {
        this.locationTypeCode = locationTypeCode;
    }

}
