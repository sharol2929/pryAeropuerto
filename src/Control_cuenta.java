import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
        usuarios = baseDatos.getUsuarios();
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
        boolean bolean = true;
        if (usuario == null || contraseña == null || contraseña1== null ||pregunta == null ||tipo == null){
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Datos vacios ");
            alert.setContentText("No deje ningun campo sin llenar ");
            alert.showAndWait();
        }else{
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
            
            for (int i=0; i<usuarios.size(); i++){
                if(usuario.equals(usuarios.get(i).getUsuario())){
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("El usuario seleccionado ya existe");
                    alert.setContentText(" Seleccione otro");
                    alert.showAndWait();
                    bolean = false;
                }   
            }
            
            if (bolean){
                
                if (contraseña.length() > 3 && contraseña.equals(contraseña1)){
                   //baseDatos.registrar_usuario(usuario, contraseña, pregunta, tipo);
                   Alert alert = new Alert(AlertType.CONFIRMATION);
                   alert.setHeaderText("Cuenta creada");
                   alert.setContentText("Ya puede Ingresar al sistema");
                   alert.showAndWait();
                }else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Verifique su contraseña");
                    alert.setContentText(" Su contraseña debe ser mayor a 4 carácteres");
                    alert.showAndWait();
                }
            }
        }
        
        
  
    }

   

    

}

