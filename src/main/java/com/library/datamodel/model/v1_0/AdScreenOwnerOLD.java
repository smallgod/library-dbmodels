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
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

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

@NamedQueries({
    @NamedQuery(name = AdScreenOwnerOLD.FETCH_OWNERS, query = AdScreenOwnerOLD.FETCH_OWNER_QUERY)
})

public class AdScreenOwnerOLD extends BaseEntity implements Auditable, Serializable {

    public static final String FETCH_OWNER_QUERY = "SELECT DISTINCT owner FROM AdScreenOwner owner INNER JOIN owner.adUser user INNER JOIN owner.businesses businesses where user.userId=:userId";
    public static final String FETCH_OWNERS = "FETCH_OWNERS";

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
    private AdUser adUser; //this is a user who owns the screen, AdUser object might me confusing - perhaps change AdUser to User

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
    @Cascade({CascadeType.ALL})//multiple users can own the same business?? [I think it should be single-owner one or many businesses], one user can own multiple businesses
    private Set<AdBusiness> businesses = new HashSet<>(0);

    public AdScreenOwnerOLD() {
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

    public Set<AdBusiness> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(Set<AdBusiness> businesses) {
        this.businesses = businesses;
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
