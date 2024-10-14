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
import javafx.scene.control.TextField;

public class KacamataController {

    @FXML
    private TextField stokField;

    @FXML
    private Button btnKeluar;

    @FXML
    private TextField frameField;

    @FXML
    private TextField productIDField;

    @FXML
    private Button btnTambahData;

    @FXML
    private TextField hargaField;

    @FXML
    private TextField lensaField;

    private ObservableList<String> kacamataList;
    
    @FXML
    private ListView<String> listViewKacamata;

    public void initialize(URL url, ResourceBundle rb) {
        kacamataList = FXCollections.observableArrayList();
        listViewKacamata.setItems(kacamataList);
    }

    @FXML
    void tambahDataklik(ActionEvent event) {
        String productID = productIDField.getText();
        String frame = frameField.getText();
        String lensa = lensaField.getText();
        String stok = stokField.getText();
        String harga = hargaField.getText();

        if (productID.isEmpty() || frame.isEmpty() || lensa.isEmpty() || stok.isEmpty() || harga.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Data Tidak Lengkap");
            alert.setContentText("Isi Data dengan Lengkap.");
            alert.showAndWait();
        } else {
            String dataKacamata = "ID: " + productID + ", Frame: " + frame + ", Lensa: " + lensa
                    + ", Stok: " + stok + ", Harga: Rp" + harga;

            kacamataList.add(dataKacamata);
            productIDField.clear();
            frameField.clear();
            lensaField.clear();
            stokField.clear();
            hargaField.clear();
        }

    }

    @FXML
    void keluarklik(ActionEvent event) {
    btnKeluar.getScene().getWindow().hide();
    }

}
