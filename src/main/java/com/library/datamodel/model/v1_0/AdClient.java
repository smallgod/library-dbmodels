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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
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
@Table(name = "ad_client")

@NamedQueries({
    @NamedQuery(name = AdClient.FETCH_CLIENTS, query = AdClient.FETCH_CLIENT_QUERY)
})
public class AdClient extends BaseEntity implements Auditable, Serializable {

    public static final String FETCH_CLIENT_QUERY = "SELECT DISTINCT client FROM AdClient client INNER JOIN client.adUser user where user.userId=:userId";
    public static final String FETCH_CLIENTS = "FETCH_CLIENTS";

    private static final long serialVersionUID = -6439854988797731103L;

    @Expose
    @Id
    @GeneratedValue(generator = "adClientKeyGenerator")
    @GenericGenerator(
            name = "adClientKeyGenerator",
            strategy = "foreign",
            parameters = @Parameter(
                    value = "adUser",
                    name = "property"
            )
    )
    private long id;

    @Expose
    @SerializedName(value = "number_of_programs")
    @Column(name = "number_of_programs")
    private int numberOfPrograms;

    @Expose
    @SerializedName(value = "censor")
    @Column(name = "censor")
    private boolean isToBeCensored; //whether we need to take programs/ads from this account through a check for approval (this means a couple of minutes' delay before scheduling)

    @Expose
    @SerializedName(value = "user_id")
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    })
    @Cascade(CascadeType.ALL)
    private AdUser adUser;

    public AdClient() {
    }

    public int getNumberOfPrograms() {
        return numberOfPrograms;
    }

    public void setNumberOfPrograms(int numberOfPrograms) {
        this.numberOfPrograms = numberOfPrograms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isIsToBeCensored() {
        return isToBeCensored;
    }

    public void setIsToBeCensored(boolean isToBeCensored) {
        this.isToBeCensored = isToBeCensored;
    }

    public AdUser getAdUser() {
        return adUser;
    }

    public void setAdUser(AdUser adUser) {
        this.adUser = adUser;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.adUser);
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
        final AdClient other = (AdClient) obj;
        if (this.id != other.getId()) {
            return false;
        }

        return Objects.equals(this.adUser, other.getAdUser());
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
