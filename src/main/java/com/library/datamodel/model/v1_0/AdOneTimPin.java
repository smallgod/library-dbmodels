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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.LocalDateTime;

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
@Table(name = "ad_otp")

public class AdOneTimPin extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = 2875511788949066175L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "otp")
    private int otp;

    @Expose
    @SerializedName(value = "otps_sent")
    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "otps_sent",
            joinColumns = {
                @JoinColumn(name = "otp_id")

            },
            inverseJoinColumns = {
                @JoinColumn(name = "primary_phone", referencedColumnName = "primary_phone")
            }
    )
    @Cascade({CascadeType.ALL})
    private Set<AdUser> adUsers = new HashSet<>(0);

    public AdOneTimPin() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public Set<AdUser> getAdUsers() {
        return adUsers;
    }

    public void setAdUsers(Set<AdUser> adUsers) {
        this.adUsers = adUsers;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final AdOneTimPin other = (AdOneTimPin) obj;
        return this.id == other.getId();
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
