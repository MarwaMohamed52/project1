
package com.invoice.display;
public class Line {
    private int num;
    private String item;
    private double price;
    private int count;
    private Invoice invoice;

    public Line() {
    }

    public Line(int num, String item, double price, int count) {
       
        this.item = item;
        this.price = price;
        this.count = count;
    }

    public Line(String item, double price, int count, Invoice invoice) {
        this.item = item;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }
public double getLtotal()
{return price*count;
}
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

   
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String tostring(){
        return "Line{" + "num=" + invoice.getNum() + ", item=" + item + ", price=" +price + ", count=" + count + '}';
    }

    public Invoice getInvoice() {
        return invoice;
    }
}
