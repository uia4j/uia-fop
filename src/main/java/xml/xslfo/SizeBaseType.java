//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.04.03 at 10:01:50 AM CST 
//


package xml.xslfo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for size_base_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="size_base_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="auto"/>
 *     &lt;enumeration value="landscape"/>
 *     &lt;enumeration value="portrait"/>
 *     &lt;enumeration value="inherit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "size_base_Type")
@XmlEnum
public enum SizeBaseType {

    @XmlEnumValue("auto")
    AUTO("auto"),
    @XmlEnumValue("landscape")
    LANDSCAPE("landscape"),
    @XmlEnumValue("portrait")
    PORTRAIT("portrait"),
    @XmlEnumValue("inherit")
    INHERIT("inherit");
    private final String value;

    SizeBaseType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SizeBaseType fromValue(String v) {
        for (SizeBaseType c: SizeBaseType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
