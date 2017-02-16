package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenRegion;
import com.library.datamodel.Constants.TextType;
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_text", uniqueConstraints = @UniqueConstraint(columnNames = {"text_id"}))

public class AdText1 extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -3434906437273662803L;

    @Column(name = "text_id")
    @SerializedName(value = "text_id")
    private long textId;

    @Column(name = "text_content")
    @SerializedName(value = "text_content")
    private String textContent;

    @Column(name = "text_type")
    @Enumerated(EnumType.STRING)
    @SerializedName(value = "text_type")
    private TextType textType; //HEADER_TEXT | SCROLL_TEXT

    @Column(name = "region")
    @Enumerated(EnumType.STRING)
    @SerializedName(value = "region")
    private AdScreenRegion screenRegion; //region of the screen where the advert is going to display

    @Column(name = "uploaded_to_dsm")
    @SerializedName(value = "uploaded_to_dsm")
    private boolean isUploadedToDSM;

    @SerializedName(value = "program")
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adTextList")//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    private Set<AdProgram> adProgramTexts = new HashSet<>();

    public AdText1() {
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

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
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

    public Set<AdProgram> getAdProgramTexts() {
        return adProgramTexts;
    }

    public void setAdProgramTexts(Set<AdProgram> adProgramTexts) {
        this.adProgramTexts = adProgramTexts;
    }
    
    

//    public Set<AdProgram> getAdProgramTexts() {
//        return adProgramTexts;
//    }
//
//    public void setAdProgramTexts(Set<AdProgram> adProgramTexts) {
//        this.adProgramTexts = adProgramTexts;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.textId ^ (this.textId >>> 32));
        hash = 79 * hash + Objects.hashCode(this.textContent);
        hash = 79 * hash + Objects.hashCode(this.textType);
        hash = 79 * hash + Objects.hashCode(this.screenRegion);
        hash = 79 * hash + (this.isUploadedToDSM ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.adProgramTexts);
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
        final AdText1 other = (AdText1) obj;
        if (this.textId != other.textId) {
            return false;
        }
        if (this.isUploadedToDSM != other.isUploadedToDSM) {
            return false;
        }
        if (!Objects.equals(this.textContent, other.textContent)) {
            return false;
        }
        if (this.textType != other.textType) {
            return false;
        }
        if (this.screenRegion != other.screenRegion) {
            return false;
        }
        if (!Objects.equals(this.adProgramTexts, other.adProgramTexts)) {
            return false;
        }
        return true;
    }
}