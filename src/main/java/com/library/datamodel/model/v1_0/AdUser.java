package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdXpoAccountStatus;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
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
@Table(name = "ad_user", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id"}))

public class AdUser extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -9199479009606759914L;

    @Expose
    @Id
    @GeneratedValue(generator = "myGenerator")
    @GenericGenerator(
            name = "adUserKeyGenerator",
            strategy = "foreign",
            parameters = @Parameter(
                    value = "business",
                    name = "property"
            )
    )
    private long id;

    @Expose
    @SerializedName(value = "user_id")
    @Column(name = "user_id", nullable = false)
    private String userId = "770000000"; //this can be a telephone number  / primary contact / default for guests

    @Column(name = "password", nullable = false)
    private String password = "#password#"; //default password for guests

    @Column(name = "password_encrypted")
    private boolean isPasswordEncrypted = Boolean.FALSE; //default for guests

    @Column(name = "primary_phone", nullable = false)
    private String primaryPhone = "256770000000"; //default for guests

    @Column(name = "other_phone")
    private String otherPhone;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "first_name")
    private String firstName = "Guest";

    @Column(name = "last_name")
    private String lastName;

    @Expose
    @SerializedName(value = "business_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
        @JoinColumn(name = "business_id") // we can leave this Join-Column out, if we leave it out, Hibernate will use the entity Id
    })
    @Cascade({CascadeType.ALL})
    private AdBusiness business;

    @Column(name = "failed_login_attempts")
    private int failedLoginAttempts;

    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    private AdXpoAccountStatus accountStatus;

    @Column(name = "agreed_to_terms")
    private boolean agreedToTermsOfuse;

    @Column(name = "otp")
    private int otp;

    @Type(type = "jodalocaldatetime")
    @Column(name = "otp_expiry_date")
    @SerializedName(value = "otp_expiry_date")
    private LocalDateTime otpExpiryDate;

    public AdUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AdBusiness getBusiness() {
        return business;
    }

    public void setBusiness(AdBusiness business) {
        this.business = business;
    }

    public int getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(int failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public AdXpoAccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AdXpoAccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public boolean isAgreedToTermsOfuse() {
        return agreedToTermsOfuse;
    }

    public void setAgreedToTermsOfuse(boolean agreedToTermsOfuse) {
        this.agreedToTermsOfuse = agreedToTermsOfuse;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public LocalDateTime getOtpExpiryDate() {
        return otpExpiryDate;
    }

    public void setOtpExpiryDate(LocalDateTime otpExpiryDate) {
        this.otpExpiryDate = otpExpiryDate;
    }

    public boolean isIsPasswordEncrypted() {
        return isPasswordEncrypted;
    }

    public void setIsPasswordEncrypted(boolean isPasswordEncrypted) {
        this.isPasswordEncrypted = isPasswordEncrypted;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 83 * hash + Objects.hashCode(this.userId);
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
        final AdUser other = (AdUser) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.userId, other.getUserId());
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
