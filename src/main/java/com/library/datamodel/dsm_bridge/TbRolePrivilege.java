package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:58:36 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TbRolePrivilege generated by hbm2java
 */
@Entity
@Table(name = "tb_role_privilege")
public class TbRolePrivilege implements java.io.Serializable {

	private TbRolePrivilegeId id;

	public TbRolePrivilege() {
	}

	public TbRolePrivilege(TbRolePrivilegeId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ 
			@AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false)),
			@AttributeOverride(name = "privilegeId", column = @Column(name = "PRIVILEGE_ID", nullable = false)) })
	public TbRolePrivilegeId getId() {
		return this.id;
	}

	public void setId(TbRolePrivilegeId id) {
		this.id = id;
	}

}