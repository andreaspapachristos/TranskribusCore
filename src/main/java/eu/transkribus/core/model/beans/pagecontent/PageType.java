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
import javax.xml.bind.annotation.XmlType;
import eu.transkribus.core.model.beans.pagecontent_trp.TrpRegionType;


/**
 * <p>Java class for PageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlternativeImage" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}AlternativeImageType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Border" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}BorderType" minOccurs="0"/>
 *         &lt;element name="PrintSpace" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}PrintSpaceType" minOccurs="0"/>
 *         &lt;element name="ReadingOrder" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}ReadingOrderType" minOccurs="0"/>
 *         &lt;element name="Layers" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}LayersType" minOccurs="0"/>
 *         &lt;element name="Relations" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}RelationsType" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="TextRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}TextRegionType"/>
 *           &lt;element name="ImageRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}ImageRegionType"/>
 *           &lt;element name="LineDrawingRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}LineDrawingRegionType"/>
 *           &lt;element name="GraphicRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}GraphicRegionType"/>
 *           &lt;element name="TableRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}TableRegionType"/>
 *           &lt;element name="ChartRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}ChartRegionType"/>
 *           &lt;element name="SeparatorRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}SeparatorRegionType"/>
 *           &lt;element name="MathsRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}MathsRegionType"/>
 *           &lt;element name="ChemRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}ChemRegionType"/>
 *           &lt;element name="MusicRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}MusicRegionType"/>
 *           &lt;element name="AdvertRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}AdvertRegionType"/>
 *           &lt;element name="NoiseRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}NoiseRegionType"/>
 *           &lt;element name="UnknownRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}UnknownRegionType"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="imageFilename" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="imageWidth" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="imageHeight" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="custom" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2013-07-15}PageTypeSimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PageType", propOrder = {
    "alternativeImage",
    "border",
    "printSpace",
    "readingOrder",
    "layers",
    "relations",
    "textRegionOrImageRegionOrLineDrawingRegion"
})
public class PageType {

    @XmlElement(name = "AlternativeImage")
    protected List<AlternativeImageType> alternativeImage;
    @XmlElement(name = "Border")
    protected BorderType border;
    @XmlElement(name = "PrintSpace")
    protected PrintSpaceType printSpace;
    @XmlElement(name = "ReadingOrder")
    protected ReadingOrderType readingOrder;
    @XmlElement(name = "Layers")
    protected LayersType layers;
    @XmlElement(name = "Relations")
    protected RelationsType relations;
    @XmlElements({
        @XmlElement(name = "ChemRegion", type = ChemRegionType.class),
        @XmlElement(name = "TextRegion", type = TextRegionType.class),
        @XmlElement(name = "UnknownRegion", type = UnknownRegionType.class),
        @XmlElement(name = "ImageRegion", type = ImageRegionType.class),
        @XmlElement(name = "ChartRegion", type = ChartRegionType.class),
        @XmlElement(name = "MathsRegion", type = MathsRegionType.class),
        @XmlElement(name = "NoiseRegion", type = NoiseRegionType.class),
        @XmlElement(name = "AdvertRegion", type = AdvertRegionType.class),
        @XmlElement(name = "GraphicRegion", type = GraphicRegionType.class),
        @XmlElement(name = "MusicRegion", type = MusicRegionType.class),
        @XmlElement(name = "SeparatorRegion", type = SeparatorRegionType.class),
        @XmlElement(name = "TableRegion", type = TableRegionType.class),
        @XmlElement(name = "LineDrawingRegion", type = LineDrawingRegionType.class)
    })
    protected List<TrpRegionType> textRegionOrImageRegionOrLineDrawingRegion;
    @XmlAttribute(required = true)
    protected String imageFilename;
    @XmlAttribute(required = true)
    protected int imageWidth;
    @XmlAttribute(required = true)
    protected int imageHeight;
    @XmlAttribute
    protected String custom;
    @XmlAttribute
    protected PageTypeSimpleType type;

    /**
     * Gets the value of the alternativeImage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alternativeImage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlternativeImage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AlternativeImageType }
     * 
     * 
     */
    public List<AlternativeImageType> getAlternativeImage() {
        if (alternativeImage == null) {
            alternativeImage = new ArrayList<AlternativeImageType>();
        }
        return this.alternativeImage;
    }

    /**
     * Gets the value of the border property.
     * 
     * @return
     *     possible object is
     *     {@link BorderType }
     *     
     */
    public BorderType getBorder() {
        return border;
    }

    /**
     * Sets the value of the border property.
     * 
     * @param value
     *     allowed object is
     *     {@link BorderType }
     *     
     */
    public void setBorder(BorderType value) {
        this.border = value;
    }

    /**
     * Gets the value of the printSpace property.
     * 
     * @return
     *     possible object is
     *     {@link PrintSpaceType }
     *     
     */
    public PrintSpaceType getPrintSpace() {
        return printSpace;
    }

    /**
     * Sets the value of the printSpace property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrintSpaceType }
     *     
     */
    public void setPrintSpace(PrintSpaceType value) {
        this.printSpace = value;
    }

    /**
     * Gets the value of the readingOrder property.
     * 
     * @return
     *     possible object is
     *     {@link ReadingOrderType }
     *     
     */
    public ReadingOrderType getReadingOrder() {
        return readingOrder;
    }

    /**
     * Sets the value of the readingOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingOrderType }
     *     
     */
    public void setReadingOrder(ReadingOrderType value) {
        this.readingOrder = value;
    }

    /**
     * Gets the value of the layers property.
     * 
     * @return
     *     possible object is
     *     {@link LayersType }
     *     
     */
    public LayersType getLayers() {
        return layers;
    }

    /**
     * Sets the value of the layers property.
     * 
     * @param value
     *     allowed object is
     *     {@link LayersType }
     *     
     */
    public void setLayers(LayersType value) {
        this.layers = value;
    }

    /**
     * Gets the value of the relations property.
     * 
     * @return
     *     possible object is
     *     {@link RelationsType }
     *     
     */
    public RelationsType getRelations() {
        return relations;
    }

    /**
     * Sets the value of the relations property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelationsType }
     *     
     */
    public void setRelations(RelationsType value) {
        this.relations = value;
    }

    /**
     * Gets the value of the textRegionOrImageRegionOrLineDrawingRegion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textRegionOrImageRegionOrLineDrawingRegion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextRegionOrImageRegionOrLineDrawingRegion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChemRegionType }
     * {@link TextRegionType }
     * {@link UnknownRegionType }
     * {@link ImageRegionType }
     * {@link ChartRegionType }
     * {@link MathsRegionType }
     * {@link NoiseRegionType }
     * {@link AdvertRegionType }
     * {@link GraphicRegionType }
     * {@link MusicRegionType }
     * {@link SeparatorRegionType }
     * {@link TableRegionType }
     * {@link LineDrawingRegionType }
     * 
     * 
     */
    public List<TrpRegionType> getTextRegionOrImageRegionOrLineDrawingRegion() {
        if (textRegionOrImageRegionOrLineDrawingRegion == null) {
            textRegionOrImageRegionOrLineDrawingRegion = new ArrayList<TrpRegionType>();
        }
        return this.textRegionOrImageRegionOrLineDrawingRegion;
    }

    /**
     * Gets the value of the imageFilename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageFilename() {
        return imageFilename;
    }

    /**
     * Sets the value of the imageFilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageFilename(String value) {
        this.imageFilename = value;
    }

    /**
     * Gets the value of the imageWidth property.
     * 
     */
    public int getImageWidth() {
        return imageWidth;
    }

    /**
     * Sets the value of the imageWidth property.
     * 
     */
    public void setImageWidth(int value) {
        this.imageWidth = value;
    }

    /**
     * Gets the value of the imageHeight property.
     * 
     */
    public int getImageHeight() {
        return imageHeight;
    }

    /**
     * Sets the value of the imageHeight property.
     * 
     */
    public void setImageHeight(int value) {
        this.imageHeight = value;
    }

    /**
     * Gets the value of the custom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustom() {
        return custom;
    }

    /**
     * Sets the value of the custom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustom(String value) {
        this.custom = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link PageTypeSimpleType }
     *     
     */
    public PageTypeSimpleType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageTypeSimpleType }
     *     
     */
    public void setType(PageTypeSimpleType value) {
        this.type = value;
    }

}
