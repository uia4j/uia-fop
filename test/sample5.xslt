<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="MA_ORDER_REPORT"
                    page-height="29.7cm"
                    page-width="21.0cm"
                    margin="2cm">
                    <fo:region-body
                        region-name="region-body"
                        margin-top="1cm"
                        margin-bottom="1cm" />
                    <fo:region-before
                        extent="10.0pt"
                        region-name="region-header" />
                    <fo:region-after 
                        extent="10.0pt"
                        region-name="region-footer" />
                </fo:simple-page-master>
                <fo:page-sequence-master master-name="MA_ORDER">
                    <fo:repeatable-page-master-reference master-reference="MA_ORDER_REPORT" />
                </fo:page-sequence-master>
            </fo:layout-master-set>
            <xsl:for-each select="orders/order">
                <fo:page-sequence
                    id="orderSection"
                    master-reference="MA_ORDER"
                    font-family="Arial,sans-serif,SimHei">
                    <fo:static-content flow-name="region-header">
                        <fo:table>
                            <fo:table-column column-width="33%" />
                            <fo:table-column column-width="33%" />
                            <fo:table-column column-width="33%" />
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="id" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">MA Order</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="right">
                                            <xsl:value-of select="runBeginTime" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:static-content>
                    <fo:static-content flow-name="region-footer">
                        <fo:table>
                            <fo:table-column column-width="33%" />
                            <fo:table-column column-width="33%" />
                            <fo:table-column column-width="33%" />
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block>Approved By:</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <fo:page-number />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="right">FW co., ltd.</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:static-content>
                    <fo:flow flow-name="region-body">
                        <fo:table margin-bottom="1cm">
                            <fo:table-column column-width="20%" />
                            <fo:table-column column-width="30%" />
                            <fo:table-column column-width="20%" />
                            <fo:table-column column-width="30%" />
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="right"
                                            margin-right="2mm">Name</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="name" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="right"
                                            margin-right="2mm">Work Group</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="workGroup" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="right"
                                            margin-right="2mm">Description</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="description" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="right"
                                            margin-right="2mm">QA Group</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="qaGroup" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="right"
                                            margin-right="2mm">Begin Time</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="runBeginTime" />
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="right"
                                            margin-right="2mm">MA Type</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="freqName" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="right"
                                            margin-right="2mm">End Time</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block>
                                            <xsl:value-of select="runEndTime" />
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                        <fo:table
                            border="solid 0.3mm black"
                            margin="0.1mm">
                            <fo:table-column
                                column-width="40px"
                                border="solid 0.1mm black" />
                            <fo:table-column
                                column-width="25%"
                                border="solid 0.1mm black" />
                            <fo:table-column
                                column-width="25%"
                                border="solid 0.1mm black" />
                            <fo:table-column border="solid 0.1mm black" />
                            <fo:table-header>
                                <fo:table-row
                                    border="solid 0.1mm black"
                                    background-color="#eeeeee">
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="center">Seq No</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="center">Item Name </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="center">Result</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block
                                            font-weight="bold"
                                            text-align="center">Remark</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>
                            <fo:table-body>
                                <xsl:for-each select="items/item">
                                    <fo:table-row border="solid 0.1mm black">
                                        <fo:table-cell>
                                            <fo:block text-align="right">
                                                <xsl:value-of select="seqNo" />
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block>
                                                <xsl:value-of select="itemName" />
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block>
                                                <xsl:value-of select="maResult" />
                                            </fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block>
                                                <xsl:value-of select="maRemark" />
                                            </fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </xsl:for-each>
                            </fo:table-body>
                        </fo:table>
                    </fo:flow>
                </fo:page-sequence>
            </xsl:for-each>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
