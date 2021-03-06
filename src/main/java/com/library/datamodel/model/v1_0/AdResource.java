package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenRegion;
import com.library.datamodel.Constants.ResourceType;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
//@Table(name = "ad_resource")
@Table(name = "ad_resource", uniqueConstraints = @UniqueConstraint(columnNames = {"upload_id"}))
@NamedQueries({
    @NamedQuery(name = AdResource.FETCH_RESOURCE_BY_UPLOADID, query = AdResource.FETCH_RESOURCE_BY_UPLOADID_QUERY),
    @NamedQuery(name = AdResource.FETCH_RESOURCE_BY_CAMPAIGNID, query = AdResource.FETCH_RESOURCE_BY_CAMPAIGNID_QUERY),
    @NamedQuery(name = AdResource.FETCH_RESOURCE_BY_ENTITYID, query = AdResource.FETCH_RESOURCE_BY_ENTITYID_QUERY),
    @NamedQuery(name = AdResource.FETCH_RES_BY_CAMPNID_N_UPLDID, query = AdResource.FETCH_RES_BY_CAMPNID_N_UPLDID_QUERY)
})
public class AdResource extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -5362654229120480614L;

    //public static final String FETCH_RESOURCE_BY_UPLOADID_QUERY = "SELECT DISTINCT resource FROM AdResource resource INNER JOIN resource.adResourcePrograms programs where programs.campaignId=:campaignId";
    public static final String FETCH_RESOURCE_BY_UPLOADID_QUERY = "SELECT DISTINCT resource FROM AdResource resource INNER JOIN resource.adResourcePrograms programs where resource.uploadId=:uploadId";
    public static final String FETCH_RESOURCE_BY_UPLOADID = "FETCH_RESOURCE_BY_UPLOADID";

    public static final String FETCH_RESOURCE_BY_CAMPAIGNID_QUERY = "SELECT DISTINCT resource FROM AdResource resource INNER JOIN resource.adResourcePrograms programs where programs.campaignId=:campaignId";
    public static final String FETCH_RESOURCE_BY_CAMPAIGNID = "FETCH_RESOURCE_BY_CAMPAIGNID";

    public static final String FETCH_RESOURCE_BY_ENTITYID_QUERY = "SELECT DISTINCT resource FROM AdResource resource INNER JOIN resource.adResourcePrograms programs where resource.id=:id";
    public static final String FETCH_RESOURCE_BY_ENTITYID = "FETCH_RESOURCE_BY_ENTITYID";

    public static final String FETCH_RES_BY_CAMPNID_N_UPLDID_QUERY = "SELECT DISTINCT resource FROM AdResource resource INNER JOIN resource.adResourcePrograms programs where programs.campaignId=:campaignId AND resource.uploadId=:uploadId";
    public static final String FETCH_RES_BY_CAMPNID_N_UPLDID = "FETCH_RES_BY_CAMPNID_N_UPLDID";

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
    @Column(name = "upload_id")
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
    private boolean isUploadedToDSM; //we need to choose how to use this. Either to show we have uploaded a file to DSM or to show we have already uploaded and generated a file ID - resource ID for this file

    @Expose
    @SerializedName(value = "program_resources")
    @ManyToMany(fetch = FetchType.EAGER)//LAZY works especially with HQL though with criteria it was throwing the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "program_resources",//EAGER works with criteria but throws the infamous NullPointer exceptin while trying to execute the select query

            joinColumns = {
                @JoinColumn(name = "upload_id", referencedColumnName = "upload_id")

            },
            inverseJoinColumns = {
                @JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id")
            }
    )
    @Cascade({CascadeType.ALL})
    @OrderBy("id")
    private Set<AdProgram> adResourcePrograms = new HashSet<>();

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

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 43 * hash + Objects.hashCode(this.uploadId);
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
        final AdResource other = (AdResource) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.uploadId, other.getUploadId());
    }

}
