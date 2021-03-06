package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbTemplateRectId generated by hbm2java
 */
@Embeddable
public class TbTemplateRectId implements java.io.Serializable {

	private int cstmId;
	private int tmpltId;
	private int rectId;

	public TbTemplateRectId() {
	}

	public TbTemplateRectId(int cstmId, int tmpltId, int rectId) {
		this.cstmId = cstmId;
		this.tmpltId = tmpltId;
		this.rectId = rectId;
	}

	@Column(name = "CSTM_ID", nullable = false)
	public int getCstmId() {
		return this.cstmId;
	}

	public void setCstmId(int cstmId) {
		this.cstmId = cstmId;
	}

	@Column(name = "TMPLT_ID", nullable = false)
	public int getTmpltId() {
		return this.tmpltId;
	}

	public void setTmpltId(int tmpltId) {
		this.tmpltId = tmpltId;
	}

	@Column(name = "RECT_ID", nullable = false)
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
		if (!(other instanceof TbTemplateRectId))
			return false;
		TbTemplateRectId castOther = (TbTemplateRectId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getTmpltId() == castOther.getTmpltId())
				&& (this.getRectId() == castOther.getRectId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + this.getTmpltId();
		result = 37 * result + this.getRectId();
		return result;
	}

}
