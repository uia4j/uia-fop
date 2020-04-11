<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="cd"
                    page-height="29.7cm"
                    page-width="21.0cm"
                    margin="2cm">
                    <fo:region-body region-name="data-body" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence
                master-reference="cd"
                font-family="Arial,sans-serif,SimHei">
                <fo:flow flow-name="data-body">
                    <fo:table>
                        <fo:table-column column-width="50%" />
                        <fo:table-column column-width="50%" />
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block>Report</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="right">
                                        Updated Time:
                                        <xsl:value-of select="report/summary/updatedTime" />
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
