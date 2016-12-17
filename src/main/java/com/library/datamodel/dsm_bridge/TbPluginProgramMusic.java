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
 * TbPluginProgramMusic generated by hbm2java
 */
@Entity
@Table(name = "tb_plugin_program_music", catalog = "gnamp_v4")
public class TbPluginProgramMusic implements java.io.Serializable {

	private TbPluginProgramMusicId id;
	private TbPluginProgram tbPluginProgram;
	private int seq;
	private long fileId;

	public TbPluginProgramMusic() {
	}

	public TbPluginProgramMusic(TbPluginProgramMusicId id, TbPluginProgram tbPluginProgram, int seq, long fileId) {
		this.id = id;
		this.tbPluginProgram = tbPluginProgram;
		this.seq = seq;
		this.fileId = fileId;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "taskId", column = @Column(name = "TASK_ID", nullable = false)),
			@AttributeOverride(name = "prgmId", column = @Column(name = "PRGM_ID", nullable = false)),
			@AttributeOverride(name = "musicId", column = @Column(name = "MUSIC_ID", nullable = false)) })
	public TbPluginProgramMusicId getId() {
		return this.id;
	}

	public void setId(TbPluginProgramMusicId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "CSTM_ID", referencedColumnName = "CSTM_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "PRGM_ID", referencedColumnName = "PRGM_ID", nullable = false, insertable = false, updatable = false) })
	public TbPluginProgram getTbPluginProgram() {
		return this.tbPluginProgram;
	}

	public void setTbPluginProgram(TbPluginProgram tbPluginProgram) {
		this.tbPluginProgram = tbPluginProgram;
	}

	@Column(name = "SEQ", nullable = false)
	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	@Column(name = "FILE_ID", nullable = false)
	public long getFileId() {
		return this.fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
	}

}
