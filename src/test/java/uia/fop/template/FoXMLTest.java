package uia.fop.template;

import java.io.File;

import org.junit.Test;

import uia.fop.template.builder.FormBuilder;
import uia.fop.template.builder.PageNumberBuilder;
import uia.fop.template.builder.SimpleFormBuilder;
import uia.fop.template.builder.TableBuilder;

public class FoXMLTest {

    @Test
    public void testSample5() throws Exception {
        FoXML xml = new FoXML();
        xml.createLayout("MA_ORDER_REPORT", Paper.A4)
                .enableHeader()
                .enableFooter();

        FoPage area = xml.addPage("MA_ORDER_REPORT");
        // body
        // body> form
        new FormBuilder(2)
                .addInfo("Name", 0, 0, "order/name")
                .addInfo("Description", 1, 0, "order/description")
                .addInfo("Begin Time", 2, 0, "order/runBeginTime")
                .addInfo("End Time", 3, 0, "order/runEndTime")
                .addInfo("Work Group", 0, 1, "order/workGroup")
                .addInfo("QA Group", 1, 1, "order/qaGroup")
                .addInfo("Freq", 2, 1, "order/freqName")
                .applyToBody(area);
        // body> table
        new TableBuilder(4)
                .createHeaders(new String[] { "Seq No.", "Item Name", "Result", "Remark" })
                .createRowTemplate(new String[] {
                        "seqNo",
                        "itemName",
                        "maResult",
                        "maRemark"
                })
                .applyToBody(area);

        // header
        new SimpleFormBuilder(3)
                .addValuePath("order/id", 0, 0)
                .addValue("MA Order", 0, 1)
                .addValue(ImageBox.fixedHeight(new File("test/image1.png"), 24), 0, 2)
                .applyToHeader(area);

        // footer
        new PageNumberBuilder()
                .applyToFooter(area);

        System.out.println(xml.build());
    }
}
