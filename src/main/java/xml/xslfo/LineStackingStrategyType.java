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
 * <p>Java class for line_stacking_strategy_Type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="line_stacking_strategy_Type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="line-height"/>
 *     &lt;enumeration value="font-height"/>
 *     &lt;enumeration value="max-height"/>
 *     &lt;enumeration value="inherit"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "line_stacking_strategy_Type")
@XmlEnum
public enum LineStackingStrategyType {

    @XmlEnumValue("line-height")
    LINE_HEIGHT("line-height"),
    @XmlEnumValue("font-height")
    FONT_HEIGHT("font-height"),
    @XmlEnumValue("max-height")
    MAX_HEIGHT("max-height"),
    @XmlEnumValue("inherit")
    INHERIT("inherit");
    private final String value;

    LineStackingStrategyType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LineStackingStrategyType fromValue(String v) {
        for (LineStackingStrategyType c: LineStackingStrategyType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
