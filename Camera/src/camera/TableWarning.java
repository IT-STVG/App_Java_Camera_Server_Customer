/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camera;

import static camera.TableValues.columnNames;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.table.AbstractTableModel;
public class TableWarning extends AbstractTableModel{
    public final static String[] columnNames={"ID","WARNING","TIME","AREA"};
    
    public Object[][] values={
        {"1","y","17-02-1997","WEST"},
        {"2","y","17-03-1997","WEST"},
        {"3","N","17-04-1997","WEST"}
    };

    @Override
    public int getRowCount() {
        return values.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return values[0].length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return values[i][i1]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column){
        return columnNames[column];
    }
}
