package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenRegion;
import com.library.datamodel.Constants.TextType;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
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
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
//@Table(name = "ad_text")
@Table(name = "ad_text", uniqueConstraints = @UniqueConstraint(columnNames = {"text_id"}))
@NamedQueries(
        @NamedQuery(name = AdText.FETCH_TEXT, query = AdText.FETCH_TEXT_QUERY)
)
public class AdText extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -3434906437273662803L;

    public static final String FETCH_TEXT_QUERY = "SELECT DISTINCT txt FROM AdText txt INNER JOIN txt.adTextPrograms prog where prog.id=:id";
    public static final String FETCH_TEXT = "fetch_text";

    //HQL queries are written differently especially joins e.g.
    //In SQL, select a.id, a.name, a.url from FilesInfo a inner join FilesShare b on a.id=b.fileid where b.userid=5 and b.owner=1;
    //In HQL, is:
    //select a.id, a.name, a.url from FilesInfo a inner join a.filesShared b where b.userid=5 and b.owner=1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @Expose
    @Column(name = "text_id")
    @SerializedName(value = "text_id")
    private long textId;

    @Column(name = "text_content")
    @SerializedName(value = "text_content")
    private String textContent;

    //HEADER_TEXT | SCROLL_TEXT
    @Column(name = "text_type")
    @Enumerated(EnumType.STRING)
    @SerializedName(value = "text_type")
    private TextType textType;

    //region of the screen where the advert is going to display
    @Column(name = "region")
    @Enumerated(EnumType.STRING)
    @SerializedName(value = "region")
    private AdScreenRegion screenRegion;

    @Column(name = "uploaded_to_dsm")
    @SerializedName(value = "uploaded_to_dsm")
    private boolean isUploadedToDSM;

    @SerializedName(value = "program_text")
    @ManyToMany(fetch = FetchType.EAGER)//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "program_text",
            joinColumns = {
                @JoinColumn(name = "text_id")

            },
            inverseJoinColumns = {
                @JoinColumn(name = "program_join_id")
            }
    )
    @Cascade({CascadeType.ALL})
    private Set<AdProgram> adTextPrograms = new HashSet<>(0);

    public AdText() {
    }

    public long getTextId() {
        return textId;
    }

    public void setTextId(long textId) {
        this.textId = textId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public TextType getTextType() {
        return textType;
    }

    public void setTextType(TextType textType) {
        this.textType = textType;
    }

    public boolean isIsUploadedToDSM() {
        return isUploadedToDSM;
    }

    public void setIsUploadedToDSM(boolean isUploadedToDSM) {
        this.isUploadedToDSM = isUploadedToDSM;
    }

    public AdScreenRegion getScreenRegion() {
        return screenRegion;
    }

    public void setScreenRegion(AdScreenRegion screenRegion) {
        this.screenRegion = screenRegion;
    }

    public Set<AdProgram> getAdTextPrograms() {
        return adTextPrograms;
    }

    public void setAdTextPrograms(Set<AdProgram> adTextPrograms) {
        this.adTextPrograms = adTextPrograms;
    }

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + (int) (this.textId ^ (this.textId >>> 32));
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
        final AdText other = (AdText) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return this.textId == other.getTextId();
    }

}
