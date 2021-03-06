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
 * TbSystemTemplateRectImage generated by hbm2java
 */
@Entity
@Table(name = "tb_system_template_rect_image")
public class TbSystemTemplateRectImage implements java.io.Serializable {

	private TbSystemTemplateRectImageId id;
	private TbSystemFile tbSystemFile;
	private TbSystemTemplateRect tbSystemTemplateRect;
	private int seq;
	private int playTime;
	private int swapStyle;
	private int swapTime;
	private int scaleStyle;

	public TbSystemTemplateRectImage() {
	}

	public TbSystemTemplateRectImage(TbSystemTemplateRectImageId id, TbSystemFile tbSystemFile,
			TbSystemTemplateRect tbSystemTemplateRect, int seq, int playTime, int swapStyle, int swapTime,
			int scaleStyle) {
		this.id = id;
		this.tbSystemFile = tbSystemFile;
		this.tbSystemTemplateRect = tbSystemTemplateRect;
		this.seq = seq;
		this.playTime = playTime;
		this.swapStyle = swapStyle;
		this.swapTime = swapTime;
		this.scaleStyle = scaleStyle;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "tmpltId", column = @Column(name = "TMPLT_ID", nullable = false)),
			@AttributeOverride(name = "rectId", column = @Column(name = "RECT_ID", nullable = false)),
			@AttributeOverride(name = "imageId", column = @Column(name = "IMAGE_ID", nullable = false)) })
	public TbSystemTemplateRectImageId getId() {
		return this.id;
	}

	public void setId(TbSystemTemplateRectImageId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILE_ID", nullable = false)
	public TbSystemFile getTbSystemFile() {
		return this.tbSystemFile;
	}

	public void setTbSystemFile(TbSystemFile tbSystemFile) {
		this.tbSystemFile = tbSystemFile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "TMPLT_ID", referencedColumnName = "TMPLT_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "RECT_ID", referencedColumnName = "RECT_ID", nullable = false, insertable = false, updatable = false) })
	public TbSystemTemplateRect getTbSystemTemplateRect() {
		return this.tbSystemTemplateRect;
	}

	public void setTbSystemTemplateRect(TbSystemTemplateRect tbSystemTemplateRect) {
		this.tbSystemTemplateRect = tbSystemTemplateRect;
	}

	@Column(name = "SEQ", nullable = false)
	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Column(name = "PLAY_TIME", nullable = false)
	public int getPlayTime() {
		return this.playTime;
	}

	public void setPlayTime(int playTime) {
		this.playTime = playTime;
	}

	@Column(name = "SWAP_STYLE", nullable = false)
	public int getSwapStyle() {
		return this.swapStyle;
	}

	public void setSwapStyle(int swapStyle) {
		this.swapStyle = swapStyle;
	}

	@Column(name = "SWAP_TIME", nullable = false)
	public int getSwapTime() {
		return this.swapTime;
	}

	public void setSwapTime(int swapTime) {
		this.swapTime = swapTime;
	}

	@Column(name = "SCALE_STYLE", nullable = false)
	public int getScaleStyle() {
		return this.scaleStyle;
	}

	public void setScaleStyle(int scaleStyle) {
		this.scaleStyle = scaleStyle;
	}

}
