package com.library.datamodel.model.v1_0;

import com.library.datamodel.Constants.AdScreenRegion;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_resource")

public class AdResource extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -5362654229120480614L;

    @Column(name = "resource_id") //this can be null, since this resourceId is just generated later
    private String resourceId;

    @Column(name = "name")
    private String resourceName;

    @Column(name = "res_descript")
    private String resourceDesc;

    @Column(name = "type")
    private int resourceType;

    @Column(name = "resource_size")
    private long resourceSize;

    @Column(name = "resource_code")
    private long resourseCode; //sum

    @Column(name = "region")
    @Enumerated(EnumType.STRING)
    private AdScreenRegion screenRegion; //region of the screen where the advert is going to display

    @Column(name = "uploaded_to_dsm")
    private boolean isUploadedToDSM;

    public AdResource() {
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    public int getResourceType() {
        return resourceType;
    }

    public void setResourceType(int resourceType) {
        this.resourceType = resourceType;
    }

    public long getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(long resourceSize) {
        this.resourceSize = resourceSize;
    }

    public long getResourseCode() {
        return resourseCode;
    }

    public void setResourseCode(long resourseCode) {
        this.resourseCode = resourseCode;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public boolean isIsUploadedToDSM() {
        return isUploadedToDSM;
    }

    public void setIsUploadedToDSM(boolean isUploadedToDSM) {
        this.isUploadedToDSM = isUploadedToDSM;
    }

    public AdScreenRegion getScreenRegion() {
        return screenRegion;
    }

    public void setScreenRegion(AdScreenRegion screenRegion) {
        this.screenRegion = screenRegion;
    }

}
