/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

import java.awt.Color;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author QCU
 */
public class TableActionCellEditor extends DefaultCellEditor {
    
    private final TableActionEvent event;
    private final Supplier<Integer> editableRowSupplier;
    
    public TableActionCellEditor(TableActionEvent event, Supplier<Integer> editableRowSupplier) {
        super(new JCheckBox());
        this.event = event;
        this.editableRowSupplier = editableRowSupplier;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        CellPanelAction action = new CellPanelAction();
        action.initEvent(event, row);
        action.setEditModeIcon(row == editableRowSupplier.get());
        action.setBackground(table.getSelectionBackground());
        return action;
    }
    
}
