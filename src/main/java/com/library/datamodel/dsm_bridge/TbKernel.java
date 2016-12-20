package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbKernel generated by hbm2java
 */
@Entity
@Table(name = "tb_kernel")
public class TbKernel implements java.io.Serializable {

	private String version;
	private String name;
	private String descp;
	private int size;
	private long sum;
	private Date importTime;
	private String importUser;
	private Set<TbTerminal> tbTerminals = new HashSet<TbTerminal>(0);

	public TbKernel() {
	}

	public TbKernel(String version, String name, String descp, int size, long sum, Date importTime, String importUser) {
		this.version = version;
		this.name = name;
		this.descp = descp;
		this.size = size;
		this.sum = sum;
		this.importTime = importTime;
		this.importUser = importUser;
	}

	public TbKernel(String version, String name, String descp, int size, long sum, Date importTime, String importUser,
			Set<TbTerminal> tbTerminals) {
		this.version = version;
		this.name = name;
		this.descp = descp;
		this.size = size;
		this.sum = sum;
		this.importTime = importTime;
		this.importUser = importUser;
		this.tbTerminals = tbTerminals;
	}

	@Id

	@Column(name = "VERSION", unique = true, nullable = false, length = 64)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	@Column(name = "SIZE", nullable = false)
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Column(name = "SUM", nullable = false)
	public long getSum() {
		return this.sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IMPORT_TIME", nullable = false, length = 19)
	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	@Column(name = "IMPORT_USER", nullable = false, length = 64)
	public String getImportUser() {
		return this.importUser;
	}

	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbKernel")
	public Set<TbTerminal> getTbTerminals() {
		return this.tbTerminals;
	}

	public void setTbTerminals(Set<TbTerminal> tbTerminals) {
		this.tbTerminals = tbTerminals;
	}

}
