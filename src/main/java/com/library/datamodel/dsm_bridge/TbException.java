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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TbException generated by hbm2java
 */
@Entity
@Table(name = "tb_exception")
public class TbException implements java.io.Serializable {

	private TbExceptionId id;
	private TbTerminal tbTerminal;

	public TbException() {
	}

	public TbException(TbExceptionId id, TbTerminal tbTerminal) {
		this.id = id;
		this.tbTerminal = tbTerminal;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "devId", column = @Column(name = "DEV_ID", nullable = false)),
			@AttributeOverride(name = "dateTime", column = @Column(name = "DATE_TIME", nullable = false, length = 19)),
			@AttributeOverride(name = "exception", column = @Column(name = "EXCEPTION", nullable = false)),
			@AttributeOverride(name = "extInt", column = @Column(name = "EXT_INT", nullable = false)),
			@AttributeOverride(name = "extString", column = @Column(name = "EXT_STRING", nullable = false, length = 256)) })
	public TbExceptionId getId() {
		return this.id;
	}

	public void setId(TbExceptionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "DEV_ID", referencedColumnName = "DEV_ID", nullable = false, insertable = false, updatable = false) })
	public TbTerminal getTbTerminal() {
		return this.tbTerminal;
	}

	public void setTbTerminal(TbTerminal tbTerminal) {
		this.tbTerminal = tbTerminal;
	}

}
