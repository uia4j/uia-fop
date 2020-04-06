package uia.fop.template;

import java.io.File;

import org.junit.Test;

public class MSWordTest {

    @Test
    public void test() throws Exception {
        MSWord xml = new MSWord(new File("test/msword.docx"));
        System.out.println(xml.toOpenXMLFormat());
        System.out.println(xml.toXslFo());
    }

    @Test
    public void testSave() throws Exception {
        MSWord xml = new MSWord(new File("test/msword.docx"));
        xml.saveXslFo(new File("test/msword.xslt"));
    }
}
