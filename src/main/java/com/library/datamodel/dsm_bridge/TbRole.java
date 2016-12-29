package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbRole generated by hbm2java
 */
@Entity
@Table(name = "tb_role")
public class TbRole implements java.io.Serializable {

	private TbRoleId id;
	private TbCustomer tbCustomer;
	private String name;
	private String descp;
	private Date createTime;
	private String createUser;
	private Set<TbUser> tbUsers = new HashSet<TbUser>(0);
	private Set<TbPrivilege> tbPrivileges = new HashSet<TbPrivilege>(0);

	public TbRole() {
	}

	public TbRole(TbRoleId id, TbCustomer tbCustomer, String name, String descp, Date createTime, String createUser) {
		this.id = id;
		this.tbCustomer = tbCustomer;
		this.name = name;
		this.descp = descp;
		this.createTime = createTime;
		this.createUser = createUser;
	}

	public TbRole(TbRoleId id, TbCustomer tbCustomer, String name, String descp, Date createTime, String createUser,
			Set<TbUser> tbUsers, Set<TbPrivilege> tbPrivileges) {
		this.id = id;
		this.tbCustomer = tbCustomer;
		this.name = name;
		this.descp = descp;
		this.createTime = createTime;
		this.createUser = createUser;
		this.tbUsers = tbUsers;
		this.tbPrivileges = tbPrivileges;
	}

	@EmbeddedId

	@AttributeOverrides({ 
			@AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false)) })
	public TbRoleId getId() {
		return this.id;
	}

	public void setId(TbRoleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CSTM_ID", nullable = false, insertable = false, updatable = false)
	public TbCustomer getTbCustomer() {
		return this.tbCustomer;
	}

	public void setTbCustomer(TbCustomer tbCustomer) {
		this.tbCustomer = tbCustomer;
	}

	@Column(name = "NAME", nullable = false, length = 64)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCP", nullable = false, length = 256)
	public String getDescp() {
		return this.descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_TIME", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CREATE_USER", nullable = false, length = 64)
	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	public Set<TbUser> getTbUsers() {
		return this.tbUsers;
	}

	public void setTbUsers(Set<TbUser> tbUsers) {
		this.tbUsers = tbUsers;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_role_privilege", joinColumns = {
			@JoinColumn(name = "CSTM_ID", nullable = false, updatable = false),
			@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "PRIVILEGE_ID", nullable = false, updatable = false) })
	public Set<TbPrivilege> getTbPrivileges() {
		return this.tbPrivileges;
	}

	public void setTbPrivileges(Set<TbPrivilege> tbPrivileges) {
		this.tbPrivileges = tbPrivileges;
	}

}