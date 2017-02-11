package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.datamodel.Constants.AdScreenRegion;
import com.library.datamodel.Constants.ResourceType;
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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_text", uniqueConstraints = @UniqueConstraint(columnNames = {"text_id"}))

public class AdText extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -3434906437273662803L;

    @Column(name = "text_id")
    private long textId;

    @Column(name = "text_content")
    @SerializedName(value = "text_content")
    private String textContent;

    @Column(name = "text_type")
    @Enumerated(EnumType.STRING)
    private TextType textType; //HEADER_TEXT | SCROLL_TEXT

    @Column(name = "region")
    @Enumerated(EnumType.STRING)
    private AdScreenRegion screenRegion; //region of the screen where the advert is going to display

    @Column(name = "uploaded_to_dsm")
    private boolean isUploadedToDSM;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "adTextList")//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    private Set<AdProgram> adProgramSet = new HashSet<>(0);

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

    public Set<AdProgram> getAdProgramSet() {
        return adProgramSet;
    }

    public void setAdProgramSet(Set<AdProgram> adProgramSet) {
        this.adProgramSet = adProgramSet;
    }

}
