import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Control_cuenta  implements Initializable{
    ObservableList <String> tipo = FXCollections.observableArrayList();

    List <Usuario> usuarios= new ArrayList<Usuario>();

    Lista_vuelos baseDatos = new Lista_vuelos();

    @FXML
    private ImageView im_vuelo;

    @FXML
    private TextField txf_nombre;

    @FXML
    private PasswordField psf_contraseña;

    @FXML
    private Button btn_crear;

    @FXML
    private PasswordField psf_contraseña1;

    @FXML
    private TextField txf_pregunta;

    @FXML
    private ComboBox<String> cb_tipo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        baseDatos.conexion_usuarios();
        tipo.addAll("Aeropuerto","Aerolinea","Hangar");
        cb_tipo.setItems(tipo);
    }

    @FXML
    void crear_cuenta(ActionEvent event) {
        String usuario = txf_nombre.getText();
        String contraseña = psf_contraseña.getText();
        String contraseña1 = psf_contraseña1.getText();
        String pregunta = txf_pregunta.getText();
        String tipo = cb_tipo.getSelectionModel().getSelectedItem();

        if (tipo.equals("Aeropuerto")){
            System.out.println("entre");
            tipo = "0";
        }
        if (tipo.equals("Aerolinea")){
            tipo = "1";
        }
        if (tipo.equals("Hangar")){
            tipo = "2";
        }

        Usuario u1 = new Usuario(usuario, contraseña, pregunta, tipo);
        usuarios.add(u1); baseDatos.registrar_usuario(usuario, contraseña, pregunta, tipo);
  
    }

   

    

}

