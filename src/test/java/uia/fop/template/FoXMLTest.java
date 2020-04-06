package uia.fop.template;

import org.junit.Test;

import uia.fop.template.builder.FormBuilder;
import uia.fop.template.builder.PageNumberBuilder;
import uia.fop.template.builder.SimpleFormBuilder;
import uia.fop.template.builder.TableBuilder;

public class FoXMLTest {

    @Test
    public void test() throws Exception {
        FoXML xml = new FoXML();
        xml.createLayout("MA_ORDER_REPORT", Paper.A4)
                .enableHeader()
                .enableFooter();

        FoPage area = xml.addPage("MA_ORDER_REPORT");
        // body
        new FormBuilder(2)
                .addInfo("保養工單", 0, 0, "order/name")
                .addInfo("說明", 1, 0, "order/description")
                .addInfo("開始時間", 2, 0, "order/runBeginTime")
                .addInfo("結束時間", 3, 0, "order/runEndTime")
                .addInfo("工作群組", 0, 1, "order/workGroup")
                .addInfo("品保群組", 1, 1, "order/qaGroup")
                .addInfo("頻率", 2, 1, "order/freqName")
                .applyToBody(area);
        new TableBuilder(4)
                .createHeaders(new String[] { "項次", "保養項目名稱", "結果", "備註" })
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
                .addValuePath("order/runBeginTime", 0, 2)
                .applyToHeader(area);

        // footer
        new PageNumberBuilder()
                .applyToFooter(area);

        System.out.println(xml.build());
    }
}
