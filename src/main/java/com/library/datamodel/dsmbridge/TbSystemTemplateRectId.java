package com.library.datamodel.dsmbridge;

// default package
// Generated Dec 7, 2016 4:56:51 PM by Hibernate Tools 5.2.0.Beta1

/**
 * TbSystemTemplateRectId generated by hbm2java
 */
public class TbSystemTemplateRectId implements java.io.Serializable {

	private int tmpltId;
	private int rectId;

	public TbSystemTemplateRectId() {
	}

	public TbSystemTemplateRectId(int tmpltId, int rectId) {
		this.tmpltId = tmpltId;
		this.rectId = rectId;
	}

	public int getTmpltId() {
		return this.tmpltId;
	}

	public void setTmpltId(int tmpltId) {
		this.tmpltId = tmpltId;
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
		if (!(other instanceof TbSystemTemplateRectId))
			return false;
		TbSystemTemplateRectId castOther = (TbSystemTemplateRectId) other;

		return (this.getTmpltId() == castOther.getTmpltId()) && (this.getRectId() == castOther.getRectId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTmpltId();
		result = 37 * result + this.getRectId();
		return result;
	}

}
