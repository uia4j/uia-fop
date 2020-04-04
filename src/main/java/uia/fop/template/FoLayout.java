package uia.fop.template;

import xml.xslfo.RegionAfter;
import xml.xslfo.RegionBefore;
import xml.xslfo.RegionBody;
import xml.xslfo.Root;
import xml.xslfo.SimplePageMaster;

public class FoLayout {

    public static final String REGION_BODY_NAME = "region-body";

    public static final String REGION_HEADER_NAME = "region-header";

    public static final String REGION_FOOTER_NAME = "region-footer";

    private final Root root;

    private final SimplePageMaster pageMaster;

    FoLayout(Root root, SimplePageMaster pageMaster) {
        this.root = root;
        this.pageMaster = pageMaster;

        RegionBody body = new RegionBody();
        body.setRegionName(REGION_BODY_NAME);
        this.pageMaster.setRegionBody(body);
    }

    public String getName() {
        return this.pageMaster.getMasterName();
    }

    public String getRegionBodyName() {
        return REGION_BODY_NAME;
    }

    public String getRegionHeaderName() {
        return REGION_HEADER_NAME;
    }

    public String getRegionFooterName() {
        return REGION_FOOTER_NAME;
    }

    public boolean isEnableHeader() {
        return this.pageMaster.getRegionBefore() != null;
    }

    public boolean isEnableFooter() {
        return this.pageMaster.getRegionAfter() != null;
    }

    public FoLayout enableHeader() {
        return enableHeader("1cm");
    }

    public FoLayout enableHeader(String marginTop) {
        this.pageMaster.getRegionBody().setMarginTop(marginTop);

        RegionBefore header = new RegionBefore();
        header.setRegionName(REGION_HEADER_NAME);
        this.pageMaster.setRegionBefore(header);
        return this;
    }

    public FoLayout enableFooter() {
        return enableFooter("1cm");
    }

    public FoLayout enableFooter(String marginBottom) {
        this.pageMaster.getRegionBody().setMarginBottom(marginBottom);

        RegionAfter footer = new RegionAfter();
        footer.setRegionName(REGION_FOOTER_NAME);
        this.pageMaster.setRegionAfter(footer);
        return this;
    }
}
