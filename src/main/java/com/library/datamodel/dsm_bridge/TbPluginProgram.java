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
 * TbPluginProgram generated by hbm2java
 */
@Entity
@Table(name = "tb_plugin_program")
public class TbPluginProgram implements java.io.Serializable {

	private TbPluginProgramId id;
	private TbPluginRect tbPluginRect;
	private TbPluginTask tbPluginTask;
	private String descp;
	private String name;
	private int seq;
	private int width;
	private int height;
	private int state;
	private Date createTime;
	private String createUser;
	private Set<TbPluginRect> tbPluginRects = new HashSet<TbPluginRect>(0);
	private Set<TbPluginProgramMusic> tbPluginProgramMusics = new HashSet<TbPluginProgramMusic>(0);

	public TbPluginProgram() {
	}

	public TbPluginProgram(TbPluginProgramId id, TbPluginRect tbPluginRect, TbPluginTask tbPluginTask, String descp,
			String name, int seq, int width, int height, int state, Date createTime, String createUser) {
		this.id = id;
		this.tbPluginRect = tbPluginRect;
		this.tbPluginTask = tbPluginTask;
		this.descp = descp;
		this.name = name;
		this.seq = seq;
		this.width = width;
		this.height = height;
		this.state = state;
		this.createTime = createTime;
		this.createUser = createUser;
	}

	public TbPluginProgram(TbPluginProgramId id, TbPluginRect tbPluginRect, TbPluginTask tbPluginTask, String descp,
			String name, int seq, int width, int height, int state, Date createTime, String createUser,
			Set<TbPluginRect> tbPluginRects, Set<TbPluginProgramMusic> tbPluginProgramMusics) {
		this.id = id;
		this.tbPluginRect = tbPluginRect;
		this.tbPluginTask = tbPluginTask;
		this.descp = descp;
		this.name = name;
		this.seq = seq;
		this.width = width;
		this.height = height;
		this.state = state;
		this.createTime = createTime;
		this.createUser = createUser;
		this.tbPluginRects = tbPluginRects;
		this.tbPluginProgramMusics = tbPluginProgramMusics;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "taskId", column = @Column(name = "TASK_ID", nullable = false)),
			@AttributeOverride(name = "prgmId", column = @Column(name = "PRGM_ID", nullable = false)) })
	public TbPluginProgramId getId() {
		return this.id;
	}

	public void setId(TbPluginProgramId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "PRGM_ID", referencedColumnName = "PRGM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "MAIN_RECT", referencedColumnName = "RECT_ID", nullable = false, insertable = false, updatable = false) })
	public TbPluginRect getTbPluginRect() {
		return this.tbPluginRect;
	}

	public void setTbPluginRect(TbPluginRect tbPluginRect) {
		this.tbPluginRect = tbPluginRect;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false) })
	public TbPluginTask getTbPluginTask() {
		return this.tbPluginTask;
	}

	public void setTbPluginTask(TbPluginTask tbPluginTask) {
		this.tbPluginTask = tbPluginTask;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbPluginProgram")
	public Set<TbPluginRect> getTbPluginRects() {
		return this.tbPluginRects;
	}

	public void setTbPluginRects(Set<TbPluginRect> tbPluginRects) {
		this.tbPluginRects = tbPluginRects;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbPluginProgram")
	public Set<TbPluginProgramMusic> getTbPluginProgramMusics() {
		return this.tbPluginProgramMusics;
	}

	public void setTbPluginProgramMusics(Set<TbPluginProgramMusic> tbPluginProgramMusics) {
		this.tbPluginProgramMusics = tbPluginProgramMusics;
	}

}
