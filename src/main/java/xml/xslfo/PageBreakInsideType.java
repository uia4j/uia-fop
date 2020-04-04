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
 * <p>Java class for page_break_inside_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="page_break_inside_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="auto"/>
 *     &lt;enumeration value="avoid"/>
 *     &lt;enumeration value="inherit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "page_break_inside_Type")
@XmlEnum
public enum PageBreakInsideType {

    @XmlEnumValue("auto")
    AUTO("auto"),
    @XmlEnumValue("avoid")
    AVOID("avoid"),
    @XmlEnumValue("inherit")
    INHERIT("inherit");
    private final String value;

    PageBreakInsideType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PageBreakInsideType fromValue(String v) {
        for (PageBreakInsideType c: PageBreakInsideType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}