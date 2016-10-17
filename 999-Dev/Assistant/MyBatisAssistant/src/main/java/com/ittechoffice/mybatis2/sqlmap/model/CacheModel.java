//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2016.10.04 於 11:26:51 AM CST 
//


package com.ittechoffice.mybatis2.sqlmap.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "flushIntervalOrFlushOnExecuteOrProperty"
})
@XmlRootElement(name = "cacheModel")
public class CacheModel {

    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "type", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String type;
    @XmlAttribute(name = "readOnly")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String readOnly;
    @XmlAttribute(name = "serialize")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String serialize;
    @XmlElements({
        @XmlElement(name = "flushInterval", required = true, type = FlushInterval.class),
        @XmlElement(name = "flushOnExecute", required = true, type = FlushOnExecute.class),
        @XmlElement(name = "property", required = true, type = Property.class)
    })
    protected List<Object> flushIntervalOrFlushOnExecuteOrProperty;

    /**
     * 取得 id 特性的值.
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
     * 設定 id 特性的值.
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
     * 取得 type 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * 設定 type 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * 取得 readOnly 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReadOnly() {
        return readOnly;
    }

    /**
     * 設定 readOnly 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadOnly(String value) {
        this.readOnly = value;
    }

    /**
     * 取得 serialize 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialize() {
        return serialize;
    }

    /**
     * 設定 serialize 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialize(String value) {
        this.serialize = value;
    }

    /**
     * Gets the value of the flushIntervalOrFlushOnExecuteOrProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flushIntervalOrFlushOnExecuteOrProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlushIntervalOrFlushOnExecuteOrProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FlushInterval }
     * {@link FlushOnExecute }
     * {@link Property }
     * 
     * 
     */
    public List<Object> getFlushIntervalOrFlushOnExecuteOrProperty() {
        if (flushIntervalOrFlushOnExecuteOrProperty == null) {
            flushIntervalOrFlushOnExecuteOrProperty = new ArrayList<Object>();
        }
        return this.flushIntervalOrFlushOnExecuteOrProperty;
    }

}
