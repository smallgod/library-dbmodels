package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDate;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.LocalDate;

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
//@Entity(name = "recon_entity1")
@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "resource")
//@Table(name = "generator", uniqueConstraints = @UniqueConstraint(columnNames = {"generatorId", "macAddress"}))

//id int auto_increment primary key, subject varchar(30),description varchar(100), targetArea varchar(40),startTime varchar(20),endTime varchar(20),imageUrl varchar(100),contactDetails varchar(50),category varchar (30),paymentMethod varchar(30),advertType varchar(20),advertiserType varchar(30), resourceId varchar (10000),DateSent currentTimestamp)")
public class Resource extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -7031217932863800011L;

    @Column(name = "resource_id", unique = true)
    @SerializedName(value = "resource_id")
    private String resourceId;

    @Column(name = "resource_name", nullable = false)
    private String resourceName;

    @Type(type = "jodalocaldate")
    @Column(name = "start_display")
    private LocalDate startDisplayDate;

    @Type(type = "jodalocaldate")
    @Column(name = "stop_display")
    private LocalDate stopDisplayDate;

    @Column(name = "uploaded_to_dsm")
    private boolean isUploadedToDSM;

    @Column(name = "resource_size")
    private long resourceSize;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public LocalDate getStartDisplayDate() {
        return startDisplayDate;
    }

    public void setStartDisplayDate(LocalDate startDisplayDate) {
        this.startDisplayDate = startDisplayDate;
    }

    public LocalDate getStopDisplayDate() {
        return stopDisplayDate;
    }

    public void setStopDisplayDate(LocalDate stopDisplayDate) {
        this.stopDisplayDate = stopDisplayDate;
    }

    public boolean isIsUploadedToDSM() {
        return isUploadedToDSM;
    }

    public void setIsUploadedToDSM(boolean isUploadedToDSM) {
        this.isUploadedToDSM = isUploadedToDSM;
    }

    public long getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(long resourceSize) {
        this.resourceSize = resourceSize;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

}
