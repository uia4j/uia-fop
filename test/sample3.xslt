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
            <fo:page-sequence master-reference="cd">
                <fo:flow flow-name="data-body">
                    <fo:table>
                        <fo:table-column column-width="20%" />
                        <fo:table-column column-width="30%" />
                        <fo:table-column column-width="20%" />
                        <fo:table-column column-width="30%" />
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block>Title</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="report/summary/title" />
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Updated Time</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
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
