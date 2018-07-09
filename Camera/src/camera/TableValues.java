/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author GUNDOGAN
 */
public class TableValues extends AbstractTableModel{
    
    public final static String[] columnNames = {
        "ID", "NAME", "AREA","WARNING"
    };

    public Object[][] values = {
        {
            "1", "CAMERA 1","WEST","y"
        
        }, {
            "2", "CAMERA 2","WEST","n"
        }, {
            "3", "CAMERA 3","WEST","n"
        }
    };

    public int getRowCount() {
        return values.length;
    }

    public int getColumnCount() {
        return values[0].length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return values[rowIndex][columnIndex];
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}
