//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.02 at 02:22:18 PM EAT 
//


package com.library.datamodel.jaxb.config.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for credentialstype complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="credentialstype"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element name="apiusername" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apipassword" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="apipublickey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "credentialstype", propOrder = {

})
public class Credentialstype {

    @XmlElement(required = true)
    protected String apiusername;
    @XmlElement(required = true)
    protected String apipassword;
    @XmlElement(required = true)
    protected String apipublickey;

    /**
     * Gets the value of the apiusername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApiusername() {
        return apiusername;
    }

    /**
     * Sets the value of the apiusername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApiusername(String value) {
        this.apiusername = value;
    }

    /**
     * Gets the value of the apipassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApipassword() {
        return apipassword;
    }

    /**
     * Sets the value of the apipassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApipassword(String value) {
        this.apipassword = value;
    }

    /**
     * Gets the value of the apipublickey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApipublickey() {
        return apipublickey;
    }

    /**
     * Sets the value of the apipublickey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApipublickey(String value) {
        this.apipublickey = value;
    }

}
