package utsoptik_pkg_2021110034;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class PenjualanController {

    @FXML
    private Button btnSimpanPenjualan;


    @FXML
    private DatePicker saleDatePicker;

    @FXML
    private TextField totalHargaField;
    
    private ObservableList<String> penjualanList;
    @FXML
    private TextField orderIDField;

    @FXML
    void simpanPenjualan(ActionEvent event) {
    String customerID = orderIDField.getText();
        String totalPembelianStr = totalHargaField.getText();
        LocalDate saleDate = saleDatePicker.getValue();

        if (customerID.isEmpty() || totalPembelianStr.isEmpty() || saleDate == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText("Data Tidak Lengkap");
            alert.setContentText("Harap lengkapi semua data penjualan.");
            alert.showAndWait();
            return;
        }

        String dataPenjualan = "Order ID: " + orderIDField + ", Total Pembelian: Rp" + totalPembelianStr + ", Tanggal: " + saleDate.toString();

        penjualanList.add(dataPenjualan);

        orderIDField.clear();
        totalHargaField.clear();
        saleDatePicker.setValue(null);

    }

}
