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
 * TbDemandProgram generated by hbm2java
 */
@Entity
@Table(name = "tb_demand_program")
public class TbDemandProgram implements java.io.Serializable {

	private TbDemandProgramId id;
	private TbDemandRect tbDemandRect;
	private TbDemandTask tbDemandTask;
	private String descp;
	private String name;
	private int seq;
	private int width;
	private int height;
	private int state;
	private Date createTime;
	private String createUser;
	private int playCount;
	private int playStyle;
	private Set<TbDemandRect> tbDemandRects = new HashSet<TbDemandRect>(0);
	private Set<TbDemandProgramMusic> tbDemandProgramMusics = new HashSet<TbDemandProgramMusic>(0);

	public TbDemandProgram() {
	}

	public TbDemandProgram(TbDemandProgramId id, TbDemandRect tbDemandRect, TbDemandTask tbDemandTask, String descp,
			String name, int seq, int width, int height, int state, Date createTime, String createUser, int playCount,
			int playStyle) {
		this.id = id;
		this.tbDemandRect = tbDemandRect;
		this.tbDemandTask = tbDemandTask;
		this.descp = descp;
		this.name = name;
		this.seq = seq;
		this.width = width;
		this.height = height;
		this.state = state;
		this.createTime = createTime;
		this.createUser = createUser;
		this.playCount = playCount;
		this.playStyle = playStyle;
	}

	public TbDemandProgram(TbDemandProgramId id, TbDemandRect tbDemandRect, TbDemandTask tbDemandTask, String descp,
			String name, int seq, int width, int height, int state, Date createTime, String createUser, int playCount,
			int playStyle, Set<TbDemandRect> tbDemandRects, Set<TbDemandProgramMusic> tbDemandProgramMusics) {
		this.id = id;
		this.tbDemandRect = tbDemandRect;
		this.tbDemandTask = tbDemandTask;
		this.descp = descp;
		this.name = name;
		this.seq = seq;
		this.width = width;
		this.height = height;
		this.state = state;
		this.createTime = createTime;
		this.createUser = createUser;
		this.playCount = playCount;
		this.playStyle = playStyle;
		this.tbDemandRects = tbDemandRects;
		this.tbDemandProgramMusics = tbDemandProgramMusics;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "taskId", column = @Column(name = "TASK_ID", nullable = false)),
			@AttributeOverride(name = "prgmId", column = @Column(name = "PRGM_ID", nullable = false)) })
	public TbDemandProgramId getId() {
		return this.id;
	}

	public void setId(TbDemandProgramId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "PRGM_ID", referencedColumnName = "PRGM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "MAIN_RECT", referencedColumnName = "RECT_ID", nullable = false, insertable = false, updatable = false) })
	public TbDemandRect getTbDemandRect() {
		return this.tbDemandRect;
	}

	public void setTbDemandRect(TbDemandRect tbDemandRect) {
		this.tbDemandRect = tbDemandRect;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false) })
	public TbDemandTask getTbDemandTask() {
		return this.tbDemandTask;
	}

	public void setTbDemandTask(TbDemandTask tbDemandTask) {
		this.tbDemandTask = tbDemandTask;
	}

	@Column(name = "DESCP", nullable = false, length = 256)
	public String getDescp() {
		return this.descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	@Column(name = "NAME", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SEQ", nullable = false)
	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Column(name = "WIDTH", nullable = false)
	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Column(name = "HEIGHT", nullable = false)
	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Column(name = "STATE", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
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

	@Column(name = "PLAY_COUNT", nullable = false)
	public int getPlayCount() {
		return this.playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

	@Column(name = "PLAY_STYLE", nullable = false)
	public int getPlayStyle() {
		return this.playStyle;
	}

	public void setPlayStyle(int playStyle) {
		this.playStyle = playStyle;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbDemandProgram")
	public Set<TbDemandRect> getTbDemandRects() {
		return this.tbDemandRects;
	}

	public void setTbDemandRects(Set<TbDemandRect> tbDemandRects) {
		this.tbDemandRects = tbDemandRects;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbDemandProgram")
	public Set<TbDemandProgramMusic> getTbDemandProgramMusics() {
		return this.tbDemandProgramMusics;
	}

	public void setTbDemandProgramMusics(Set<TbDemandProgramMusic> tbDemandProgramMusics) {
		this.tbDemandProgramMusics = tbDemandProgramMusics;
	}

}
