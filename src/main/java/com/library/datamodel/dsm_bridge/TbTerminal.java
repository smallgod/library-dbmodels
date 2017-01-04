package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import com.library.sgsharedinterface.DBInterface;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbTerminal generated by hbm2java
 */
@Entity
@Table(name = "tb_terminal")
public class TbTerminal implements Serializable, DBInterface {

    private static final long serialVersionUID = -2535532264508982021L;

	private TbTerminalId id;
	private TbApp tbApp;
	private TbCity tbCity;
	private TbConfig tbConfig;
	private TbDemandTask tbDemandTask;
	private TbGroup tbGroup;
	private TbKernel tbKernel;
	private TbLoopTask tbLoopTask;
	private TbPluginTask tbPluginTask;
	private String name;
	private String descp;
	private Date createTime;
	private String createUser;
	private String curKernel;
	private String curApp;
	private Integer curConfigId;
	private Date curConfigVersion;
	private Integer curLooptaskId;
	private Date curLooptaskVersion;
	private Date curLoopfileVersion;
	private Date curLoopplayVersion;
	private Date curLoopstrategyVersion;
	private Integer curDemandtaskId;
	private Date curDemandtaskVersion;
	private Date curDemandfileVersion;
	private Date curDemandplayVersion;
	private Integer curPlugintaskId;
	private Date curPlugintaskVersion;
	private Date curPluginfileVersion;
	private Date curPluginplayVersion;
	private Date assignSourceVersion;
	private String restSchedule;
	private String standbySchedule;
	private String captureSchedule;
	private String demandSchedule;
	private Date scheduleVersion;
	private String subtitle;
	private Date subtitleVersion;
	private Date curSubtitleVersion;
	private int onlineState;
	private Date logonTime;
	private Date logoffTime;
	private long downloadTotal;
	private long downloadFinished;
	private int downloadType;
	private int poweron;
	private int poweroff;
	private int aliveInterval;
	private Date lastAlive;
	private Date lastPatrol;
	private Date lastDownload;
	private long flowLimit;
	private long netFlow;
	private Set<TbTerminalEvent> tbTerminalEvents = new HashSet<TbTerminalEvent>(0);
	private Set<TbException> tbExceptions = new HashSet<TbException>(0);
	private Set<TbKeylog> tbKeylogs = new HashSet<TbKeylog>(0);
	private Set<TbPlaylog> tbPlaylogs = new HashSet<TbPlaylog>(0);

	public TbTerminal() {
	}

	public TbTerminal(TbTerminalId id, TbConfig tbConfig, TbDemandTask tbDemandTask, TbGroup tbGroup,
			TbLoopTask tbLoopTask, TbPluginTask tbPluginTask, String name, String descp, Date createTime,
			String createUser, Date assignSourceVersion, String restSchedule, String standbySchedule,
			String captureSchedule, String demandSchedule, Date scheduleVersion, String subtitle, Date subtitleVersion,
			Date curSubtitleVersion, int onlineState, Date logonTime, Date logoffTime, long downloadTotal,
			long downloadFinished, int downloadType, int poweron, int poweroff, int aliveInterval, Date lastAlive,
			Date lastPatrol, Date lastDownload, long flowLimit, long netFlow) {
		this.id = id;
		this.tbConfig = tbConfig;
		this.tbDemandTask = tbDemandTask;
		this.tbGroup = tbGroup;
		this.tbLoopTask = tbLoopTask;
		this.tbPluginTask = tbPluginTask;
		this.name = name;
		this.descp = descp;
		this.createTime = createTime;
		this.createUser = createUser;
		this.assignSourceVersion = assignSourceVersion;
		this.restSchedule = restSchedule;
		this.standbySchedule = standbySchedule;
		this.captureSchedule = captureSchedule;
		this.demandSchedule = demandSchedule;
		this.scheduleVersion = scheduleVersion;
		this.subtitle = subtitle;
		this.subtitleVersion = subtitleVersion;
		this.curSubtitleVersion = curSubtitleVersion;
		this.onlineState = onlineState;
		this.logonTime = logonTime;
		this.logoffTime = logoffTime;
		this.downloadTotal = downloadTotal;
		this.downloadFinished = downloadFinished;
		this.downloadType = downloadType;
		this.poweron = poweron;
		this.poweroff = poweroff;
		this.aliveInterval = aliveInterval;
		this.lastAlive = lastAlive;
		this.lastPatrol = lastPatrol;
		this.lastDownload = lastDownload;
		this.flowLimit = flowLimit;
		this.netFlow = netFlow;
	}

