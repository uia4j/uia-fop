package uia.fop.template;

import xml.xslfo.SimplePageMaster;

public final class PaperA4 implements Paper {

    @Override
    public void apply(SimplePageMaster pageMaster) {
        pageMaster.setPageHeight("29.7cm");
        pageMaster.setPageWidth("21.0cm");
        pageMaster.getMargin().add("2cm");
    }
}
