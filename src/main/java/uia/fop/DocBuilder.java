package uia.fop;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

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
import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class DocBuilder {

    private final FopFactory fopFactory;

    private InputStream xmlInput;

    private InputStream xsltInput;

    public DocBuilder() throws SAXException, IOException {
        this(null);
    }

    public DocBuilder(File fopConfXml) throws SAXException, IOException {
        this.fopFactory = fopConfXml == null
                ? FopFactory.newInstance(new File(".").toURI())
                : FopFactory.newInstance(fopConfXml);
    }

    public DocBuilder data(String xml, String charsetName) throws UnsupportedEncodingException {
        this.xmlInput = new ByteArrayInputStream(xml.getBytes(charsetName));
        return this;
    }

    public DocBuilder data(File xmlFile) throws FileNotFoundException {
        this.xmlInput = new FileInputStream(xmlFile);
        return this;
    }

    public DocBuilder data(InputStream xmlInput) {
        this.xmlInput = xmlInput;
        return this;
    }

    public DocBuilder style(File xsltFile) throws FileNotFoundException {
        this.xsltInput = new FileInputStream(xsltFile);
        return this;
    }

    public DocBuilder style(InputStream xsltInput) {
        this.xsltInput = xsltInput;
        return this;
    }

    public void output(File pdfFile) throws UnsupportedEncodingException, IOException, FOPException, TransformerException {
        try (OutputStream pdfOutput = new java.io.BufferedOutputStream(new FileOutputStream(pdfFile))) {
            output(this.xmlInput, this.xsltInput, pdfOutput);
        }
    }

    public void output(OutputStream pdfOutput) throws UnsupportedEncodingException, IOException, FOPException, TransformerException {
        output(this.xmlInput, this.xsltInput, pdfOutput);
    }

    private void output(InputStream xmlInput, InputStream xsltInput, OutputStream pdfOutput) throws FOPException, TransformerException {
        // configure foUserAgent as desired
        FOUserAgent foUserAgent = this.fopFactory.newFOUserAgent();

        // Setup output
        // Construct fop with desired output format
        Fop fop = this.fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, pdfOutput);

        // Setup XSLT
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(new StreamSource(xsltInput));

        // Setup input for XSLT transformation
        Source src = new StreamSource(xmlInput);

        // Resulting SAX events (the generated FO) must be piped through to FOP
        Result res = new SAXResult(fop.getDefaultHandler());

        // Start XSLT transformation and FOP processing
        transformer.transform(src, res);
    }
}
