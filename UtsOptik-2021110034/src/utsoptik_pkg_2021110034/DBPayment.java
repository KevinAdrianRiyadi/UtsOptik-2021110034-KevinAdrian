/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utsoptik_pkg_2021110034;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/**
 *
 * @author Raymond
 */
public class DBPayment {

    private PaymentModel pm = new PaymentModel();

    public PaymentModel getPaymentModel() {
        return (pm);
    }

    public void setPaymentModel(PaymentModel s) {
        pm = s;
    }

    public ObservableList<PaymentModel> Load() {
        try {
            ObservableList<PaymentModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select paymentid, customerid, orderid, jenispembayaran, jumlahpembayara, tanggalpembayara from payment");
            int i = 1;
            while (rs.next()) {
                PaymentModel d = new PaymentModel();
                d.setPaymentid(rs.getInt("paymentid"));
                d.setCustomerid(rs.getInt("customerid"));
                d.setOrderid(rs.getInt("orderid"));
                d.setJenispembayaran(rs.getString("jenispembayaran"));
                d.setJumlahpembayaran(rs.getInt("jumlahpembayaran"));
                d.setTanggalpembayaran(rs.getDate("tanggalpembayaran"));
                tableData.add(d);
                i++;
            }
            con.tutupKoneksi();
            return tableData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int validasi(String nomor, String kode) {
        int val = 0;
        try {
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery(
                    "select count(*) as jml from payment where paymentid = '" + nomor
                    + "' ");
            while (rs.next()) {
                val = rs.getInt("jml");
            }
            con.tutupKoneksi();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    public boolean insert() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
            "insert into customer (paymentid, customerid, orderid, jenispembayaran, jumlahpembayaran, tanggalpembayaran) values (?,?,?,?)");
            con.preparedStatement.setInt(1, getPaymentModel().getPaymentid());
            con.preparedStatement.setInt(2, getPaymentModel().getCustomerid());
            con.preparedStatement.setInt(3, getPaymentModel().getOrderid());
            con.preparedStatement.setString(4, getPaymentModel().getJenispembayaran());
            con.preparedStatement.setInt(5, getPaymentModel().getJumlahpembayaran());
            con.preparedStatement.setDate(6, getPaymentModel().getTanggalpembayaran());
            con.preparedStatement.executeQuery();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean delete(String nomor, String kode) {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();;
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from payment where paymentid  = ?");
            con.preparedStatement.setString(1, nomor);
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }

    public boolean update() {
        boolean berhasil = false;
        Koneksi con = new Koneksi();
        try {
            con.bukaKoneksi();
            con.preparedStatement = con.dbKoneksi.prepareStatement(
                    "update payment set customer = ?, order = ?, jenispembayaran = ?, jumlahpembayaran = ?, tanggalpembayaran = ?  where  paymentid = ? ");
            con.preparedStatement.setInt(1, getPaymentModel().getPaymentid());
            con.preparedStatement.setInt(2, getPaymentModel().getOrderid());
            con.preparedStatement.setString(3, getPaymentModel().getJenispembayaran());
             con.preparedStatement.setInt(4, getPaymentModel().getJumlahpembayaran());
              con.preparedStatement.setDate(5, getPaymentModel().getTanggalpembayaran());
            con.preparedStatement.executeUpdate();
            berhasil = true;
        } catch (Exception e) {
            e.printStackTrace();
            berhasil = false;
        } finally {
            con.tutupKoneksi();
            return berhasil;
        }
    }
}
