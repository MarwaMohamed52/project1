/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.invoice.display;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marwa
 */
public class bylinetabel extends AbstractTableModel{
    private ArrayList<Line>linne;
    private String[] cols={"No.","ItemName","ItemPrice","Count","ItemTotal"};

    public bylinetabel(ArrayList<Line> linne) {
        this.linne = linne;
    }

    @Override
    public int getRowCount() {
     return linne.size()  ;  }

    @Override
    public int getColumnCount() {
       return cols.length;
               }
    public String getColumnName(int col2){
        return cols[col2];
    }
   
    public Object getValueAt(int rowIndex, int columnIndex) {
         Line l=linne.get(rowIndex);
          switch(columnIndex){
            case 0:return l.getInvoice().getNum();
            case 1:return l.getItem();
            case 2:return l.getPrice();
            case 3:return l.getCount();
            case 4:return l.getLtotal();
            default:return "";
    } 
}
}
