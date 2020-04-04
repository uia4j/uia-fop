package uia.fop.template.builder;

import uia.fop.template.FoTableBuilder;

import xml.xslfo.Block;
import xml.xslfo.Table;
import xml.xslfo.TableBody;
import xml.xslfo.TableCell;
import xml.xslfo.TableColumn;
import xml.xslfo.TableHeader;
import xml.xslfo.TableLayoutType;
import xml.xslfo.TableRow;
import xml.xslfo.TextAlignType;

public class TableBuilder extends FoTableBuilder {

    private Table table;

    private TableBody tableBody;

    private int columns;

    public TableBuilder(int columns) {
        this.table = new Table();
        this.table.setTableLayout(TableLayoutType.AUTO);
        this.table.getMargin().add("0.1mm");
        this.table.setBorder("solid 0.3mm black");
        this.columns = columns;

        // columns
        int w = 100 / columns;
        for (int i = 0; i < columns; i++) {
            TableColumn col = new TableColumn();
            col.getColumnWidth().add(w + "%");
            col.setBorder("solid 0.1mm black");
            this.table.getTableColumn().add(col);
        }

        // body
        this.tableBody = new TableBody();
        this.table.getTableBody().add(this.tableBody);
    }

    @Override
    public Table result() {
        return this.table;
    }

    public TableBuilder createHeaders(String[] headerNames) {
        // rows
        TableRow row = new TableRow();
        row.setBorder("solid 0.1mm black");
        row.setBackgroundColor("#eeeeee");
        for (String headerName : headerNames) {
            Block block = new Block();
            block.setTextAlign(TextAlignType.CENTER);
            block.setFontWeight("bold");
            block.getContent().add(headerName);
            TableCell cell = new TableCell();
            cell.getMarkerOrBlockOrBlockContainer().add(block);

            row.getTableCell().add(cell);
        }
        this.table.setTableHeader(new TableHeader());
        this.table.getTableHeader().getTableRow().add(row);

        return this;
    }

    public TableBuilder createRowTemplate(String[] paths) {
        // rows
        TableRow row = new TableRow();
        row.setBorder("solid 0.1mm black");
        for (int i = 0; i < this.columns; i++) {
            Block block = new Block();
            block.getContent().add(String.format("<xsl:value-of select=\"%s\" />", paths[i]));
            TableCell cell = new TableCell();
            cell.getMarkerOrBlockOrBlockContainer().add(block);

            row.getTableCell().add(cell);
        }
        this.tableBody.getTableRow().add(row);

        return this;
    }
}
