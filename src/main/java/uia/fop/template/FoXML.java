package uia.fop.template;

import java.util.TreeMap;

import uia.utils.JaxbUtils;

import xml.xslfo.Flow;
import xml.xslfo.LayoutMasterSet;
import xml.xslfo.PageSequence;
import xml.xslfo.Root;
import xml.xslfo.SimplePageMaster;

public class FoXML {

    public static final String FONT_FAMILY = "Arial,sans-serif,SimHei";

    private Root root;

    private TreeMap<String, FoLayout> layouts;

    public FoXML() {
        this.root = new Root();
        this.root.setLayoutMasterSet(new LayoutMasterSet());

        this.layouts = new TreeMap<>();
    }

    public FoLayout createLayout(String layoutName, Paper paper) {
        FoLayout layout = this.layouts.get(layoutName);
        if (layout != null) {
            return layout;
        }

        SimplePageMaster pageMaster = new SimplePageMaster();
        pageMaster.setMasterName(layoutName);
        paper.apply(pageMaster);
        this.root.getLayoutMasterSet().getSimplePageMasterOrPageSequenceMaster().add(pageMaster);

        layout = new FoLayout(this.root, pageMaster);
        this.layouts.put(layoutName, layout);
        return layout;
    }

    public FoPage addPage(String layoutName) {
        FoLayout layout = this.layouts.get(layoutName);
        if (layout == null) {
            return null;
        }

        PageSequence pageSeq = new PageSequence();
        pageSeq.setFontFamily(FoXML.FONT_FAMILY);
        pageSeq.setMasterReference(layout.getName());
        pageSeq.setFlow(new Flow());
        pageSeq.getFlow().setFlowName(layout.getRegionBodyName());
        this.root.getPageSequence().add(pageSeq);

        return new FoPage(this.root, layout, pageSeq);
    }

    public String build() throws Exception {
        JaxbUtils<xml.xslfo.Root> jaxb = new JaxbUtils<xml.xslfo.Root>(
                xml.xslfo.Root.class,
                "root",
                "http://www.w3.org/1999/XSL/Format",
                "xml.xslfo");
        jaxb.addNamespacePrefix("http://www.w3.org/1999/XSL/Format", "fo");
        jaxb.addNamespacePrefix("http://www.w3.org/1999/XSL/Transform", "xsl");

        return jaxb.toXml(this.root)
                .replace("&lt;", "<")
                .replace("&gt;", ">");
    }
}
