package uia.fop.template;

import xml.xslfo.Table;

public abstract class FoTableBuilder {

    public abstract Table result();

    public void applyToBody(FoPage pageSeq) {
        pageSeq.setMainContent(this);
    }

    public void applyToHeader(FoPage pageSeq) {
        pageSeq.addHeaderContent(this);
    }

    public void applyToFooter(FoPage pageSeq) {
        pageSeq.addFooterContent(this);
    }
}
