//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.18 at 03:42:43 PM EAT 
//


package com.library.datamodel.dsm_bridge.xmlpojos.program;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the jaxb.com.library.datamodel.dsm_bridge.xmlpojos.program package. 
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
    private final static QName _MarqueeTypeImage_QNAME = new QName("", "image");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: jaxb.com.library.datamodel.dsm_bridge.xmlpojos.program
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
     * Create an instance of {@link ProgramlistType }
     * 
     */
    public ProgramlistType createProgramlistType() {
        return new ProgramlistType();
    }

    /**
     * Create an instance of {@link VideoType }
     * 
     */
    public VideoType createVideoType() {
        return new VideoType();
    }

    /**
     * Create an instance of {@link ImgType }
     * 
     */
    public ImgType createImgType() {
        return new ImgType();
    }

    /**
     * Create an instance of {@link HybridrectType }
     * 
     */
    public HybridrectType createHybridrectType() {
        return new HybridrectType();
    }

    /**
     * Create an instance of {@link ProgramType }
     * 
     */
    public ProgramType createProgramType() {
        return new ProgramType();
    }

    /**
     * Create an instance of {@link ImageType }
     * 
     */
    public ImageType createImageType() {
        return new ImageType();
    }

    /**
     * Create an instance of {@link MarqueeType }
     * 
     */
    public MarqueeType createMarqueeType() {
        return new MarqueeType();
    }

    /**
     * Create an instance of {@link ExtenttextrectType }
     * 
     */
    public ExtenttextrectType createExtenttextrectType() {
        return new ExtenttextrectType();
    }

    /**
     * Create an instance of {@link ImagerectType }
     * 
     */
    public ImagerectType createImagerectType() {
        return new ImagerectType();
    }

    /**
     * Create an instance of {@link VideorectType }
     * 
     */
    public VideorectType createVideorectType() {
        return new VideorectType();
    }

    /**
     * Create an instance of {@link TimeType }
     * 
     */
    public TimeType createTimeType() {
        return new TimeType();
    }

    /**
     * Create an instance of {@link ClockrectType }
     * 
     */
    public ClockrectType createClockrectType() {
        return new ClockrectType();
    }

    /**
     * Create an instance of {@link LogorectType }
     * 
     */
    public LogorectType createLogorectType() {
        return new LogorectType();
    }

    /**
     * Create an instance of {@link FileType }
     * 
     */
    public FileType createFileType() {
        return new FileType();
    }

    /**
     * Create an instance of {@link FilesType }
     * 
     */
    public FilesType createFilesType() {
        return new FilesType();
    }

    /**
     * Create an instance of {@link FontType }
     * 
     */
    public FontType createFontType() {
        return new FontType();
    }

    /**
     * Create an instance of {@link FontsType }
     * 
     */
    public FontsType createFontsType() {
        return new FontsType();
    }

    /**
     * Create an instance of {@link MetaType }
     * 
     */
    public MetaType createMetaType() {
        return new MetaType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConfigType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "config")
    public JAXBElement<ConfigType> createConfig(ConfigType value) {
        return new JAXBElement<ConfigType>(_Config_QNAME, ConfigType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "image", scope = MarqueeType.class)
    public JAXBElement<ImageType> createMarqueeTypeImage(ImageType value) {
        return new JAXBElement<ImageType>(_MarqueeTypeImage_QNAME, ImageType.class, MarqueeType.class, value);
    }

}
