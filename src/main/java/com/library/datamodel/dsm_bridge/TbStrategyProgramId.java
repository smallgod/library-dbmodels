package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbStrategyProgramId generated by hbm2java
 */
@Embeddable
public class TbStrategyProgramId implements java.io.Serializable {

	private int cstmId;
	private int taskId;
	private int strategyId;
	private int serialId;

	public TbStrategyProgramId() {
	}

	public TbStrategyProgramId(int cstmId, int taskId, int strategyId, int serialId) {
		this.cstmId = cstmId;
		this.taskId = taskId;
		this.strategyId = strategyId;
		this.serialId = serialId;
	}

	@Column(name = "CSTM_ID", nullable = false)
	public int getCstmId() {
		return this.cstmId;
	}

	public void setCstmId(int cstmId) {
		this.cstmId = cstmId;
	}

	@Column(name = "TASK_ID", nullable = false)
	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@Column(name = "STRATEGY_ID", nullable = false)
	public int getStrategyId() {
		return this.strategyId;
	}

	public void setStrategyId(int strategyId) {
		this.strategyId = strategyId;
	}

	@Column(name = "SERIAL_ID", nullable = false)
	public int getSerialId() {
		return this.serialId;
	}

	public void setSerialId(int serialId) {
		this.serialId = serialId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbStrategyProgramId))
			return false;
		TbStrategyProgramId castOther = (TbStrategyProgramId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getTaskId() == castOther.getTaskId())
				&& (this.getStrategyId() == castOther.getStrategyId())
				&& (this.getSerialId() == castOther.getSerialId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + this.getTaskId();
		result = 37 * result + this.getStrategyId();
		result = 37 * result + this.getSerialId();
		return result;
	}

}