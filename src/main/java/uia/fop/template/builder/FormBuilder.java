package uia.fop.template.builder;

import java.util.List;

import uia.fop.template.FoTableBuilder;

import xml.xslfo.Block;
import xml.xslfo.Table;
import xml.xslfo.TableBody;
import xml.xslfo.TableCell;
import xml.xslfo.TableColumn;
import xml.xslfo.TableRow;
import xml.xslfo.TextAlignType;

public class FormBuilder extends FoTableBuilder {

    private Table table;

    private TableBody tableBody;

    private int columns;

    public FormBuilder(int columns) {
        this.table = new Table();
        this.table.setMarginBottom("1cm");
        this.columns = columns;

        // columns
        int w = 100 / columns;
        int w1 = (int) (0.4 * w);
        int w2 = w - w1;
        for (int i = 0; i < columns; i++) {
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
        return this.table;
    }

    public FormBuilder addLabel(String label, int rowIndex, int columnIndex) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.setFontWeight("bold");
        block.setMarginRight("0.1mm");
        block.setTextAlign(TextAlignType.RIGHT);
        block.getContent().add(label);
        cells.get(2 * columnIndex).getMarkerOrBlockOrBlockContainer().add(block);

        return this;
    }

    public FormBuilder addLabel(String label, int rowIndex, int columnIndex, String path) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.setFontWeight("bold");
        block.setMarginRight("0.1mm");
        block.setTextAlign(TextAlignType.RIGHT);
        block.getContent().add(label);
        cells.get(2 * columnIndex).getMarkerOrBlockOrBlockContainer().add(block);

        return addValuePath(path, rowIndex, columnIndex);
    }

    public FormBuilder addValue(String value, int rowIndex, int columnIndex) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.getContent().add(value);
        cells.get(2 * columnIndex + 1).getMarkerOrBlockOrBlockContainer().add(block);

        return this;
    }

    public FormBuilder addValuePath(String path, int rowIndex, int columnIndex) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.getContent().add(String.format("<xsl:value-of select=\"%s\" />", path));
        cells.get(2 * columnIndex + 1).getMarkerOrBlockOrBlockContainer().add(block);

        return this;
    }

    private TableRow buildRow(int rowIndex) {
        List<TableRow> rows = this.tableBody.getTableRow();
        while (rows.size() < (rowIndex + 1)) {
            TableRow row = new TableRow();
            List<TableCell> cells = row.getTableCell();
            while (cells.size() < (2 * this.columns)) {
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
