//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.18 at 03:42:44 PM EAT 
//


package com.library.datamodel.dsm_bridge.xmlpojos.strategy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.com.library.datamodel.dsm_bridge.xmlpojos.strategy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Config_QNAME = new QName("", "config");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.com.library.datamodel.dsm_bridge.xmlpojos.strategy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfigType }
     * 
     */
    public ConfigType createConfigType() {
        return new ConfigType();
    }

    /**
     * Create an instance of {@link TaskType }
     * 
     */
    public TaskType createTaskType() {
        return new TaskType();
    }

    /**
     * Create an instance of {@link ProgramType }
     * 
     */
    public ProgramType createProgramType() {
        return new ProgramType();
    }

    /**
     * Create an instance of {@link ProSerialType }
     * 
     */
    public ProSerialType createProSerialType() {
        return new ProSerialType();
    }

    /**
     * Create an instance of {@link DayTaskType }
     * 
     */
    public DayTaskType createDayTaskType() {
        return new DayTaskType();
    }

    /**
     * Create an instance of {@link MultiTaskType }
     * 
     */
    public MultiTaskType createMultiTaskType() {
        return new MultiTaskType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "config")
    public JAXBElement<ConfigType> createConfig(ConfigType value) {
        return new JAXBElement<ConfigType>(_Config_QNAME, ConfigType.class, null, value);
    }

}
