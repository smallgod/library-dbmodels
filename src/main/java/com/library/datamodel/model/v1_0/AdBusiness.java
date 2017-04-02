package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;

@TypeDefs({
    @TypeDef(name = "jodalocaldatetime", typeClass = PersistentLocalDateTime.class,
            parameters = {
                @Parameter(value = "UTC", name = "databaseZone"),
                @Parameter(value = "UTC", name = "javaZone")
            }
    ),
    @TypeDef(name = "jodalocaldate", typeClass = PersistentLocalDate.class,
            parameters = {
                @Parameter(value = "UTC", name = "databaseZone"),
                @Parameter(value = "UTC", name = "javaZone")
            }
    )
})
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_business", uniqueConstraints = @UniqueConstraint(columnNames = {"business_id"}))

public class AdBusiness extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -8412758120450080292L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

     @Expose
    @SerializedName(value = "is_default")
    @Column(name = "is_default")
    private boolean isDefault; //default business a user is advertising from if no business is explicitly selected
     
    @Expose
    @SerializedName(value = "business_id")
    @Column(name = "business_id", nullable = false)
    private String businessId; // a combination of 3 letters & 3 numbers (unique id)

    @SerializedName(value = "business_name")
    @Column(name = "business_name")
    private String businessName;

    @Expose
    @SerializedName(value = "business_type_code")
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "business_type", referencedColumnName = "business_type_code")
    })
    @Cascade(CascadeType.ALL)
    private AdBusinessType businessType; // e.g. Plumbing | Telecom

    @Expose
    @SerializedName(value = "business_location")
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "business_location", referencedColumnName = "area_code")
    })
    @Cascade(CascadeType.ALL)
    private AdArea businessLocation; // e.g. Ntinda

    @SerializedName(value = "target_audience")
    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "business_target_audience",
            joinColumns = {
                @JoinColumn(name = "business_id", referencedColumnName = "business_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "audience_code", referencedColumnName = "audience_code")
            }
    )
    @Cascade({CascadeType.ALL})//e.g. Boda-Boda Riders | ALL | Corporates
    private Set<AdAudienceType> targetAudience = new HashSet<>(0);

    @SerializedName(value = "business_owners")
    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "business_owners",
            joinColumns = {
                @JoinColumn(name = "business_id", referencedColumnName = "business_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "user_id")
            }
    )
    @Cascade({CascadeType.ALL})//multiple users can own the same business, one user can own multiple businesses
    private Set<AdUser> businessOwners = new HashSet<>(0);

    public AdBusiness() {
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Set<AdAudienceType> getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(Set<AdAudienceType> targetAudience) {
        this.targetAudience = targetAudience;
    }

    public AdBusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(AdBusinessType businessType) {
        this.businessType = businessType;
    }

    public AdArea getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(AdArea businessLocation) {
        this.businessLocation = businessLocation;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.businessId);
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
        final AdBusiness other = (AdBusiness) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.businessId, other.getBusinessId());
    }

    public Set<AdUser> getBusinessOwners() {
        return businessOwners;
    }

    public void setBusinessOwners(Set<AdUser> businessOwners) {
        this.businessOwners = businessOwners;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

}

//@SerializedName(value = "client_programs")
//    @OneToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "client_programs",
//            joinColumns = {
//                @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "client_program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false),
//                @JoinColumn(name = "campaign_name", referencedColumnName = "campaign_name", nullable = false, insertable = false, updatable = false)
//            }
//    )
//    //@Cascade(CascadeType.SAVE_UPDATE)
