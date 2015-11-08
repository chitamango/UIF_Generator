//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.10.07 at 10:53:07 PM EST 
//


package com.acp.process;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for andType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="andType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="atom" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="artifact" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="op">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="=="/>
 *                       &lt;enumeration value=">"/>
 *                       &lt;enumeration value="&lt;"/>
 *                       &lt;enumeration value="&lt;="/>
 *                       &lt;enumeration value=">="/>
 *                       &lt;enumeration value="!="/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="type" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="attribute"/>
 *                       &lt;enumeration value="state"/>
 *                       &lt;enumeration value="input"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *                 &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "andType", propOrder = {
    "atom"
})
public class AndType {

    @XmlElement(namespace = "http://www.swin.edu.au", required = true)
    protected List<Atom> atom;

    /**
     * Gets the value of the atom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the atom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAtom().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Atom }
     * 
     * 
     */
    public List<Atom> getAtom() {
        if (atom == null) {
            atom = new ArrayList<Atom>();
        }
        return this.atom;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="artifact" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="attribute" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="op">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="=="/>
     *             &lt;enumeration value=">"/>
     *             &lt;enumeration value="&lt;"/>
     *             &lt;enumeration value="&lt;="/>
     *             &lt;enumeration value=">="/>
     *             &lt;enumeration value="!="/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="type" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="attribute"/>
     *             &lt;enumeration value="state"/>
     *             &lt;enumeration value="input"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Atom {

        @XmlAttribute
        protected String artifact;
        @XmlAttribute
        protected String attribute;
        @XmlAttribute
        protected String id;
        @XmlAttribute
        protected String op;
        @XmlAttribute(required = true)
        protected String type;
        @XmlAttribute(required = true)
        protected String value;

        /**
         * Gets the value of the artifact property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getArtifact() {
            return artifact;
        }

        /**
         * Sets the value of the artifact property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setArtifact(String value) {
            this.artifact = value;
        }

        /**
         * Gets the value of the attribute property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAttribute() {
            return attribute;
        }

        /**
         * Sets the value of the attribute property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAttribute(String value) {
            this.attribute = value;
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
         * Gets the value of the op property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOp() {
            return op;
        }

        /**
         * Sets the value of the op property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOp(String value) {
            this.op = value;
        }

        /**
         * Gets the value of the type property.
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
         * Sets the value of the type property.
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
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

    }

}