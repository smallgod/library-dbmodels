package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TbCategoryTree generated by hbm2java
 */
@Entity
@Table(name = "tb_category_tree", catalog = "gnamp_v4")
public class TbCategoryTree implements java.io.Serializable {

	private TbCategoryTreeId id;
	private TbCustomer tbCustomer;

	public TbCategoryTree() {
	}

	public TbCategoryTree(TbCategoryTreeId id, TbCustomer tbCustomer) {
		this.id = id;
		this.tbCustomer = tbCustomer;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "catId", column = @Column(name = "CAT_ID", nullable = false)),
			@AttributeOverride(name = "parentId", column = @Column(name = "PARENT_ID", nullable = false)) })
	public TbCategoryTreeId getId() {
		return this.id;
	}

	public void setId(TbCategoryTreeId id) {
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

}
