//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.06.02 at 04:22:01 PM MESZ 
//


package eu.transkribus.core.model.beans.pagecontent;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ColourDepthSimpleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ColourDepthSimpleType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="bilevel"/>
 *     &lt;enumeration value="greyscale"/>
 *     &lt;enumeration value="colour"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ColourDepthSimpleType")
@XmlEnum
public enum ColourDepthSimpleType {

    @XmlEnumValue("bilevel")
    BILEVEL("bilevel"),
    @XmlEnumValue("greyscale")
    GREYSCALE("greyscale"),
    @XmlEnumValue("colour")
    COLOUR("colour"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ColourDepthSimpleType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ColourDepthSimpleType fromValue(String v) {
        for (ColourDepthSimpleType c: ColourDepthSimpleType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
