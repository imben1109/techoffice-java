//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.18 at 10:19:16 AM CST 
//


package com.techoffice.javaee.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 	
 * 
 * 	  The message-destination-typeType specifies the type of
 * 	  the destination. The type is specified by the Java interface
 * 	  expected to be implemented by the destination.
 * 
 * 	  Example:
 * 
 * 	    <message-destination-type>javax.jms.Queue
 * 	    </message-destination-type>
 * 
 * 	  
 *       
 * 
 * <p>Java class for message-destination-typeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="message-destination-typeType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;restriction base="&lt;http://java.sun.com/xml/ns/javaee&gt;fully-qualified-classType"&gt;
 *     &lt;/restriction&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message-destination-typeType")
public class MessageDestinationTypeType
    extends FullyQualifiedClassType
{


}