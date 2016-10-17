//
// 此檔案是由 JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 所產生 
// 請參閱 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2016.10.04 於 11:26:51 AM CST 
//


package com.ittechoffice.mybatis2.sqlmap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@XmlRootElement(name = "isNotParameterPresent")
public class IsNotParameterPresent {

    @XmlAttribute(name = "prepend")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String prepend;
    @XmlAttribute(name = "open")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String open;
    @XmlAttribute(name = "close")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String close;
    @XmlAttribute(name = "removeFirstPrepend")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String removeFirstPrepend;
    @XmlValue
    protected String value;

    /**
     * 取得 prepend 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrepend() {
        return prepend;
    }

    /**
     * 設定 prepend 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrepend(String value) {
        this.prepend = value;
    }

    /**
     * 取得 open 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpen() {
        return open;
    }

    /**
     * 設定 open 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpen(String value) {
        this.open = value;
    }

    /**
     * 取得 close 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClose() {
        return close;
    }

    /**
     * 設定 close 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClose(String value) {
        this.close = value;
    }

    /**
     * 取得 removeFirstPrepend 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoveFirstPrepend() {
        return removeFirstPrepend;
    }

    /**
     * 設定 removeFirstPrepend 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoveFirstPrepend(String value) {
        this.removeFirstPrepend = value;
    }

    /**
     * 取得 value 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getvalue() {
        return value;
    }

    /**
     * 設定 value 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setvalue(String value) {
        this.value = value;
    }

}
