package uia.fop.template;

import xml.xslfo.SimplePageMaster;

public final class PaperA4L implements Paper {

    @Override
    public void apply(SimplePageMaster pageMaster) {
        pageMaster.setPageHeight("21.0cm");
        pageMaster.setPageWidth("29.7cm");
        pageMaster.getMargin().add("2cm");
    }
}
