package utsoptik_pkg_2021110034;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class KacamataMenuController {

    @FXML
    private AnchorPane contentArea;

    private void loadFXML(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node node = loader.load();

            contentArea.getChildren().clear();
            contentArea.getChildren().add(node);

            AnchorPane.setTopAnchor(node, 0.0);
            AnchorPane.setBottomAnchor(node, 0.0);
            AnchorPane.setLeftAnchor(node, 0.0);
            AnchorPane.setRightAnchor(node, 0.0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void showKacamata() {
        loadFXML("Kacamata.fxml");
        
    }
    

    @FXML
    private void showPenjualan() {
        loadFXML("Penjualan.fxml");
    }

    @FXML
    private void showCustomer() {
        loadFXML("Customer.fxml");
    }

    @FXML
    private void showPayment() {
        loadFXML("Payment.fxml");
    }
    
    @FXML
    private void showTampilDataKacamata() {
        loadFXML("TampilDataKacamata.fxml");
        
    }
    
    @FXML
    private void showTampilDataCustomer() {
        loadFXML("TampilDataCustomer.fxml");
        
    }
    
    @FXML
    private void showTampilDataPayment() {
        loadFXML("TampilDataPayment.fxml");
        
    }
    
    @FXML
    private void showTampilDataPenjualan() {
        loadFXML("TampilDataPenjualan.fxml");
        
    }
}
