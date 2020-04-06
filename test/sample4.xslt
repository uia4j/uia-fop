<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="report"
                    page-height="21.0cm"
                    page-width="29.7cm"
                    margin="2cm">
                    <fo:region-body region-name="data-body" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence
                master-reference="report"
                font-family="Arial,sans-serif,SimHei">
                <fo:flow flow-name="data-body">
                    <fo:table>
                        <fo:table-column column-width="20%" />
                        <fo:table-column column-width="30%" />
                        <fo:table-column column-width="20%" />
                        <fo:table-column column-width="30%" />
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block font-weight="bold">Title</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="report/summary/title" />
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block font-weight="bold">Updated Time</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>
                                        <xsl:value-of select="report/summary/updatedTime" />
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <fo:table border="solid 0.3mm black">
                        <fo:table-column
                            column-width="16%"
                            border="solid 0.1mm black" />
                        <fo:table-column
                            column-width="16%"
                            border="solid 0.1mm black" />
                        <fo:table-column
                            column-width="16%"
                            border="solid 0.1mm black" />
                        <fo:table-column
                            column-width="16%"
                            border="solid 0.1mm black" />
                        <fo:table-column
                            column-width="16%"
                            border="solid 0.1mm black" />
                        <fo:table-column
                            column-width="16%"
                            border="solid 0.1mm black" />
                        <fo:table-header>
                            <fo:table-row
                                border="solid 0.1mm black"
                                background-color="#eeeeee">
                                <fo:table-cell>
                                    <fo:block>Title</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Artist</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Country</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Company</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Price</fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block>Year</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="report/catalog/cd">
                                <fo:table-row border="solid 0.1mm black">
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="title" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="artist" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="country" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="company" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="price" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="year" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
