package com.library.datamodel.dsmbridge;

// default package
// Generated Dec 7, 2016 4:56:51 PM by Hibernate Tools 5.2.0.Beta1

/**
 * TbCombinFile generated by hbm2java
 */
public class TbCombinFile implements java.io.Serializable {

	private TbCombinFileId id;
	private String name;
	private String descp;
	private int type;
	private long size;
	private long sum;

	public TbCombinFile() {
	}

	public TbCombinFile(TbCombinFileId id, String name, String descp, int type, long size, long sum) {
		this.id = id;
		this.name = name;
		this.descp = descp;
		this.type = type;
		this.size = size;
		this.sum = sum;
	}

	public TbCombinFileId getId() {
		return this.id;
	}

	public void setId(TbCombinFileId id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescp() {
		return this.descp;
	}

	public void setDescp(String descp) {
		this.descp = descp;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public long getSize() {
		return this.size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public long getSum() {
		return this.sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

}
