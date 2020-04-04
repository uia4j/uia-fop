package uia.fop;

import java.io.File;

import org.junit.Test;

public class PdfFileTest {

    @Test
    public void testSample2() throws Exception {
        PdfFile.newInstance().save(
                new File("test/sample2.pdf"),
                new File("test/sample2.xml"),
                new File("test/sample2.xslt"));
    }

    @Test
    public void testSample3() throws Exception {
        PdfFile.newInstance().save(
                new File("test/sample3.pdf"),
                new File("test/sample3.xml"),
                new File("test/sample3.xslt"));
    }

    @Test
    public void testSample4() throws Exception {
        PdfFile.newInstance(new File("conf/fop.xml")).save(
                new File("test/sample4.pdf"),
                new File("test/sample4.xml"),
                new File("test/sample4.xslt"));
    }

    @Test
    public void testSample5() throws Exception {
        PdfFile.newInstance(new File("conf/fop.xml")).save(
                new File("test/sample5.pdf"),
                new File("test/sample5.xml"),
                new File("test/sample5.xslt"));
    }
}
