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

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_resource")

public class AdResource extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -5362654229120480614L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Expose
    @SerializedName(value = "resource_id")
    @Column(name = "resource_id") //this by default should be zero(0), since this resourceId is just generated later
    private long resourceId = 0;

    @Expose
    @SerializedName(value = "resource_sequence")
    @Column(name = "resource_sequence")
    private int sequence = 1;

    @Expose(deserialize = false, serialize = false)
    @SerializedName(value = "upload_id")
    @Column(name = "upload_id") //this by default should be zero(0), since this resourceId is just generated later
    private String uploadId;

    @Expose
    @SerializedName(value = "resource_name")
    @Column(name = "resource_name")
    private String resourceName;

    @Expose
    @SerializedName(value = "res_description")
    @Column(name = "res_description")
    private String resourceDesc;

    @Expose
    @SerializedName(value = "resource_type")
    @Column(name = "resource_type")
    @Enumerated(EnumType.ORDINAL)
    private ResourceType resourceType;

    @Expose
    @SerializedName(value = "resource_size")
    @Column(name = "resource_size")
    private long resourceSize;

    @Expose
    @SerializedName(value = "resource_code")
    @Column(name = "resource_code")
    private long resourseCode; //sum

    @Expose
    @SerializedName(value = "region")
    @Column(name = "region")
    @Enumerated(EnumType.STRING)
    private AdScreenRegion screenRegion; //region of the screen where the advert is going to display

    @Expose
    @SerializedName(value = "uploaded_to_dsm")
    @Column(name = "uploaded_to_dsm")
    private boolean isUploadedToDSM;

    @Expose
    @SerializedName(value = "program_resources")
    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "program_resources",
            joinColumns = {
                @JoinColumn(name = "upload_id")

            },
            inverseJoinColumns = {
                @JoinColumn(name = "program_join_id")
            }
    )
    @Cascade({CascadeType.ALL})
    private Set<AdProgram> adResourcePrograms = new HashSet<>(0);

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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<AdProgram> getAdResourcePrograms() {
        return adResourcePrograms;
    }

    public void setAdResourcePrograms(Set<AdProgram> adResourcePrograms) {
        this.adResourcePrograms = adResourcePrograms;
    }

}
