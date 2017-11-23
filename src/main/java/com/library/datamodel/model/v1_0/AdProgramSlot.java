package com.library.datamodel.model.v1_0;

import com.google.gson.annotations.SerializedName;
import com.library.sgsharedinterface.Auditable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@DynamicUpdate(value = true)
@SelectBeforeUpdate(value = true)
@Table(name = "ad_program_slot")
@NamedQueries(
        @NamedQuery(name = AdProgramSlot.FETCH_PROG_SLOT, query = AdProgramSlot.FETCH_PROG_SLOT_QUERY)
)
public class AdProgramSlot extends BaseEntity implements Auditable, Serializable {

    private static final long serialVersionUID = -3434906437273662803L;

    public static final String FETCH_PROG_SLOT_QUERY = "SELECT DISTINCT programSlot FROM AdProgramSlot programSlot INNER JOIN programSlot.adTimeSlot timeslot INNER JOIN programSlot.adPrograms program where program.campaignId=:campaignId";
    //public static final String FETCH_PROG_SLOT_QUERY = "SELECT DISTINCT progslot FROM AdProgramSlot progslot INNER JOIN progslot.adPrograms prog INNER JOIN progslot.adTimeSlot timeslot where prog.campaignId=:campaignId";
    public static final String FETCH_PROG_SLOT = "FETCH_PROG_SLOT";

    //HQL queries are written differently especially joins e.g.
    //In SQL, select a.id, a.name, a.url from FilesInfo a inner join FilesShare b on a.id=b.fileid where b.userid=5 and b.owner=1;
    //In HQL, is:
    //select a.id, a.name, a.url from FilesInfo a inner join a.filesShared b where b.userid=5 and b.owner=1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    @SerializedName(value = "id")
    private long id;

    @Column(name = "preferred_hour")
    @SerializedName(value = "preferred_hour")
    private int preferredHour;

    @Column(name = "frequency")
    @SerializedName(value = "frequency")
    private int frequency;

    @SerializedName(value = "time_slot")
    @OneToOne()
    @JoinColumns({
        @JoinColumn(name = "time_slot", referencedColumnName = "slot_code")
    })
    @Cascade({CascadeType.ALL})
    private AdTimeSlot adTimeSlot;

    @SerializedName(value = "program_slots")
    @ManyToMany(fetch = FetchType.LAZY)//LAZY works especially with HQL though with criteria it was throwing the exception  org.hibernate.LazyInitializationException: failed to lazily initialize a collection
    @JoinTable(name = "program_slots",//EAGER works with criteria but throws the infamous NullPointer exceptin while trying to execute the select query

            joinColumns = {
                @JoinColumn(name = "program_slot_id", referencedColumnName = "id")

            },
            inverseJoinColumns = {
                @JoinColumn(name = "campaign_id", referencedColumnName = "campaign_id")
            }
    )
    @Cascade({CascadeType.ALL})
    private Set<AdProgram> adPrograms = new HashSet<>(0);

    @Column(name = "is_monday")
    @SerializedName(value = "is_monday")
    private boolean isMonday;

    @Column(name = "is_tuesday")
    @SerializedName(value = "is_tuesday")
    private boolean isTuesday;

    @Column(name = "is_wednesday")
    @SerializedName(value = "is_wednesday")
    private boolean isWednesday;

    @Column(name = "is_thursday")
    @SerializedName(value = "is_thursday")
    private boolean isThursady;

    @Column(name = "is_friday")
    @SerializedName(value = "is_friday")
    private boolean isFriday;

    @Column(name = "is_saturday")
    @SerializedName(value = "is_saturday")
    private boolean isSaturday;

    @Column(name = "is_sunday")
    @SerializedName(value = "is_sunday")
    private boolean isSunday;

    public AdProgramSlot() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPreferredHour() {
        return preferredHour;
    }

    public void setPreferredHour(int preferredHour) {
        this.preferredHour = preferredHour;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean isIsThursady() {
        return isThursady;
    }

    public void setIsThursady(boolean isThursady) {
        this.isThursady = isThursady;
    }

    public boolean isIsFriday() {
        return isFriday;
    }

    public void setIsFriday(boolean isFriday) {
        this.isFriday = isFriday;
    }

    public boolean isIsSaturday() {
        return isSaturday;
    }

    public void setIsSaturday(boolean isSaturday) {
        this.isSaturday = isSaturday;
    }

    public boolean isIsSunday() {
        return isSunday;
    }

    public void setIsSunday(boolean isSunday) {
        this.isSunday = isSunday;
    }

    public Set<AdProgram> getAdPrograms() {
        return adPrograms;
    }

    public void setAdPrograms(Set<AdProgram> adPrograms) {
        this.adPrograms = adPrograms;
    }

    public boolean isIsMonday() {
        return isMonday;
    }

    public void setIsMonday(boolean isMonday) {
        this.isMonday = isMonday;
    }

    public boolean isIsTuesday() {
        return isTuesday;
    }

    public void setIsTuesday(boolean isTuesday) {
        this.isTuesday = isTuesday;
    }

    public boolean isIsWednesday() {
        return isWednesday;
    }

    public void setIsWednesday(boolean isWednesday) {
        this.isWednesday = isWednesday;
    }

    public AdTimeSlot getAdTimeSlot() {
        return adTimeSlot;
    }

    public void setAdTimeSlot(AdTimeSlot adTimeSlot) {
        this.adTimeSlot = adTimeSlot;
    }

    @Override
    public String getUsername() {
        return this.getLastModifiedBy();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final AdProgramSlot other = (AdProgramSlot) obj;
        return this.id == other.getId();
    }
}