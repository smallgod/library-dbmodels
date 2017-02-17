package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_payment")

public class AdPayment extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -1408718657632013689L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;
    

//    @Embedded
//    @Column(name = "Amount")
//    private Amounttype amount;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "PaymentMode")
//    private PaymentMode paymentMode;
//
//    @Enumerated(EnumType.STRING)
//    private ValueStore payerValueStore;
//
//    @Enumerated(EnumType.STRING)
//    private ValueStore recipientValueStore;
//
//    private String payerNarration;
//
//    @JoinColumn(name = "id")
//    @OneToOne
//    private Client payer;
//
//    private String payerAccount;
//
//   private DateTime datePaymentAcknowledged;
//
//    private String internalTransactionID; //generated internally
//
//    private String recieptNumber; //sent back by recipient
//
//    private String recipientNarration;
//
//    private PaymentStatus paymentStatus;
//
//
//    
//    
//    /**
//     * Gets the value of the amount property.
//     *
//     * @return possible object is {@link Amounttype }
//     *
//     */
//    public Amounttype getAmount() {
//        return amount;
//    }
//
//    /**
//     * Sets the value of the amount property.
//     *
//     * @param value allowed object is {@link Amounttype }
//     *
//     */
//    public void setAmount(Amounttype value) {
//        this.amount = value;
//    }
//
//    public boolean isSetAmount() {
//        return (this.getAmount() != null);
//    }
//
//    /**
//     * Gets the value of the paymentMode property.
//     *
//     * @return possible object is {@link PaymentMode }
//     *
//     */
//    public PaymentMode getPaymentMode() {
//        return paymentMode;
//    }
//
//    /**
//     * Sets the value of the paymentMode property.
//     *
//     * @param value allowed object is {@link PaymentMode }
//     *
//     */
//    public void setPaymentMode(PaymentMode value) {
//        this.paymentMode = value;
//    }
//
//    public boolean isSetPaymentmode() {
//        return (this.getPaymentMode() != null);
//    }
//
//    /**
//     * Gets the value of the payerNarration property.
//     *
//     * @return possible object is {@link String }
//     *
//     */
//    public String getPayerNarration() {
//        return payerNarration;
//    }
//
//    /**
//     * Sets the value of the payerNarration property.
//     *
//     * @param value allowed object is {@link String }
//     *
//     */
//    public void setPayerNarration(String value) {
//        this.payerNarration = value;
//    }
//
//    public boolean isSetPaymentnarration() {
//        return (this.getPayerNarration() != null);
//    }
//
//    /**
//     * Gets the value of the paymentStatus property.
//     *
//     * @return possible object is {@link Statustype }
//     *
//     */
//    public PaymentStatus getPaymentStatus() {
//        return paymentStatus;
//    }
//
//    /**
//     * Sets the value of the paymentStatus property.
//     *
//     * @param value allowed object is {@link Statustype }
//     *
//     */
//    public void setPaymentStatus(PaymentStatus value) {
//        this.paymentStatus = value;
//    }
//
//    public boolean isSetTransactionstatus() {
//        return (this.paymentStatus != null);
//    }
//
//    /**
//     * Gets the value of the recipientHandle property.
//     *
//     * @return possible object is {@link String }
//     *
//     */
//    public String getRecipientHandle() {
//        return "@" + recipientHandle; //handles should display in the format @handle
//    }
//
//    /**
//     * Sets the value of the recipientHandle property.
//     *
//     * @param value allowed object is {@link String }
//     *
//     */
//    public void setRecipientHandle(String value) {
//        this.recipientHandle = value;
//    }
//
//    /**
//     * Gets the value of the datePaymentAcknowledged property.
//     *
//     * @return possible object is {@link XMLGregorianCalendar }
//     *
//     */
//    public DateTime getDatePaymentAcknowledged() {
//        return datePaymentAcknowledged;
//    }
//
//    /**
//     * Sets the value of the datePaymentAcknowledged property.
//     *
//     * @param value allowed object is {@link XMLGregorianCalendar }
//     *
//     */
//    public void setDatePaymentAcknowledged(DateTime value) {
//        this.datePaymentAcknowledged = value;
//    }
//
//    public boolean isSetClientpaymentdate() {
//        return (this.datePaymentAcknowledged != null);
//    }
//
//    /**
//     * Gets the value of the serviceType property.
//     *
//     * @return possible object is {@link ServiceType }
//     *
//     */
//    public ServiceType getServiceType() {
//        return serviceType;
//    }
//
//    /**
//     * Sets the value of the serviceType property.
//     *
//     * @param value allowed object is {@link ServiceType }
//     *
//     */
//    public void setServiceType(ServiceType value) {
//        this.serviceType = value;
//    }
//
//    public boolean isSetServiceoption() {
//        return (this.getServiceType() != null);
//    }
//
//    /**
//     * Gets the value of the paymentQueryAnswers property.
//     *
//     * @return possible object is {@link String }
//     *
//     */
//    public String getPaymentQueryAnswers() {
//        return paymentQueryAnswers;
//    }
//
//    /**
//     * Sets the value of the paymentQueryAnswers property.
//     *
//     * @param value allowed object is {@link String }
//     *
//     */
//    public void setPaymentQueryAnswers(String value) {
//        this.paymentQueryAnswers = value;
//    }
//
//    public boolean isSetVersion() {
//        return (this.paymentQueryAnswers != null);
//    }
//
//    public ValueStore getPayerValueStore() {
//        return payerValueStore;
//    }
//
//    public void setPayerValueStore(ValueStore payerValueStore) {
//        this.payerValueStore = payerValueStore;
//    }
//
//    public ValueStore getRecipientValueStore() {
//        return recipientValueStore;
//    }
//
//    public void setRecipientValueStore(ValueStore recipientValueStore) {
//        this.recipientValueStore = recipientValueStore;
//    }
//
//    public String getPayerAccount() {
//        return payerAccount;
//    }
//
//    public void setPayerAccount(String payerAccount) {
//        this.payerAccount = payerAccount;
//    }
//
//    public String getRecipientAccount() {
//        return recipientAccount;
//    }
//
//    public void setRecipientAccount(String recipientAccount) {
//        this.recipientAccount = recipientAccount;
//    }
//
//    public String getInternalTransactionID() {
//        return internalTransactionID;
//    }
//
//    public void setInternalTransactionID(String internalTransactionID) {
//        this.internalTransactionID = internalTransactionID;
//    }
//
//    @Override
//    public DBMSXMLObject getXMLObject() {
//        return this;
//    }
//
//    @Override
//    public String getUsername() {
//        return "user name";
//    }
//
//    public String getRecieptNumber() {
//        return recieptNumber;
//    }
//
//    public void setRecieptNumber(String recieptNumber) {
//        this.recieptNumber = recieptNumber;
//    }
//
//    public String getRecipientNarration() {
//        return recipientNarration;
//    }
//
//    public void setRecipientNarration(String recipientNarration) {
//        this.recipientNarration = recipientNarration;
//    }
//
//    public String getRecieverDetails() {
//        return recieverDetails;
//    }
//
//    public void setRecieverDetails(String recieverDetails) {
//        this.recieverDetails = recieverDetails;
//    }
//
//    public Client getPayer() {
//        return payer;
//    }
//
//    public void setPayer(Client payer) {
//        this.payer = payer;
//    }
//
//    public String getRecipientAlias() {
//        return recipientAlias;
//    }
//
//    public void setRecipientAlias(String recipientAlias) {
//        this.recipientAlias = recipientAlias;
//    }
//
//    public String getPayerNames() {
//        return payerNames;
//    }
//
//    public void setPayerNames(String payerNames) {
//        this.payerNames = payerNames;
//    }
//
//    public String getStatusPushed() {
//        return statusPushed;
//    }
//
//    public void setStatusPushed(String statusPushed) {
//        this.statusPushed = statusPushed;
//    }
//
//    public String getPaymentPushed() {
//        return paymentPushed;
//    }
//
//    public void setPaymentPushed(String paymentPushed) {
//        this.paymentPushed = paymentPushed;
//    }
//
//    public String getPayerID() {
//        return payerID;
//    }
//
//    public void setPayerID(String payerID) {
//        this.payerID = payerID;
//    }
//     @Override
//    public String getModifyAction() {
//        return "modify action";
//    }
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

}
