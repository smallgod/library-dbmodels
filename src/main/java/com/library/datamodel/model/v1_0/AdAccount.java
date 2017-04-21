package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.ValueStore;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
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
@Table(name = "ad_account", uniqueConstraints = @UniqueConstraint(columnNames = {"account_number"}))

@NamedQueries({
    @NamedQuery(name = AdAccount.FETCH_USER_ACCOUNTS, query = AdAccount.FETCH_USER_ACCOUNTS_QUERY),
    @NamedQuery(name = AdAccount.FETCH_THIS_ACCOUNT, query = AdAccount.FETCH_THIS_ACCOUNT_QUERY),
    @NamedQuery(name = AdAccount.FETCH_ACCOUNT, query = AdAccount.FETCH_ACCOUNT_QUERY),
    @NamedQuery(name = AdAccount.FETCH_PREFERRED_ACCOUNT, query = AdAccount.FETCH_PREFERRED_ACCOUNT_QUERY)
})

//This account will be used for both payment accounts (advertisers) and recieving accounts (screen owners)
public class AdAccount extends BaseEntity implements Auditable, Serializable {

    public static final String FETCH_USER_ACCOUNTS_QUERY = "SELECT DISTINCT account FROM AdAccount account INNER JOIN account.adUsers users where users.userId=:userId";
    public static final String FETCH_USER_ACCOUNTS = "FETCH_USER_ACCOUNTS";
    
     public static final String FETCH_THIS_ACCOUNT_QUERY = "SELECT DISTINCT account FROM AdAccount account INNER JOIN account.adUsers users where account.accountNumber=:accountNumber";
    public static final String FETCH_THIS_ACCOUNT = "FETCH_THIS_ACCOUNT";

    public static final String FETCH_PREFERRED_ACCOUNT_QUERY = "SELECT DISTINCT account FROM AdAccount account INNER JOIN account.adUsers users where users.userId=:userId AND account.isAccountPreferred=:ispreferred";
    public static final String FETCH_PREFERRED_ACCOUNT = "FETCH_PREFERRED_ACCOUNT";

    public static final String FETCH_ACCOUNT_QUERY = "SELECT DISTINCT account FROM AdAccount account INNER JOIN account.adUsers users where users.userId=:userId AND account.accountNumber=:accountNumber";
    public static final String FETCH_ACCOUNT = "FETCH_ACCOUNT";

    private static final long serialVersionUID = 1590135329856889692L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @SerializedName(value = "account_number")
    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "value_store")
    @Enumerated(EnumType.STRING)
    private ValueStore valueStore;

    @SerializedName(value = "account_preferred")
    @Column(name = "account_preferred")
    private boolean isAccountPreferred;

    //multiple users can pay from the same account or decide to recieve payments (screen owners) on the same account - we don't mind
    @SerializedName(value = "account_number_holders")
    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "account_number_holders",
            joinColumns = {
                @JoinColumn(name = "account_number", referencedColumnName = "account_number")

            },
            inverseJoinColumns = {
                @JoinColumn(name = "user_id", referencedColumnName = "user_id")
            }
    )
    @Cascade({CascadeType.ALL})
    private Set<AdUser> adUsers = new HashSet<>(0); //change this after migrating to better design -> Businesses own account numbers not Users

    public AdAccount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.accountNumber);
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
        final AdAccount other = (AdAccount) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.accountNumber, other.getAccountNumber());
    }

    public ValueStore getValueStore() {
        return valueStore;
    }

    public void setValueStore(ValueStore valueStore) {
        this.valueStore = valueStore;
    }

    public boolean isIsAccountPreferred() {
        return isAccountPreferred;
    }

    public void setIsAccountPreferred(boolean isAccountPreferred) {
        this.isAccountPreferred = isAccountPreferred;
    }

    public Set<AdUser> getAdUsers() {
        return adUsers;
    }

    public void setAdUsers(Set<AdUser> adUsers) {
        this.adUsers = adUsers;
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
