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

public class TampilDataCustomerController {


    @FXML
    private Button btnKeluar;


    private ObservableList<String> customerList;
    
    private ListView<String> listViewCustomer;

    public void initialize(URL url, ResourceBundle rb) {
        customerList = FXCollections.observableArrayList();
        listViewCustomer.setItems(customerList);
    }

    @FXML
    void keluarklik(ActionEvent event) {
    btnKeluar.getScene().getWindow().hide();
    }

}
