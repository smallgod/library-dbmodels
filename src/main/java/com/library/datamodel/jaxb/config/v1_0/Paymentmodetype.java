//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.07 at 11:55:46 AM EAT 
//


package com.library.datamodel.jaxb.config.v1_0;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paymentmodetype.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="paymentmodetype"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MOBILE"/&gt;
 *     &lt;enumeration value="USSD"/&gt;
 *     &lt;enumeration value="WEB"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "paymentmodetype")
@XmlEnum
public enum Paymentmodetype {

    MOBILE,
    USSD,
    WEB;

    public String value() {
        return name();
    }

    public static Paymentmodetype fromValue(String v) {
        return valueOf(v);
    }

}
