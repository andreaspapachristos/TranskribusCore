//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.07.21 um 11:17:10 AM CEST 
//


package eu.transkribus.core.model.beans.pagecontent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * Numbered region
 * 
 * <p>Java-Klasse für RegionRefIndexedType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RegionRefIndexedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="regionRef" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegionRefIndexedType")
public class RegionRefIndexedType {

    @XmlAttribute(name = "index", required = true)
    protected int index;
    @XmlAttribute(name = "regionRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object regionRef;

    /**
     * Ruft den Wert der index-Eigenschaft ab.
     * 
     */
    public int getIndex() {
        return index;
    }

    /**
     * Legt den Wert der index-Eigenschaft fest.
     * 
     */
    public void setIndex(int value) {
        this.index = value;
    }

    /**
     * Ruft den Wert der regionRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRegionRef() {
        return regionRef;
    }

    /**
     * Legt den Wert der regionRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRegionRef(Object value) {
        this.regionRef = value;
    }

}
