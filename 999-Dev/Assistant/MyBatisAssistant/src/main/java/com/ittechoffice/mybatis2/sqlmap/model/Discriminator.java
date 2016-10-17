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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "subMap"
})
@XmlRootElement(name = "discriminator")
public class Discriminator {

    @XmlAttribute(name = "javaType", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String javaType;
    @XmlAttribute(name = "column")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String column;
    @XmlAttribute(name = "columnIndex")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String columnIndex;
    @XmlAttribute(name = "jdbcType")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String jdbcType;
    @XmlAttribute(name = "nullValue")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String nullValue;
    @XmlAttribute(name = "typeHandler")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String typeHandler;
    @XmlElement(required = true)
    protected List<SubMap> subMap;

    /**
     * 取得 javaType 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJavaType() {
        return javaType;
    }

    /**
     * 設定 javaType 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJavaType(String value) {
        this.javaType = value;
    }

    /**
     * 取得 column 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumn() {
        return column;
    }

    /**
     * 設定 column 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumn(String value) {
        this.column = value;
    }

    /**
     * 取得 columnIndex 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnIndex() {
        return columnIndex;
    }

    /**
     * 設定 columnIndex 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnIndex(String value) {
        this.columnIndex = value;
    }

    /**
     * 取得 jdbcType 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJdbcType() {
        return jdbcType;
    }

    /**
     * 設定 jdbcType 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJdbcType(String value) {
        this.jdbcType = value;
    }

    /**
     * 取得 nullValue 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNullValue() {
        return nullValue;
    }

    /**
     * 設定 nullValue 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNullValue(String value) {
        this.nullValue = value;
    }

    /**
     * 取得 typeHandler 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeHandler() {
        return typeHandler;
    }

    /**
     * 設定 typeHandler 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeHandler(String value) {
        this.typeHandler = value;
    }

    /**
     * Gets the value of the subMap property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subMap property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubMap().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubMap }
     * 
     * 
     */
    public List<SubMap> getSubMap() {
        if (subMap == null) {
            subMap = new ArrayList<SubMap>();
        }
        return this.subMap;
    }

}
