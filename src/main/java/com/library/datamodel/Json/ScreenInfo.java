package com.library.datamodel.Json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @author smallGod
 */
public class ScreenInfo {

    @SerializedName("vendor_name")
    @Expose
    private String vendorName;

    @SerializedName("screen_height")
    @Expose
    private int screenHeight;

    @SerializedName("screen_width")
    @Expose
    private int screenWidth;

    @SerializedName("placement")
    @Expose
    private String placement;

    @SerializedName("popularity")
    @Expose
    private String popularity;

    @SerializedName("allow_volume")
    @Expose
    private boolean isAllowVolume;

    @SerializedName("split_screen")
    @Expose
    private String splitScreen;

    @SerializedName("screen_size")
    @Expose
    private String screenSize;

    @Expose
    @SerializedName(value = "screen_type")
    private String screenType;

    @Expose
    @SerializedName(value = "is_publish")
    private boolean isPublish;

    @SerializedName("terminal_id")
    @Expose
    private String terminalId;
    
    @Expose
    @SerializedName(value = "extra_1")
    private String extra1;

    @SerializedName("extra_2")
    @Expose
    private String extra2;


    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public boolean getAllowVolume() {
        return isAllowVolume;
    }

    public void setIsAllowVolume(boolean isAllowVolume) {
        this.isAllowVolume = isAllowVolume;
    }

    public String getSplitScreen() {
        return splitScreen;
    }

    public void setSplitScreen(String splitScreen) {
        this.splitScreen = splitScreen;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public boolean isIsPublish() {
        return isPublish;
    }

    public void setIsPublish(boolean isPublish) {
        this.isPublish = isPublish;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    
    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

}
