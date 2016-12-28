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
public class ImageRectValues {

    //<imagerect interactive="off" jump="0" layer="2" nH="930" nW="665" nX="1255" nY="0" rectid="1482242433" rectname="loop_prog1_image">
    private String interactive;
    private int rectId;
    private String rectName;
    private int jump;
    private int layer;
    private int nH;
    private int nW;
    private int nX;
    private int nY;

    public String getInteractive() {
        return interactive;
    }

    public void setInteractive(String interactive) {
        this.interactive = interactive;
    }

    public int getRectId() {
        return rectId;
    }

    public void setRectId(int rectId) {
        this.rectId = rectId;
    }

    public String getRectName() {
        return rectName;
    }

    public void setRectName(String rectName) {
        this.rectName = rectName;
    }

    public int getJump() {
        return jump;
    }

    public void setJump(int jump) {
        this.jump = jump;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public int getnH() {
        return nH;
    }

    public void setnH(int nH) {
        this.nH = nH;
    }

    public int getnW() {
        return nW;
    }

    public void setnW(int nW) {
        this.nW = nW;
    }

    public int getnX() {
        return nX;
    }

    public void setnX(int nX) {
        this.nX = nX;
    }

    public int getnY() {
        return nY;
    }

    public void setnY(int nY) {
        this.nY = nY;
    }

}
