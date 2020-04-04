<?xml version="1.0" encoding="UTF-8"?>
<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<fo:layout-master-set>
		<fo:simple-page-master master-name="Cover"
		                       margin="1in"
		                       page-height="11in"
		                       page-width="8.5in"> 
			<fo:region-body margin-top="2in"/>
		</fo:simple-page-master>
		<fo:simple-page-master master-name="StoriesOdd"
		                       page-height="11in"
		                       page-width="8.5in"
		                       margin=".5in">
			<fo:region-body margin=".5in"/>
			<fo:region-before region-name="oddHead"
			                  extent=".5in"/>
			<fo:region-after region-name="oddFoot"
			                 extent=".5in"/>
		</fo:simple-page-master>
		<fo:simple-page-master master-name="StoriesEven"
		                       page-height="11in"
		                       page-width="8.5in"
		                       margin=".5in">
			<fo:region-body margin=".5in"/>
			<fo:region-before region-name="evenHead"
			                  extent=".5in"/>
			<fo:region-after region-name="evenFoot"
			                 extent=".5in"/>
		</fo:simple-page-master>
		<fo:page-sequence-master master-name="Stories">
			<fo:repeatable-page-master-alternatives>
				<fo:conditional-page-master-reference master-reference="StoriesOdd"
				                                      odd-or-even="odd"/>
				<fo:conditional-page-master-reference master-reference="StoriesEven"
				                                      odd-or-even="even"/>
			</fo:repeatable-page-master-alternatives>
		</fo:page-sequence-master>
		<fo:page-sequence-master master-name="CoverPage">
			<fo:single-page-master-reference master-reference="Cover"/>
		</fo:page-sequence-master>
	</fo:layout-master-set>
	<fo:page-sequence master-reference="CoverPage">
		<fo:flow flow-name="xsl-region-body">
			<fo:block text-align="center"
			          font-weight="bold"
			          font-size="1in"> Cover Page </fo:block>
		</fo:flow>
	</fo:page-sequence>
	<fo:page-sequence master-reference="Stories">
		<fo:static-content flow-name="oddHead">
			<fo:block border-bottom-width="thin"
			          border-bottom-style="solid"
			          border-bottom-color="green"
			          font-weight="bold"
			          text-align="outside"> Story Title </fo:block>
		</fo:static-content>
		<fo:static-content flow-name="evenHead">
			<fo:block border-bottom-width="thin"
			          border-bottom-style="solid"
			          border-bottom-color="green"
			          font-weight="bold"
			          text-align="outside"> Book of Stories </fo:block>
		</fo:static-content>
		<fo:static-content flow-name="oddFoot">
			<fo:block border-bottom-width="thin"
			          border-bottom-style="solid"
			          border-bottom-color="green"
			          font-weight="bold"
			          text-align="outside">
				<fo:page-number/> | </fo:block>
		</fo:static-content>
		<fo:static-content flow-name="evenFoot">
			<fo:block border-bottom-width="thin"
			          border-bottom-style="solid"
			          border-bottom-color="green"
			          font-weight="bold"
			          text-align="outside"> | <fo:page-number/>
			</fo:block>
		</fo:static-content>
		<fo:flow flow-name="xsl-region-body">
			<fo:block/>
		</fo:flow>
	</fo:page-sequence>
</fo:root>