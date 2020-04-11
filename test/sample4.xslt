<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="MA_ORDER_REPORT"
                                       page-height="29.7cm"
                                       page-width="21.0cm"
                                       margin="2cm">
                    <fo:region-body region-name="region-body"
                                    margin-top="1cm"
                                    margin-bottom="1cm"/>
                    <fo:region-before region-name="region-header"/>
                    <fo:region-after region-name="region-footer"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <xsl:for-each select="orders/order">
                <fo:page-sequence master-reference="MA_ORDER_REPORT"
                                  font-family="Arial,sans-serif,SimHei">
                    <fo:static-content flow-name="region-header">
                        <fo:table margin-bottom="3mm">
                            <fo:table-column column-width="33%"/>
                            <fo:table-column column-width="33%"/>
                            <fo:table-column column-width="33%"/>
                            <fo:table-body>
                                <fo:table-row height="16px"
                                              display-align="center">
                                    <fo:table-cell>
                                        <fo:block margin-right="0.1cm"><xsl:value-of select="id" /></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">MA Order</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="right">
                                            <fo:external-graphic height="24px" 
                                                                 src="url('data:image/png;base64,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')"
                                                                 width="24px"/>
                                        </fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:static-content>
                    <fo:static-content flow-name="region-footer">
                        <fo:table margin-bottom="1cm">
                            <fo:table-column column-width="40%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="40%"/>
                            <fo:table-body>
                                <fo:table-row>
                                    <fo:table-cell>
                                        <fo:block/>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="center">
                                            <fo:page-number/>
                                        </fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block text-align="right"/>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                    </fo:static-content>
                    <fo:flow flow-name="region-body">
                        <fo:table margin-bottom="3mm">
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="30%"/>
                            <fo:table-column column-width="20%"/>
                            <fo:table-column column-width="30%"/>
                            <fo:table-body>
                                <fo:table-row height="16px"
                                              display-align="center">
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="right"
                                                  margin-right="0.1cm">Name</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="name" /></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="right"
                                                  margin-right="0.1cm">Work Group</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="workGroup" /></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row height="16px"
                                              display-align="center">
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="right"
                                                  margin-right="0.1cm">Description</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="description" /></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="right"
                                                  margin-right="0.1cm">QA Group</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="qaGroup" /></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row height="16px"
                                              display-align="center">
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="right"
                                                  margin-right="0.1cm">Begin Time</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="runBeginTime" /></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="right"
                                                  margin-right="0.1cm">Freq</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="freqName" /></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                                <fo:table-row height="16px"
                                              display-align="center">
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="right"
                                                  margin-right="0.1cm">End Time</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block><xsl:value-of select="runEndTime" /></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block/>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block/>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-body>
                        </fo:table>
                        <fo:table table-layout="auto"
                                  border="solid 0.3mm black"
                                  margin="0.1mm">
                            <fo:table-column column-width="25%"
                                             border="solid 0.1mm black"/>
                            <fo:table-column column-width="25%"
                                             border="solid 0.1mm black"/>
                            <fo:table-column column-width="25%"
                                             border="solid 0.1mm black"/>
                            <fo:table-column column-width="25%"
                                             border="solid 0.1mm black"/>
                            <fo:table-header>
                                <fo:table-row height="16px"
                                              border="solid 0.1mm black"
                                              display-align="center"
                                              font-size="11px"
                                              background-color="#eeeeee">
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="center">Seq No.</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="center">Item Name</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="center">Result</fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell>
                                        <fo:block font-weight="bold"
                                                  text-align="center">Remark</fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>
                            <fo:table-body>
                                <xsl:for-each select="items/item">
                                    <fo:table-row height="16px"
                                                  border="solid 0.1mm black"
                                                  display-align="center"
                                                  font-size="11px">
                                        <fo:table-cell>
                                            <fo:block><xsl:value-of select="seqNo" /></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block><xsl:value-of select="itemName" /></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block><xsl:value-of select="maResult" /></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block><xsl:value-of select="maRemark" /></fo:block>
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
