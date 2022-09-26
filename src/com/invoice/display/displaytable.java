
package com.invoice.display;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



public class displaytable extends AbstractTableModel {
    private  ArrayList<Invoice> invoices;
    private String[] cols={"No.","Date","Customer","Total"};

    public displaytable(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }
    

    @Override
    public int getRowCount() {
        return invoices.size();}

    @Override
    public int getColumnCount() {
        return cols.length;
    }
  

    @Override
  public String  getColumnName(int col1){
      return cols[col1]
    ;
}
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice inv=invoices.get(rowIndex);
        switch(columnIndex){
            case 0:return inv.getNum();
            case 1:return inv.getDate();
            case 2:return inv.getCustomer();
            case 3:return inv.gettottal();
            default:return "";
        }
    }
}
