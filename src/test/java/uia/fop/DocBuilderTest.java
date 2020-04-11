package uia.fop;

import java.io.File;

import org.junit.Test;

public class DocBuilderTest {

    /**
     * A4 table.
     *
     * @throws Exception
     */
    @Test
    public void testSample1() throws Exception {
        new DocBuilder()
                .data(new File("test/sample1.xml"))
                .style(new File("test/sample1.xslt"))
                .output(new File("test/output/sample1.pdf"));
    }

    /**
     * A4 form.
     *
     * @throws Exception
     */
    @Test
    public void testSample2() throws Exception {
        new DocBuilder()
                .data(new File("test/sample2.xml"))
                .style(new File("test/sample2.xslt"))
                .output(new File("test/output/sample2.pdf"));
    }

    /**
     * A4L form and table.
     *
     * @throws Exception
     */
    @Test
    public void testSample3() throws Exception {
        new DocBuilder()
                .data(new File("test/sample3.xml"))
                .style(new File("test/sample3.xslt"))
                .output(new File("test/output/sample3.pdf"));
    }

    /**
     * with fop.xml configuration.
     *
     * @throws Exception
     */
    @Test
    public void testSample4() throws Exception {
        new DocBuilder()
                .data(new File("test/sample4.xml"))
                .style(new File("test/sample4.xslt"))
                .output(new File("test/output/sample4.pdf"));
    }

    /**
     * multiple pages.
     *
     * @throws Exception
     */
    @Test
    public void testSample5() throws Exception {
        new DocBuilder(new File("conf/fop.xml"))
                .data(new File("test/sample5.xml"))
                .style(new File("test/sample5.xslt"))
                .output(new File("test/output/sample5.pdf"));
    }

    /**
     * MS Word template.
     *
     * @throws Exception
     */
    @Test
    public void testMsword() throws Exception {
        new DocBuilder(new File("conf/fop.xml"))
                .data(new File("test/msword.xml"))
                .style(new File("test/msword.xslt"))
                .output(new File("test/output/msword.pdf"));
    }
}
