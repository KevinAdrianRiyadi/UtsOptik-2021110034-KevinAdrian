package utsoptik_pkg_2021110034;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PaymentController {

    private DatePicker tanggalPembayaranField;

    private TextField jenisPembayaranField;


    private TextField jumlahPembayaranField;

    
    private ObservableList<String> pembayaranList;
         
    private ListView<String> listViewPembayaran;
    private TextField paymentIDField;
    @FXML
    private Button btnKeluar;


    void tambahklik(ActionEvent event) {
    String paymentID = paymentIDField.getText();
        String jenisPembayaran = jenisPembayaranField.getText();
        String jumlahPembayaran = jumlahPembayaranField.getText();
        LocalDate tanggalPembayaran = tanggalPembayaranField.getValue();

        if (paymentID.isEmpty() || jenisPembayaran.isEmpty() || jumlahPembayaran.isEmpty() || tanggalPembayaran == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Data Tidak Lengkap");
            alert.setContentText("Harap lengkapi semua data pembayaran.");
            alert.showAndWait();
        } else {
            String dataPembayaran = "ID: " + paymentID + ", Jenis: " + jenisPembayaran + ", Jumlah: Rp" + jumlahPembayaran + ", Tanggal: " + tanggalPembayaran.toString();

            pembayaranList.add(dataPembayaran);
            paymentIDField.clear();
            jenisPembayaranField.clear();
            jumlahPembayaranField.clear();
            tanggalPembayaranField.setValue(null);
        }

    }

    void hapusklik(ActionEvent event) {
    String selectedPembayaran = listViewPembayaran.getSelectionModel().getSelectedItem();
        if (selectedPembayaran != null) {
            pembayaranList.remove(selectedPembayaran); 
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText("Tidak Ada Pembayaran Dipilih");
            alert.setContentText("Harap pilih pembayaran yang ingin dihapus.");
            alert.showAndWait();
        }

    }

    @FXML
    private void keluarklik(ActionEvent event) {
    }

}
