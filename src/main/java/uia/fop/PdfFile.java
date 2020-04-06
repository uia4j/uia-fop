package uia.fop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

/**
 * Hello world!
 *
 */
public class PdfFile {

    private final File fopConfXml;

    public static PdfFile newInstance() {
        return new PdfFile(null);
    }

    public static PdfFile newInstance(File fopConfXml) {
        return new PdfFile(fopConfXml);
    }

    private PdfFile(File fopConfXml) {
        this.fopConfXml = fopConfXml;
    }

    public void saveAs(File xmlFile, File xsltFile, File pdfFile) throws Exception {
        try {
            System.out.println(new File(".").getAbsolutePath());
            // configure fopFactory as desired
            final FopFactory fopFactory = this.fopConfXml == null
                    ? FopFactory.newInstance(new File(".").toURI())
                    : FopFactory.newInstance(this.fopConfXml);

            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            // configure foUserAgent as desired

            // Setup output
            try (OutputStream out = new java.io.BufferedOutputStream(new FileOutputStream(pdfFile))) {
                // Construct fop with desired output format
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

                // Setup XSLT
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

                // Setup input for XSLT transformation
                Source src = new StreamSource(xmlFile);

                // Resulting SAX events (the generated FO) must be piped through to FOP
                Result res = new SAXResult(fop.getDefaultHandler());

                // Start XSLT transformation and FOP processing
                transformer.transform(src, res);
            }
            catch (FOPException | TransformerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}
