package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbDemandRectContentId generated by hbm2java
 */
@Embeddable
public class TbDemandRectContentId implements java.io.Serializable {

	private int cstmId;
	private int taskId;
	private int prgmId;
	private int rectId;
	private int contentId;

	public TbDemandRectContentId() {
	}

	public TbDemandRectContentId(int cstmId, int taskId, int prgmId, int rectId, int contentId) {
		this.cstmId = cstmId;
		this.taskId = taskId;
		this.prgmId = prgmId;
		this.rectId = rectId;
		this.contentId = contentId;
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

	@Column(name = "PRGM_ID", nullable = false)
	public int getPrgmId() {
		return this.prgmId;
	}

	public void setPrgmId(int prgmId) {
		this.prgmId = prgmId;
	}

	@Column(name = "RECT_ID", nullable = false)
	public int getRectId() {
		return this.rectId;
	}

	public void setRectId(int rectId) {
		this.rectId = rectId;
	}

	@Column(name = "CONTENT_ID", nullable = false)
	public int getContentId() {
		return this.contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbDemandRectContentId))
			return false;
		TbDemandRectContentId castOther = (TbDemandRectContentId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getTaskId() == castOther.getTaskId())
				&& (this.getPrgmId() == castOther.getPrgmId()) && (this.getRectId() == castOther.getRectId())
				&& (this.getContentId() == castOther.getContentId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + this.getTaskId();
		result = 37 * result + this.getPrgmId();
		result = 37 * result + this.getRectId();
		result = 37 * result + this.getContentId();
		return result;
	}

}
