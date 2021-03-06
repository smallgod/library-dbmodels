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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_business_service", uniqueConstraints = @UniqueConstraint(columnNames = {"busines_service_short_name"}))

public class AdBusinessService extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -1139458573433634348L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @SerializedName(value = "busines_service_name")
    @Column(name = "busines_service_name", length = 1000)
    private String businessServiceName;

    /**
     * will be used for giving more description to GET_SCREENS response
     */
    //BAR | SALON | SPORTS_HOUSE | HOTEL | HOSTELS | SCHOOLS | UNIVERSITIES | AIRPORT | BIBANDA | RESTAURANT | SUPERMARKET | SHOP
    @SerializedName(value = "busines_service_short_name")
    @Column(name = "busines_service_short_name", length = 1000, nullable = false)
    private String businessServiceShortName;

    public AdBusinessService() {
    }

    public String getBusinessServiceName() {
        return businessServiceName;
    }

    public void setBusinessServiceName(String businessServiceName) {
        this.businessServiceName = businessServiceName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessServiceShortName() {
        return businessServiceShortName;
    }

    public void setBusinessServiceShortName(String businessServiceShortName) {
        this.businessServiceShortName = businessServiceShortName;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

}
