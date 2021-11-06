import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Control_contraseña implements Initializable {
    
    @FXML
    private ImageView im_vuelo;

    @FXML
    private TextField txf_contraseña;

    @FXML
    private PasswordField txf_confirmo;

    @FXML
    private Button btn_cambiar;

    @FXML
    private TextField txf_pregunta;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
    }

    @FXML
    void crear_contraseña(ActionEvent event) {
        String pregunta = txf_pregunta.getText();
        String contraseña = txf_contraseña.getText();
        String contraseña2 = txf_confirmo.getText();



    }

    

}

