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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
//@DynamicUpdate(value = true)
//@SelectBeforeUpdate(value = true)
@Table(name = "ad_text")

public class AdText extends BaseEntity implements Auditable, Serializable {

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

    @SerializedName(value = "program_text")
    @ManyToMany(
            fetch = FetchType.EAGER
//            cascade = {
//                //javax.persistence.CascadeType.PERSIST, 
//                javax.persistence.CascadeType.ALL
//            }
    )//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "ad_program_text",
            joinColumns = {
                @JoinColumn(name = "text_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "program_join_id")
            }
    )
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<AdProgram> adPrograms = new HashSet<AdProgram>(0);

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

    public Set<AdProgram> getAdPrograms() {
        return adPrograms;
    }

    public void setAdPrograms(Set<AdProgram> adPrograms) {
        this.adPrograms = adPrograms;
    }

//    public Set<AdProgram> getAdProgramTexts() {
//        return adPrograms;
//    }
//
//    public void setAdProgramTexts(Set<AdProgram> adPrograms) {
//        this.adPrograms = adPrograms;
//    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (int) (this.textId ^ (this.textId >>> 32));
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
        
        if (this.getId() == other.getId()) {
            return true;
        }
        
        return this.textId == other.getTextId();
    }
    
    
}