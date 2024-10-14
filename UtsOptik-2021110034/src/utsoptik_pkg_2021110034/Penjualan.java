package utsoptik_pkg_2021110034;

import java.sql.Date;

public class Penjualan {
    private int orderID;
    private Date Date;
    private int totalHarga;

    public Penjualan(int orderID, Date Date, int totalHarga) {
        this.orderID = orderID;
        this.Date = Date;
        this.totalHarga = totalHarga;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    @Override
    public String toString() {
        return ", customer ID: " + orderID + 
               ", Tanggal: " + Date + 
               ", Total Harga: Rp" + totalHarga;
    }
}
