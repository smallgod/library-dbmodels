package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbDemandProgramMusicId generated by hbm2java
 */
@Embeddable
public class TbDemandProgramMusicId implements java.io.Serializable {

	private int cstmId;
	private int taskId;
	private int prgmId;
	private int musicId;

	public TbDemandProgramMusicId() {
	}

	public TbDemandProgramMusicId(int cstmId, int taskId, int prgmId, int musicId) {
		this.cstmId = cstmId;
		this.taskId = taskId;
		this.prgmId = prgmId;
		this.musicId = musicId;
	}

	@Column(name = "CSTM_ID", nullable = false)
	public int getCstmId() {
		return this.cstmId;
	}

	public void setCstmId(int cstmId) {
		this.cstmId = cstmId;
	}

	@Column(name = "TASK_ID", nullable = false)
	public int getTaskId() {
		return this.taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	@Column(name = "PRGM_ID", nullable = false)
	public int getPrgmId() {
		return this.prgmId;
	}

	public void setPrgmId(int prgmId) {
		this.prgmId = prgmId;
	}

	@Column(name = "MUSIC_ID", nullable = false)
	public int getMusicId() {
		return this.musicId;
	}

	public void setMusicId(int musicId) {
		this.musicId = musicId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbDemandProgramMusicId))
			return false;
		TbDemandProgramMusicId castOther = (TbDemandProgramMusicId) other;

		return (this.getCstmId() == castOther.getCstmId()) && (this.getTaskId() == castOther.getTaskId())
				&& (this.getPrgmId() == castOther.getPrgmId()) && (this.getMusicId() == castOther.getMusicId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCstmId();
		result = 37 * result + this.getTaskId();
		result = 37 * result + this.getPrgmId();
		result = 37 * result + this.getMusicId();
		return result;
	}

}
