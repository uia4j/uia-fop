package uia.fop.template.builder;

import java.io.File;

import org.junit.Test;

import uia.fop.template.FoPage;
import uia.fop.template.FoXML;
import uia.fop.template.ImageBox;
import uia.fop.template.Paper;

public class SimpleFormBuilderTest {

    @Test
    public void test() throws Exception {
        FoXML fo = new FoXML();
        fo.createLayout("order", Paper.A4)
                .enableHeader()
                .enableFooter();

        FoPage page = fo.addPage("order");
        new SimpleFormBuilder(3)
                .addValue(ImageBox.fixedHeight(new File("test/image1.png"), 64), 0, 0)
                .applyToBody(page);

        new PageNumberBuilder()
                .applyToFooter(page);

        System.out.println(fo.build());
    }
}
