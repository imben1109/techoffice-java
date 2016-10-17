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
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "flushInterval")
public class FlushInterval {

    @XmlAttribute(name = "milliseconds")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String milliseconds;
    @XmlAttribute(name = "seconds")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String seconds;
    @XmlAttribute(name = "minutes")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String minutes;
    @XmlAttribute(name = "hours")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String hours;

    /**
     * 取得 milliseconds 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMilliseconds() {
        return milliseconds;
    }

    /**
     * 設定 milliseconds 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMilliseconds(String value) {
        this.milliseconds = value;
    }

    /**
     * 取得 seconds 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeconds() {
        return seconds;
    }

    /**
     * 設定 seconds 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeconds(String value) {
        this.seconds = value;
    }

    /**
     * 取得 minutes 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinutes() {
        return minutes;
    }

    /**
     * 設定 minutes 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinutes(String value) {
        this.minutes = value;
    }

    /**
     * 取得 hours 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHours() {
        return hours;
    }

    /**
     * 設定 hours 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHours(String value) {
        this.hours = value;
    }

}
