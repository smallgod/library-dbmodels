package com.library.datamodel.dsmbridge;

// default package
// Generated Dec 7, 2016 4:56:51 PM by Hibernate Tools 5.2.0.Beta1

/**
 * TbStrategyProgram generated by hbm2java
 */
public class TbStrategyProgram implements java.io.Serializable {

	private TbStrategyProgramId id;
	private TbLoopProgram tbLoopProgram;
	private TbStrategy tbStrategy;
	private int seq;
	private int playCount;

	public TbStrategyProgram() {
	}

	public TbStrategyProgram(TbStrategyProgramId id, TbLoopProgram tbLoopProgram, TbStrategy tbStrategy, int seq,
			int playCount) {
		this.id = id;
		this.tbLoopProgram = tbLoopProgram;
		this.tbStrategy = tbStrategy;
		this.seq = seq;
		this.playCount = playCount;
	}

	public TbStrategyProgramId getId() {
		return this.id;
	}

	public void setId(TbStrategyProgramId id) {
		this.id = id;
	}

	public TbLoopProgram getTbLoopProgram() {
		return this.tbLoopProgram;
	}

	public void setTbLoopProgram(TbLoopProgram tbLoopProgram) {
		this.tbLoopProgram = tbLoopProgram;
	}

	public TbStrategy getTbStrategy() {
		return this.tbStrategy;
	}

	public void setTbStrategy(TbStrategy tbStrategy) {
		this.tbStrategy = tbStrategy;
	}

	public int getSeq() {
		return this.seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getPlayCount() {
		return this.playCount;
	}

	public void setPlayCount(int playCount) {
		this.playCount = playCount;
	}

}
