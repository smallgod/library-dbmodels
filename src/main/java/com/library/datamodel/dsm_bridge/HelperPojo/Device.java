/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.dsm_bridge.HelperPojo;

import java.util.Date;

public class Device {

    protected int customerId;
    protected long deviceId;
    protected String deviceName;
    protected String description;
    protected int groupId;
    protected String groupName;
    protected int cityId;
    protected String cityName;
    protected Date createTime;
    protected String createUser;
    protected String assignKernelVersion;
    protected String assignAppVersion;
    protected String curKernelVersion;
    protected String curAppVersion;
    protected int assignConfigId;
    protected String assignConfigName;
    protected Date assignConfigVersion;
    protected int curConfigId;
    protected String curConfigName;
    protected Date curConfigVersion;
    protected int assignLoopTaskId;
    protected String assignLoopTaskName;
    protected Date assignLoopTaskVersion;
    protected Date assignLoopFileVersion;
    protected Date assignLoopPlayVersion;
    protected Date assignLoopStrategyVersion;
    protected int curLoopTaskId;
    protected String curLoopTaskName;
    protected Date curLoopTaskVersion;
    protected Date curLoopFileVersion;
    protected Date curLoopPlayVersion;
    protected Date curLoopStrategyVersion;
    protected int assignDemandTaskId;
    protected String assignDemandTaskName;
    protected Date assignDemandTaskVersion;
    protected Date assignDemandFileVersion;
    protected Date assignDemandPlayVersion;
    protected int curDemandTaskId;
    protected String curDemandTaskName;
    protected Date curDemandTaskVersion;
    protected Date curDemandFileVersion;
    protected Date curDemandPlayVersion;
    protected int assignPluginTaskId;
    protected String assignPluginTaskName;
    protected Date assignPluginTaskVersion;
    protected Date assignPluginFileVersion;
    protected Date assignPluginPlayVersion;
    protected int curPluginTaskId;
    protected String curPluginTaskName;
    protected Date curPluginTaskVersion;
    protected Date curPluginFileVersion;
    protected Date curPluginPlayVersion;
    protected Date assignSourceVersion;
    protected Date curSourceVersion;
    protected String restSchedule;
    protected String standBySchedule;
    protected String captureSchedule;
    protected String demandSchedule;
    protected Date scheduleVersion;
    protected String subtitle;
    protected Date subtitleVersion;
    protected Date curSubtitleVersion;
    protected int onlineState;
    protected Date logonTime;
    protected Date logoffTime;
    protected long downloadTotal;
    protected long downloadFinished;
    protected int downloadType;
    protected int powerOn;
    protected int powerOff;
    protected int aliveInterval;
    protected Date lastAlive;
    protected Date lastPatrol;
    protected Date lastDownload;
    protected int kernelUpdated;
    protected int appUpdated;
    protected int configUpdated;
    protected int loopTaskUpdated;
    protected int demandTaskUpdated;
    protected int pluginTaskUpdated;
    protected int subtitleUpdated;

