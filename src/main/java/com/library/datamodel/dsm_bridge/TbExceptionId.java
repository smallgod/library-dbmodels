package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbExceptionId generated by hbm2java
 */
@Embeddable
public class TbExceptionId implements java.io.Serializable {

	private int cstmId;
	private long devId;
	private Date dateTime;
	private int exception;
	private int extInt;
	private String extString;

	public TbExceptionId() {
	}

	public TbExceptionId(int cstmId, long devId, Date dateTime, int exception, int extInt, String extString) {
		this.cstmId = cstmId;
		this.devId = devId;
		this.dateTime = dateTime;
		this.exception = exception;
		this.extInt = extInt;
		this.extString = extString;
	}

	@Column(name = "CSTM_ID", nullable = false)
	public int getCstmId() {
		return this.cstmId;
	}

	public void setCstmId(int cstmId) {
		this.cstmId = cstmId;
	}

	@Column(name = "DEV_ID", nullable = false)
	public long getDevId() {
		return this.devId;
	}

	public void setDevId(long devId) {
		this.devId = devId;
	}

	@Column(name = "DATE_TIME", nullable = false, length = 19)
	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "EXCEPTION", nullable = false)
	public int getException() {
		return this.exception;
	}

	public void setException(int exception) {
		this.exception = exception;
	}

	@Column(name = "EXT_INT", nullable = false)
	public int getExtInt() {
		return this.extInt;
	}

	public void setExtInt(int extInt) {
		this.extInt = extInt;
	}

	@Column(name = "EXT_STRING", nullable = false, length = 256)
	public String getExtString() {
		return this.extString;
	}

	public void setExtString(String extString) {
		this.extString = extString;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbExceptionId))
			return false;
		TbExceptionId castOther = (TbExceptionId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getDevId() == castOther.getDevId())
				&& ((this.getDateTime() == castOther.getDateTime()) || (this.getDateTime() != null
						&& castOther.getDateTime() != null && this.getDateTime().equals(castOther.getDateTime())))
				&& (this.getException() == castOther.getException()) && (this.getExtInt() == castOther.getExtInt())
				&& ((this.getExtString() == castOther.getExtString()) || (this.getExtString() != null
						&& castOther.getExtString() != null && this.getExtString().equals(castOther.getExtString())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + (int) this.getDevId();
		result = 37 * result + (getDateTime() == null ? 0 : this.getDateTime().hashCode());
		result = 37 * result + this.getException();
		result = 37 * result + this.getExtInt();
		result = 37 * result + (getExtString() == null ? 0 : this.getExtString().hashCode());
		return result;
	}

}
