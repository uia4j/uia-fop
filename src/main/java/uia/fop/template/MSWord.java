package uia.fop.template;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;

import org.docx4j.Docx4J;
import org.docx4j.XmlUtils;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.convert.out.common.Exporter;
import org.docx4j.convert.out.fo.FOExporterVisitor;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class MSWord {

    private final WordprocessingMLPackage wordMLPackage;

    public MSWord(File file) throws Docx4JException {
        this.wordMLPackage = WordprocessingMLPackage.load(file);
    }

    public String toOpenXMLFormat() {
        return XmlUtils.marshaltoString(
                this.wordMLPackage.getMainDocumentPart().getJaxbElement(),
                true,
                true);
    }

    public String toXslFo() throws Docx4JException {
        OutputStream baos = new ByteArrayOutputStream();
        Exporter<FOSettings> exporter = FOExporterVisitor.getInstance();
        FOSettings settings = Docx4J.createFOSettings();
        settings.setWmlPackage(this.wordMLPackage);
        settings.setApacheFopMime(FOSettings.INTERNAL_FO_MIME);
        exporter.export(settings, baos);

        try {
            return ((ByteArrayOutputStream) baos).toString("UTF-8");
        }
        catch (Exception ex) {
            throw new Docx4JException(ex.getMessage(), ex);
        }
    }

    public void saveXslFo(File file) throws Docx4JException {
        OutputStream baos = new ByteArrayOutputStream();
        Exporter<FOSettings> exporter = FOExporterVisitor.getInstance();
        FOSettings settings = Docx4J.createFOSettings();
        settings.setWmlPackage(this.wordMLPackage);
        settings.setApacheFopMime(FOSettings.INTERNAL_FO_MIME);
        settings.setFoDumpFile(file);
        exporter.export(settings, baos);
    }
}
