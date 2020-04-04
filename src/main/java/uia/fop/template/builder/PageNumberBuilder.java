package uia.fop.template.builder;

import java.util.List;

import uia.fop.template.FoTableBuilder;

import xml.xslfo.Block;
import xml.xslfo.PageNumber;
import xml.xslfo.Table;
import xml.xslfo.TableBody;
import xml.xslfo.TableCell;
import xml.xslfo.TableColumn;
import xml.xslfo.TableRow;
import xml.xslfo.TextAlignType;

public class PageNumberBuilder extends FoTableBuilder {

    private Table table;

    private TableBody tableBody;

    public PageNumberBuilder() {
        this.table = new Table();
        this.table.setMarginBottom("1cm");

        // columns
        TableColumn left = new TableColumn();
        left.getColumnWidth().add("40%");
        this.table.getTableColumn().add(left);

        TableColumn center = new TableColumn();
        center.getColumnWidth().add("20%");
        this.table.getTableColumn().add(center);

        TableColumn right = new TableColumn();
        right.getColumnWidth().add("40%");
        this.table.getTableColumn().add(right);

        // body
        this.tableBody = new TableBody();
        this.table.getTableBody().add(this.tableBody);

        // left
        TableRow row = new TableRow();
        List<TableCell> cells = row.getTableCell();
        TableCell cellLeft = new TableCell();
        cells.add(cellLeft);
        Block blockLeft = new Block();
        cellLeft.getMarkerOrBlockOrBlockContainer().add(blockLeft);

        // center
        TableCell cellCenter = new TableCell();
        cells.add(cellCenter);
        Block blockPN = new Block();
        blockPN.setTextAlign(TextAlignType.CENTER);
        blockPN.getContent().add(new PageNumber());
        cellCenter.getMarkerOrBlockOrBlockContainer().add(blockPN);

        // right
        TableCell cellRight = new TableCell();
        cells.add(cellRight);
        Block blockRight = new Block();
        blockRight.setTextAlign(TextAlignType.RIGHT);
        cellRight.getMarkerOrBlockOrBlockContainer().add(blockRight);

        this.tableBody.getTableRow().add(row);
    }

    @Override
    public Table result() {
        return this.table;
    }
}
