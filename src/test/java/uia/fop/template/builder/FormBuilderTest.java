package uia.fop.template.builder;

import org.junit.Test;

import uia.fop.template.FoPage;
import uia.fop.template.FoXML;
import uia.fop.template.Paper;

public class FormBuilderTest {

    @Test
    public void test() throws Exception {
        FoXML fo = new FoXML();
        fo.createLayout("order", Paper.A4)
                .enableHeader()
                .enableFooter();

        FoPage page = fo.addPage("order");
        new FormBuilder(2)
                .addLabel("Title", 0, 0)
                .addValuePath("title", 0, 0)
                .addLabel("Updated Time", 0, 1)
                .addValuePath("updatedTime", 0, 1)
                .applyToBody(page);

        new PageNumberBuilder()
                .applyToFooter(page);

        System.out.println(fo.build());
    }
}
