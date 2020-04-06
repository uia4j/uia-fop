package uia.fop;

import java.io.File;

import org.junit.Test;

public class PdfFileTest {

    /**
     * table.
     *
     * @throws Exception
     */
    @Test
    public void testSample2() throws Exception {
        PdfFile.newInstance().saveAs(
                new File("test/sample3.xml"),
                new File("test/sample3.xslt"),
                new File("test/sample3.pdf"));
    }

    /**
     * form.
     *
     * @throws Exception
     */
    @Test
    public void testSample3() throws Exception {
        PdfFile.newInstance().saveAs(
                new File("test/sample3.xml"),
                new File("test/sample3.xslt"),
                new File("test/sample3.pdf"));
    }

    /**
     * form and table.
     *
     * @throws Exception
     */
    @Test
    public void testSample4() throws Exception {
        PdfFile.newInstance().saveAs(
                new File("test/sample4.xml"),
                new File("test/sample4.xslt"),
                new File("test/sample4.pdf"));
    }

    /**
     * multiple pages.
     *
     * @throws Exception
     */
    @Test
    public void testSample5() throws Exception {
        PdfFile.newInstance().saveAs(
                new File("test/sample5.xml"),
                new File("test/sample5.xslt"),
                new File("test/sample5.pdf"));
    }

    /**
     * MS Word template.
     *
     * @throws Exception
     */
    @Test
    public void testMsword() throws Exception {
        PdfFile.newInstance().saveAs(
                new File("test/msword.xml"),
                new File("test/msword.xslt"),
                new File("test/msword.pdf"));
    }
}