    public Device() {
        this.customerId = 0;
        this.deviceId = 0L;
        this.deviceName = "";
        this.description = "";
        this.groupId = 0;
        this.groupName = "";
        this.cityId = 0;
        this.cityName = "";
        this.createTime = null;
        this.createUser = "";
        this.assignKernelVersion = "";
        this.assignAppVersion = "";
        this.curKernelVersion = "";
        this.curAppVersion = "";
        this.assignConfigId = 0;
        this.assignConfigName = "";
        this.assignConfigVersion = null;
        this.curConfigId = 0;
        this.curConfigName = "";
        this.curConfigVersion = null;
        this.assignLoopTaskId = 0;
        this.assignLoopTaskName = null;
        this.assignLoopTaskVersion = null;
        this.assignLoopFileVersion = null;
        this.assignLoopPlayVersion = null;
        this.assignLoopStrategyVersion = null;
        this.curLoopTaskId = 0;
        this.curLoopTaskName = null;
        this.curLoopTaskVersion = null;
        this.curLoopFileVersion = null;
        this.curLoopPlayVersion = null;
        this.curLoopStrategyVersion = null;
        this.assignDemandTaskId = 0;
        this.assignDemandTaskName = null;
        this.assignDemandTaskVersion = null;
        this.assignDemandFileVersion = null;
        this.assignDemandPlayVersion = null;
        this.curDemandTaskId = 0;
        this.curDemandTaskName = null;
        this.curDemandTaskVersion = null;
        this.curDemandFileVersion = null;
        this.curDemandPlayVersion = null;
        this.assignPluginTaskId = 0;
        this.assignPluginTaskName = null;
        this.assignPluginTaskVersion = null;
        this.assignPluginFileVersion = null;
        this.assignPluginPlayVersion = null;
        this.curPluginTaskId = 0;
        this.curPluginTaskName = null;
        this.curPluginTaskVersion = null;
        this.curPluginFileVersion = null;
        this.curPluginPlayVersion = null;
        this.assignSourceVersion = null;
        this.curSourceVersion = null;
        this.restSchedule = "";
        this.standBySchedule = "";
        this.captureSchedule = "";
        this.demandSchedule = "";
        this.scheduleVersion = null;
        this.subtitle = "";
        this.subtitleVersion = null;
        this.curSubtitleVersion = null;
        this.onlineState = 0;
        this.logonTime = null;
        this.logoffTime = null;
        this.downloadTotal = 0L;
        this.downloadFinished = 0L;
        this.downloadType = 0;
        this.powerOn = 0;
        this.powerOff = 0;
        this.aliveInterval = 0;
        this.lastAlive = null;
        this.lastPatrol = null;
        this.lastDownload = null;
        this.kernelUpdated = 0;
        this.appUpdated = 0;
        this.configUpdated = 0;
        this.loopTaskUpdated = 0;
        this.demandTaskUpdated = 0;
        this.pluginTaskUpdated = 0;
        this.subtitleUpdated = 0;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final int newCustomerId) {
        this.customerId = newCustomerId;
    }

    public long getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(final long newDeviceId) {
        this.deviceId = newDeviceId;
    }

