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

public class SimpleFormBuilder extends FoTableBuilder {

    private Table table;

    private TableBody tableBody;

    private int columns;

    public SimpleFormBuilder(int columns) {
        this.table = new Table();
        this.table.setMarginBottom("3mm");
        this.columns = columns;

        // columns
        int w = 100 / columns;
        for (int i = 0; i < columns; i++) {
            TableColumn col1 = new TableColumn();
            col1.getColumnWidth().add(w + "%");
            this.table.getTableColumn().add(col1);
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

    public SimpleFormBuilder addValue(String value, int rowIndex, int columnIndex) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.setMarginRight("0.1mm");
        block.getContent().add(value);
        cells.get(columnIndex).getMarkerOrBlockOrBlockContainer().add(block);

        return this;
    }

    public SimpleFormBuilder addValuePath(String path, int rowIndex, int columnIndex) {
        TableRow row = buildRow(rowIndex);
        List<TableCell> cells = row.getTableCell();

        Block block = new Block();
        block.setMarginRight("0.1mm");
        block.getContent().add(String.format("<xsl:value-of select=\"%s\" />", path));
        cells.get(columnIndex).getMarkerOrBlockOrBlockContainer().add(block);

        return this;
    }

    private TableRow buildRow(int rowIndex) {
        List<TableRow> rows = this.tableBody.getTableRow();
        while (rows.size() < (rowIndex + 1)) {
            TableRow row = new TableRow();
            row.setDisplayAlign(DisplayAlignType.CENTER);
            row.setHeight("16px");
            List<TableCell> cells = row.getTableCell();
            for (int i = 0; i < this.columns; i++) {
                TableCell cell = new TableCell();
                cells.add(cell);
            }

            rows.add(row);
        }

        return rows.get(rowIndex);
    }
}
