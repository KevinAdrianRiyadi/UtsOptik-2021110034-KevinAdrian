/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utsoptik_pkg_2021110034;

import java.sql.Date;

/**
 *
 * @author Raymond
 */
public class PaymentModel {
    public int paymentid, customerid, orderid, jumlahpembayaran;
    public String jenispembayaran;
    public Date tanggalpembayaran;

    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getJumlahpembayaran() {
        return jumlahpembayaran;
    }

    public void setJumlahpembayaran(int jumlahpembayaran) {
        this.jumlahpembayaran = jumlahpembayaran;
    }

    public String getJenispembayaran() {
        return jenispembayaran;
    }

    public void setJenispembayaran(String jenispembayaran) {
        this.jenispembayaran = jenispembayaran;
    }

    public Date getTanggalpembayaran() {
        return tanggalpembayaran;
    }

    public void setTanggalpembayaran(Date tanggalpembayaran) {
        this.tanggalpembayaran = tanggalpembayaran;
    }
    
    
    
}
