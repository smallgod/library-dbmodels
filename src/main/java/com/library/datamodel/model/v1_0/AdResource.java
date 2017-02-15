package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenRegion;
import com.library.datamodel.Constants.ResourceType;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_resource", uniqueConstraints = @UniqueConstraint(columnNames = {"upload_id"}))

public class AdResource extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -5362654229120480614L;

    @Column(name = "resource_id") //this by default should be zero(0), since this resourceId is just generated later
    @SerializedName(value = "resource_id")
    private long resourceId = 0;

    @Column(name = "resource_sequence")
    @SerializedName(value = "resource_sequence")
    private int sequence = 1;

    @Column(name = "upload_id") //this by default should be zero(0), since this resourceId is just generated later
    @Expose(deserialize = false, serialize = false)
    private String uploadId;

    @Column(name = "resource_name")
    @SerializedName(value = "resource_name")
    private String resourceName;

    @Column(name = "res_description")
    @SerializedName(value = "res_description")
    private String resourceDesc;

    @Column(name = "resource_type")
    @Enumerated(EnumType.ORDINAL)
    @SerializedName(value = "resource_type")
    private ResourceType resourceType;

    @Column(name = "resource_size")
    private long resourceSize;

    @Column(name = "resource_code")
    @SerializedName(value = "resource_code")
    private long resourseCode; //sum

    @Column(name = "region")
    @Enumerated(EnumType.STRING)
    @SerializedName(value = "region")
    private AdScreenRegion screenRegion; //region of the screen where the advert is going to display

    @Column(name = "uploaded_to_dsm")
    @SerializedName(value = "uploaded_to_dsm")
    private boolean isUploadedToDSM;

    //for now comment the Many-to-Many out but ideally we should be able tö use resources across multiple programs i.e. Many-to-Many
//    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adResourceList")//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    private Set<AdProgram> adProgramResources = new HashSet<>();
//    
    public AdResource() {
    }

    public long getResourceId() {
        return resourceId;
    }

    public void setResourceId(long resourceId) {
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

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
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

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    /*public Set<AdProgram> getAdProgramResources() {
        return adProgramResources;
    }

    public void setAdProgramResources(Set<AdProgram> adProgramResources) {
        this.adProgramResources = adProgramResources;
    }
     */
    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

//    public Set<AdProgram> getAdProgramResources() {
//        return adProgramResources;
//    }
//
//    public void setAdProgramResources(Set<AdProgram> adProgramResources) {
//        this.adProgramResources = adProgramResources;
//    }


}
