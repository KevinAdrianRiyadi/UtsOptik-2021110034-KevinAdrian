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
public class DBKacamata {

    private KacamataModel km = new KacamataModel();

    public KacamataModel getKacamataModel() {
        return (km);
    }

    public void setKacamataModel(KacamataModel s) {
        km = s;
    }

    public ObservableList<KacamataModel> Load() {
        try {
            ObservableList<KacamataModel> tableData = FXCollections.observableArrayList();
            Koneksi con = new Koneksi();
            con.bukaKoneksi();
            con.statement = con.dbKoneksi.createStatement();
            ResultSet rs = con.statement.executeQuery("Select productid, frame, lensa, stok, harga from kacamata");
            int i = 1;
            while (rs.next()) {
                KacamataModel d = new KacamataModel();
                d.setProductid(rs.getInt("productid"));
                d.setFrame(rs.getString("frame"));
                d.setLensa(rs.getString("lensa"));
                d.setStok(rs.getInt("stok"));
                d.setHarga(rs.getInt("harga"));
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
                    "select count(*) as jml from product where productid = '" + nomor
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
            "insert into customer (productid, frame, lensa, stok, harga) values (?,?,?,?)");
            con.preparedStatement.setInt(1, getKacamataModel().getProductid());
            con.preparedStatement.setString(2, getKacamataModel().getFrame());
            con.preparedStatement.setString(3, getKacamataModel().getLensa());
            con.preparedStatement.setInt(4, getKacamataModel().getStok());
            con.preparedStatement.setInt(4, getKacamataModel().getHarga());
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
            con.preparedStatement = con.dbKoneksi.prepareStatement("delete from product where productid  = ?");
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
            "update product set frame = ?, lensa = ?, stok = ? , harga = ?  where  productid = ? ");
            con.preparedStatement.setString(1, getKacamataModel().getFrame());
            con.preparedStatement.setString(2, getKacamataModel().getLensa());
            con.preparedStatement.setInt(3, getKacamataModel().getStok());
            con.preparedStatement.setInt(4, getKacamataModel().getHarga());
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
