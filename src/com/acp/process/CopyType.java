//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.07 at 10:53:07 PM EST 
//


package com.acp.process;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for copyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="copyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="from" type="{http://www.swin.edu.au}fromType"/>
 *         &lt;element name="to" type="{http://www.swin.edu.au}toType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "copyType", propOrder = {

})
public class CopyType {

    @XmlElement(namespace = "http://www.swin.edu.au", required = true)
    protected FromType from;
    @XmlElement(namespace = "http://www.swin.edu.au", required = true)
    protected ToType to;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link FromType }
     *     
     */
    public FromType getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link FromType }
     *     
     */
    public void setFrom(FromType value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link ToType }
     *     
     */
    public ToType getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link ToType }
     *     
     */
    public void setTo(ToType value) {
        this.to = value;
    }

}
