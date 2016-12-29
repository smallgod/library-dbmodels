package com.library.datamodel.dsm_bridge;
// default package
// Generated Dec 17, 2016 3:56:53 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VwPluginFile generated by hbm2java
 */
@Entity
@Table(name = "vw_plugin_file")
public class VwPluginFile implements java.io.Serializable {

	private VwPluginFileId id;

	public VwPluginFile() {
	}

	public VwPluginFile(VwPluginFileId id) {
		this.id = id;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "cstmId", column = @Column(name = "CSTM_ID", nullable = false)),
			@AttributeOverride(name = "taskId", column = @Column(name = "TASK_ID", nullable = false)),
			@AttributeOverride(name = "fileId", column = @Column(name = "FILE_ID")) })
	public VwPluginFileId getId() {
		return this.id;
	}

	public void setId(VwPluginFileId id) {
		this.id = id;
	}

}