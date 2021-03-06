package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbCombinFileId generated by hbm2java
 */
@Embeddable
public class TbCombinFileId implements java.io.Serializable {

	private int cstmId;
	private long fileId;
	private long segmentId;

	public TbCombinFileId() {
	}

	public TbCombinFileId(int cstmId, long fileId, long segmentId) {
		this.cstmId = cstmId;
		this.fileId = fileId;
		this.segmentId = segmentId;
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

	@Column(name = "SEGMENT_ID", nullable = false)
	public long getSegmentId() {
		return this.segmentId;
	}

	public void setSegmentId(long segmentId) {
		this.segmentId = segmentId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbCombinFileId))
			return false;
		TbCombinFileId castOther = (TbCombinFileId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getFileId() == castOther.getFileId())
				&& (this.getSegmentId() == castOther.getSegmentId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + (int) this.getFileId();
		result = 37 * result + (int) this.getSegmentId();
		return result;
	}

}
