/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.dsm_bridge.adpojos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smallgod
 */
public class MetaFileWrapper {

    private List<MetaFile> metaFileList;
    private long lastFileId;

    public List<MetaFile> getMetaFileList() {

        if (metaFileList == null) {
            metaFileList = new ArrayList<>();
        }
        return this.metaFileList;
    }

    public long getLastFileId() {
        return lastFileId;
    }

    public void setLastFileId(long lastFileId) {
        this.lastFileId = lastFileId;
    }
}