    public void setCityName(final String newCityName) {
        this.cityName = newCityName;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityId(final int newCityId) {
        this.cityId = newCityId;
    }

    public int getCityId() {
        return this.cityId;
    }

    public void setGroupName(final String newGroupName) {
        this.groupName = newGroupName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupId(final int newGroupId) {
        this.groupId = newGroupId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(final String newDeviceName) {
        this.deviceName = newDeviceName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String newDescription) {
        this.description = newDescription;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(final Date newCreateTime) {
        this.createTime = newCreateTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(final String newCreateUser) {
        this.createUser = newCreateUser;
    }

    public String getAssignKernelVersion() {
        return this.assignKernelVersion;
    }

    public void setAssignKernelVersion(final String newAssignKernelVersion) {
        this.assignKernelVersion = newAssignKernelVersion;
    }

    public String getAssignAppVersion() {
        return this.assignAppVersion;
    }

    public void setAssignAppVersion(final String newAssignAppVersion) {
        this.assignAppVersion = newAssignAppVersion;
    }

    public String getCurKernelVersion() {
        return this.curKernelVersion;
    }

    public void setCurKernelVersion(final String newCurKernelVersion) {
        this.curKernelVersion = newCurKernelVersion;
    }

    public String getCurAppVersion() {
        return this.curAppVersion;
    }

    public void setCurAppVersion(final String newCurAppVersion) {
        this.curAppVersion = newCurAppVersion;
    }

    public int getAssignConfigId() {
        return this.assignConfigId;
    }

    public void setAssignConfigId(final int newAssignConfigId) {
        this.assignConfigId = newAssignConfigId;
    }

    public String getAssignConfigName() {
        return this.assignConfigName;
    }

    public void setAssignConfigName(final String newAssignConfigName) {
        this.assignConfigName = newAssignConfigName;
    }

    public Date getAssignConfigVersion() {
        return this.assignConfigVersion;
    }

    public void setAssignConfigVersion(final Date newAssignConfigVersion) {
        this.assignConfigVersion = newAssignConfigVersion;
    }

    public int getCurConfigId() {
        return this.curConfigId;
    }

    public void setCurConfigId(final int newCurConfigId) {
        this.curConfigId = newCurConfigId;
    }

    public String getCurConfigName() {
        return this.curConfigName;
    }

    public void setCurConfigName(final String newCurConfigName) {
        this.curConfigName = newCurConfigName;
    }

    public Date getCurConfigVersion() {
        return this.curConfigVersion;
    }

    public void setCurConfigVersion(final Date newCurConfigVersion) {
        this.curConfigVersion = newCurConfigVersion;
    }

    public int getAssignLoopTaskId() {
        return this.assignLoopTaskId;
    }

    public void setAssignLoopTaskId(final int newAssignLoopTaskId) {
        this.assignLoopTaskId = newAssignLoopTaskId;
    }

    public String getAssignLoopTaskName() {
        return this.assignLoopTaskName;
    }

    public void setAssignLoopTaskName(final String newAssignLoopTaskName) {
        this.assignLoopTaskName = newAssignLoopTaskName;
    }

    public Date getAssignLoopTaskVersion() {
        return this.assignLoopTaskVersion;
    }

    public void setAssignLoopTaskVersion(final Date newAssignLoopTaskVersion) {
        this.assignLoopTaskVersion = newAssignLoopTaskVersion;
    }

    public Date getAssignLoopFileVersion() {
        return this.assignLoopFileVersion;
    }

    public void setAssignLoopFileVersion(final Date newAssignLoopFileVersion) {
        this.assignLoopFileVersion = newAssignLoopFileVersion;
    }

    public Date getAssignLoopPlayVersion() {
        return this.assignLoopPlayVersion;
    }

    public void setAssignLoopPlayVersion(final Date newAssignLoopPlayVersion) {
        this.assignLoopPlayVersion = newAssignLoopPlayVersion;
    }

    public Date getAssignLoopStrategyVersion() {
        return this.assignLoopStrategyVersion;
    }

    public void setAssignLoopStrategyVersion(final Date newAssignLoopStrategyVersion) {
        this.assignLoopStrategyVersion = newAssignLoopStrategyVersion;
    }

    public int getCurLoopTaskId() {
        return this.curLoopTaskId;
    }

    public void setCurLoopTaskId(final int newCurLoopTaskId) {
        this.curLoopTaskId = newCurLoopTaskId;
    }

    public String getCurLoopTaskName() {
        return this.curLoopTaskName;
    }

    public void setCurLoopTaskName(final String newCurLoopTaskName) {
        this.curLoopTaskName = newCurLoopTaskName;
    }

    public Date getCurLoopTaskVersion() {
        return this.curLoopTaskVersion;
    }

    public void setCurLoopTaskVersion(final Date newCurLoopTaskVersion) {
        this.curLoopTaskVersion = newCurLoopTaskVersion;
    }

    public Date getCurLoopFileVersion() {
        return this.curLoopFileVersion;
    }

    public void setCurLoopFileVersion(final Date newCurLoopFileVersion) {
        this.curLoopFileVersion = newCurLoopFileVersion;
    }

    public Date getCurLoopPlayVersion() {
        return this.curLoopPlayVersion;
    }

    public void setCurLoopPlayVersion(final Date newCurLoopPlayVersion) {
        this.curLoopPlayVersion = newCurLoopPlayVersion;
    }

    public Date getCurLoopStrategyVersion() {
        return this.curLoopStrategyVersion;
    }

    public void setCurLoopStrategyVersion(final Date newCurLoopStrategyVersion) {
        this.curLoopStrategyVersion = newCurLoopStrategyVersion;
    }

    public int getAssignDemandTaskId() {
        return this.assignDemandTaskId;
    }

    public void setAssignDemandTaskId(final int newAssignDemandTaskId) {
        this.assignDemandTaskId = newAssignDemandTaskId;
    }

    public String getAssignDemandTaskName() {
        return this.assignDemandTaskName;
    }

    public void setAssignDemandTaskName(final String newAssignDemandTaskName) {
        this.assignDemandTaskName = newAssignDemandTaskName;
    }

    public Date getAssignDemandTaskVersion() {
        return this.assignDemandTaskVersion;
    }

    public void setAssignDemandTaskVersion(final Date newAssignDemandTaskVersion) {
        this.assignDemandTaskVersion = newAssignDemandTaskVersion;
    }

    public Date getAssignDemandFileVersion() {
        return this.assignDemandFileVersion;
    }

    public void setAssignDemandFileVersion(final Date newAssignDemandFileVersion) {
        this.assignDemandFileVersion = newAssignDemandFileVersion;
    }

    public Date getAssignDemandPlayVersion() {
        return this.assignDemandPlayVersion;
    }

    public void setAssignDemandPlayVersion(final Date newAssignDemandPlayVersion) {
        this.assignDemandPlayVersion = newAssignDemandPlayVersion;
    }

    public int getCurDemandTaskId() {
        return this.curDemandTaskId;
    }

    public void setCurDemandTaskId(final int newCurDemandTaskId) {
        this.curDemandTaskId = newCurDemandTaskId;
    }

    public String getCurDemandTaskName() {
        return this.curDemandTaskName;
    }

    public void setCurDemandTaskName(final String newCurDemandTaskName) {
        this.curDemandTaskName = newCurDemandTaskName;
    }

    public Date getCurDemandTaskVersion() {
        return this.curDemandTaskVersion;
    }

    public void setCurDemandTaskVersion(final Date newCurDemandTaskVersion) {
        this.curDemandTaskVersion = newCurDemandTaskVersion;
    }

    public Date getCurDemandFileVersion() {
        return this.curDemandFileVersion;
    }

    public void setCurDemandFileVersion(final Date newCurDemandFileVersion) {
        this.curDemandFileVersion = newCurDemandFileVersion;
    }

    public Date getCurDemandPlayVersion() {
        return this.curDemandPlayVersion;
    }

    public void setCurDemandPlayVersion(final Date newCurDemandPlayVersion) {
        this.curDemandPlayVersion = newCurDemandPlayVersion;
    }

    public int getAssignPluginTaskId() {
        return this.assignPluginTaskId;
    }

    public void setAssignPluginTaskId(final int newAssignPluginTaskId) {
        this.assignPluginTaskId = newAssignPluginTaskId;
    }

    public String getAssignPluginTaskName() {
        return this.assignPluginTaskName;
    }

    public void setAssignPluginTaskName(final String newAssignPluginTaskName) {
        this.assignPluginTaskName = newAssignPluginTaskName;
    }

    public Date getAssignPluginTaskVersion() {
        return this.assignPluginTaskVersion;
    }

    public void setAssignPluginTaskVersion(final Date newAssignPluginTaskVersion) {
        this.assignPluginTaskVersion = newAssignPluginTaskVersion;
    }

    public Date getAssignPluginFileVersion() {
        return this.assignPluginFileVersion;
    }

    public void setAssignPluginFileVersion(final Date newAssignPluginFileVersion) {
        this.assignPluginFileVersion = newAssignPluginFileVersion;
    }

    public Date getAssignPluginPlayVersion() {
        return this.assignPluginPlayVersion;
    }

    public void setAssignPluginPlayVersion(final Date newAssignPluginPlayVersion) {
        this.assignPluginPlayVersion = newAssignPluginPlayVersion;
    }

    public int getCurPluginTaskId() {
        return this.curPluginTaskId;
    }

    public void setCurPluginTaskId(final int newCurPluginTaskId) {
        this.curPluginTaskId = newCurPluginTaskId;
    }

    public String getCurPluginTaskName() {
        return this.curPluginTaskName;
    }

    public void setCurPluginTaskName(final String newCurPluginTaskName) {
        this.curPluginTaskName = newCurPluginTaskName;
    }

    public Date getCurPluginTaskVersion() {
        return this.curPluginTaskVersion;
    }

    public void setCurPluginTaskVersion(final Date newCurPluginTaskVersion) {
        this.curPluginTaskVersion = newCurPluginTaskVersion;
    }

    public Date getCurPluginFileVersion() {
        return this.curPluginFileVersion;
    }

    public void setCurPluginFileVersion(final Date newCurPluginFileVersion) {
        this.curPluginFileVersion = newCurPluginFileVersion;
    }

    public Date getCurPluginPlayVersion() {
        return this.curPluginPlayVersion;
    }

    public void setCurPluginPlayVersion(final Date newCurPluginPlayVersion) {
        this.curPluginPlayVersion = newCurPluginPlayVersion;
    }

    public Date getAssignSourceVersion() {
        return this.assignSourceVersion;
    }

    public void setAssignSourceVersion(final Date newAssignSourceVersion) {
        this.assignSourceVersion = newAssignSourceVersion;
    }

    public Date getCurSourceVersion() {
        return this.curSourceVersion;
    }

    public void setCurSourceVersion(final Date newCurSourceVersion) {
        this.curSourceVersion = newCurSourceVersion;
    }

    public String getRestSchedule() {
        return this.restSchedule;
    }

    public void setRestSchedule(final String newRestSchedule) {
        this.restSchedule = newRestSchedule;
    }

    public String getStandBySchedule() {
        return this.standBySchedule;
    }

    public void setStandBySchedule(final String newStandBySchedule) {
        this.standBySchedule = newStandBySchedule;
    }

    public String getCaptureSchedule() {
        return this.captureSchedule;
    }

    public void setCaptureSchedule(final String newCaptureSchedule) {
        this.captureSchedule = newCaptureSchedule;
    }

    public String getDemandSchedule() {
        return this.demandSchedule;
    }

    public void setDemandSchedule(final String newDemandSchedule) {
        this.demandSchedule = newDemandSchedule;
    }

    public Date getScheduleVersion() {
        return this.scheduleVersion;
    }

    public void setScheduleVersion(final Date newScheduleVersion) {
        this.scheduleVersion = newScheduleVersion;
    }

    public String getSubtitle() {
        return this.subtitle;
    }

    public void setSubtitle(final String newSubtitle) {
        this.subtitle = newSubtitle;
    }

    public Date getSubtitleVersion() {
        return this.subtitleVersion;
    }

    public void setSubtitleVersion(final Date newSubtitleVersion) {
        this.subtitleVersion = newSubtitleVersion;
    }

    public Date getCurSubtitleVersion() {
        return this.curSubtitleVersion;
    }

    public void setCurSubtitleVersion(final Date newCurSubtitleVersion) {
        this.curSubtitleVersion = newCurSubtitleVersion;
    }

    public int getOnlineState() {
        return this.onlineState;
    }

    public void setOnlineState(final int newOnlineState) {
        this.onlineState = newOnlineState;
    }

    public Date getLogonTime() {
        return this.logonTime;
    }

    public void setLogonTime(final Date newLogonTime) {
        this.logonTime = newLogonTime;
    }

    public Date getLogoffTime() {
        return this.logoffTime;
    }

    public void setLogoffTime(final Date newLogoffTime) {
        this.logoffTime = newLogoffTime;
    }

    public long getDownloadTotal() {
        return this.downloadTotal;
    }

    public void setDownloadTotal(final long newDownloadTotal) {
        this.downloadTotal = newDownloadTotal;
    }

    public long getDownloadFinished() {
        return this.downloadFinished;
    }

    public void setDownloadFinished(final long newDownloadFinished) {
        this.downloadFinished = newDownloadFinished;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public void setDownloadType(final int newDownloadType) {
        this.downloadType = newDownloadType;
    }

    public int getPowerOn() {
        return this.powerOn;
    }

    public void setPowerOn(final int newPowerOn) {
        this.powerOn = newPowerOn;
    }

    public int getPowerOff() {
        return this.powerOff;
    }

    public void setPowerOff(final int newPowerOff) {
        this.powerOff = newPowerOff;
    }

    public int getAliveInterval() {
        return this.aliveInterval;
    }

    public void setAliveInterval(final int newAliveInterval) {
        this.aliveInterval = newAliveInterval;
    }

    public Date getLastAlive() {
        return this.lastAlive;
    }

    public void setLastAlive(final Date newLastAlive) {
        this.lastAlive = newLastAlive;
    }

    public Date getLastPatrol() {
        return this.lastPatrol;
    }

    public void setLastPatrol(final Date newLastPatrol) {
        this.lastPatrol = newLastPatrol;
    }

    public Date getLastDownload() {
        return this.lastDownload;
    }

    public void setLastDownload(final Date newLastDownload) {
        this.lastDownload = newLastDownload;
    }

    public void setKernelUpdated(final int newKernelUpdated) {
        this.kernelUpdated = newKernelUpdated;
    }

    public int getKernelUpdated() {
        return this.kernelUpdated;
    }

    public void setAppUpdated(final int newAppUpdated) {
        this.appUpdated = newAppUpdated;
    }

    public int getAppUpdated() {
        return this.appUpdated;
    }

    public void setConfigUpdated(final int newConfigUpdated) {
        this.configUpdated = newConfigUpdated;
    }

    public int getConfigUpdated() {
        return this.configUpdated;
    }

    public void setLoopTaskUpdated(final int newLoopTaskUpdated) {
        this.loopTaskUpdated = newLoopTaskUpdated;
    }

    public int getLoopTaskUpdated() {
        return this.loopTaskUpdated;
    }

    public void setDemandTaskUpdated(final int newDemandTaskUpdated) {
        this.demandTaskUpdated = newDemandTaskUpdated;
    }

    public int getDemandTaskUpdated() {
        return this.demandTaskUpdated;
    }

    public void setPluginTaskUpdated(final int newPluginUpdated) {
        this.pluginTaskUpdated = newPluginUpdated;
    }

    public int getPluginTaskUpdated() {
        return this.pluginTaskUpdated;
    }

    public void setSubtitleUpdated(final int newSubtitleUpdated) {
        this.subtitleUpdated = newSubtitleUpdated;
    }

    public int getSubtitleUpdated() {
        return this.subtitleUpdated;
    }

    @Override
    public String toString() {
        return "Device{" + "customerId=" + customerId + ", deviceId=" + deviceId + ", deviceName=" + deviceName + ", description=" + description + ", groupId=" + groupId + ", groupName=" + groupName + ", cityId=" + cityId + ", cityName=" + cityName + ", createTime=" + createTime + ", createUser=" + createUser + ", assignKernelVersion=" + assignKernelVersion + ", assignAppVersion=" + assignAppVersion + ", curKernelVersion=" + curKernelVersion + ", curAppVersion=" + curAppVersion + ", assignConfigId=" + assignConfigId + ", assignConfigName=" + assignConfigName + ", assignConfigVersion=" + assignConfigVersion + ", curConfigId=" + curConfigId + ", curConfigName=" + curConfigName + ", curConfigVersion=" + curConfigVersion + ", assignLoopTaskId=" + assignLoopTaskId + ", assignLoopTaskName=" + assignLoopTaskName + ", assignLoopTaskVersion=" + assignLoopTaskVersion + ", assignLoopFileVersion=" + assignLoopFileVersion + ", assignLoopPlayVersion=" + assignLoopPlayVersion + ", assignLoopStrategyVersion=" + assignLoopStrategyVersion + ", curLoopTaskId=" + curLoopTaskId + ", curLoopTaskName=" + curLoopTaskName + ", curLoopTaskVersion=" + curLoopTaskVersion + ", curLoopFileVersion=" + curLoopFileVersion + ", curLoopPlayVersion=" + curLoopPlayVersion + ", curLoopStrategyVersion=" + curLoopStrategyVersion + ", assignDemandTaskId=" + assignDemandTaskId + ", assignDemandTaskName=" + assignDemandTaskName + ", assignDemandTaskVersion=" + assignDemandTaskVersion + ", assignDemandFileVersion=" + assignDemandFileVersion + ", assignDemandPlayVersion=" + assignDemandPlayVersion + ", curDemandTaskId=" + curDemandTaskId + ", curDemandTaskName=" + curDemandTaskName + ", curDemandTaskVersion=" + curDemandTaskVersion + ", curDemandFileVersion=" + curDemandFileVersion + ", curDemandPlayVersion=" + curDemandPlayVersion + ", assignPluginTaskId=" + assignPluginTaskId + ", assignPluginTaskName=" + assignPluginTaskName + ", assignPluginTaskVersion=" + assignPluginTaskVersion + ", assignPluginFileVersion=" + assignPluginFileVersion + ", assignPluginPlayVersion=" + assignPluginPlayVersion + ", curPluginTaskId=" + curPluginTaskId + ", curPluginTaskName=" + curPluginTaskName + ", curPluginTaskVersion=" + curPluginTaskVersion + ", curPluginFileVersion=" + curPluginFileVersion + ", curPluginPlayVersion=" + curPluginPlayVersion + ", assignSourceVersion=" + assignSourceVersion + ", curSourceVersion=" + curSourceVersion + ", restSchedule=" + restSchedule + ", standBySchedule=" + standBySchedule + ", captureSchedule=" + captureSchedule + ", demandSchedule=" + demandSchedule + ", scheduleVersion=" + scheduleVersion + ", subtitle=" + subtitle + ", subtitleVersion=" + subtitleVersion + ", curSubtitleVersion=" + curSubtitleVersion + ", onlineState=" + onlineState + ", logonTime=" + logonTime + ", logoffTime=" + logoffTime + ", downloadTotal=" + downloadTotal + ", downloadFinished=" + downloadFinished + ", downloadType=" + downloadType + ", powerOn=" + powerOn + ", powerOff=" + powerOff + ", aliveInterval=" + aliveInterval + ", lastAlive=" + lastAlive + ", lastPatrol=" + lastPatrol + ", lastDownload=" + lastDownload + ", kernelUpdated=" + kernelUpdated + ", appUpdated=" + appUpdated + ", configUpdated=" + configUpdated + ", loopTaskUpdated=" + loopTaskUpdated + ", demandTaskUpdated=" + demandTaskUpdated + ", pluginTaskUpdated=" + pluginTaskUpdated + ", subtitleUpdated=" + subtitleUpdated + '}';
    }
    
    
    
    
}
