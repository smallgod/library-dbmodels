package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdPaymentStatus;
import com.library.datamodel.Constants.ValueStore;
import com.library.datamodel.jaxb.config.v1_0.Amounttype;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Table(name = "ad_payment_details")

public class AdPaymentDetails extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -1408718657632013689L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @Expose
    @SerializedName(value = "payment_status")
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private AdPaymentStatus paymentStatus;

    @Expose
    @Embedded
    @Column(name = "Amount")
    private Amounttype amount;

    @Expose
    @SerializedName(value = "payer_store")
    @Column(name = "payer_store")
    @Enumerated(EnumType.STRING)
    private ValueStore payerValueStore;

    @Expose
    @SerializedName(value = "acknowledgement_date")
    @Column(name = "acknowledgement_date")
    @Type(type = "jodalocaldatetime")
    private LocalDateTime paymentAcknowledgmentDate;

    @Expose
    @SerializedName(value = "payer_account")
    @Column(name = "payer_account")
    private String payerAccount;

    @Expose
    @SerializedName(value = "internal_payment_id")
    @Column(name = "internal_payment_id")
    private String internalPaymentID; //generated internally

    @Expose
    @SerializedName(value = "aggregator_payment_id")
    @Column(name = "aggregator_payment_id")
    private String aggregatorPaymentID;

    @Expose
    @SerializedName(value = "payer_valuestore_payment_id")
    @Column(name = "payer_valuestore_payment_id")
    private String payerValueStorePaymentID; //e.g. MTN mobile money ID

    @Expose
    @SerializedName(value = "status_description")
    @Column(name = "status_description")
    private String statusDescription;

//    private String payerNarration;
//    private String statusPushed; //1 or 0 -> ONLY push statuses if paymentStatus is already in final state i.e. FAILED|SUCCESSFUL|ESCALATED and StatusPushed is 0
//    private String paymentPushed; //1 or 0  ONLY push payments if payment is in NEW and paymentPushed is 0 -> after pushing change paymentStatus to PENDING
//    @Enumerated(EnumType.STRING)
//    @Column(name = "PaymentMode")
//    private PaymentMode paymentMode;
//    @JoinColumn(name = "id")
//    @OneToOne
//    private Client payer;
//    @Enumerated(EnumType.STRING)
//    private ValueStore recipientValueStore;
//    private String recipientAccount;
//    private String paymentQueryAnswers; //each recipient has a set of questions the payer must (has to) answer
//    private String recipientHandle;
//    private String recipientAlias; //this is an alias given by the user to identify their merchant their own way
//    private String recieverDetails;
//    private String payerID;
//    private String payerNames; //a customer entered names when paying - we will use to update the Name in Client incase it is different from what we have
//    private ServiceType serviceType;
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

    /**
     * Gets the value of the amount property.
     *
     * @return possible object is {@link Amounttype }
     *
     */
    public Amounttype getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is {@link Amounttype }
     *
     */
    public void setAmount(Amounttype value) {
        this.amount = value;
    }

    public boolean isSetAmount() {
        return (this.getAmount() != null);
    }

    public AdPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(AdPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public ValueStore getPayerValueStore() {
        return payerValueStore;
    }

    public void setPayerValueStore(ValueStore payerValueStore) {
        this.payerValueStore = payerValueStore;
    }

    public LocalDateTime getPaymentAcknowledgmentDate() {
        return paymentAcknowledgmentDate;
    }

    public void setPaymentAcknowledgmentDate(LocalDateTime paymentAcknowledgmentDate) {
        this.paymentAcknowledgmentDate = paymentAcknowledgmentDate;
    }

    public String getPayerAccount() {
        return payerAccount;
    }

    public void setPayerAccount(String payerAccount) {
        this.payerAccount = payerAccount;
    }

    public String getInternalPaymentID() {
        return internalPaymentID;
    }

    public void setInternalPaymentID(String internalPaymentID) {
        this.internalPaymentID = internalPaymentID;
    }

    public String getAggregatorPaymentID() {
        return aggregatorPaymentID;
    }

    public void setAggregatorPaymentID(String aggregatorPaymentID) {
        this.aggregatorPaymentID = aggregatorPaymentID;
    }

    public String getPayerValueStorePaymentID() {
        return payerValueStorePaymentID;
    }

    public void setPayerValueStorePaymentID(String payerValueStorePaymentID) {
        this.payerValueStorePaymentID = payerValueStorePaymentID;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }
}
