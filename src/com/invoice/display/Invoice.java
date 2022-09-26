
package com.invoice.display;

import java.util.ArrayList;


public class Invoice {
    private int num;
    private String date;
    private String customer;
    private ArrayList<Line> lines;

    public Invoice() {
    }

    public Invoice(int num, String date, String customer) {
        this.num = num;
        this.date = date;
        this.customer = customer;
    }
   
    
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
     public double gettottal()
    { double total1=0;
    for(Line linee:getLines()){
        total1+=linee.getLtotal();
    }
    
    
        return total1;}

    public ArrayList<Line> getLines() {
        if (lines==null){
            lines=new ArrayList<>();
        }
        return lines;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" + "num=" + num + ", date=" + date + ", customer=" + customer + '}';
    }
    
}
