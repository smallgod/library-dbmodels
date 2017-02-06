package com.library.datamodel.model.v1_0;

import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "ad_screenowner")

//id int auto_increment primary key, subject varchar(30),description varchar(100), targetArea varchar(40),startTime varchar(20),endTime varchar(20),imageUrl varchar(100),contactDetails varchar(50),category varchar (30),paymentMethod varchar(30),advertType varchar(20),advertiserType varchar(30), advertiserId varchar (10000),DateSent currentTimestamp)")
public class AdScreenOwner extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7420964819128665745L;

    @Column(name = "owner_id", unique = true, nullable = false)
    private String screenOwnerId;

    public AdScreenOwner() {
    }

    public String getScreenOwnerId() {
        return screenOwnerId;
    }

    public void setScreenOwnerId(String screenOwnerId) {
        this.screenOwnerId = screenOwnerId;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

}
