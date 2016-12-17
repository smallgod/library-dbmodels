package com.library.datamodel.dsmbridge;

// default package
// Generated Dec 7, 2016 4:56:51 PM by Hibernate Tools 5.2.0.Beta1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbPluginTask generated by hbm2java
 */
public class TbPluginTask implements java.io.Serializable {

	private TbPluginTaskId id;
	private TbCustomer tbCustomer;
	private String name;
	private String descp;
	private Date taskVersion;
	private Date fileVersion;
	private Date playVersion;
	private int state;
	private Date createTime;
	private String createUser;
	private Date startTime;
	private Date stopTime;
	private int pluginCount;
	private int pluginStyle;
	private Set tbPluginPrograms = new HashSet(0);
	private Set tbPluginSources = new HashSet(0);
	private Set tbTerminals = new HashSet(0);

	public TbPluginTask() {
	}

	public TbPluginTask(TbPluginTaskId id, TbCustomer tbCustomer, String name, String descp, Date taskVersion,
			Date fileVersion, Date playVersion, int state, Date createTime, String createUser, Date startTime,
			Date stopTime, int pluginCount, int pluginStyle) {
		this.id = id;
		this.tbCustomer = tbCustomer;
		this.name = name;
		this.descp = descp;
		this.taskVersion = taskVersion;
		this.fileVersion = fileVersion;
		this.playVersion = playVersion;
		this.state = state;
		this.createTime = createTime;
		this.createUser = createUser;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.pluginCount = pluginCount;
		this.pluginStyle = pluginStyle;
	}

	public TbPluginTask(TbPluginTaskId id, TbCustomer tbCustomer, String name, String descp, Date taskVersion,
			Date fileVersion, Date playVersion, int state, Date createTime, String createUser, Date startTime,
			Date stopTime, int pluginCount, int pluginStyle, Set tbPluginPrograms, Set tbPluginSources,
			Set tbTerminals) {
		this.id = id;
		this.tbCustomer = tbCustomer;
		this.name = name;
		this.descp = descp;
		this.taskVersion = taskVersion;
		this.fileVersion = fileVersion;
		this.playVersion = playVersion;
		this.state = state;
		this.createTime = createTime;
		this.createUser = createUser;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.pluginCount = pluginCount;
		this.pluginStyle = pluginStyle;
		this.tbPluginPrograms = tbPluginPrograms;
		this.tbPluginSources = tbPluginSources;
		this.tbTerminals = tbTerminals;
	}

	public TbPluginTaskId getId() {
		return this.id;
	}

	public void setId(TbPluginTaskId id) {
		this.id = id;
	}

	public TbCustomer getTbCustomer() {
		return this.tbCustomer;
	}

	public void setTbCustomer(TbCustomer tbCustomer) {
		this.tbCustomer = tbCustomer;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescp() {
		return this.descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public Date getTaskVersion() {
		return this.taskVersion;
	}

	public void setTaskVersion(Date taskVersion) {
		this.taskVersion = taskVersion;
	}

	public Date getFileVersion() {
		return this.fileVersion;
	}

	public void setFileVersion(Date fileVersion) {
		this.fileVersion = fileVersion;
	}

	public Date getPlayVersion() {
		return this.playVersion;
	}

	public void setPlayVersion(Date playVersion) {
		this.playVersion = playVersion;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public int getPluginCount() {
		return this.pluginCount;
	}

	public void setPluginCount(int pluginCount) {
		this.pluginCount = pluginCount;
	}

	public int getPluginStyle() {
		return this.pluginStyle;
	}

	public void setPluginStyle(int pluginStyle) {
		this.pluginStyle = pluginStyle;
	}

	public Set getTbPluginPrograms() {
		return this.tbPluginPrograms;
	}

	public void setTbPluginPrograms(Set tbPluginPrograms) {
		this.tbPluginPrograms = tbPluginPrograms;
	}

	public Set getTbPluginSources() {
		return this.tbPluginSources;
	}

	public void setTbPluginSources(Set tbPluginSources) {
		this.tbPluginSources = tbPluginSources;
	}

	public Set getTbTerminals() {
		return this.tbTerminals;
	}

	public void setTbTerminals(Set tbTerminals) {
		this.tbTerminals = tbTerminals;
	}

}
