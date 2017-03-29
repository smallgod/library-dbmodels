package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
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
@Table(name = "ad_api_credentials")

public class AdAPICredentials extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = 2875511788949066175L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    /**
     * APP Id will determine if this is a web client request or an app request
     * and which particular app. For Web clients, we have one / same appId, for
     * mobile apps, we have one appId assigned to each app at installation
     */
    @Column(name = "app_id")
    private String appId;

    @Column(name = "api_password")
    private String apiPassword;

    public AdAPICredentials() {
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

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.appId);
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
        final AdAPICredentials other = (AdAPICredentials) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.appId, other.getAppId());
    }

    public String getApiPassword() {
        return apiPassword;
    }

    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
    }

}


/*@Expose
    @SerializedName(value = "resource_list")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adResourcePrograms")
    @Cascade({CascadeType.ALL})
    private Set<AdResource> adResourceList = new HashSet<>(0);

    @Expose
    @SerializedName(value = "text_list")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adTextPrograms")
    @Cascade({CascadeType.ALL})
    private Set<AdText> adTextList = new HashSet<>(0);*/
//    @SerializedName(value = "program_screens")
//    @ManyToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "list_program_screens",
//            joinColumns = {
//                @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "screen_id", referencedColumnName = "screen_id", nullable = false, insertable = false, updatable = false)
//            }
//    )
//for now comment the Many-to-Many out but ideally we should be able tö use resources across multiple programs i.e. Many-to-Many
//    @SerializedName(value = "program_resources") // for now we comment this guy Many-to-Many guy out
//    @ManyToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "list_program_resources",
//            joinColumns = {
//                @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "upload_id", referencedColumnName = "upload_id", nullable = false, insertable = false, updatable = false)
//            }
//    )
//    @SerializedName(value = "program_resources")
//    @OneToMany(fetch = FetchType.EAGER) //To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
//    @JoinTable(name = "program_resources",
//            joinColumns = {
//                @JoinColumn(name = "program_id", referencedColumnName = "program_id", nullable = false, insertable = false, updatable = false)
//            },
//            inverseJoinColumns = {
//                //@JoinColumn(name = "resource_id",   referencedColumnName = "resource_id", nullable = false, insertable = false, updatable = false),
//                @JoinColumn(name = "resource_size", referencedColumnName = "resource_size", nullable = false, insertable = false, updatable = false)
//                //@JoinColumn(name = "resource_name", referencedColumnName = "resource_name", nullable = false, insertable = false, updatable = false)
//            }
//    )
//    //@Cascade(CascadeType.SAVE_UPDATE)
//    private Set<AdResource> adResources = new HashSet<>(0)
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumns({
//        @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//    })
//    //@Cascade(CascadeType.SAVE_UPDATE)
//    private Set<AdScreen> adScreenList = new HashSet<>();//all the screens on which this ad needs to display
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumns({
//        @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//    })
//    //@Cascade(CascadeType.SAVE_UPDATE)
//    
//
//  @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumns({
//        @JoinColumn(name = "program_join_id", referencedColumnName = "program_join_id", nullable = false, insertable = false, updatable = false)
//    })
//    //@Cascade(CascadeType.SAVE_UPDATE)
