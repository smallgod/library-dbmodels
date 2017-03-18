//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.18 at 03:42:43 PM EAT 
//


package com.library.datamodel.dsm_bridge.xmlpojos.program;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for clockrectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="clockrectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="time" type="{}timeType"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="align_h" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="align_v" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="backcolor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="fontcolor" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="fontname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="fontsize" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="interactive" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="jump" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="layer" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="nH" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="nW" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="nX" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="nY" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="rectid" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="rectname" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="transparent" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clockrectType", propOrder = {
    "time"
})
public class ClockrectType {

    @XmlElement(required = true)
    protected TimeType time;
    @XmlAttribute(name = "align_h")
    protected String alignH;
    @XmlAttribute(name = "align_v")
    protected String alignV;
    @XmlAttribute(name = "backcolor")
    protected String backcolor;
    @XmlAttribute(name = "fontcolor")
    protected String fontcolor;
    @XmlAttribute(name = "fontname")
    protected String fontname;
    @XmlAttribute(name = "fontsize")
    protected Integer fontsize;
    @XmlAttribute(name = "interactive")
    protected String interactive;
    @XmlAttribute(name = "jump")
    protected Integer jump;
    @XmlAttribute(name = "layer")
    protected Integer layer;
    @XmlAttribute(name = "nH")
    protected Integer nh;
    @XmlAttribute(name = "nW")
    protected Integer nw;
    @XmlAttribute(name = "nX")
    protected Integer nx;
    @XmlAttribute(name = "nY")
    protected Integer ny;
    @XmlAttribute(name = "rectid")
    protected Integer rectid;
    @XmlAttribute(name = "rectname")
    protected String rectname;
    @XmlAttribute(name = "transparent")
    protected String transparent;

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link TimeType }
     *     
     */
    public TimeType getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeType }
     *     
     */
    public void setTime(TimeType value) {
        this.time = value;
    }

    /**
     * Gets the value of the alignH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlignH() {
        return alignH;
    }

    /**
     * Sets the value of the alignH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlignH(String value) {
        this.alignH = value;
    }

    /**
     * Gets the value of the alignV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlignV() {
        return alignV;
    }

    /**
     * Sets the value of the alignV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlignV(String value) {
        this.alignV = value;
    }

    /**
     * Gets the value of the backcolor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackcolor() {
        return backcolor;
    }

    /**
     * Sets the value of the backcolor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackcolor(String value) {
        this.backcolor = value;
    }

    /**
     * Gets the value of the fontcolor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontcolor() {
        return fontcolor;
    }

    /**
     * Sets the value of the fontcolor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontcolor(String value) {
        this.fontcolor = value;
    }

    /**
     * Gets the value of the fontname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontname() {
        return fontname;
    }

    /**
     * Sets the value of the fontname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontname(String value) {
        this.fontname = value;
    }

    /**
     * Gets the value of the fontsize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFontsize() {
        return fontsize;
    }

    /**
     * Sets the value of the fontsize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFontsize(Integer value) {
        this.fontsize = value;
    }

    /**
     * Gets the value of the interactive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInteractive() {
        return interactive;
    }

    /**
     * Sets the value of the interactive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInteractive(String value) {
        this.interactive = value;
    }

    /**
     * Gets the value of the jump property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJump() {
        return jump;
    }

    /**
     * Sets the value of the jump property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJump(Integer value) {
        this.jump = value;
    }

    /**
     * Gets the value of the layer property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLayer() {
        return layer;
    }

    /**
     * Sets the value of the layer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLayer(Integer value) {
        this.layer = value;
    }

    /**
     * Gets the value of the nh property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNH() {
        return nh;
    }

    /**
     * Sets the value of the nh property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNH(Integer value) {
        this.nh = value;
    }

    /**
     * Gets the value of the nw property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNW() {
        return nw;
    }

    /**
     * Sets the value of the nw property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNW(Integer value) {
        this.nw = value;
    }

    /**
     * Gets the value of the nx property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNX() {
        return nx;
    }

    /**
     * Sets the value of the nx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNX(Integer value) {
        this.nx = value;
    }

    /**
     * Gets the value of the ny property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNY() {
        return ny;
    }

    /**
     * Sets the value of the ny property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNY(Integer value) {
        this.ny = value;
    }

    /**
     * Gets the value of the rectid property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRectid() {
        return rectid;
    }

    /**
     * Sets the value of the rectid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRectid(Integer value) {
        this.rectid = value;
    }

    /**
     * Gets the value of the rectname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRectname() {
        return rectname;
    }

    /**
     * Sets the value of the rectname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRectname(String value) {
        this.rectname = value;
    }

    /**
     * Gets the value of the transparent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransparent() {
        return transparent;
    }

    /**
     * Sets the value of the transparent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransparent(String value) {
        this.transparent = value;
    }

}
