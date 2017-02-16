package com.library.datamodel.model.v1_0;

/**
 * Works but inserts duplicate entries in all tables involved
 * 
 * AdText adText1 = new AdText();
        adText1.setIsUploadedToDSM(Boolean.FALSE);
        adText1.setScreenRegion(AdScreenRegion.CENTER);
        adText1.setTextContent("This is scroll text right here...");
        adText1.setTextType(TextType.SCROLL_TEXT);
        adText1.setTextId(new Random().nextInt());

        AdText adText2 = new AdText();
        adText2.setIsUploadedToDSM(Boolean.FALSE);
        adText2.setScreenRegion(AdScreenRegion.CENTER);
        adText2.setTextContent("This is Header Text.");
        adText2.setTextType(TextType.HEADER_TEXT);
        adText2.setTextId(new Random().nextInt());

        AdProgram program1 = new AdProgram();
        program1.setAdCampaignName("Test Campaign - No. 1");
        program1.setAdLength(10);
        program1.setAdStatus(AdvertStatus.PROCESSING);
        program1.setProgJoinId(new Random().nextInt());
        program1.setDisplayLayout(ProgDisplayLayout.THREE_SPLIT);
        program1.setIsDSMUpdated(Boolean.FALSE);
        program1.setStartAdDate(new LocalDate(2017, 2, 15));
        program1.setEndAdDate(new LocalDate(2017, 2, 17));
        program1.setIsToBeNotified(Boolean.TRUE);
        program1.setNumOfFileResources(3);
        program1.setPaymentStatus(AdPaymentStatus.NOT_PAID);
        program1.setTotalSchedulesPlayed(9);
        program1.setTotalSchedulesToPlay(900);

        AdProgram program2 = new AdProgram();
        program2.setAdCampaignName("Test Campaign - No. 2");
        program2.setAdLength(15);
        program2.setAdStatus(AdvertStatus.PROCESSING);
        program2.setProgJoinId(new Random().nextInt());
        program2.setDisplayLayout(ProgDisplayLayout.THREE_SPLIT);
        program2.setIsDSMUpdated(Boolean.FALSE);
        program2.setStartAdDate(new LocalDate(2017, 2, 15));
        program2.setEndAdDate(new LocalDate(2017, 2, 18));
        program2.setIsToBeNotified(Boolean.TRUE);
        program2.setNumOfFileResources(3);
        program2.setPaymentStatus(AdPaymentStatus.NOT_PAID);
        program2.setTotalSchedulesPlayed(10);
        program2.setTotalSchedulesToPlay(999);

        
        
        //Add programs to each of the adText sets
        adText1.getAdPrograms().add(program1);
        adText1.getAdPrograms().add(program2);
        adText2.getAdPrograms().add(program1);
        adText2.getAdPrograms().add(program2);
        
        //Add Text to each of the Program sets
        program1.getAdTextList().add(adText1);
        program1.getAdTextList().add(adText2);
        program2.getAdTextList().add(adText1);
        program2.getAdTextList().add(adText2);
        
        

        databaseAdapter.saveOrUpdateEntity(program1, Boolean.TRUE);

        Thread.sleep(delay);

        databaseAdapter.saveOrUpdateEntity(program2, Boolean.TRUE);

        Thread.sleep(delay);
 */

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
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_text")

public class AdText2 extends BaseEntity implements Auditable, Serializable {

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
            fetch = FetchType.EAGER, 
            cascade = {
                //javax.persistence.CascadeType.PERSIST, 
                javax.persistence.CascadeType.ALL
            }
    )//To-Do change this back to LAZY later when you find a solution to the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "ad_program_text",
            joinColumns = {
                @JoinColumn(name = "text_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "program_join_id")
            }
    )
    private Set<AdProgram> adPrograms = new HashSet<AdProgram>();

    public AdText2() {
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
}
