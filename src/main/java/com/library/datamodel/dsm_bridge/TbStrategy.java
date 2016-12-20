package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

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
 * TbStrategy generated by hbm2java
 */
@Entity
@Table(name = "tb_strategy")
public class TbStrategy implements java.io.Serializable {

	private TbStrategyId id;
	private TbLoopTask tbLoopTask;
	private String name;
	private String descp;
	private Date startDate;
	private Date stopDate;
	private int weekDays;
	private int startTime;
	private int stopTime;
	private Date createTime;
	private String createUser;
	private Set<TbStrategyProgram> tbStrategyPrograms = new HashSet<TbStrategyProgram>(0);

	public TbStrategy() {
	}

	public TbStrategy(TbStrategyId id, TbLoopTask tbLoopTask, String name, String descp, Date startDate, Date stopDate,
			int weekDays, int startTime, int stopTime, Date createTime, String createUser) {
		this.id = id;
		this.tbLoopTask = tbLoopTask;
		this.name = name;
		this.descp = descp;
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.weekDays = weekDays;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.createTime = createTime;
		this.createUser = createUser;
	}

	public TbStrategy(TbStrategyId id, TbLoopTask tbLoopTask, String name, String descp, Date startDate, Date stopDate,
			int weekDays, int startTime, int stopTime, Date createTime, String createUser,
			Set<TbStrategyProgram> tbStrategyPrograms) {
		this.id = id;
		this.tbLoopTask = tbLoopTask;
		this.name = name;
		this.descp = descp;
		this.startDate = startDate;
		this.stopDate = stopDate;
		this.weekDays = weekDays;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.createTime = createTime;
		this.createUser = createUser;
		this.tbStrategyPrograms = tbStrategyPrograms;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "taskId", column = @Column(name = "TASK_ID", nullable = false)),
			@AttributeOverride(name = "strategyId", column = @Column(name = "STRATEGY_ID", nullable = false)) })
	public TbStrategyId getId() {
		return this.id;
	}

	public void setId(TbStrategyId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false) })
	public TbLoopTask getTbLoopTask() {
		return this.tbLoopTask;
	}

	public void setTbLoopTask(TbLoopTask tbLoopTask) {
		this.tbLoopTask = tbLoopTask;
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
	@Column(name = "START_DATE", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STOP_DATE", nullable = false, length = 19)
	public Date getStopDate() {
		return this.stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

	@Column(name = "WEEK_DAYS", nullable = false)
	public int getWeekDays() {
		return this.weekDays;
	}

	public void setWeekDays(int weekDays) {
		this.weekDays = weekDays;
	}

	@Column(name = "START_TIME", nullable = false)
	public int getStartTime() {
		return this.startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	@Column(name = "STOP_TIME", nullable = false)
	public int getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(int stopTime) {
		this.stopTime = stopTime;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbStrategy")
	public Set<TbStrategyProgram> getTbStrategyPrograms() {
		return this.tbStrategyPrograms;
	}

	public void setTbStrategyPrograms(Set<TbStrategyProgram> tbStrategyPrograms) {
		this.tbStrategyPrograms = tbStrategyPrograms;
	}

}
