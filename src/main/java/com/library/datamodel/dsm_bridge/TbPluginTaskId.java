package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbPluginTaskId generated by hbm2java
 */
@Embeddable
public class TbPluginTaskId implements java.io.Serializable {

	private int cstmId;
	private int taskId;

	public TbPluginTaskId() {
	}

	public TbPluginTaskId(int cstmId, int taskId) {
		this.cstmId = cstmId;
		this.taskId = taskId;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbPluginTaskId))
			return false;
		TbPluginTaskId castOther = (TbPluginTaskId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getTaskId() == castOther.getTaskId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + this.getTaskId();
		return result;
	}

}
