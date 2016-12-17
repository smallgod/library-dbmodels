package com.library.datamodel.dsmbridge;

// default package
// Generated Dec 7, 2016 4:56:51 PM by Hibernate Tools 5.2.0.Beta1

/**
 * TbSourceId generated by hbm2java
 */
public class TbSourceId implements java.io.Serializable {

	private int cstmId;
	private int sourceId;

	public TbSourceId() {
	}

	public TbSourceId(int cstmId, int sourceId) {
		this.cstmId = cstmId;
		this.sourceId = sourceId;
	}

	public int getCstmId() {
		return this.cstmId;
	}

	public void setCstmId(int cstmId) {
		this.cstmId = cstmId;
	}

	public int getSourceId() {
		return this.sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbSourceId))
			return false;
		TbSourceId castOther = (TbSourceId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getSourceId() == castOther.getSourceId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + this.getSourceId();
		return result;
	}

}
