package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdPaymentStatus;
import com.library.datamodel.Constants.AdvertStatus;
import com.library.datamodel.Constants.AdvertStep;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

//@Entity(name = "recon_entity1")
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "advert")

//id int auto_increment primary key, subject varchar(30),description varchar(100), targetArea varchar(40),startTime varchar(20),endTime varchar(20),imageUrl varchar(100),contactDetails varchar(50),category varchar (30),paymentMethod varchar(30),advertType varchar(20),advertiserType varchar(30), advertiserId varchar (10000),DateSent currentTimestamp)")
public class Advert extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Column(name = "advertiser_id", nullable = true, unique = false)
    @SerializedName(value = "advertiserId")
    private String advertiserId;

    @SerializedName(value = "advertText")
    @Column(name = "advert_text", length = 10000) //might want to change this - what if the data is too long
    private String advertText;
    
    @SerializedName(value = "adStatus")
    //the status of the advert whether successful, Rejected or ....
    private AdvertStatus adStatus;
    
    @SerializedName(value = "adStep")
    //at which processing level this advert is at
    private AdvertStep adStep;
    
    @SerializedName(value = "paymentStatus")
    //whether this advert has been paid for or not - if an advert is rejected after payment, 
    //payment should be reversed and this value should read 'REVERSED'
    private AdPaymentStatus paymentStatus;

    public Advert(String advertiserId, String advertText) {
        this.advertiserId = advertiserId;
        this.advertText = advertText;
    }

    public Advert() {
        this("", ""); //initialise fields
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertText() {
        return advertText;
    }

    public void setAdvertText(String advertText) {
        this.advertText = advertText;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public AdvertStatus getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(AdvertStatus adStatus) {
        this.adStatus = adStatus;
    }

    public AdvertStep getAdStep() {
        return adStep;
    }

    public void setAdStep(AdvertStep adStep) {
        this.adStep = adStep;
    }

    public AdPaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(AdPaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

}
