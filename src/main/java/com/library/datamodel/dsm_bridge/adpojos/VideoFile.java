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
public class VideoFile {

    private String fileName;
    private long path;
    private String position;
    private int sequence;
    private int showTime;
    private String unRotateBoolean;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public String getUnRotateBoolean() {
        return unRotateBoolean;
    }

    public void setUnRotateBoolean(String unRotateBoolean) {
        this.unRotateBoolean = unRotateBoolean;
    }

}
