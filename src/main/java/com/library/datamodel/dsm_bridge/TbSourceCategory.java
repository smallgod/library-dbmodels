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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbSourceCategory generated by hbm2java
 */
@Entity
@Table(name = "tb_source_category", catalog = "gnamp_v4")
public class TbSourceCategory implements java.io.Serializable {

	private TbSourceCategoryId id;
	private TbCustomer tbCustomer;
	private TbSourceCategory tbSourceCategory;
	private String name;
	private String descp;
	private int depth;
	private int subNum;
	private Date createTime;
	private String createUser;
	private Set<TbSource> tbSources = new HashSet<TbSource>(0);
	private Set<TbSourceCategory> tbSourceCategories = new HashSet<TbSourceCategory>(0);

	public TbSourceCategory() {
	}

	public TbSourceCategory(TbSourceCategoryId id, TbCustomer tbCustomer, TbSourceCategory tbSourceCategory,
			String name, String descp, int depth, int subNum, Date createTime, String createUser) {
		this.id = id;
		this.tbCustomer = tbCustomer;
		this.tbSourceCategory = tbSourceCategory;
		this.name = name;
		this.descp = descp;
		this.depth = depth;
		this.subNum = subNum;
		this.createTime = createTime;
		this.createUser = createUser;
	}

	public TbSourceCategory(TbSourceCategoryId id, TbCustomer tbCustomer, TbSourceCategory tbSourceCategory,
			String name, String descp, int depth, int subNum, Date createTime, String createUser,
			Set<TbSource> tbSources, Set<TbSourceCategory> tbSourceCategories) {
		this.id = id;
		this.tbCustomer = tbCustomer;
		this.tbSourceCategory = tbSourceCategory;
		this.name = name;
		this.descp = descp;
		this.depth = depth;
		this.subNum = subNum;
		this.createTime = createTime;
		this.createUser = createUser;
		this.tbSources = tbSources;
		this.tbSourceCategories = tbSourceCategories;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "catId", column = @Column(name = "CAT_ID", nullable = false)) })
	public TbSourceCategoryId getId() {
		return this.id;
	}

	public void setId(TbSourceCategoryId id) {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "PARENT_ID", referencedColumnName = "CAT_ID", nullable = false, insertable = false, updatable = false) })
	public TbSourceCategory getTbSourceCategory() {
		return this.tbSourceCategory;
	}

	public void setTbSourceCategory(TbSourceCategory tbSourceCategory) {
		this.tbSourceCategory = tbSourceCategory;
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

	@Column(name = "DEPTH", nullable = false)
	public int getDepth() {
		return this.depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Column(name = "SUB_NUM", nullable = false)
	public int getSubNum() {
		return this.subNum;
	}

	public void setSubNum(int subNum) {
		this.subNum = subNum;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbSourceCategory")
	public Set<TbSource> getTbSources() {
		return this.tbSources;
	}

	public void setTbSources(Set<TbSource> tbSources) {
		this.tbSources = tbSources;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tbSourceCategory")
	public Set<TbSourceCategory> getTbSourceCategories() {
		return this.tbSourceCategories;
	}

	public void setTbSourceCategories(Set<TbSourceCategory> tbSourceCategories) {
		this.tbSourceCategories = tbSourceCategories;
	}

}
