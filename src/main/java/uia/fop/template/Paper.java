package uia.fop.template;

import xml.xslfo.SimplePageMaster;

public interface Paper {

    public final static Paper A4 = new PaperA4();

    public final static Paper A4L = new PaperA4L();

    public void apply(SimplePageMaster pageMaster);
}
