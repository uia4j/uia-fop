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
 * <p>Java class for force_page_count_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="force_page_count_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="auto"/>
 *     &lt;enumeration value="even"/>
 *     &lt;enumeration value="odd"/>
 *     &lt;enumeration value="end-on-even"/>
 *     &lt;enumeration value="end-on-odd"/>
 *     &lt;enumeration value="no-force"/>
 *     &lt;enumeration value="inherit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "force_page_count_Type")
@XmlEnum
public enum ForcePageCountType {

    @XmlEnumValue("auto")
    AUTO("auto"),
    @XmlEnumValue("even")
    EVEN("even"),
    @XmlEnumValue("odd")
    ODD("odd"),
    @XmlEnumValue("end-on-even")
    END_ON_EVEN("end-on-even"),
    @XmlEnumValue("end-on-odd")
    END_ON_ODD("end-on-odd"),
    @XmlEnumValue("no-force")
    NO_FORCE("no-force"),
    @XmlEnumValue("inherit")
    INHERIT("inherit");
    private final String value;

    ForcePageCountType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ForcePageCountType fromValue(String v) {
        for (ForcePageCountType c: ForcePageCountType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
