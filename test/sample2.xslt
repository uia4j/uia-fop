<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="test"
                    page-height="29.7cm"
                    page-width="21.0cm"
                    margin-top="2cm"
                    margin-bottom="2cm"
                    margin-left="2cm"
                    margin-right="2cm">
                    <fo:region-body region-name="region-body" />
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence
                master-reference="test"
                font-family="Arial,sans-serif,SimHei">
                <fo:flow flow-name="region-body">
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
                                    <fo:block>名稱</fo:block>
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
                            <xsl:for-each select="catalog/cd">
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
