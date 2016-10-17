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
@XmlRootElement(name = "procedure")
public class Procedure {

    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String id;
    @XmlAttribute(name = "parameterMap")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parameterMap;
    @XmlAttribute(name = "parameterClass")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String parameterClass;
    @XmlAttribute(name = "resultMap")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String resultMap;
    @XmlAttribute(name = "resultClass")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String resultClass;
    @XmlAttribute(name = "cacheModel")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String cacheModel;
    @XmlAttribute(name = "fetchSize")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String fetchSize;
    @XmlAttribute(name = "xmlResultName")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String xmlResultName;
    @XmlAttribute(name = "remapResults")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String remapResults;
    @XmlAttribute(name = "timeout")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String timeout;
    @XmlValue
    protected String value;

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
     * 取得 parameterMap 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterMap() {
        return parameterMap;
    }

    /**
     * 設定 parameterMap 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterMap(String value) {
        this.parameterMap = value;
    }

    /**
     * 取得 parameterClass 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterClass() {
        return parameterClass;
    }

    /**
     * 設定 parameterClass 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterClass(String value) {
        this.parameterClass = value;
    }

    /**
     * 取得 resultMap 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultMap() {
        return resultMap;
    }

    /**
     * 設定 resultMap 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultMap(String value) {
        this.resultMap = value;
    }

    /**
     * 取得 resultClass 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultClass() {
        return resultClass;
    }

    /**
     * 設定 resultClass 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultClass(String value) {
        this.resultClass = value;
    }

    /**
     * 取得 cacheModel 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCacheModel() {
        return cacheModel;
    }

    /**
     * 設定 cacheModel 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCacheModel(String value) {
        this.cacheModel = value;
    }

    /**
     * 取得 fetchSize 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFetchSize() {
        return fetchSize;
    }

    /**
     * 設定 fetchSize 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFetchSize(String value) {
        this.fetchSize = value;
    }

    /**
     * 取得 xmlResultName 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlResultName() {
        return xmlResultName;
    }

    /**
     * 設定 xmlResultName 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlResultName(String value) {
        this.xmlResultName = value;
    }

    /**
     * 取得 remapResults 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemapResults() {
        return remapResults;
    }

    /**
     * 設定 remapResults 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemapResults(String value) {
        this.remapResults = value;
    }

    /**
     * 取得 timeout 特性的值.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeout() {
        return timeout;
    }

    /**
     * 設定 timeout 特性的值.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeout(String value) {
        this.timeout = value;
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
