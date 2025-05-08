/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Table;

import java.awt.Color;
import java.awt.Component;
import java.util.function.Supplier;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**  
 *
 * @author QCU
 */
public class TableActionCellRender extends DefaultTableCellRenderer {
    
    private final Supplier<Integer> editableRowSupplier;

    public TableActionCellRender(Supplier<Integer> editableRowSupplier) {
        this.editableRowSupplier = editableRowSupplier;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        CellPanelAction action = new CellPanelAction();
        action.setEditModeIcon(row == editableRowSupplier.get());
        if (!isSelected && row % 2 == 0){
            action.setBackground(Color.white);
        } else {
            action.setBackground(com.getBackground());
            
        }
        return action;
    }
    
}
