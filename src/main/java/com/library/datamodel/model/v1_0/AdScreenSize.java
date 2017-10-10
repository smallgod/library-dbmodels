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
import javax.persistence.UniqueConstraint;
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
@Table(name = "ad_screen_size", uniqueConstraints = @UniqueConstraint(columnNames = {"screen_size_code"}))
@NamedQueries({
    @NamedQuery(name = AdScreenSize.FETCH_SCREEN_SIZE, query = AdScreenSize.FETCH_SCREEN_SIZE_QUERY)
})
public class AdScreenSize extends BaseEntity implements Auditable, Serializable {

    public static final String FETCH_SCREEN_SIZE_QUERY = "SELECT screenSize FROM AdScreenSize screenSize WHERE screenSize.screenSizeCode=:code";
    public static final String FETCH_SCREEN_SIZE = "FETCH_SCREEN_SIZE";

    private static final long serialVersionUID = 7733884536250533392L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Expose
    @SerializedName(value = "screen_size_code")
    @Column(name = "screen_size_code")
    private String screenSizeCode; //  e.g. FIFTEEN

    @Expose
    @SerializedName(value = "layout_name")
    @Column(name = "layout_name")
    private String screenSizeName; // e.g. "15 INCH"

    @Expose
    @SerializedName(value = "scrren_size_value")
    @Column(name = "scrren_size_value")
    private float screenSizeValue; // different sixes attract different %s that affect pricing

    public AdScreenSize() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getScreenSizeName() {
        return screenSizeName;
    }

    public void setScreenSizeName(String screenSizeName) {
        this.screenSizeName = screenSizeName;
    }

    public float getScreenSizeValue() {
        return screenSizeValue;
    }

    public void setScreenSizeValue(float screenSizeValue) {
        this.screenSizeValue = screenSizeValue;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    public String getScreenSizeCode() {
        return screenSizeCode;
    }

    public void setScreenSizeCode(String screenSizeCode) {
        this.screenSizeCode = screenSizeCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.screenSizeCode);
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
        final AdScreenSize other = (AdScreenSize) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return Objects.equals(this.screenSizeCode, other.getScreenSizeCode());
    }

}
