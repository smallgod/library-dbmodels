package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TbLoopSource generated by hbm2java
 */
@Entity
@Table(name = "tb_loop_source")
public class TbLoopSource implements java.io.Serializable {

	private TbLoopSourceId id;
	private TbLoopTask tbLoopTask;

	public TbLoopSource() {
	}

	public TbLoopSource(TbLoopSourceId id, TbLoopTask tbLoopTask) {
		this.id = id;
		this.tbLoopTask = tbLoopTask;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "taskId", column = @Column(name = "TASK_ID", nullable = false)),
			@AttributeOverride(name = "sourceId", column = @Column(name = "SOURCE_ID", nullable = false)),
			@AttributeOverride(name = "origin", column = @Column(name = "ORIGIN", nullable = false)) })
	public TbLoopSourceId getId() {
		return this.id;
	}

	public void setId(TbLoopSourceId id) {
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

}