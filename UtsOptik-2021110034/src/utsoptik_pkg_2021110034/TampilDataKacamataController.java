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

public class TampilDataKacamataController {

    @FXML
    private TextField stokField;

    @FXML
    private Button btnKeluar;

    @FXML
    private TextField frameField;

    @FXML
    private TextField productIDField;

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
    void keluarklik(ActionEvent event) {
    btnKeluar.getScene().getWindow().hide();
    }

}
