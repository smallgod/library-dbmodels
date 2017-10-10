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
@Table(name = "ad_audience_xtics", uniqueConstraints = @UniqueConstraint(columnNames = {"xtics_id"}))

//can be used for both screens and normal areas in the database
/**
 * When sending back locations for search by location, we can use AdArea and
 * depending on the number of screens available in a certain area we can mixup
 * what we send back to UI e.g. if there are 20 screens in wandegeya market and
 * 5 screens in Karamoja, we can return an array of wandegeya - 20 screens &
 * Karamoja - 5 screens -> so the JSON object "name" should not be restricted to
 * only "area_name" object
 */
public class AdAudienceXtics extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = 7763590605747655539L;

    @Expose
    @SerializedName(value = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Expose
    @SerializedName(value = "income_ultra_low")
    @Column(name = "income_ultra_low")
    private int incomeUltraLow; //out of 10

    @Expose
    @SerializedName(value = "income_low")
    @Column(name = "income_low")
    private int incomeLow; //out of 10

    @Expose
    @SerializedName(value = "income_average")
    @Column(name = "income_average")
    private int incomeAverage; //out of 10

    @Expose
    @SerializedName(value = "income_high")
    @Column(name = "income_high")
    private int incomeHigh; //out of 10

    @Expose
    @SerializedName(value = "income_ultra_high")
    @Column(name = "income_ultra_high")
    private int incomeUltraHigh; //out of 10

    @Expose
    @SerializedName(value = "male")
    @Column(name = "gender_male")
    private int genderMale; //out of 10

    @Expose
    @SerializedName(value = "female")
    @Column(name = "gender_female")
    private int genderFemale; //out of 10

    @Expose
    @SerializedName(value = "swahili")
    @Column(name = "lang_swahili")
    private int langSwahili;

    @Expose
    @SerializedName(value = "english")
    @Column(name = "english")
    private int langEnglish;

    @Expose
    @SerializedName(value = "french")
    @Column(name = "lang_french")
    private int langFrench;

    @Expose
    @SerializedName(value = "kinyarwanda")
    @Column(name = "lang_kinyarwanda")
    private int langKinyarwanda;
    
    @Expose
    @SerializedName(value = "luganda")
    @Column(name = "lang_luganda")
    private int langLuganda;

    @Expose
    @SerializedName(value = "arabic")
    @Column(name = "lang_arabic")
    private int langArabic; //this kind'a database might not be scalable but use for now..

    @Expose
    @SerializedName(value = "under_12")
    @Column(name = "age_under_12")
    private int ageUnder12;

    @Expose
    @SerializedName(value = "13_to_17")
    @Column(name = "age_13_to_17")
    private int age13to17;

    @Expose
    @SerializedName(value = "18_to_24")
    @Column(name = "age_18_to_24")
    private int age18to24;

    @Expose
    @SerializedName(value = "25_to_39")
    @Column(name = "age_25_to_39")
    private int age25to39;

    @Expose
    @SerializedName(value = "40_to_55")
    @Column(name = "age_40_to_55")
    private int age40to55;

    @Expose
    @SerializedName(value = "above_56")
    @Column(name = "age_above_56")
    private int ageAbove56;

    public AdAudienceXtics() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIncomeUltraLow() {
        return incomeUltraLow;
    }

    public void setIncomeUltraLow(int incomeUltraLow) {
        this.incomeUltraLow = incomeUltraLow;
    }

    public int getIncomeLow() {
        return incomeLow;
    }

    public void setIncomeLow(int incomeLow) {
        this.incomeLow = incomeLow;
    }

    public int getIncomeAverage() {
        return incomeAverage;
    }

    public void setIncomeAverage(int incomeAverage) {
        this.incomeAverage = incomeAverage;
    }

    public int getIncomeHigh() {
        return incomeHigh;
    }

    public void setIncomeHigh(int incomeHigh) {
        this.incomeHigh = incomeHigh;
    }

    public int getIncomeUltraHigh() {
        return incomeUltraHigh;
    }

    public void setIncomeUltraHigh(int incomeUltraHigh) {
        this.incomeUltraHigh = incomeUltraHigh;
    }

    public int getGenderMale() {
        return genderMale;
    }

    public void setGenderMale(int genderMale) {
        this.genderMale = genderMale;
    }

    public int getGenderFemale() {
        return genderFemale;
    }

    public void setGenderFemale(int genderFemale) {
        this.genderFemale = genderFemale;
    }

    public int getLangSwahili() {
        return langSwahili;
    }

    public void setLangSwahili(int langSwahili) {
        this.langSwahili = langSwahili;
    }

    public int getLangEnglish() {
        return langEnglish;
    }

    public void setLangEnglish(int langEnglish) {
        this.langEnglish = langEnglish;
    }

    public int getLangFrench() {
        return langFrench;
    }

    public void setLangFrench(int langFrench) {
        this.langFrench = langFrench;
    }

    public int getLangKinyarwanda() {
        return langKinyarwanda;
    }

    public void setLangKinyarwanda(int langKinyarwanda) {
        this.langKinyarwanda = langKinyarwanda;
    }

    public int getLangArabic() {
        return langArabic;
    }

    public void setLangArabic(int langArabic) {
        this.langArabic = langArabic;
    }

    public int getAgeUnder12() {
        return ageUnder12;
    }

    public void setAgeUnder12(int ageUnder12) {
        this.ageUnder12 = ageUnder12;
    }

    public int getAge13to17() {
        return age13to17;
    }

    public void setAge13to17(int age13to17) {
        this.age13to17 = age13to17;
    }

    public int getAge18to24() {
        return age18to24;
    }

    public void setAge18to24(int age18to24) {
        this.age18to24 = age18to24;
    }

    public int getAge25to39() {
        return age25to39;
    }

    public void setAge25to39(int age25to39) {
        this.age25to39 = age25to39;
    }

    public int getAge40to55() {
        return age40to55;
    }

    public void setAge40to55(int age40to55) {
        this.age40to55 = age40to55;
    }

    public int getAgeAbove56() {
        return ageAbove56;
    }

    public void setAgeAbove56(int ageAbove56) {
        this.ageAbove56 = ageAbove56;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final AdAudienceXtics other = (AdAudienceXtics) obj;
        return this.id == other.getId();
    }

    public int getLangLuganda() {
        return langLuganda;
    }

    public void setLangLuganda(int langLuganda) {
        this.langLuganda = langLuganda;
    }

}
