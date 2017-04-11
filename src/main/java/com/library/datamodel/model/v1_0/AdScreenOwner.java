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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name = "ad_screenowner")

public class AdScreenOwner extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @Expose
    @SerializedName(value = "user_id")
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    })
    @Cascade(CascadeType.ALL)
    private AdUser adUser;

    @SerializedName(value = "business_screen_owners")
    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "business_screen_owners",
            joinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "user_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "business_id", referencedColumnName = "business_id")

            }
    )
    @Cascade({CascadeType.ALL})//multiple users can own the same business, one user can own multiple businesses
    private Set<AdBusiness> businessScreenOwners = new HashSet<>(0);

    public AdScreenOwner() {
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AdUser getAdUser() {
        return adUser;
    }

    public void setAdUser(AdUser adUser) {
        this.adUser = adUser;
    }

    public Set<AdBusiness> getBusinessScreenOwners() {
        return businessScreenOwners;
    }

    public void setBusinessScreenOwners(Set<AdBusiness> businessScreenOwners) {
        this.businessScreenOwners = businessScreenOwners;
    }

}

//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//@Cascade(CascadeType.SAVE_UPDATE)
//@Fetch(FetchMode.JOIN)
//    @JoinTable(name = "owner_screens",
//            joinColumns = {
//                @JoinColumn(name = "owner_id", referencedColumnName = "owner_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
//
//            }
//    )
