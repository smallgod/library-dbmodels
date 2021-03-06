package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbFileId generated by hbm2java
 */
@Embeddable
public class TbFileId implements java.io.Serializable {

	private int cstmId;
	private long fileId;

	public TbFileId() {
	}

	public TbFileId(int cstmId, long fileId) {
		this.cstmId = cstmId;
		this.fileId = fileId;
	}

	@Column(name = "CSTM_ID", nullable = false)
	public int getCstmId() {
		return this.cstmId;
	}

	public void setCstmId(int cstmId) {
		this.cstmId = cstmId;
	}

	@Column(name = "FILE_ID", nullable = false)
	public long getFileId() {
		return this.fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbFileId))
			return false;
		TbFileId castOther = (TbFileId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getFileId() == castOther.getFileId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + (int) this.getFileId();
		return result;
	}

}
