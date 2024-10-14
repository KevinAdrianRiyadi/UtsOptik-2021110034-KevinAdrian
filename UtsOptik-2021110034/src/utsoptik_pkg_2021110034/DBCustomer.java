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
public class DBCustomer {

    private CustomerModel cm = new CustomerModel();

    public CustomerModel getCustomerModel() {
        return (cm);
    }

    public void setCustomerModel(CustomerModel s) {
        cm = s;
    }

    public ObservableList<CustomerModel> Load() {
        try {
            ObservableList<CustomerModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select customerid, nama, telepon, alamat from customer");
            int i = 1;
            while (rs.next()) {
                CustomerModel d = new CustomerModel();
                d.setCustomerid(rs.getInt("customerid"));
                d.setNama(rs.getString("nama"));
                d.setTelepon(rs.getInt("telepon"));
                d.setAlamat(rs.getString("alamat"));
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
                    "select count(*) as jml from customer where customerid = '" + nomor
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
                    "insert into customer (customerid, nama, alamat, telepon) values (?,?,?,?)");
            con.preparedStatement.setInt(1, getCustomerModel().getCustomerid());
            con.preparedStatement.setString(2, getCustomerModel().getNama());
            con.preparedStatement.setString(3, getCustomerModel().getAlamat());
            con.preparedStatement.setInt(4, getCustomerModel().getTelepon());
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from customer where customerid  = ?");
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
                    "update customer set nama = ?, telepon = ?, alamat = ?  where  customerid = ? ");
            con.preparedStatement.setString(1, getCustomerModel().getNama());
            con.preparedStatement.setInt(2, getCustomerModel().getTelepon());
            con.preparedStatement.setString(3, getCustomerModel().getAlamat());
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
