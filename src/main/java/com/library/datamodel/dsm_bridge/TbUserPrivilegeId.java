package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:58:36 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbUserPrivilegeId generated by hbm2java
 */
@Embeddable
public class TbUserPrivilegeId implements java.io.Serializable {

	private int cstmId;
	private int userId;
	private int privilegeId;

	public TbUserPrivilegeId() {
	}

	public TbUserPrivilegeId(int cstmId, int userId, int privilegeId) {
		this.cstmId = cstmId;
		this.userId = userId;
		this.privilegeId = privilegeId;
	}

	@Column(name = "CSTM_ID", nullable = false)
	public int getCstmId() {
		return this.cstmId;
	}

	public void setCstmId(int cstmId) {
		this.cstmId = cstmId;
	}

	@Column(name = "USER_ID", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "PRIVILEGE_ID", nullable = false)
	public int getPrivilegeId() {
		return this.privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbUserPrivilegeId))
			return false;
		TbUserPrivilegeId castOther = (TbUserPrivilegeId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getUserId() == castOther.getUserId())
				&& (this.getPrivilegeId() == castOther.getPrivilegeId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + this.getUserId();
		result = 37 * result + this.getPrivilegeId();
		return result;
	}

}
