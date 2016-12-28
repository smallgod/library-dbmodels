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
public class AudioFile {

    private String fileName;
    private long path;
    private int sequence;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getPath() {
        return path;
    }

    public void setPath(long path) {
        this.path = path;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

}
