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
 * TbStrategyProgram generated by hbm2java
 */
@Entity
@Table(name = "tb_strategy_program")
public class TbStrategyProgram implements java.io.Serializable {

	private TbStrategyProgramId id;
	private TbLoopProgram tbLoopProgram;
	private TbStrategy tbStrategy;
	private int seq;
	private int playCount;

	public TbStrategyProgram() {
	}

	public TbStrategyProgram(TbStrategyProgramId id, TbLoopProgram tbLoopProgram, TbStrategy tbStrategy, int seq,
			int playCount) {
		this.id = id;
		this.tbLoopProgram = tbLoopProgram;
		this.tbStrategy = tbStrategy;
		this.seq = seq;
		this.playCount = playCount;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "taskId", column = @Column(name = "TASK_ID", nullable = false)),
			@AttributeOverride(name = "strategyId", column = @Column(name = "STRATEGY_ID", nullable = false)),
			@AttributeOverride(name = "serialId", column = @Column(name = "SERIAL_ID", nullable = false)) })
	public TbStrategyProgramId getId() {
		return this.id;
	}

	public void setId(TbStrategyProgramId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "PRGM_ID", referencedColumnName = "PRGM_ID", nullable = false, insertable = false, updatable = false) })
	public TbLoopProgram getTbLoopProgram() {
		return this.tbLoopProgram;
	}

	public void setTbLoopProgram(TbLoopProgram tbLoopProgram) {
		this.tbLoopProgram = tbLoopProgram;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "STRATEGY_ID", referencedColumnName = "STRATEGY_ID", nullable = false, insertable = false, updatable = false) })
	public TbStrategy getTbStrategy() {
		return this.tbStrategy;
	}

	public void setTbStrategy(TbStrategy tbStrategy) {
		this.tbStrategy = tbStrategy;
	}

	@Column(name = "SEQ", nullable = false)
	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Column(name = "PLAY_COUNT", nullable = false)
	public int getPlayCount() {
		return this.playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

}
