
package com.invoice.control;

import com.invoice.display.Invoice;
import com.invoice.display.Line;
import com.invoice.display.displaytable;
import com.invoice.main.invoiceframe;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Controller implements ActionListener ,ListSelectionListener{
    private invoiceframe fm;
    public Controller(invoiceframe fm)
    {
        this.fm=fm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand=e.getActionCommand();
        System.out.println("Action"+actionCommand);
       switch (actionCommand){
            case "Load File" -> LoadFile();
            case "Save File" -> SaveFile();
              case "Create New Invoice" -> CreateNewInvoice();
              case "Delete Invoice" -> DeleteInvoice();
              case "Save" -> Save();
              case "Cancel" -> Cancel();
       }}
    

    private void Cancel() {
    }

    private void Save() {
    }

    private void DeleteInvoice() {
    }

    private void CreateNewInvoice() {
    }

    private void SaveFile() {
    }
  public void valueChanged(ListSelectionEvent e) {
      System.out.println("you have selected row:"+fm.getInvoicetable().getSelectedRow());
  }
    private void LoadFile() {
        JFileChooser fc=new JFileChooser();
        try{
       int action =fc.showOpenDialog(fm);
     if  (action==JFileChooser.APPROVE_OPTION){
        File headerFile= fc.getSelectedFile();
       Path headerPath= Paths.get(headerFile.getAbsolutePath());

   List<String> headerlines = Files.readAllLines(headerPath);
       System.out.println("Invoices have been read");
        ArrayList<Invoice> invoiceArray=new ArrayList<>();
       for(String headerline :headerlines){
          String[]headerParts= headerline.split(",");
          int invoicenumber=Integer.parseInt(headerParts[0]);
          
          String invoicedate=headerParts[1];
        String customername=headerParts[2];
        Invoice invoice=new Invoice(invoicenumber,invoicedate, customername);
        invoiceArray.add(invoice);
       }
       System.out.println("check point");
       action=fc.showOpenDialog(fm);
       if  (action==JFileChooser.APPROVE_OPTION);{
            File lineFile= fc.getSelectedFile();
             Path linePath= Paths.get(lineFile.getAbsolutePath());
            List<String>lineLines=Files.readAllLines(linePath);
               System.out.println("lines have been read");
                 for(String lineLine :lineLines){
          String[]lineParts= lineLine.split(",");
          int invoicenumber=Integer.parseInt(lineParts[0]);
          String itemName=lineParts[1];
          double itemPrice=Double.parseDouble(lineParts[2]);
          int count=Integer.parseInt(lineParts[3]);
          Invoice inve=null;
          for(Invoice invoice:invoiceArray){
          if(invoice.getNum()== invoicenumber){
              inve=invoice;
              break;
          }
          }
                Line line=new Line(itemName,itemPrice,count,inve);
                         inve.getLines().add(line);
                        
                 }System.out.println("check point");
          
               } fm.setInvoices(invoiceArray);
               displaytable dst=new displaytable(invoiceArray);
               fm.setdisplaytable(dst);
               fm.getInvoicetable().setModel(dst);
               
       
        }
    } catch(IOException ex){
        ex.printStackTrace();
       
    }
}

    
}