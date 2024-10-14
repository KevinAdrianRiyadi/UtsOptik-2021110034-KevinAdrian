package utsoptik_pkg_2021110034;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class CustomerController {

    @FXML
    private Button btntampildata;

    @FXML
    private TextField namaField;

    @FXML
    private TextField customerIDField;

    @FXML
    private TextField teleponField;

    @FXML
    private Button btnTambahData;

    @FXML
    private TextField alamatField;

    @FXML
    private Button btnHapusData;

    private ObservableList<String> pelangganList;

    @FXML
    private ListView<String> listViewPelanggan;

    
    public void initialize(URL url, ResourceBundle rb) {
        pelangganList = FXCollections.observableArrayList();
        listViewPelanggan.setItems(pelangganList);
    }

    @FXML
    void tambahklik(ActionEvent event) {
        String customerID = customerIDField.getText();
        String nama = namaField.getText();
        String alamat = alamatField.getText();
        String telepon = teleponField.getText();

        if (customerID.isEmpty() || nama.isEmpty() || alamat.isEmpty() || telepon.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Data Tidak Lengkap");
            alert.setContentText("Harap isi semua field.");
            alert.showAndWait();
        } else {
            String dataPelanggan = "ID: " + customerID + ", Nama: " + nama + ", Alamat: " + alamat + ", Telepon: " + telepon;

            pelangganList.add(dataPelanggan);
            customerIDField.clear();
            namaField.clear();
            alamatField.clear();
            teleponField.clear();

        }
    }

    @FXML
    void simpanklik(ActionEvent event) {
        if (pelangganList.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Kosong");
            alert.setHeaderText(null);
            alert.setContentText("Belum ada pelanggan yang ditambahkan.");
            alert.showAndWait();
        } else {
            listViewPelanggan.refresh();
        }
    }

    @FXML
    void hapusklik(ActionEvent event) {
        String selectedPelanggan = listViewPelanggan.getSelectionModel().getSelectedItem();
        if (selectedPelanggan != null) {

            pelangganList.remove(selectedPelanggan);
            listViewPelanggan.refresh();
        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Tidak Ada Pelanggan Dipilih");
            alert.setContentText("Harap pilih pelanggan yang ingin dihapus.");
            alert.showAndWait();
        }

    }

}
