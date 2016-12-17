package com.library.datamodel.dsmbridge;

// default package
// Generated Dec 7, 2016 4:56:51 PM by Hibernate Tools 5.2.0.Beta1

/**
 * TbLoopRectContent generated by hbm2java
 */
public class TbLoopRectContent implements java.io.Serializable {

	private TbLoopRectContentId id;
	private TbLoopRect tbLoopRect;
	private int contentType;
	private int seq;
	private Long fileId;
	private String detail;

	public TbLoopRectContent() {
	}

	public TbLoopRectContent(TbLoopRectContentId id, TbLoopRect tbLoopRect, int contentType, int seq) {
		this.id = id;
		this.tbLoopRect = tbLoopRect;
		this.contentType = contentType;
		this.seq = seq;
	}

	public TbLoopRectContent(TbLoopRectContentId id, TbLoopRect tbLoopRect, int contentType, int seq, Long fileId,
			String detail) {
		this.id = id;
		this.tbLoopRect = tbLoopRect;
		this.contentType = contentType;
		this.seq = seq;
		this.fileId = fileId;
		this.detail = detail;
	}

	public TbLoopRectContentId getId() {
		return this.id;
	}

	public void setId(TbLoopRectContentId id) {
		this.id = id;
	}

	public TbLoopRect getTbLoopRect() {
		return this.tbLoopRect;
	}

	public void setTbLoopRect(TbLoopRect tbLoopRect) {
		this.tbLoopRect = tbLoopRect;
	}

	public int getContentType() {
		return this.contentType;
	}

	public void setContentType(int contentType) {
		this.contentType = contentType;
	}

	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Long getFileId() {
		return this.fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
