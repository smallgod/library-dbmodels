/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.dsm_bridge.adpojos;

/**
 *
 * @author smallgod
 */
public class AdFile {

    private int fileSize;
    private long fileName;
    private long crc;

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public long getFileName() {
        return fileName;
    }

    public void setFileName(long fileName) {
        this.fileName = fileName;
    }

    public long getCrc() {
        return crc;
    }

    public void setCrc(long crc) {
        this.crc = crc;
    }

}
