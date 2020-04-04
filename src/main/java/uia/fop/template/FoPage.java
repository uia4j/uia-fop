package uia.fop.template;

import xml.xslfo.PageSequence;
import xml.xslfo.Root;
import xml.xslfo.StaticContent;

public class FoPage {

    private final FoLayout layout;

    private final PageSequence pageSeq;

    FoPage(Root root, FoLayout layout, PageSequence pageSeq) {
        this.layout = layout;
        this.pageSeq = pageSeq;
    }

    public void setId(String id) {
        this.pageSeq.setId(id);
    }

    public String getId() {
        return this.pageSeq.getId();
    }

    public FoPage setMainContent(FoTableBuilder builder) {
        this.pageSeq.getFlow()
                .getMarkerOrBlockOrBlockContainer()
                .add(builder.result());
        return this;
    }

    public FoPage addHeaderContent(FoTableBuilder builder) {
        StaticContent sc = new StaticContent();
        sc.setFlowName(FoLayout.REGION_HEADER_NAME);
        sc.getBlockOrBlockContainerOrTable().add(builder.result());
        this.pageSeq.getStaticContent().add(sc);
        return this;
    }

    public FoPage addFooterContent(FoTableBuilder builder) {
        StaticContent sc = new StaticContent();
        sc.setFlowName(FoLayout.REGION_FOOTER_NAME);
        sc.getBlockOrBlockContainerOrTable().add(builder.result());
        this.pageSeq.getStaticContent().add(sc);
        return this;
    }
}
