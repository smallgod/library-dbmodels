package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author smallGod
 */
public class XticsLanguage {

    @SerializedName("english")
    @Expose
    private int english;

    @SerializedName("luganda")
    @Expose
    private int luganda;

    @SerializedName("swahili")
    @Expose
    private int swahili;

    @SerializedName("kinyarwanda")
    @Expose
    private int kinyarwanda;

    @SerializedName("french")
    @Expose
    private int french;

    @SerializedName("chinese")
    @Expose
    private int chinese;

    @SerializedName("arabic")
    @Expose
    private int arabic;

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getLuganda() {
        return luganda;
    }

    public void setLuganda(int luganda) {
        this.luganda = luganda;
    }

    public int getSwahili() {
        return swahili;
    }

    public void setSwahili(int swahili) {
        this.swahili = swahili;
    }

    public int getKinyarwanda() {
        return kinyarwanda;
    }

    public void setKinyarwanda(int kinyarwanda) {
        this.kinyarwanda = kinyarwanda;
    }

    public int getFrench() {
        return french;
    }

    public void setFrench(int french) {
        this.french = french;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getArabic() {
        return arabic;
    }

    public void setArabic(int arabic) {
        this.arabic = arabic;
    }

}
