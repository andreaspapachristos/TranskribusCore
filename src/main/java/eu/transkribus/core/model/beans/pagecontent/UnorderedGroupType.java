//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.02.23 at 05:32:05 PM MEZ 
//


package eu.transkribus.core.model.beans.pagecontent;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 				Numbered group (contains unordered elements)
 * 			
 * 
 * <p>Java class for UnorderedGroupType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UnorderedGroupType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="RegionRef" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}RegionRefType"/>
 *         &lt;element name="OrderedGroup" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}OrderedGroupType"/>
 *         &lt;element name="UnorderedGroup" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}UnorderedGroupType"/>
 *       &lt;/choice>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="caption" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnorderedGroupType", propOrder = {
    "regionRefOrOrderedGroupOrUnorderedGroup"
})
public class UnorderedGroupType {

    @XmlElements({
        @XmlElement(name = "RegionRef", type = RegionRefType.class),
        @XmlElement(name = "UnorderedGroup", type = UnorderedGroupType.class),
        @XmlElement(name = "OrderedGroup", type = OrderedGroupType.class)
    })
    protected List<Object> regionRefOrOrderedGroupOrUnorderedGroup;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute
    protected String caption;

    /**
     * Gets the value of the regionRefOrOrderedGroupOrUnorderedGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionRefOrOrderedGroupOrUnorderedGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionRefOrOrderedGroupOrUnorderedGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegionRefType }
     * {@link UnorderedGroupType }
     * {@link OrderedGroupType }
     * 
     * 
     */
    public List<Object> getRegionRefOrOrderedGroupOrUnorderedGroup() {
        if (regionRefOrOrderedGroupOrUnorderedGroup == null) {
            regionRefOrOrderedGroupOrUnorderedGroup = new ArrayList<Object>();
        }
        return this.regionRefOrOrderedGroupOrUnorderedGroup;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the caption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Sets the value of the caption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaption(String value) {
        this.caption = value;
    }

}