	public TbTerminal(TbTerminalId id, TbApp tbApp, TbCity tbCity, TbConfig tbConfig, TbDemandTask tbDemandTask,
			TbGroup tbGroup, TbKernel tbKernel, TbLoopTask tbLoopTask, TbPluginTask tbPluginTask, String name,
			String descp, Date createTime, String createUser, String curKernel, String curApp, Integer curConfigId,
			Date curConfigVersion, Integer curLooptaskId, Date curLooptaskVersion, Date curLoopfileVersion,
			Date curLoopplayVersion, Date curLoopstrategyVersion, Integer curDemandtaskId, Date curDemandtaskVersion,
			Date curDemandfileVersion, Date curDemandplayVersion, Integer curPlugintaskId, Date curPlugintaskVersion,
			Date curPluginfileVersion, Date curPluginplayVersion, Date assignSourceVersion, String restSchedule,
			String standbySchedule, String captureSchedule, String demandSchedule, Date scheduleVersion,
			String subtitle, Date subtitleVersion, Date curSubtitleVersion, int onlineState, Date logonTime,
			Date logoffTime, long downloadTotal, long downloadFinished, int downloadType, int poweron, int poweroff,
			int aliveInterval, Date lastAlive, Date lastPatrol, Date lastDownload, long flowLimit, long netFlow,
			Set<TbTerminalEvent> tbTerminalEvents, Set<TbException> tbExceptions, Set<TbKeylog> tbKeylogs,
			Set<TbPlaylog> tbPlaylogs) {
		this.id = id;
		this.tbApp = tbApp;
		this.tbCity = tbCity;
		this.tbConfig = tbConfig;
		this.tbDemandTask = tbDemandTask;
		this.tbGroup = tbGroup;
		this.tbKernel = tbKernel;
		this.tbLoopTask = tbLoopTask;
		this.tbPluginTask = tbPluginTask;
		this.name = name;
		this.descp = descp;
		this.createTime = createTime;
		this.createUser = createUser;
		this.curKernel = curKernel;
		this.curApp = curApp;
		this.curConfigId = curConfigId;
		this.curConfigVersion = curConfigVersion;
		this.curLooptaskId = curLooptaskId;
		this.curLooptaskVersion = curLooptaskVersion;
		this.curLoopfileVersion = curLoopfileVersion;
		this.curLoopplayVersion = curLoopplayVersion;
		this.curLoopstrategyVersion = curLoopstrategyVersion;
		this.curDemandtaskId = curDemandtaskId;
		this.curDemandtaskVersion = curDemandtaskVersion;
		this.curDemandfileVersion = curDemandfileVersion;
		this.curDemandplayVersion = curDemandplayVersion;
		this.curPlugintaskId = curPlugintaskId;
		this.curPlugintaskVersion = curPlugintaskVersion;
		this.curPluginfileVersion = curPluginfileVersion;
		this.curPluginplayVersion = curPluginplayVersion;
		this.assignSourceVersion = assignSourceVersion;
		this.restSchedule = restSchedule;
		this.standbySchedule = standbySchedule;
		this.captureSchedule = captureSchedule;
		this.demandSchedule = demandSchedule;
		this.scheduleVersion = scheduleVersion;
		this.subtitle = subtitle;
		this.subtitleVersion = subtitleVersion;
		this.curSubtitleVersion = curSubtitleVersion;
		this.onlineState = onlineState;
		this.logonTime = logonTime;
		this.logoffTime = logoffTime;
		this.downloadTotal = downloadTotal;
		this.downloadFinished = downloadFinished;
		this.downloadType = downloadType;
		this.poweron = poweron;
		this.poweroff = poweroff;
		this.aliveInterval = aliveInterval;
		this.lastAlive = lastAlive;
		this.lastPatrol = lastPatrol;
		this.lastDownload = lastDownload;
		this.flowLimit = flowLimit;
		this.netFlow = netFlow;
		this.tbTerminalEvents = tbTerminalEvents;
		this.tbExceptions = tbExceptions;
		this.tbKeylogs = tbKeylogs;
		this.tbPlaylogs = tbPlaylogs;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "devId", column = @Column(name = "DEV_ID", nullable = false)) })
	public TbTerminalId getId() {
		return this.id;
	}

	public void setId(TbTerminalId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSIGN_APP")
	public TbApp getTbApp() {
		return this.tbApp;
	}

	public void setTbApp(TbApp tbApp) {
		this.tbApp = tbApp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	public TbCity getTbCity() {
		return this.tbCity;
	}

	public void setTbCity(TbCity tbCity) {
		this.tbCity = tbCity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ASSIGN_CONFIG_ID", referencedColumnName = "CONFIG_ID", nullable = false, insertable = false, updatable = false) })
	public TbConfig getTbConfig() {
		return this.tbConfig;
	}

	public void setTbConfig(TbConfig tbConfig) {
		this.tbConfig = tbConfig;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ASSIGN_DEMANDTASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false) })
	public TbDemandTask getTbDemandTask() {
		return this.tbDemandTask;
	}

	public void setTbDemandTask(TbDemandTask tbDemandTask) {
		this.tbDemandTask = tbDemandTask;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "GROUP_ID", referencedColumnName = "GROUP_ID", nullable = false, insertable = false, updatable = false) })
	public TbGroup getTbGroup() {
		return this.tbGroup;
	}

	public void setTbGroup(TbGroup tbGroup) {
		this.tbGroup = tbGroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ASSIGN_KERNEL")
	public TbKernel getTbKernel() {
		return this.tbKernel;
	}

	public void setTbKernel(TbKernel tbKernel) {
		this.tbKernel = tbKernel;
	}

        //@ManyToOne(optional = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = EAGER)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ASSIGN_LOOPTASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false) })
	public TbLoopTask getTbLoopTask() {
		return this.tbLoopTask;
	}

	public void setTbLoopTask(TbLoopTask tbLoopTask) {
		this.tbLoopTask = tbLoopTask;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ASSIGN_PLUGINTASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false) })
	public TbPluginTask getTbPluginTask() {
		return this.tbPluginTask;
	}

	public void setTbPluginTask(TbPluginTask tbPluginTask) {
		this.tbPluginTask = tbPluginTask;
	}

	@Column(name = "NAME", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCP", nullable = false, length = 256)
	public String getDescp() {
		return this.descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CREATE_USER", nullable = false, length = 64)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@Column(name = "CUR_KERNEL", length = 64)
	public String getCurKernel() {
		return this.curKernel;
	}

	public void setCurKernel(String curKernel) {
		this.curKernel = curKernel;
	}

	@Column(name = "CUR_APP", length = 64)
	public String getCurApp() {
		return this.curApp;
	}

	public void setCurApp(String curApp) {
		this.curApp = curApp;
	}

	@Column(name = "CUR_CONFIG_ID")
	public Integer getCurConfigId() {
		return this.curConfigId;
	}

	public void setCurConfigId(Integer curConfigId) {
		this.curConfigId = curConfigId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_CONFIG_VERSION", length = 19)
	public Date getCurConfigVersion() {
		return this.curConfigVersion;
	}

	public void setCurConfigVersion(Date curConfigVersion) {
		this.curConfigVersion = curConfigVersion;
	}

	@Column(name = "CUR_LOOPTASK_ID")
	public Integer getCurLooptaskId() {
		return this.curLooptaskId;
	}

	public void setCurLooptaskId(Integer curLooptaskId) {
		this.curLooptaskId = curLooptaskId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_LOOPTASK_VERSION", length = 19)
	public Date getCurLooptaskVersion() {
		return this.curLooptaskVersion;
	}

	public void setCurLooptaskVersion(Date curLooptaskVersion) {
		this.curLooptaskVersion = curLooptaskVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_LOOPFILE_VERSION", length = 19)
	public Date getCurLoopfileVersion() {
		return this.curLoopfileVersion;
	}

	public void setCurLoopfileVersion(Date curLoopfileVersion) {
		this.curLoopfileVersion = curLoopfileVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_LOOPPLAY_VERSION", length = 19)
	public Date getCurLoopplayVersion() {
		return this.curLoopplayVersion;
	}

	public void setCurLoopplayVersion(Date curLoopplayVersion) {
		this.curLoopplayVersion = curLoopplayVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_LOOPSTRATEGY_VERSION", length = 19)
	public Date getCurLoopstrategyVersion() {
		return this.curLoopstrategyVersion;
	}

	public void setCurLoopstrategyVersion(Date curLoopstrategyVersion) {
		this.curLoopstrategyVersion = curLoopstrategyVersion;
	}

	@Column(name = "CUR_DEMANDTASK_ID")
	public Integer getCurDemandtaskId() {
		return this.curDemandtaskId;
	}

	public void setCurDemandtaskId(Integer curDemandtaskId) {
		this.curDemandtaskId = curDemandtaskId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_DEMANDTASK_VERSION", length = 19)
	public Date getCurDemandtaskVersion() {
		return this.curDemandtaskVersion;
	}

	public void setCurDemandtaskVersion(Date curDemandtaskVersion) {
		this.curDemandtaskVersion = curDemandtaskVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_DEMANDFILE_VERSION", length = 19)
	public Date getCurDemandfileVersion() {
		return this.curDemandfileVersion;
	}

	public void setCurDemandfileVersion(Date curDemandfileVersion) {
		this.curDemandfileVersion = curDemandfileVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_DEMANDPLAY_VERSION", length = 19)
	public Date getCurDemandplayVersion() {
		return this.curDemandplayVersion;
	}

	public void setCurDemandplayVersion(Date curDemandplayVersion) {
		this.curDemandplayVersion = curDemandplayVersion;
	}

	@Column(name = "CUR_PLUGINTASK_ID")
	public Integer getCurPlugintaskId() {
		return this.curPlugintaskId;
	}

	public void setCurPlugintaskId(Integer curPlugintaskId) {
		this.curPlugintaskId = curPlugintaskId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_PLUGINTASK_VERSION", length = 19)
	public Date getCurPlugintaskVersion() {
		return this.curPlugintaskVersion;
	}

	public void setCurPlugintaskVersion(Date curPlugintaskVersion) {
		this.curPlugintaskVersion = curPlugintaskVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_PLUGINFILE_VERSION", length = 19)
	public Date getCurPluginfileVersion() {
		return this.curPluginfileVersion;
	}

	public void setCurPluginfileVersion(Date curPluginfileVersion) {
		this.curPluginfileVersion = curPluginfileVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_PLUGINPLAY_VERSION", length = 19)
	public Date getCurPluginplayVersion() {
		return this.curPluginplayVersion;
	}

	public void setCurPluginplayVersion(Date curPluginplayVersion) {
		this.curPluginplayVersion = curPluginplayVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ASSIGN_SOURCE_VERSION", nullable = false, length = 19)
	public Date getAssignSourceVersion() {
		return this.assignSourceVersion;
	}

	public void setAssignSourceVersion(Date assignSourceVersion) {
		this.assignSourceVersion = assignSourceVersion;
	}

	@Column(name = "REST_SCHEDULE", nullable = false, length = 1024)
	public String getRestSchedule() {
		return this.restSchedule;
	}

	public void setRestSchedule(String restSchedule) {
		this.restSchedule = restSchedule;
	}

	@Column(name = "STANDBY_SCHEDULE", nullable = false, length = 1024)
	public String getStandbySchedule() {
		return this.standbySchedule;
	}

	public void setStandbySchedule(String standbySchedule) {
		this.standbySchedule = standbySchedule;
	}

	@Column(name = "CAPTURE_SCHEDULE", nullable = false, length = 1024)
	public String getCaptureSchedule() {
		return this.captureSchedule;
	}

	public void setCaptureSchedule(String captureSchedule) {
		this.captureSchedule = captureSchedule;
	}

	@Column(name = "DEMAND_SCHEDULE", nullable = false, length = 1024)
	public String getDemandSchedule() {
		return this.demandSchedule;
	}

	public void setDemandSchedule(String demandSchedule) {
		this.demandSchedule = demandSchedule;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SCHEDULE_VERSION", nullable = false, length = 19)
	public Date getScheduleVersion() {
		return this.scheduleVersion;
	}

	public void setScheduleVersion(Date scheduleVersion) {
		this.scheduleVersion = scheduleVersion;
	}

	@Column(name = "SUBTITLE", nullable = false, length = 4096)
	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "SUBTITLE_VERSION", nullable = false, length = 19)
	public Date getSubtitleVersion() {
		return this.subtitleVersion;
	}

	public void setSubtitleVersion(Date subtitleVersion) {
		this.subtitleVersion = subtitleVersion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CUR_SUBTITLE_VERSION", nullable = false, length = 19)
	public Date getCurSubtitleVersion() {
		return this.curSubtitleVersion;
	}

	public void setCurSubtitleVersion(Date curSubtitleVersion) {
		this.curSubtitleVersion = curSubtitleVersion;
	}

	@Column(name = "ONLINE_STATE", nullable = false)
	public int getOnlineState() {
		return this.onlineState;
	}

	public void setOnlineState(int onlineState) {
		this.onlineState = onlineState;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGON_TIME", nullable = false, length = 19)
	public Date getLogonTime() {
		return this.logonTime;
	}

	public void setLogonTime(Date logonTime) {
		this.logonTime = logonTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGOFF_TIME", nullable = false, length = 19)
	public Date getLogoffTime() {
		return this.logoffTime;
	}

	public void setLogoffTime(Date logoffTime) {
		this.logoffTime = logoffTime;
	}

	@Column(name = "DOWNLOAD_TOTAL", nullable = false)
	public long getDownloadTotal() {
		return this.downloadTotal;
	}

	public void setDownloadTotal(long downloadTotal) {
		this.downloadTotal = downloadTotal;
	}

	@Column(name = "DOWNLOAD_FINISHED", nullable = false)
	public long getDownloadFinished() {
		return this.downloadFinished;
	}

	public void setDownloadFinished(long downloadFinished) {
		this.downloadFinished = downloadFinished;
	}

	@Column(name = "DOWNLOAD_TYPE", nullable = false)
	public int getDownloadType() {
		return this.downloadType;
	}

	public void setDownloadType(int downloadType) {
		this.downloadType = downloadType;
	}

	@Column(name = "POWERON", nullable = false)
	public int getPoweron() {
		return this.poweron;
	}

	public void setPoweron(int poweron) {
		this.poweron = poweron;
	}

	@Column(name = "POWEROFF", nullable = false)
	public int getPoweroff() {
		return this.poweroff;
	}

	public void setPoweroff(int poweroff) {
		this.poweroff = poweroff;
	}

	@Column(name = "ALIVE_INTERVAL", nullable = false)
	public int getAliveInterval() {
		return this.aliveInterval;
	}

	public void setAliveInterval(int aliveInterval) {
		this.aliveInterval = aliveInterval;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_ALIVE", nullable = false, length = 19)
	public Date getLastAlive() {
		return this.lastAlive;
	}

	public void setLastAlive(Date lastAlive) {
		this.lastAlive = lastAlive;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_PATROL", nullable = false, length = 19)
	public Date getLastPatrol() {
		return this.lastPatrol;
	}

	public void setLastPatrol(Date lastPatrol) {
		this.lastPatrol = lastPatrol;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_DOWNLOAD", nullable = false, length = 19)
	public Date getLastDownload() {
		return this.lastDownload;
	}

	public void setLastDownload(Date lastDownload) {
		this.lastDownload = lastDownload;
	}

	@Column(name = "FLOW_LIMIT", nullable = false)
	public long getFlowLimit() {
		return this.flowLimit;
	}

	public void setFlowLimit(long flowLimit) {
		this.flowLimit = flowLimit;
	}

	@Column(name = "NET_FLOW", nullable = false)
	public long getNetFlow() {
		return this.netFlow;
	}

	public void setNetFlow(long netFlow) {
		this.netFlow = netFlow;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbTerminal")
	public Set<TbTerminalEvent> getTbTerminalEvents() {
		return this.tbTerminalEvents;
	}

	public void setTbTerminalEvents(Set<TbTerminalEvent> tbTerminalEvents) {
		this.tbTerminalEvents = tbTerminalEvents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbTerminal")
	public Set<TbException> getTbExceptions() {
		return this.tbExceptions;
	}

	public void setTbExceptions(Set<TbException> tbExceptions) {
		this.tbExceptions = tbExceptions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbTerminal")
	public Set<TbKeylog> getTbKeylogs() {
		return this.tbKeylogs;
	}

	public void setTbKeylogs(Set<TbKeylog> tbKeylogs) {
		this.tbKeylogs = tbKeylogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbTerminal")
	public Set<TbPlaylog> getTbPlaylogs() {
		return this.tbPlaylogs;
	}

	public void setTbPlaylogs(Set<TbPlaylog> tbPlaylogs) {
		this.tbPlaylogs = tbPlaylogs;
	}

}
