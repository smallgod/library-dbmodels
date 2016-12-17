package com.library.datamodel.dsmbridge;

// default package
// Generated Dec 7, 2016 4:56:51 PM by Hibernate Tools 5.2.0.Beta1

/**
 * TbPluginRectId generated by hbm2java
 */
public class TbPluginRectId implements java.io.Serializable {

	private int cstmId;
	private int taskId;
	private int prgmId;
	private int rectId;

	public TbPluginRectId() {
	}

	public TbPluginRectId(int cstmId, int taskId, int prgmId, int rectId) {
		this.cstmId = cstmId;
		this.taskId = taskId;
		this.prgmId = prgmId;
		this.rectId = rectId;
	}

	public int getCstmId() {
		return this.cstmId;
	}

	public void setCstmId(int cstmId) {
		this.cstmId = cstmId;
	}

	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getPrgmId() {
		return this.prgmId;
	}

	public void setPrgmId(int prgmId) {
		this.prgmId = prgmId;
	}

	public int getRectId() {
		return this.rectId;
	}

	public void setRectId(int rectId) {
		this.rectId = rectId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbPluginRectId))
			return false;
		TbPluginRectId castOther = (TbPluginRectId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getTaskId() == castOther.getTaskId())
				&& (this.getPrgmId() == castOther.getPrgmId()) && (this.getRectId() == castOther.getRectId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + this.getTaskId();
		result = 37 * result + this.getPrgmId();
		result = 37 * result + this.getRectId();
		return result;
	}

}
