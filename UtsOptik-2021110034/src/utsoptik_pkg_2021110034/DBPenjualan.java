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
public class DBPenjualan {

    private PenjualanModel mm = new PenjualanModel();

    public PenjualanModel getPenjualanModel() {
        return (mm);
    }

    public void setPenjualanModel(PenjualanModel s) {
        mm = s;
    }

    public ObservableList<PenjualanModel> Load() {
        try {
            ObservableList<PenjualanModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select orderid, customerid, totalharga, tanggal, quantity, productid from penjualan");
            int i = 1;
            while (rs.next()) {
                PenjualanModel d = new PenjualanModel();
                d.setOrderid(rs.getInt("orderd"));
                d.setCustomerid(rs.getInt("customerid"));
                d.setTotalharga(rs.getInt("totalharga"));
                d.setTanggal(rs.getDate("tanggal"));
                d.setQuantity(rs.getInt("quantity"));
                d.setProductid(rs.getInt("productid"));
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
                    "select count(*) as jml from penjualan where orderid = '" + nomor
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
                    "insert into customer (orderid, customerid, totalharga, tanggal, quantity, productid) values (?,?,?,?)");
            con.preparedStatement.setInt(1, getPenjualanModel().getOrderid());
            con.preparedStatement.setInt(2, getPenjualanModel().getCustomerid());
            con.preparedStatement.setInt(3, getPenjualanModel().getTotalharga());
            con.preparedStatement.setDate(4, getPenjualanModel().getTanggal());
            con.preparedStatement.setInt(5, getPenjualanModel().getQuantity());
            con.preparedStatement.setInt(6, getPenjualanModel().getProductid());
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from order where orderid  = ?");
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
                    "update customer set customerid = ?, totalharga = ?, tanggal = ? , quantity = ? , productid = ?  where  orderid = ? ");
            con.preparedStatement.setInt(1, getPenjualanModel().getCustomerid());
            con.preparedStatement.setInt(2, getPenjualanModel().getTotalharga());
            con.preparedStatement.setDate(3, getPenjualanModel().getTanggal());
            con.preparedStatement.setInt(4, getPenjualanModel().getQuantity());
            con.preparedStatement.setInt(5, getPenjualanModel().getProductid());
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
