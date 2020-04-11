package uia.fop.template.builder;

import java.util.List;

import uia.fop.template.FoTableBuilder;

import xml.xslfo.Block;
import xml.xslfo.DisplayAlignType;
import xml.xslfo.Table;
import xml.xslfo.TableBody;
import xml.xslfo.TableCell;
import xml.xslfo.TableColumn;
import xml.xslfo.TableRow;
import xml.xslfo.TextAlignType;

public class FormBuilder extends FoTableBuilder {

    private Table table;

    private TableBody tableBody;

    private int columnCount;

    public FormBuilder(int columnCount) {
        this.table = new Table();
        this.table.setMarginBottom("3mm");
        this.columnCount = columnCount;

        // columns
        int w = 100 / columnCount;
        int w1 = (int) (0.4 * w);
        int w2 = w - w1;
        for (int i = 0; i < columnCount; i++) {
            TableColumn col1 = new TableColumn();
            col1.getColumnWidth().add(w1 + "%");
            this.table.getTableColumn().add(col1);

            TableColumn col2 = new TableColumn();
            col2.getColumnWidth().add(w2 + "%");
            this.table.getTableColumn().add(col2);
        }

        // body
        this.tableBody = new TableBody();
        this.table.getTableBody().add(this.tableBody);
    }

    @Override
    public Table result() {
        for (TableRow row : this.tableBody.getTableRow()) {
            for (TableCell cell : row.getTableCell()) {
                if (cell.getMarkerOrBlockOrBlockContainer().isEmpty()) {
                    cell.getMarkerOrBlockOrBlockContainer()
                            .add(new Block());
                }
            }
        }
        return this.table;
    }

    public FormBuilder addInfo(String label, int rowIndex, int columnIndex, String xsltSelect) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.setFontWeight("bold");
        block.setMarginRight("0.1cm");
        block.setTextAlign(TextAlignType.RIGHT);
        block.getContent().add(label);
        cells.get(2 * columnIndex).getMarkerOrBlockOrBlockContainer().add(block);

        return addValueSelect(xsltSelect, rowIndex, columnIndex);
    }

    public FormBuilder addLabel(String label, int rowIndex, int columnIndex) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.setFontWeight("bold");
        block.setMarginRight("0.1cm");
        block.setTextAlign(TextAlignType.RIGHT);
        block.getContent().add(label);
        cells.get(2 * columnIndex).getMarkerOrBlockOrBlockContainer().add(block);

        return this;
    }

    public FormBuilder addValue(String value, int rowIndex, int columnIndex) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.getContent().add(value);
        cells.get(2 * columnIndex + 1).getMarkerOrBlockOrBlockContainer().add(block);

        return this;
    }

    public FormBuilder addValueSelect(String xsltSelect, int rowIndex, int columnIndex) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.getContent().add(String.format("<xsl:value-of select=\"%s\" />", xsltSelect));
        cells.get(2 * columnIndex + 1).getMarkerOrBlockOrBlockContainer().add(block);

        return this;
    }

    private TableRow buildRow(int rowIndex) {
        List<TableRow> rows = this.tableBody.getTableRow();
        while (rows.size() < (rowIndex + 1)) {
            TableRow row = new TableRow();
            row.setDisplayAlign(DisplayAlignType.CENTER);
            row.setHeight("16px");
            List<TableCell> cells = row.getTableCell();
            while (cells.size() < (2 * this.columnCount)) {
                TableCell cellLabel = new TableCell();
                cells.add(cellLabel);

                TableCell cellContent = new TableCell();
                cells.add(cellContent);
            }

            rows.add(row);
        }

        return rows.get(rowIndex);
    }
}
