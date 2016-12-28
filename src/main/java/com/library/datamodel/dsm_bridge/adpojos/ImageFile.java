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
public class ImageFile {

    private String cutIn;
    private String name;
    private Long path;
    private String position;
    private int effectTime;
    private String scroll;
    private int sequence;
    private int showTime;
    private String swap;

    public String getCutIn() {
        return cutIn;
    }

    public void setCutIn(String cutIn) {
        this.cutIn = cutIn;
    }

    public int getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(int effectTime) {
        this.effectTime = effectTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPath() {
        return path;
    }

    public void setPath(Long path) {
        this.path = path;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getScroll() {
        return scroll;
    }

    public void setScroll(String scroll) {
        this.scroll = scroll;
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

    public String getSwap() {
        return swap;
    }

    public void setSwap(String swap) {
        this.swap = swap;
    }

}
