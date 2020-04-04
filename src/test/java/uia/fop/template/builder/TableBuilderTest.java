package uia.fop.template.builder;

import org.junit.Test;

import uia.fop.template.FoPage;
import uia.fop.template.FoXML;
import uia.fop.template.Paper;

public class TableBuilderTest {

    @Test
    public void testXslFoXML() throws Exception {
        FoXML fo = new FoXML();
        fo.createLayout("order", Paper.A4);
        FoPage page = fo.addPage("order");

        new TableBuilder(6)
                .createHeaders(new String[] { "Title", "Artist", "Contry", "Company", "Price", "Year" })
                .createRowTemplate(new String[] {
                        "title",
                        "artist",
                        "country",
                        "company",
                        "price",
                        "year"
                })
                .applyToBody(page);

        System.out.println(fo.build());
    }
}
